package com.xingjiahe.www.template;

public class QuickSort {
    public static void main(String[] args) {
        int []arr = {5,1,7,3,6,9,4};
        quickSort(arr,0,arr.length-1);
         for(int i :arr){
             System.out.println(i + "\t");
         }
    }

   /**
    * @author  hejiaxing
    * @desc
    * time   O(nlogn)  O(n2)
    * space  O(nlogn)   O(n)
    */

       public static  void quickSort(int []arr, int leftIndex ,int rightIndex){
           if(leftIndex >= rightIndex) return;
           int left  = leftIndex;
           int right = rightIndex;
           //基准位
           int key = arr[left];
           while (left<right){
               while (left<right && arr[right]>=key){
                   right--;
               }
               while (left<right && arr[left]<=key){
                   left++;
               }
               int temp = arr[left];
               arr[left] = arr[right];
               arr[right] = temp;
           }
            int temp = arr[left];
           arr[left] = arr [leftIndex];
           arr[leftIndex] =temp;
           quickSort(arr,left-1,leftIndex);
           quickSort(arr,right+1,rightIndex);
       }
}
