package dxh.leetcode;

import java.util.Stack;

/*
 * ����һ������ÿ k ���ڵ�һ����з�ת�������ط�ת�������
k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ��������� k������������ô�����ʣ��ڵ㱣��ԭ��˳��
ʾ�� :
�����������1->2->3->4->5
�� k = 2 ʱ��Ӧ������: 2->1->4->3->5
�� k = 3 ʱ��Ӧ������: 3->2->1->4->5*/

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
