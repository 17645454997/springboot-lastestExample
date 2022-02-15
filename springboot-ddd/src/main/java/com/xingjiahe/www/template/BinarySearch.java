package com.xingjiahe.www.template;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/2/15 上午11:36
 */
public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {4,5,7,0,1,2};
        System.out.println(search(arr,6,0));
    }
    public static   int search(int [] arr,int n,int target){
        int begin = 0;
        int end = n-1;
        while (begin<=end){
            int mid = begin + (end -begin)/2;
            if(arr[mid] == target){
                return  mid;
            }
            if(arr[begin] <arr[mid]){
                if(arr[begin]<=target && target <arr[mid]){
                    end = mid-1;
                }else {
                    begin= mid+1;
                }
            }else {
                if(arr[mid]<target && target<=arr[end]){
                    begin =mid+1;
                }else {
                    end = mid-1;
                }
            }
        }
      return  -1;
    }
}
