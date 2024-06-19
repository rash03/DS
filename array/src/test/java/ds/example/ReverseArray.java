package ds.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ReverseArray {
    @Test
    public void reverseArray(){
        System.out.println(Arrays.toString(reverseArray(new int[]{1,2,3,4,5,6})));
        System.out.println(Arrays.toString(reverseArray(new int[]{7,4,2,8,0,5})));
    }

    /**
     * T = O(N)
     */

    int[] reverseArray(int arr[]){
        for(int i = 0; i<arr.length/2;i++){
            int rIndex = arr.length-i-1;
            int temp = arr[i];
            arr[i] = arr[rIndex];
            arr[rIndex] = temp;
        }
        return arr;
    }
    int[] reverseArray1(int arr[]){

        int li = 0;
        int ri = arr.length-1;

        while(li<ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }
return arr;
    }
}
