package dxh.leetcode;
/*
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
  不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例:
给定 1->2->3->4, 你应该返回 2->1->4->3.*/

public class T24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		ListNode dummyHead = head;
		dummyHead.next = new ListNode(2);
		dummyHead = dummyHead.next;
		dummyHead.next = new ListNode(3);
		dummyHead = dummyHead.next;
		dummyHead.next = new ListNode(4);
		
		ListNode l = swapPairs(head);
		
		while(l != null) {
			System.err.println(l.val);
			l = l.next;
		}
	}
	
	public static ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode temp = dummyHead;
		while(temp.next != null && temp.next.next != null) {
			
			ListNode node1 = temp.next;
			ListNode node2 = node1.next;
			ListNode node3 = node2.next;
			
			temp.next = node2;
			node2.next = node1;
			node1.next = node3;
	
			System.out.println(node1.val);
			temp = node1;
		}
		
		return dummyHead.next;
	}

}
