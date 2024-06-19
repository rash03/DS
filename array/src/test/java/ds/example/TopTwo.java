package ds.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given an array, write a function to get first, second best scores
 * from the array and return it in new array.
 *
 * Array may contain duplicates.
 *
 * Example
 *
 * myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
 * firstSecond(myArray) // {90, 87}
 */
public class TopTwo {

    @Test
    public void topTwoScore(){
        System.out.println(Arrays.toString(topTwoScore(new int[]{84,85,86,87,85,90,85,83,23,45,84,1,2,0})));
    }
    public int[] topTwoScore(int arr[]){

        int first=Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]> first){
                second = first;
                first = arr[i];

            }else if(arr[i]>second){
                second = arr[i];
            }
        }
        return new int[] {first,second};
    }
}
