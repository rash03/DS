package ds.example;

public class QueueLA {

    int[] arr;
    int rear;
    int front;

    public QueueLA(int size){

        arr = new int[size];
        rear = front = -1;
        System.out.println("Linear Queue is created");
    }

    public boolean isFull(){
        if(rear == arr.length-1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isEmpty(){
        if(front ==-1 || front == arr.length){
            return true;
        }else{
            return false;
        }
    }

    public void enqueue(int value){
        if (isFull()){
            System.out.println("Queue is full");
        }else if(isEmpty()){
            front = 0;
            rear++;
            arr[rear] = value;
            System.out.println();
        }
    }
}
