package ds.example;

import org.junit.jupiter.api.Test;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class ContainsDuplicate {
    @Test
    public void containsDuplicate(){
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public boolean containsDuplicate(int arr[]){

        for(int i = 0 ;i<arr.length;i++){
            for(int j =i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    System.out.println("Duplicate Number:" + arr[i]);
                    return true;

                }
            }
        }
        return false;
    }
}
