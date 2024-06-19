package ds.example;

import org.junit.jupiter.api.Test;

/**
 * Best Time to Buy and Sell Stock - LeetCode 121
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a
 * different day in the future to sell that stock. Return the maximum profit you can achieve
 * from this transaction. If you cannot achieve any profit, return 0.
 *
 * Example:
 *
 * Input: prices = [7, 1, 5, 3, 6, 4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 */
public class MaxProfit {


    @Test
    public void maxProfit(){
//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{7, 2, 5, 3, 6, 4,1}));
    }
    public int maxProfit(int[] prices){

        int minPrice=Integer.MAX_VALUE;
        int profit=0;
        for(int i =0;i<prices.length;i++){

            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i]-minPrice > profit){
                profit = prices[i]-minPrice;
            }

        }
        return profit;
    }
}
