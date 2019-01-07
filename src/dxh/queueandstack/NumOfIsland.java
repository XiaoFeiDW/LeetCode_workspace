package dxh.queueandstack;

import java.awt.Dimension;
import java.awt.List;
import java.util.LinkedList;
import java.util.Queue;

/*����һ���� '1'��½�أ��� '0'��ˮ����ɵĵĶ�ά���񣬼��㵺���������
 * һ������ˮ��Χ����������ͨ��ˮƽ�����ֱ���������ڵ�½�����Ӷ��ɵġ�����Լ���������ĸ��߾���ˮ��Χ��
 * ����:
11110
11010
11000
00000

���: 1
����:
11000
11000
00100
00011

���: 3*/
public class NumOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0','0','1','0','0'},
//				{'0','0','0','1','1'}};
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		System.out.println(numIslands(grid));

	}
	
	public static int numIslands(char[][] grid) {
    	
    	int count = 0;
    	if(grid.length == 0) {
    		return 0;
    	}
    	
    	char[][] visited = new char[grid.length][grid[0].length];
    	
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid[0].length; j++) {
    			if(visited[i][j] != '1') {
    				if(grid[i][j] == '1') { //��ʾ�ǵ�һ��1
    					count++;
//    					System.err.print(i + " i ");
//    					System.out.print(j + " j ");
//    					System.out.println();
    				}
    				//����������ȱ��� 
    				dfsVisit(grid, visited, i, j);
    			}
    
    		}
    	}
    	
    	return count;
    }
    
    //������ȱ���
    public static void dfsVisit(char[][] grid, char[][] visited, int i, int j) {
    	//����
    	if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
    		return;
    	}else if(grid[i][j] == '0'){  //��ʾ���ǵ�����
    		return; 
    	}else if(visited[i][j] == '1') {  //�Ѿ��������� 
    		return;
    	}else {   //δ�������Ľڵ���ܼ�������
    		visited[i][j] = '1';   //
    		
    		dfsVisit(grid, visited, i + 1, j);//������һ��
    		dfsVisit(grid, visited, i - 1, j);//
    		dfsVisit(grid, visited, i, j + 1);
    		dfsVisit(grid, visited, i, j - 1);
    	}
    }

}
