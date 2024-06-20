package ds.example;

public class CircularQueue {

    int[] arr;
    int front;
    int rear;
    int size;

    public CircularQueue(int size){
        this.size = size;
        this.arr = new int[size];
        this.front = rear = -1;
        System.out.println("Queue Created");
    }

    public boolean isEmpty(){
        if(front == -1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull(){
        if(rear == front+1){
            return true;
        }else if (front == 0 && rear+1 == size){
            return true;
        }else{
            return false;
        }
    }

    public void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is full");
        }else if(isEmpty()){
            front++;
            rear++;
            arr[rear] = value;
            System.out.println("Successfully entered "+value+" in the queue");
        }else{
            if(rear+1 == size){
                rear = 0;
            }else{
                rear++;
            }
            arr[rear] = value;
            System.out.println("Successfully entered "+value+" in the queue");
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }else {
            int element = arr[front];
            arr[front] = -1;
            if(front == rear){
                front = rear = -1;
            }else if(front +1 == size){
                front = 0;
            }else{
                front++;
            }
            return element;
        }
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Circular queue is empty");
            return  -1;
        }else{
            return arr[front];
        }
    }

    public void delete(){
        arr = null;
        System.out.println("Queue is deleted");
    }
}
