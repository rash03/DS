package ds.example;

public class BinaryTreeArr {
    String arr[];
    int lastIndex;

    public BinaryTreeArr(int size){
        arr = new String[size+1];
        lastIndex = 0;
        System.out.println("BNinary tree of size "+size+" is created");
    }

    boolean isFull(){
        if(lastIndex == arr.length-1){
            return true;
        }else {
            return false;
        }
    }

    public void insert(String data){
        if (!isFull()){
            arr[lastIndex+1] = data;
            lastIndex++;
            System.out.println("Value "+data+"is inserted");
        }else{
            System.out.println("Tree is Full");
        }
    }
    void preOrder(int index){
        if(index > lastIndex){
            return;
        }
        System.out.print(arr[index]+" ");
        preOrder(index*2);
        preOrder(index*2 +1);
    }

    void inOrder(int index){
        if(index > lastIndex){
           return;
        }
        inOrder(index*2);
        System.out.println(arr[index]+ " ");
        inOrder(index*2 +1);
    }

    void postOrder(int index){
        if (index > lastIndex){
            return;
        }
        postOrder(index*2);
        postOrder(index*2+1);
        System.out.println(arr[index]+ " ");
    }
    void levelOrder(){
        for (int i=1;i<lastIndex;i++){
            System.out.println(arr[i]+" ");
        }
    }

    void search(String data){
        for (int i = 1;i<lastIndex;i++){
            if(arr[i] == data){
                System.out.println("Value found at location "+i);
                return;
            }
        }
        System.out.println("Value not found in Tree");
        return;
    }

    void deleteGivenNode(String data){
        for(int i =1;i<lastIndex;i++){
            if(arr[i]==data){
                arr[i] = arr[lastIndex];
                lastIndex--;
                break;
            }
        }
    }

    void deleteTree(){
        arr = null;
        System.out.println("Tree is deleted");
    }
}
