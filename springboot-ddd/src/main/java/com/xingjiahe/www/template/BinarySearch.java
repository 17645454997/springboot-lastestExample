package com.xingjiahe.www.template;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/2/15 上午11:36
 */
public class BinarySearch {

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

    public int binarySearch(int[] arr, int n, int target) {
        int begin = 0;
        int end = n - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            if (arr[begin] < arr[mid]) {
                if (arr[begin] <= target && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (arr[mid] < target && target < arr[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
     return  -1;
    }
    public static int binarySearchV2(int [] nums,int target){
        int left = 0 ;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                while (mid >= 0){
                if(target != nums[mid]){
                    break;
                }
                mid--;
                }
                if(mid == -1){
                    return  0;
                }
                return mid+1;
            }else if(target < nums[mid]){
               right = mid -1;
            }else {
                left = mid +1;
            }
        }
        return  -1;
    }


    public  static  int binarySearchV3(int [] nums){
        if(nums.length == 0 )return  0;
        int right = nums.length-1;
        int  left = 0;
        while(left<right){
            int mid = (left+right)/2;
            if(nums[right]<nums[mid]){
                left = mid+1;
            }else if(nums[mid] == nums[right]){
                right--;
            }else{
                right = mid;
            }
        }
        return  nums[left];
    }
    public static void main(String[] args) {
        int [] arr = {4,5,7,7,7,7,0,1,2};
//        System.out.println(search(arr,9,0));
//        System.out.println(binarySearchV2(arr,7));
        System.out.println(binarySearchV3(arr));
    }
}
