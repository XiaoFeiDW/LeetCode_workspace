package dxh.queueandstack;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*����һ�������ĸ�Բ�β��ֵ�ת������ÿ�����ֶ���10�����֣� '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ��ÿ�����ֿ���������ת������� '9' ��Ϊ  '0'��'0' ��Ϊ '9' ��
 * ÿ����ת��ֻ����תһ�����ֵ�һλ���֡����ĳ�ʼ����Ϊ '0000' ��һ�������ĸ����ֵ����ֵ��ַ�����
�б� deadends ������һ���������֣�һ�����ֵ����ֺ��б�����κ�һ��Ԫ����ͬ����������ᱻ�����������޷��ٱ���ת
�ַ��� target ������Խ��������֣�����Ҫ������С����ת���������������β��ܽ��������� -1��

���룺deadends = ["0201","0101","0102","1212","2002"], target = "0202"
�����6
���ͣ����ܵ��ƶ�����Ϊ "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"��
ע�� "0000" -> "0001" -> "0002" -> "0102" -> "0202" �����������ǲ��ܽ����ģ�
��Ϊ�������� "0102" ʱ������ͻᱻ������

����: deadends = ["8888"], target = "0009"
�����1
���ͣ�
�����һλ������תһ�μ��� "0000" -> "0009"��*/

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
	
	/*//����������Ч�ʵ� ˼·����"0000"��ʼ���������������ٽ���ϣ�����Ŀ��ļ��뵽�Ѿ����ʹ��Ķ����У������뵽�����У��ȴ���һ��ѭ����ʼ
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
				
				List<String> neibors = findNeibors(top); //�ҵ�top�������ٽ���
				for(String neibor : neibors) {
					if(target.equals(neibor)) {
						count++;
						return count;
					}
					if(findString(visited, neibor)) {  //����ٽ������Ѿ����ʹ��� ���˳���ǰѭ�� ������һ��ѭ��
						continue;  
					}
					if(!findString(Arrays.asList(deadends), neibor)) {  //Arrays.asList()��������ת����list
						visited.add(neibor);
						q.offer(neibor);
					}
					
				}
				
			}
			count++;
		}
		
		return -1;
	}*/
	
	/*˫������ ˼·����Ŀ��͡�0000������һ��������ıߵĵ�ǰ�㼯�ϵĴ�������������Ŀ�پͼ����һ��
	             ��������һ������Ϊ0��ʾ��·�������ܽ�ͨ��������һ�������е��ھӰ���������һ�����ϵ������ʾ���ӳɹ�*/        
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
		//��������Ҫ�ж�ĳһ���������Ľڵ��ǲ���λ����һ�����������ļ���֮�У�����ʹ�ü���HashSet
		Set<String> set1 = new HashSet<>();
		set1.add(start);
		Set<String> set2 = new HashSet<>();
		set2.add(target);
		//������С�ļ���
		while(!set1.isEmpty() && !set2.isEmpty()) {
			if(set1.size() > set2.size()) {
				Set<String> temp = set1;
				set1 = set2;
				set2 = temp;
			}
			//����set1�Ľڵ����һ��ڵ�
			Set<String> set3 = new HashSet<>();
			for(String curLock : set1) {
				List<String> neibors = findNeibors(curLock);
				for(String neibor : neibors) {
					//���set2�а��������neibor ���ʾ��ʼ��Ŀ����;��������
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
	
	//�ҵ���ǰ��ֻת��һ�ε������ٽ���
	public static List<String> findNeibors(String str){
		String temp = str;
		List<String> result = new ArrayList<>();
		for(int i = 0; i < str.length(); i++) {
			char[] charTemp = temp.toCharArray();  //ת�����ַ�����
			//ִ��+1����
			charTemp[i] = String.valueOf((Integer.parseInt(String.valueOf(charTemp[i])) + 1) % 10).toCharArray()[0];
			result.add(String.valueOf(charTemp));
			//ִ��-1����
			charTemp[i] = String.valueOf((Integer.parseInt(String.valueOf(charTemp[i])) + 8) % 10).toCharArray()[0];
			result.add(String.valueOf(charTemp));	
		}
		return result;
	}
	
	//�ҳ��б�toFind���Ƿ���str
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
