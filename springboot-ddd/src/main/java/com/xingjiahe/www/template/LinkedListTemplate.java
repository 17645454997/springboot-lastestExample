package com.xingjiahe.www.template;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/1/14 下午3:40
 */
public class LinkedListTemplate {

    class ListNode{
        int val;
        ListNode next;
    }
    public  ListNode  linkedlistMiddleNode(ListNode head){
        ListNode  i = head,j=head;
        while (j!=null && j.next!=null){
            i=i.next;
            j=j.next.next;
        }
        return  i;
    }
   public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return  head;
        }
        ListNode reversed_head =  reverse(head.next);
        head.next.next = head;
        head.next = null;
        return  reversed_head;
   }
}
