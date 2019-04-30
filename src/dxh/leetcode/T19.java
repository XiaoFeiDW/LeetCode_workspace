package dxh.leetcode;
/*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。*/
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

//典型的双指针解法。首先让first指向链表的头结点并向后移动n步，然后让second指向头结点，两个指针一起往后移动，当first的next指针为null时，
//second的next指针便为要删除的。若删除的结点是头结点，则返回头结点的next指针。
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
		//当删除的结点为头结点时  返回头结点的下一个结点
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

