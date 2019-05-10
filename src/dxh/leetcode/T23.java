package dxh.leetcode;

import java.util.ArrayList;

/*
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
示例:
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6*/

public class T23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode q = l1;
		q.next = new ListNode(2);
		q = q.next;
		q.next = new ListNode(5);
		q = q.next;
		q.next = new ListNode(8);
		
		ListNode l2 = new ListNode(1);
		ListNode q1 = l2;
		q1.next = new ListNode(2);
		q1 = q1.next;
		q1.next = new ListNode(4);
		q1 = q1.next;
		q1.next = new ListNode(7);
		
		ListNode l3 = new ListNode(1);
		ListNode q2 = l3;
		q2.next = new ListNode(3);
		q2 = q2.next;
		q2.next = new ListNode(6);
		q2 = q2.next;
		q2.next = new ListNode(9);
		
		ListNode[] lists = {l1, l2, l3};
		ListNode lNode = mergeKLists(lists);
		
		while(lNode != null) {
			System.err.println(lNode.val);
			lNode = lNode.next;
		}
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		
		if(lists.length == 0) {
			return null;
		}else if(lists.length == 1) {
			return lists[0];
		}else if(lists.length == 2) {
			return mergeTwoLists(lists[0], lists[1]);
		}
		
		int mid = lists.length / 2;
		
		ListNode[] l1 = new ListNode[mid];
		for(int i = 0; i < mid; i++) {
			l1[i] = lists[i];
		}
		
		
		ListNode[] l2 = new ListNode[lists.length - mid];
		for(int i = mid, j = 0; i < lists.length; i++, j++) {
			l2[j] = lists[i];
		}
		
		return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode head = null;
		if(l1.val >= l2.val) {
			head = l2;
			head.next = mergeTwoLists(l1, l2.next);
		}else {
			head = l1;
			head.next = mergeTwoLists(l1.next, l2);
		}
		
		return head;
	}
}
