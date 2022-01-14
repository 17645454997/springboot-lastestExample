package com.xingjiahe.www.template;

import java.util.Arrays;

/**
 * <p>双指针模版</p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/1/13 下午3:10
 */
public class TowPointers {

    public static char[] reverseString(char[]str){
        int i=0,j=str.length-1;
        while(i<j){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
        return  str;
    }

    public int removeDuplicates(int []arr){
        int i=0,j=0;
        while (j<arr.length){
            if(i==0 || arr[j]!= arr[i-1]){
                arr[i++] = arr[j++];
            }else {
                j++;
            }
        }
        return i;
    }
    public static int maxArea(int[] height) {
     int res = Integer.MIN_VALUE;
     int i=0,j=height.length-1;
     while (i<j){
            int area =  Math.min(height[i],height[j])*(j-i);
            res = Math.max(res,area);
            if(height[i] <= height[j]){
                i++;
            }else {
                j--;
            }
         }
    return  res;
    }

    public static int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
       while(left < right){
           if(height[left] < height[right]){
               if(height[left]>= left_max){
                   left_max = height[left];
               }else {
                   ans+= (left_max - height[left]);
               }
             left++;
           }else {
               if(height[right] <= right_max){
                   right_max = height[right];
               }else {
                   ans += (right_max - height[right]);
               }
            right--;
           }
       }
       return  ans;
    }


    public static void main(String[] args) {
        char [] str = new char[]{'h','e','l','l','o'};
        reverseString(str);
        Arrays.asList(str).forEach(e->System.out.println(e));
        int [] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        int [] arr = new int []{1,0,3,0,1,0,3,1};
        System.out.println(trap(arr));
    }
}
