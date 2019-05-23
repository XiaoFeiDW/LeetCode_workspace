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
		
		
		ListNode head1 = reverseKGroup(head, 5);
		while(head1 != null) {
			System.err.println(2);
			head1 = head1.next;
		}
	}
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		
		Stack<ListNode> stack = new Stack<>();
		
		if(k == 1) {
			return head;
		}
		
		ListNode p = head;
		ListNode dummyHead = new ListNode(1);
		ListNode q = dummyHead;
		while(k > 0) {
			stack.push(p);
			p = p.next;
			k--;
		}
		
		
		return dummyHead.next;
	}

}
