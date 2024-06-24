
package ds.example;

public class SDArray {

    int arr[] ;
    public SDArray(int sizeOfArray){
        arr = new int[sizeOfArray];
        for (int i = 0; i<sizeOfArray;i++){
            arr[i] = Integer.MIN_VALUE;
        }
    }

    public void insert(int location, int value){ // - O(1)
        try{
            if(arr[location] == Integer.MIN_VALUE){
                arr[location] =   value;
                System.out.println("value inserted");
            }else{
                System.out.println("location already occupied");
            }
        }catch (ArrayIndexOutOfBoundsException exp){
            System.out.println("Invalid index for Array");
        }

    }
}
