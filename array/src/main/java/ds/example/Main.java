package ds.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
//        String arr1d[] = {"a","b","c"};
//        String arr2d[][] = {{"a","b","c"},{"d","e","f"}};
//
//        int myArray[] = {84,85,86,87,85,90,85,83,23,45,84,1,2,0};
//        System.out.println(Arrays.toString(findTopTwoScores(myArray)));

//        int arr[]= new int[] {1,2,3,4,6};
//        System.out.println(findMissingNumberInArray(arr));

    }


    public class Exercise {
        public static int[] middle(int[] array) {
            // TODO
            int length = array.length;
            int rArr[] = new int[length - 2];
            for (int i = 1; i < length - 1; i++) {
                rArr[i - 1] = array[i];
            }
            return rArr;
        }
    }

    public static int sumDiagonalElements(int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int sum = 0;

        for(int i = 0;i<row;i++){
            sum += array[i][i];
        }
        return sum;

    }
}