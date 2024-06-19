package ds.example;

import org.junit.jupiter.api.Test;

/**
 * Write Java function called findMissingNumberInArray that takes an integer array
 * containing n-1 unique elements from a range of 1 to n, with one missing number,
 * and returns the missing number.
 *
 * Example
 *
 * myArray = {1,2,3,4,6}
 * findMissingNumberInArray(myArray, 6) // 5
 * Hint:
 *
 * Use the formula (n * (n + 1)) / 2 which  calculates the sum of the first n natural numbers.
 */
public class OneMissingNumber {

@Test
    public void missingNumber(){
    System.out.println(missingNumber(new int[]{1,2,3,5,6,7}));
}
public int missingNumber(int arr[]){
    int sum=0;
    for(int i = 0; i<arr.length;i++){
        sum += arr[i];
    }
    int length = arr.length+1;
    int total = (length*(length+1))/2;
    return total-sum;
}
}
