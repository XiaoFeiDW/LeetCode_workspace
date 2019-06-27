package dxh.leetcode;

import java.util.Stack;

/*
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k的整数倍，那么将最后剩余节点保持原有顺序。
示例 :
给定这个链表：1->2->3->4->5
当 k = 2 时，应当返回: 2->1->4->3->5
当 k = 3 时，应当返回: 3->2->1->4->5*/

public class T25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		ListNode q = head;
		q.next = new ListNode(2);
		q = q.next;
		q.next = new ListNode(3);
		q = q.next;
		q.next = new ListNode(4);
		q = q.next;
		q.next = new ListNode(5);
		
		
		ListNode head1 = reverseKGroup(head, 3);
		ListNode temp = head1;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
		
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		
		 	ListNode checked = head;
	     	ListNode cur = head;
	     	ListNode curNext = null;
	        ListNode temp = null;
	        
	        int j = 0;
	        int i = 0;
	        
	        //首先判断链表长度能否翻转
	        while(checked != null && k > j){
	            checked = checked.next;
	            j++;
	        }
	        
	        //满足条件  进行翻转
	        if(j == k){
	            while(cur != null && k > i){
	                curNext = cur.next;
	                cur.next = temp;   //使用temp作为链表翻转后的头结点
	                temp = cur;
	                cur = curNext;
	                i++;
	            }
	            
	            if(curNext != null){
	                head.next = reverseKGroup(curNext, k);  //head为链表翻转后的尾结点
	            }
	            return temp;
	        }
	    
	        return head;
	}
}
