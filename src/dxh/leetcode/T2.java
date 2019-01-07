package dxh.leetcode;

import java.util.Scanner;

/*
���������ǿ���������ʾ�����Ǹ�������λ����������ʽ�洢�����ǵ�ÿ���ڵ�ֻ�洢�������֡���������ӷ���һ���µ�����

����Լ���������� 0 ֮�⣬���������ֶ��������㿪ͷ��
ʾ����
���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)
�����7 -> 0 -> 8
ԭ��342 + 465 = 807*/

//Definition for singly-linked list.
//����һ���ڵ�
class ListNode {
     int val;             //���������
     ListNode next;         //�ڵ�ָ���� 
     ListNode(int x) { val = x; }  //������һ���µĽڵ��ʱ��˳����ڵ���г�ʼ��
 }

public class T2{
	
	public static void main(String[] args) {
		ListNodeTest listNodeTest1 = new ListNodeTest();
		listNodeTest1.addNode(2);
		listNodeTest1.addNode(4);
		listNodeTest1.addNode(3);
		listNodeTest1.addNode(5);
		
		ListNode l1 = listNodeTest1.head;
	
		ListNodeTest listNodeTest2 = new ListNodeTest();
		listNodeTest2.addNode(5);
		listNodeTest2.addNode(6);
		ListNode l2 = listNodeTest2.head;
		
		ListNode l3 = addTwoNumbers(l1, l2);
		while(l1 != null) {
			System.out.print(l1.val + " ");
			l1 = l1.next;
		}
		System.err.println();
		
		
		
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		while(p != null || q != null) {
			int x = (p != null) ? p.val : 0;
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;
			curr.next = new ListNode(sum % 10);
			curr = curr.next;     //����ǰ�ڵ��λ����һ���ڵ�
			if(p != null) p = p.next;
			if(q != null) q = q.next;
			
		} 
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		
		return dummyHead.next;
	
	}
	
}
class ListNodeTest{
	static ListNode head = null;
	public void addNode(int num) {
		
		ListNode temp = null;
		
		ListNode node = new ListNode(num);
		
		if(head == null) {
			head = node;
			return;
		}
		temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = node;
	}
	
}
