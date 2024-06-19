package ds.example;

public class CDLL {

    int size;
    Node head;
    Node tail;

    public void createCDLL(int nodeValue) {

        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        node.prev = node;
        head = tail = node;
        size++;
    }

    public void insertNode(int location, int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createCDLL(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            head = node;
        } else if (location >= size) {
            node.next = head;
            node.prev = tail;
            tail.next = node;
            head.prev = node;
            tail = node;
        } else {
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            node.prev = tempNode;
            node.next = tempNode.next;
            tempNode.next.prev = node;
            tempNode.next = node;
        }
        size++;
    }

    public void traverseCDLL() {
        if (head == null) {
            System.out.println("CDLL does not exist");
            return;
        }
        Node tempN = head;
        for (int i = 0; i < size; i++) {
            System.out.println(tempN.value);
            if (i < size - 1) {
                System.out.println(" -> ");
            }
            tempN = tempN.next;
        }
    }

    public void reverseTraverse() {
        if (head == null) {
            System.out.println("CDLL does not exist");
        }
        Node temp = tail;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.value);
            if (i < size - 1) {
                System.out.println(" -> ");
            }
            temp = temp.prev;
        }
    }

    public void searchNode(int nodeValue) {
        if (head == null) {
            System.out.println("CDLL does not exist");
        }
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value == nodeValue) {
                System.out.println("value found at location " + i);
                return;
            }
            temp = temp.next;
        }
        System.out.println("value does not exist");
    }

    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("CDLL does not exist");
        }
        if (location == 0) {
            if (size == 1) {
                head.next = head.prev = null;
                head = tail = null;
            } else {
                head = head.next;
                head.prev = tail;
                tail.next = head;
            }
            size--;
        } else if (location >= size) {
            if (size == 1) {
                head.next = head.prev = null;
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            }
            size--;
        }else{
        Node temp = head;
        for(int i = 0;i<=location-1;i++){
           temp = temp.next;
        }
            temp.next = temp.next.next;
            temp.next.prev = temp;
            size--;
        }
    }

    public void deleteCDLL() {
        if (head == null) {
            System.out.println("CDLL does not exist");
            return;
        }
        Node temp = head;
        for (int i = 0; i < size; i--) {
            temp.prev = null;
            temp = temp.next;
        }
        head = tail = null;
        System.out.println("CDLL is deleted");
    }
}
