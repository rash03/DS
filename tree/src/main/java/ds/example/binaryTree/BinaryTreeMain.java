package ds.example.binaryTree;

public class BinaryTreeMain {
    public static void main(String[] args) {
        BinaryTreeLL binaryTreeLL = new BinaryTreeLL();
        binaryTreeLL.insert("N1");
        binaryTreeLL.insert("N2");
        binaryTreeLL.insert("N3");
        binaryTreeLL.insert("N4");
        binaryTreeLL.insert("N5");
        binaryTreeLL.insert("N6");
        binaryTreeLL.insert("N7");
        binaryTreeLL.insert("N8");
        binaryTreeLL.insert("N9");
        binaryTreeLL.levelOrder();
        System.out.println("");
        System.out.println(binaryTreeLL.getDeepestNode().data);
    }
}
