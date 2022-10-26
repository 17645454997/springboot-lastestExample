package com.xingjiahe.www.arr;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/10/19 7:43 PM
 */
public class Solution1 {

    public  static  int[] maxWindow(int[] nums,int k){
        if(nums.length == 0) return  new int []{};
        Deque<Integer> queue = new LinkedList<>();
        int [] result  = new int [nums.length+1-k];
        for(int i=0;i<nums.length;i++){
            while(!queue.isEmpty() &&  queue.peekLast()<nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            //当队列中的元素在L的左侧的时候窗口外丢弃
             if(queue.peek()< i-k+1){
                queue.poll();
            }
             //收集时机
            if(i+1>=k){
                result[i-k+1] = nums[queue.peek()];
            }
        }
        return  result;
    }
    public static void main(String args[]) {
     int [] arr = new int[]{1,3,-1,-3,5,3,6,7};

        int[] maxWindow = maxWindow(arr, 3);
        for (int i:maxWindow){
            System.out.print(i);
        }
    }
}
