package ds.example;

public class SinglyLinkList {

    Node head;
    Node tail;
    int size;

    public void createSinglyLinkList(int nodeValue){

        Node node = new Node();
        node.value = nodeValue;
        head = tail = node;
        size++;
    }

    public void insertNode(int location, int nodeValue){
        Node node = new Node();
        node.value = nodeValue;
        if(head == null){
            createSinglyLinkList(nodeValue);
        }else if(location ==0){
            node.next = head;
            head = node;
            size++;
        }else if (location >=size){
            // TBD
        }else{
            //TBD
        }
    }

    public void deleteNode(int location){
        if(head ==null){
            return;
        }else if (location ==0){
            head = head.next;
            size--;
            if(size ==0){
                tail = null;
            }
        }else if (location >=size){
            // TBD
        }else{
            //TBD
        }
    }
}
