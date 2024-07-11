package ds.example;

import java.util.Arrays;

public class SelectionSort {
    void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIndex = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex !=i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,3,2,5,8,4,1,9};
        SelectionSort ss = new SelectionSort();
        ss.sort(arr);
        ss.printArray(arr);
    }
}
