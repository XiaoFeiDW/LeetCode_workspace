package dxh.queueandstack;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。
 * 每次旋转都只能旋转一个拨轮的一位数字。锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转
字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。

输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。*/

public class OpenLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] deadends = {"0201","0101","0102","1212","2002"};
		System.out.println(openLock1(deadends, "0202"));
		
//		System.out.println(getNeighbors("0000"));
//		List<String> result = findNeibors("1234");
//		for(String s : result) {
//			System.err.println(s);
//		}
				
	}
	
	/*//单向搜索，效率低 思路：从"0000"开始，遍历它的所有临近组合，不是目标的加入到已经访问过的队列中，并加入到队列中，等待下一次循环开始
	public static int openLock(String[] deadends, String target) {
		int count = 0;
		String start = "0000";
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		
		List<String> visited = new ArrayList<>();
		visited.add(start);
		
		while(!q.isEmpty()) {
			int sizeQ = q.size();
			for(int i = 0; i < sizeQ; i++) {
				String top = q.peek();
				q.poll();
				
				List<String> neibors = findNeibors(top); //找到top的所有临近锁
				for(String neibor : neibors) {
					if(target.equals(neibor)) {
						count++;
						return count;
					}
					if(findString(visited, neibor)) {  //如果临近锁是已经访问过的 则退出当前循环 继续下一次循环
						continue;  
					}
					if(!findString(Arrays.asList(deadends), neibor)) {  //Arrays.asList()：将数组转换成list
						visited.add(neibor);
						q.offer(neibor);
					}
					
				}
				
			}
			count++;
		}
		
		return -1;
	}*/
	
	/*双向搜索 思路：从目标和“0000”两边一起出发，哪边的当前层集合的待检测的密码锁数目少就检测哪一边
	             当其中有一个集合为0表示断路，不可能接通。当其中一个集合中的邻居包含在另外一个集合当中则表示连接成功*/        
	public static int openLock(String[] deadends, String target) {
		int count = 0;
		String start = "0000";
		if(findString(Arrays.asList(deadends), target) && findString(Arrays.asList(deadends), start)) {
			return -1;
		}
		if(start.contains(target)) {
			return 0;
		}
		List<String> visited = new ArrayList<>();
		visited.add(start);
		//由于我们要判断某一方向搜索的节点是不是位于另一个方向搜索的集合之中，所以使用集合HashSet
		Set<String> set1 = new HashSet<>();
		set1.add(start);
		Set<String> set2 = new HashSet<>();
		set2.add(target);
		//遍历最小的集合
		while(!set1.isEmpty() && !set2.isEmpty()) {
			if(set1.size() > set2.size()) {
				Set<String> temp = set1;
				set1 = set2;
				set2 = temp;
			}
			//保存set1的节点的下一层节点
			Set<String> set3 = new HashSet<>();
			for(String curLock : set1) {
				List<String> neibors = findNeibors(curLock);
				for(String neibor : neibors) {
					//如果set2中包含了这个neibor 则表示初始和目标在途中相遇了
					if(set2.contains(neibor)) {
						return count+1;
					}
					if(visited.contains(neibor)) {
						continue;
					}
					if(!findString(Arrays.asList(deadends), neibor)) {
						visited.add(neibor);
						set3.add(neibor);
					}
				}		
			}
			count++;
			set1 = set3;	
		}
		return -1;
	}
	
	//找到当前锁只转动一次的所有临近锁
	public static List<String> findNeibors(String str){
		String temp = str;
		List<String> result = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			char[] charTemp = temp.toCharArray();  //转换成字符数组
			//执行+1操作
			charTemp[i] = String.valueOf((Integer.parseInt(String.valueOf(charTemp[i])) + 1) % 10).toCharArray()[0];
			result.add(String.valueOf(charTemp));
			//执行-1操作
			charTemp[i] = String.valueOf((Integer.parseInt(String.valueOf(charTemp[i])) + 8) % 10).toCharArray()[0];
			result.add(String.valueOf(charTemp));	
		}
		return result;
	}
	
	//找出列表toFind中是否含有str
	public static boolean findString(List<String> toFind, String str) {
		for(String temp : toFind) {
			if(str.equals(temp)) {
				return true;
			}
		}
		return false;
	}
	
	public static int openLock1(String[] deadends, String target) {
		List<String> deadendsList = Arrays.asList(deadends);
		int count = 0;
		String start = "0000";
		if(target.contains(start)) {
			return 0;
		}
		if(deadendsList.contains(start) || deadendsList.contains(target)) {
			return -1;
		}
		List<String> visited = new ArrayList<>();
		visited.add(start);
		
		Set<String> set1 = new HashSet<>();
		set1.add(start);
		Set<String> set2 = new HashSet<>();
		set2.add(target);
		
		while(!set1.isEmpty() && !set2.isEmpty()) {
			if(set1.size() > set2.size()) {
				Set<String> temp = set1;
				set1 = set2;
				set2 = temp;
			}
			Set<String> set3 = new HashSet<>();
			for(String curLock : set1) {
				List<String> neighbors = findNeibors(curLock);
				for(String neighbor : neighbors) {
					if(set2.contains(neighbor)) {
						
						return count + 1;
					}
					if(visited.contains(neighbor)) {
						continue;
					}
					if(!deadendsList.contains(neighbor)) {
						visited.add(neighbor);
						set3.add(neighbor);
					}
				}
				
			}
			count++;
			set1 = set3;
			
		}
		
		
		return -1;
	}
}
