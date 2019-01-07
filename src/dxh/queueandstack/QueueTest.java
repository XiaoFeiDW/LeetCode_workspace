package dxh.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

/*设计循环队列，能实现常规的操作*/
public class QueueTest {
	
	int head = -1, tail = -1;
	int[] myQueue = new int[3];
	int k;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		QueueTest qTest = new QueueTest(3);
//		System.out.println(qTest.enQueue(1));
//		System.out.println(qTest.enQueue(2));
//		System.out.println(qTest.enQueue(3));
//		System.out.println(qTest.enQueue(4));
//		System.out.println(qTest.Rear());
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(3);
		queue.add(4);
		queue.offer(5);
		
		for(int q : queue) {
			System.out.println(q);
		}
		
		
	}
	 /** Initialize your data structure here. Set the size of the queue to be k. */
    public QueueTest(int k) {
       this.k = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
        	head = 0;
//        	tail = (tail + 1) % k;
           // myQueue[++tail % k] = value;
            //return true;
        }
        tail = (tail + 1) % k;
        myQueue[tail] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(head == tail) {
        	head = -1;
        	tail = -1;
        	return true;
        }
        head = (head + 1) % k;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }else{
            return myQueue[head];
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
         if(isEmpty()){
            return -1;
        }else{
            return myQueue[tail];
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
         if(head == -1){
             return true;
         }else{
             return false;
         }
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
         if((tail + 1) % k == head){
             return true;
         }else{
             return false;
         }
    }

}
