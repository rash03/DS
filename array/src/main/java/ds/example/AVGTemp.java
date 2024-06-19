package ds.example;

import java.util.Scanner;

public class AVGTemp {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("how many days of temp :");
        int numdays = console.nextInt();

        int temp[] = new int[numdays];
        int sum = 0;
        for (int i=0;i<numdays;i++){
            System.out.println("Enter Day "+(i+1)+" temp :");
            temp[i] = console.nextInt();
            sum += temp[i];
        }
        int avg = sum/numdays;
        System.out.println("Average Temp: "+ avg);
        System.out.println("Number of Days above avg temp :");
        for(int i = 0;i<numdays;i++){
            if(temp[i]>= avg){
                System.out.println("Day "+ (i+1)+ " temp was above Avg temp");
            }
        }

    }
}
