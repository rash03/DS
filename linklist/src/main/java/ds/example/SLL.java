package ds.example;

public class SLL {

    Node head;
    Node tail;
    int size;

    public Node createSLL(int nodeValue){

        Node node = new Node();
        node.value = nodeValue;
        node.nextRef = null;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertNodeInLL(int location, int nodeValue){
        Node node = new Node();
        node.value = nodeValue;
        if (head == null){
            createSLL(nodeValue);
            return;
        }else if(location == 0){
            node.nextRef = head;
            head = node;

        }else if (location >= size){
            tail.nextRef = node;
            tail = node;
        }else{
            int index = 0;
            Node tempNode = head;
            while(index <location -1){
               tempNode = tempNode.nextRef;
               index++;
            }
            node.nextRef = tempNode.nextRef;
            tempNode.nextRef = node;
        }
        size++;
    }

    public void traverseSLL(){
        if (head ==null){
            System.out.println("SLL is empty");
            return;
        }else{
            Node tempnode = head;
            for(int i=0;i<size;i++){
                System.out.println(tempnode.value);
                tempnode = tempnode.nextRef;
            }
        }
    }
    public boolean searchNode(int nodeValue){
        if(head!=null){
            Node tempNode = head;
            for(int i = 0;i<size;i++){
                if(tempNode.value == nodeValue){
                    System.out.println("Node found at location "+ i);
                    return true;
                }
                tempNode = tempNode.nextRef;
            }
            System.out.println("Node not Found");
            return false;
        }
        return false;
    }

    public void delete(int location){
        if(head == null){
            System.out.println("SLL does not exist");
            return;
        }else if (location == 0){
            head = head.nextRef;
            size --;
            if(size ==0){
                tail=null;
            }
        }else if (location >= size) {
            Node tempNode = head;
            for(int i=0;i<size-1;i++){
                tempNode = tempNode.nextRef;
            }
            if(tempNode == head){
                head=tail=null;
                size--;
                return;
            }
            tempNode.nextRef = null;
            tail = tempNode;
            size--;
        }else{
            Node tempNode = head;
            for(int i = 0;i<location-1;i++){
                tempNode = tempNode.nextRef;
            }
            tempNode.nextRef = tempNode.nextRef.nextRef;
            tempNode.nextRef.nextRef = null;
            size --;
        }

    }
    public void deleteSLL(){
        head = tail =null;
        System.out.println("SLL is deleted");
    }

    /**
     * Insert element in linked list
     * 1. insert element at head => most efficient
     * 2. insert element in the beginning => travers to the node then relink
     * 3. Insert element in the end of linklist => least efficient as we have to travel till end of list
     */
    static class Node{
        int value;
        Node nextRef;
    }
}
