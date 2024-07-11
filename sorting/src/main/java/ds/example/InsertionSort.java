package ds.example;

import java.util.Arrays;

public class InsertionSort {
    void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        for(int i=1;i< arr.length;i++){
            int temp = arr[i], j=i;
            while(j>0 && arr[j-1]>temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,3,2,5,8,4,1,9};
        InsertionSort is = new InsertionSort();
        is.sort(arr);
        is.printArray(arr);
    }
}
