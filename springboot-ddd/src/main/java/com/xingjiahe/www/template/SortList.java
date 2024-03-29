package com.xingjiahe.www.template;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/2/22 下午4:50
 */
public class SortList {
   public class ListNode{
       ListNode head;
       ListNode next;
       int val;
   }

   public ListNode sortList(ListNode head){
       quickSort(head,null);
       return  head;
   }

   public static  void quickSort(ListNode head,ListNode end){
       if(head !=end){
           ListNode node = partion(head,end);
           quickSort(head,node);
           quickSort(node.next,end);
       }
   }

   public static  ListNode partion(ListNode head, ListNode end){
       ListNode p1 = head, p2 = head.next;
       while (p2!=end){
           if(p2.val <head.val){
               p1=p1.next;
               int temp = p1.val;
               p1.val=p2.val;
               p2.val = temp;
           }
           p2 =p2.next;
       }
       if(p1 !=head){
           int temp = p1.val;
           p1.val = head.val;
           head.val = temp;
       }
       return  p1;
   }
}
