package ds.example;

import org.junit.jupiter.api.Test;

/**
 * Two arrays are Permutation of each other if they both contain same elements. The elements can be present in different order.
 * Given two unsorted arrays of the same size, write a function that returns true if two arrays are permutations of each other, otherwise false.
 * Input: arr1[] = {2, 1, 3, 5, 4, 3, 2}
 *        arr2[] = {3, 2, 2, 4, 5, 3, 1}
 * Output: Yes
 * Input: arr1[] = {2, 1, 3, 5,}
 *        arr2[] = {3, 2, 2, 4}
 * Output: No
 */
public class PermutationIntegerArrays {

    @Test
    public void permutation(){
        System.out.println(permutation(new int[]{2, 1, 3, 5, 4, 3, 2},new int[]{3, 2, 2, 4, 5, 3, 1}));
        System.out.println(permutation(new int[]{2, 1, 3, 5},new int[]{3, 2, 2, 4}));
    }
    public boolean permutation(int arr1[], int arr2[]){
        int sumArr1 = 0;
        int multArr1 = 1;
        int sumArr2 = 0;
        int multArr2 = 1;

        for(int i=0;i<arr1.length;i++){
            sumArr1 += arr1[i];
            multArr1 *= arr1[i];
            sumArr2 += arr2[i];
            multArr2 *= arr2[i];

        }

        if(sumArr2 == sumArr1 && multArr2 == multArr1) {
            return true;
        }
            else {
            return false;
        }

    }
}
