package dxh.leetcode;
/*����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣

ʾ����

����һ������: 1->2->3->4->5, �� n = 2.

��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
˵����

������ n ��֤����Ч�ġ�*/
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

//���͵�˫ָ��ⷨ��������firstָ�������ͷ��㲢����ƶ�n����Ȼ����secondָ��ͷ��㣬����ָ��һ�������ƶ�����first��nextָ��Ϊnullʱ��
//second��nextָ���ΪҪɾ���ġ���ɾ���Ľ����ͷ��㣬�򷵻�ͷ����nextָ�롣
public class T19 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode l = new ListNode(1);
		ListNode q = l;
		q.next = new ListNode(2);
		q = q.next;
		q.next = new ListNode(3);
		
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		while(n != 0) {
			first = first.next;
			n--;
		}
		//��ɾ���Ľ��Ϊͷ���ʱ  ����ͷ������һ�����
        if(first == null){
            return head.next;
        }
		
		ListNode second = head;
		while(first.next != null) {
			first = first.next;
			second = second.next;
		}
		
		second.next = second.next.next;
		
		return head;
		
    } 
	
	public static ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode first = dummyHead;
		while(n != 0) {
			first = first.next;
			n--;
		}
		
		ListNode second = dummyHead;
		while(first.next != null) {
			first = first.next;
			second = second.next;
		}
		
		second.next = second.next.next;
		return dummyHead.next;
	}
	
}

