package ds.example;

public class Factorial {

    public int factorial(int n){
        if(n<1){
            return -1;
        }
        if(n==0 || n==1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
}
