package ds.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Write a function which takes integer array as a parameter and
 * returns a new integer array with unique elements. (remove duplicates)
 *
 * Example
 *
 * removeDuplicates({1, 1, 2, 2, 3, 4, 5})
 * Output : [1, 2, 3, 4, 5]
 */
public class RemoveDuplicates {

    @Test
    public void removeDuplicates(){
        System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 1, 2, 2, 3, 4, 5})));
    }
    public static int[] removeDuplicates(int[] array) {

        int unqArr[] = new int[array.length];
        int unqIndex = 0;

        for(int i=0; i< array.length;i++){
            boolean isDuplicate = false;
            int item = array[i];
            for(int j =0; j<unqIndex;j++){
                if(item == unqArr[j]){
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate){
                unqArr[unqIndex++] = item;
            }
        }
        return Arrays.copyOf(unqArr,unqIndex);
    }
    /**
     * Given a sorted array nums, remove the duplicates in-place such that each element appears only once
     * and returns the new length. Do not allocate extra space for another array; you must do this by
     * modifying the input array in-place with O(1) extra memory.
     *
     * Example:
     *
     * Input: nums = [1, 1, 2]
     * Output: 2
     */
    @Test
    public void removeDuplicatesSortedTest(){
        System.out.println(removeDuplicatesSorted(new int[] {1,1,1,2}));
        System.out.println(removeDuplicatesSorted2(new int[] {1,1,1,2}));
    }
    public int removeDuplicatesSorted2(int[] nums) {
        int i =0;
        for(int j =1;j<nums.length;j++){
            if(nums[j]!= nums[i]){
                i++;
                nums[i]= nums[j];
            }
        }
        return i+1;
    }
    public int removeDuplicatesSorted(int[] nums) {
        //TODO
        int previousItem=nums[0];
        int totalCount = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == previousItem){
                nums[i] = Integer.MIN_VALUE;
            }else{
                previousItem = nums[i];
                totalCount++;
                break;
            }
        }
        return totalCount;
    }
}
