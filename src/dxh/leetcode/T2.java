package dxh.leetcode;

import java.util.Scanner;

/*
给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。

你可以假设除了数字 0 之外，这两个数字都不会以零开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807*/

//Definition for singly-linked list.
//创建一个节点
class ListNode {
     int val;             //结点数据域
     ListNode next;         //节点指针域 
     ListNode(int x) { val = x; }  //当构造一个新的节点的时候，顺便给节点进行初始化
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
			curr = curr.next;     //将当前节点进位到下一个节点
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
