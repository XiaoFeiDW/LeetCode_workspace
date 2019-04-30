package dxh.leetcode;
/*
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4*/

public class T21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
	    ListNode q = l1;
		q.next = new ListNode(2);
		q = q.next;
		q.next = new ListNode(4);
		q = q.next;
		q.next = new ListNode(8);
		
		ListNode l2 = new ListNode(1);
		ListNode p = l2;
		p.next = new ListNode(3);
		p = p.next;
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(5);
		p = p.next;
		p.next = new ListNode(7);
		
		ListNode l = mergeTwoLists(l1, l2);
		
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}

	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode l = new ListNode(-1);  //初始化哑结点指针
		ListNode q = l;                 //当前指针，使其指向哑结点指针
		
		while(l1 != null || l2 != null) {
			if(l1 == null && l2 != null) {
				q.next = l2;
				q = q.next;
				l2 = l2.next;
			}
			else if(l2 == null && l1 != null) {
				q.next = l1;
				q = q.next;
				l1 = l1.next;
			}
			else if(l1.val <= l2.val) {
				q.next = l1;
				q = q.next;
				l1 = l1.next;
			}else {
				q.next = l2;
				q = q.next;
				l2 = l2.next;
			}
		}
		return l.next;
	}

}
