package ds.example;

public class RecMaxNumber {

    static int recMaxNum(int [] arr, int n){
        if (n==1){
            return arr[0];
        }
        return Math.max(arr[n-1],recMaxNum(arr,n-1));
    }
}
/**
 * Recursive algo with single call
 * => O(N) complexity
 * Recursive algo with multiple calls O(branches ^ depth) =
 * +> O(2^n)
 * Recursive algo where in each iteration the function reduces the size of problem by a constant
 * => O(log n)
 */
