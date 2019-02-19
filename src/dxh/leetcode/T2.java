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
		//������������
		//��һ������2 -> 4 -> 3
		ListNode l1 = new ListNode(2);
		ListNode p = l1;   //��p����l1ȥ��ֵ��һ����Ҫ��ͷ���l1�Լ�ȥ������������Ҳ�������ͷ��
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(3);
		
		//�ڶ�������5 -> 6 -> 4
		ListNode l2 = new ListNode(5);
		ListNode q = l2;
		q.next = new ListNode(6);
		q = q.next;
		q.next = new ListNode(4);
		
		ListNode list = addTwoNumbers(l1, l2);
		ListNode temp = list;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
		
		
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode dummyHead = new ListNode(0); //�¶���һ���������洢����Ľ��
		ListNode p = l1;
		ListNode q = l2;
		ListNode curr = dummyHead;
		int carry = 0;   //��λ
		while(p != null || q != null) {
			int x = (p != null) ? p.val : 0;  //���ڵ�Ϊ�գ�Ĭ��Ϊ0
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;  //���½�λ
			curr.next = new ListNode(sum % 10);  //���½ڵ�
			curr = curr.next;     //����ǰ�ڵ��λ����һ���ڵ�
			if(p != null) p = p.next;  //����������l1��l2������һ���ڵ�
			if(q != null) q = q.next;
			
		} 
		//��������н�λ��������һ���½���Ա������λ�Ľ�λ
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		
		return dummyHead.next;
	
	}
	
}
