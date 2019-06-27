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
	        
	        //�����ж��������ܷ�ת
	        while(checked != null && k > j){
	            checked = checked.next;
	            j++;
	        }
	        
	        //��������  ���з�ת
	        if(j == k){
	            while(cur != null && k > i){
	                curNext = cur.next;
	                cur.next = temp;   //ʹ��temp��Ϊ����ת���ͷ���
	                temp = cur;
	                cur = curNext;
	                i++;
	            }
	            
	            if(curNext != null){
	                head.next = reverseKGroup(curNext, k);  //headΪ����ת���β���
	            }
	            return temp;
	        }
	    
	        return head;
	}
}
