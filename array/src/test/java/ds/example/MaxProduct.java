package ds.example;

import org.junit.jupiter.api.Test;

/**
 * Given the array of integers nums, you will choose two different indices i and j of that array.
 * Return the maximum value of (nums[i]-1)*(nums[j]-1).
 *
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 * Example 2:
 *
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 * Example 3:
 *
 * Input: nums = [3,7]
 * Output: 12
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 */
public class MaxProduct {
    @Test
    public void maxProduct(){
        System.out.println(maxProduct(new int[]{3,4,5,2}));
        System.out.println(maxProduct(new int[]{1,5,4,5}));
        System.out.println(maxProduct(new int[]{3,7}));
    }

    public int maxProduct(int arr[]){
        int[] topTwo = topTwo(arr);
        return (topTwo[0]-1)*(topTwo[1]-1);
    }

    int[] topTwo(int arr[]){

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i=0;i< arr.length;i++){
            if(arr[i]> first){
                second = first;
                first = arr[i];
            }else if (arr[i] > second){
                second = arr[i];
            }
        }
        return new int[]{first,second};
    }
}
