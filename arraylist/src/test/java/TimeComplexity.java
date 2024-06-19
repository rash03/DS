public class TimeComplexity {

    /**
     * Time complexity of the iterate method will be O(1)
     * because the number of times the loop runs is a constant.
     */
    void iterate(){
        for(int i=0;i<10000000; i++){
            System.out.println("hello world");
        }
    }

    void printUnorderedPair(int[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                System.out.println(i+" "+j);
            }
        }
    }
}
/**
 * Determine Time complexity
 * 1. Counting iterations
 *  In this both a flow which includes both 1st and 2nd loop will be considered
 *  as one iteration.
 *
 *  For i=1, inner loop runs for n-1 times = (n-1)
 *  For i=2, inner loop runs for n-1 times = (n-2)
 *  .
 *  .
 *  .
 *  (n-1)+(n-2).... = n(n-1)/2 ~ n^2 is complexity
 *
 *  2. Evaluating Average
 *  Average number of time 1st loop run* Average number of time 2nd lop runs
 *
 *  Outer loop runs for - n times
 *  Inner loop runs for - n/2 times in avaerage
 *  For example- 10+9+8 ... /10 = 5.5 ~ 5 ~ n/2
 *  => n*n/2 ~ n^2 is complexity
 */

