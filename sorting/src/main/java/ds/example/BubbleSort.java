package ds.example;

import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for (int j =0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {10,5,30,15,50,6};
        BubbleSort bs = new BubbleSort();
        bs.sort(arr);
        bs.printArray(arr);
    }
}
