package com.xingjiahe.www.template;

import java.util.Arrays;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/12 10:56 AM
 */
public class LengthLIS {

    public static void main(String args[]) {
         int [] nums = new int []{1, 7, 3, 5, 9, 4, 8};
     		System.out.println(lengthLIS(nums));
     	}

    private static int lengthLIS(int[] nums) {
        if(nums == null)return  0;
        int res =0;
        int [] a = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            a[i] =1;
            for(int j=0;j<i;j++){
              if(nums[j]<nums[i]){
                  if(a[i]<a[j]+1){
                      a[i] =a[j]+1;
                  }
              }
            }
       res = Math.max(res,a[i]);
        }
        return  res;
    }
}
