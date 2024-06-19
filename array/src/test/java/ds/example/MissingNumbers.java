package ds.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * Example 2:
 *
 * Input: nums = [1,1]
 * Output: [2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 *
 *
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class MissingNumbers {
    @Test
    public void missingNumbers(){
//        System.out.println(Arrays.toString(missingNumbersTest(new int[] {4,3,2,7,8,2,3,1})));
        System.out.println(Arrays.toString(missingNumbersTest(new int[] {1,1})));
    }

    public int[] missingNumbersTest(int[] arr){

        for(int i = 0 ; i<arr.length;i++){
            int value = Math.abs(arr[i]);
            if(arr[value-1]>0){
                arr[value-1] *= -1;
            }

        }
        int rArr[] = new int[arr.length];
        int rArrindex = 0;
        for(int j = 0; j<arr.length;j++){
            if (arr[j] > 0){
                rArr[rArrindex++] = j+1;
            }
        }
     return Arrays.copyOf(rArr,rArrindex);
    }

}
