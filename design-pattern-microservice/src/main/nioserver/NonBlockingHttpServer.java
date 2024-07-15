package nioserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.channels.Selector;
import java.util.HashMap;
import java.util.Map;

public class NonBlockingHttpServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(port));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        Map<SocketChannel, String> endpoints = new HashMap<>();

        while (true) {
            int numKeys = selector.select();
            if (numKeys == 0) {
                continue;
            }

            for (SelectionKey key : selector.selectedKeys()) {
                selector.selectedKeys().remove(key);

                if (key.isAcceptable()) {
                    handleAccept(serverSocketChannel, selector);
                } else if (key.isReadable()) {
                    handleRead(key, endpoints);
                } else if (key.isWritable()) {
                    handleWrite(key, endpoints);
                }
            }
        }
    }

    private static void handleAccept(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static void handleRead(SelectionKey key, Map<SocketChannel, String> endpoints) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buffer);

        if (bytesRead == -1) {
            socketChannel.close();
        } else if (bytesRead > 0) {
            buffer.flip();
            String request = new String(buffer.array(), 0, bytesRead, StandardCharsets.UTF_8);

            // Extract endpoint from request (assuming simple format)
            String endpoint = request.split(" ")[1];
            endpoints.put(socketChannel, endpoint);

            // Register for write after processing
            key.interestOps(SelectionKey.OP_WRITE);
        }
    }

    private static void handleWrite(SelectionKey key, Map<SocketChannel, String> endpoints) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        String endpoint = endpoints.get(socketChannel);

        // Send response based on endpoint (replace with actual logic)
        String response;
        if (endpoint.equals("/api1")) {
            response = handleApi1Request();
        } else if (endpoint.equals("/api2")) {
            response = handleApi2Request();
        } else {
            response = "Invalid endpoint";
        }

        ByteBuffer buffer = ByteBuffer.allocate(response.length());
        buffer.put(response.getBytes(StandardCharsets.UTF_8));
        buffer.flip();
        socketChannel.write(buffer);

        // After sending response, remove endpoint and potentially close connection
        endpoints.remove(socketChannel);
        if (buffer.hasRemaining()) {
            key.interestOps(SelectionKey.OP_WRITE);
        } else {
            socketChannel.close();
        }
    }

    private static String handleApi1Request() {
        // Simulate processing for /api1
        return "Processed API1 request";
    }

    private static String handleApi2Request() {
        // Simulate processing for /api2
        return "Processed API2 request";
    }
}
