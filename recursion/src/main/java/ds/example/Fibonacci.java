package ds.example;

public class Fibonacci {
    /**
     * A number is a sum of its 2 previous numbers.
     * Sequence starts from 0 & 1
     * 0,1,1,2,3,5,8,13,21,34,55,89 ...
     */

    static int fibonacci(int n){
        if(n<0){
            return -1;
        }
        if(n==0 || n == 1){
            return n;
        }
       return fibonacci(n-1)+ fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(7));
    }
}
