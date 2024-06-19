package ds.example;
public class CLL {

Node head;
Node tail;

int size;

public Node createCLL(int nodeValue){

    Node node = new Node();
    node.value = nodeValue;
    node.next = node;
    head = node;
    tail = node;
    size++;
    return node;

}
public void insertNode(int location, int nodeValue){

    Node node = new Node();
    node.value = nodeValue;
    if (head ==null) {
        createCLL(nodeValue);
        return;
    }else if (location == 0){
        node.next = head;
        head = node;
        tail.next = head;
    }else if (location >= size){
        node.next = head;
        tail.next = node;
        tail = node;
    }else {
        Node temp = head;
        int index = 0;
        while(index < location -1){
            temp = temp.next;
            index++;
        }
        node.next = temp.next;
        temp.next = node;
    }

    size++;
}

public void traverseCLL(){
    if(head ==null) {
        Node temp = head;
        int index = 0;
        for (int i = 0; i <= size; i++) {
            System.out.println("> " + temp.value);
            temp = temp.next;
        }
    }else{
        System.out.println("CLL does not exist");
    }
}

public void searchCLL(int nodeValue){
Node temp = head;
if(head == null) {
    System.out.println("Node not found");
}
    for (int i = 0; i<size;i++){
        if(temp.value == nodeValue){
            System.out.println("Node Value found at location: "+ i);
        }else{
            temp = temp.next;
        }
    }
    System.out.println("Node not found");
}

    public void deleteCLLNode(int location) {
        if (head == null) {
            System.out.println("CLL does not exist");
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                head.next = null;
                head = tail = null;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i =0; i< size-1;i++){
                tempNode = tempNode.next;
            }
            if(tempNode == head){
                head.next = null;
                head = tail = null;
                size --;
            }else{
                tail.next = null;
                tail = tempNode;
                tail.next = head;
                size--;
            }

        } else {
            Node tempNode = head;
            for (int i =0; i< size-1;i++){
                tempNode = tempNode.next;
            }
            Node targetNode = tempNode.next;
            tempNode.next= tempNode.next.next;
            targetNode.next = null;
            size--;
        }

    }

    public void deleteCll() {
        head = null;
        tail.next = null;
        tail = null;
    }
}