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
        }else if(isEmpty()){ // if queue is empty then we have to set the beginning of queue.=> front=> from where the elements will be removed.
            // for cases when queue is not empty then we only increment the rear => because elements are added in rear and removed from front
            front = 0;
            rear++;
            arr[rear] = value;
            System.out.println("Successfully entered "+value+" in the queue");
        }else{
            rear++;
            arr[rear] = value;
            System.out.println("Successfully entered "+value+" in the queue");
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }else{
            int element = arr[front];
            front++;
            if(front > rear){
                front = rear = -1;
            }
            return element;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("queue is empty");
            return -1;
        }else{
            return arr[front];
        }
    }

    public void delete(){
        arr = null;
        System.out.println("Queue is successfully deleted");
    }
}
