package ds.example;

public class DLL {

    Node head;
    Node tail;
    int size;

    public void createDoublyLL(int nodeValue) {
    Node node = new Node();
    node.value = nodeValue;
    head = tail = node;
    size++;
    }

    public void insertNode(int location, int nodeValue){
        Node node = new Node();
        node.value = nodeValue;
        if(head == null){
            createDoublyLL(nodeValue);
            return;
        }else if(location == 0){
            node.next = head;
            head.prev = node;
            head = node;
        }else if (location>=size){
            node.prev = tail;
            tail.next = node;
            tail = node;
        }else{
            Node tempNode = head;
            for (int i = 0 ; i<location -1;i++){
                tempNode = tempNode.next;
            }
            node.prev = tempNode;
            node.next = tempNode.next;
            tempNode.next = node;
            node.next.prev = node;
        }
        size++;
    }

    public void traverseDLL(){
        if(head !=null){
            Node tempnode = head;
            for (int i =0;i<size;i++){
                System.out.println(tempnode.value);
                if(i != size-1){
                    System.out.println(" -> ");
                }
                tempnode = tempnode.next;
            }
        }else{
            System.out.println("DLL does not exist");
        }
    }

    public void reverseTraverse(){
            if(head !=null){
                Node tempnode = tail;
                for (int i =0; i <size;i++){
                    System.out.println(tempnode.value);
                    if(i != size-1){
                        System.out.println(" -> ");
                    }
                    tempnode = tempnode.prev;
                }
            }else{
                System.out.println("DLL does not exist");
            }
    }

    public void searchNode(int nodeValue){

        if(head !=null){
            Node tempNode = head;
            for(int i = 0;i <size;i++){
                if(tempNode.value == nodeValue){
                    System.out.println("Value at location " + i);
                    return;
                }
                tempNode = tempNode.next;
            }
            System.out.println("Value does not exist");

        }else{
            System.out.println("Dll does not exist");
        }
    }

    public void deleteNode(int location){
        if(head !=null){
            if(location == 0){
                if(size == 1 ){
                    head = tail = null;
                }else{
                    head = head.next;
                    head.prev = null;
                }
                size--;
            }else if (location >=size){

                if(size == 1){
                    head = tail = null;
                }else{
                    tail = tail.prev;
                    tail.next = null;
                }
                size --;
            }else {
                Node tempNode = head;
                for(int i = 0; i<location-1;i++){
                  tempNode = tempNode.next;
                }
                tempNode.next = tempNode.next.next;
                tempNode.next.prev = tempNode;
                size --;
            }
        }
    }
    public void deleteDLL(){
        Node tempNode = head;
       for(int i = 0;i<size;i++){
           tempNode.prev = null;
           tempNode = tempNode.next;
       }
       head = tail = null;
        System.out.println("DLL is deleted");
    }
}
