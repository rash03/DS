package ds.example;

public class LL {
    Node head;
    Node tail;
    int size;

    public void insertNode(int value){
        // add at the end at tail
        Node  node = new Node();
        node.value = value;
        if(head ==null){
            createLL(value);
        }else{
            tail.nxt = node;
            node.nxt= null;
            tail = node;
            size++;
        }

    }

    private void createLL(int value) {
        Node node = new Node();
        node.value = value;
        head = tail = node;
        size++;
    }

    public int deleteNode(){
        // remove node from head
        int element = -1;
        if(head ==null){
            System.out.println("Queue is Empty");
        }else{
            element = head.value;
            head = head.nxt;
            if(size==1){
                tail= null;
            }
            size--;
        }
        return element;
    }

    public void deleteLL(){
        // make head and tail = null;

        head = tail= null;
        System.out.println("Queue Deleted");
    }
}
