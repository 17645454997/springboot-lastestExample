package com.xingjiahe.www.arr;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/19 3:55 PM
 */
public class Solution {

    public  static  int  maxProfit(int[] prices){
             int n = prices.length;
             int  [][] dp = new int[n][2];
             //第一天不持有
             dp[0][0]  = 0;
            // 第一天持有
             dp[0][1] = -prices[0];
             for(int i=1;i<n;i++ ){
                 //第i 天不持有  可以是第i -1 天 持有但是已经卖了，或者i -1天就不持有 取最大值
                 dp[i][0] =  Math.max(dp[i-1][0],dp[i-1][1] +prices[i]);
                  //第i 天持有    可以是第i -1 天就持有没动 ，也可以是第i-1 天没持有 但是买入了
                  dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
             }
             return  dp[n-1][0];
    }
    public static void main(String args[]) {
        int [] arr = new int []{7,1,5,3,6,4};
    		System.out.println(maxProfit(arr));
    	}
}
