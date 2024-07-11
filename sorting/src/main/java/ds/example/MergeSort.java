package ds.example;

import java.util.Arrays;


public class MergeSort {

    public static void merge(int[] arrA, int left , int middle, int right){

        int[] leftTmpArr = new int[middle-left+2];
        int[] rightTmpArr = new int[right-middle+1];
        for(int i=0;i<=middle-left;i++){
            leftTmpArr[i] = arrA[left+i];
        }
        for(int i=0;i<=right-middle;i++){
            rightTmpArr[i] = arrA[middle+1+i];
        }
        leftTmpArr[middle-left+1] = Integer.MAX_VALUE;
        rightTmpArr[right-middle] = Integer.MAX_VALUE;
        int i =0,j=0;
        for(int k = left; k<=right;k++){
            if(leftTmpArr[i] < rightTmpArr[j]){
                arrA[k] = leftTmpArr[i];
                i++;
            }else{
                arrA[k] = rightTmpArr[j];
                j++;
            }
        }
    }
    public static void sort(int[] arr, int left, int right){
        if(right>left){
//            int mid = (left+right)/2;
            int mid = left + (right - left) / 2;
            sort(arr, left,mid);
            sort(arr, mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {10,3,2,5,8,4,3,1,2,9,7,8};
        sort(arr,0,arr.length-1);
        printArray(arr);
    }
}
