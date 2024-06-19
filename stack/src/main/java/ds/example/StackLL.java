package ds.example;

public class StackLL {

    SinglyLinkList ll;

    public StackLL(){
        ll = new SinglyLinkList();
    }

    public void push(int value){
        ll.insertNode(0,value);
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            int result = ll.head.value;
            ll.deleteNode(0);
            return result;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return ll.head.value;
        }
    }

    public boolean isEmpty(){
        if (ll.head ==null){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        return false;
    }
}
