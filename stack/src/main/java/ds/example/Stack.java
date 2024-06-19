package ds.example;

public class Stack {

    int arr[];
    int top;

    public Stack(int size){
        this.arr = new int [size];
        this.top = -1;
    }
    public boolean isEmpty(){
        if(top ==-1){
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull() {
        if (top == arr.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int value){

        if(isFull()){
            System.out.println("Stack is full");
        }else{
            arr[top+1] = value;
            top++;
            System.out.println("Value is inserted");
        }
    }

    public int pop(){
        int value;
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            value = arr[top];
            top--;
            return value;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }else{
            return arr[top];
        }
    }
}
