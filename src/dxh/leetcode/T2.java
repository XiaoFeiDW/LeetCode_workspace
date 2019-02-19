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
		//创建两个链表
		//第一个链表2 -> 4 -> 3
		ListNode l1 = new ListNode(2);
		ListNode p = l1;   //用p代替l1去赋值，一定不要用头结点l1自己去遍历，否则就找不到链表头了
		p.next = new ListNode(4);
		p = p.next;
		p.next = new ListNode(3);
		
		//第二个链表5 -> 6 -> 4
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
		
		ListNode dummyHead = new ListNode(0); //新定义一个链表来存储计算的结果
		ListNode p = l1;
		ListNode q = l2;
		ListNode curr = dummyHead;
		int carry = 0;   //进位
		while(p != null || q != null) {
			int x = (p != null) ? p.val : 0;  //若节点为空，默认为0
			int y = (q != null) ? q.val : 0;
			int sum = carry + x + y;
			carry = sum / 10;  //更新进位
			curr.next = new ListNode(sum % 10);  //更新节点
			curr = curr.next;     //将当前节点进位到下一个节点
			if(p != null) p = p.next;  //继续对链表l1、l2遍历下一个节点
			if(q != null) q = q.next;
			
		} 
		//如果最终有进位，则生成一个新结点以保存最高位的进位
		if(carry > 0) {
			curr.next = new ListNode(carry);
		}
		
		return dummyHead.next;
	
	}
	
}
