package com.xingjiahe.www.template;

public class QuickSort {
    public static void main(String[] args) {
        int []arr = {5,1,7,3,6,9,4,-1,-10};
        quickSort(arr);
         for(int i :arr){
             System.out.println(i + "\t");
         }
    }

   /**
    * @author  hejiaxing
    * @desc
    *
    *
    *       3                  6
    *       6 5  7 9 10  3   9
    * time   O(nlogn)  O(n2)
    * space  O(nlogn)   O(n)
    */

       public static  int [] quickSort (int []arr){
           helper(arr,0,arr.length-1);
           return  arr;
       }

    private static void helper(int[] arr, int left, int right) {
           if(left>=right) return;
           int pivot  = parttion(arr,left,right);
           helper(arr,left,pivot-1);
           helper(arr,pivot+1,right);
    }

    private static int parttion(int[] arr, int left, int right) {
           int pivot  = arr[right];
           int wall = left;
           for(int i= left;i<right;i++){
               if(arr[i]<pivot){
                   swap(arr,i,wall);
                   wall++;
               }
           }
        swap(arr,wall,right);
           return  wall;
    }

    private static void swap(int[] arr, int i, int wall) {
           int temp = arr[i];
           arr[i] = arr[wall];
           arr[wall] = temp;
    }



}
