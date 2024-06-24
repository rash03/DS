package ds.example;

public class QueueLL {
    LL list;

    public QueueLL() {
        list = new LL();
        System.out.println("Queue is successfully created");
    }

    public boolean isEmpty() {
        if (list.head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void enqueue(int nodeValue) {
        list.insertNode(nodeValue);

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {

            return list.deleteNode();
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return list.head.value;
        }

    }

    public void delete(){
     list.deleteLL();
    }
}
