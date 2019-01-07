package dxh.queueandstack;

import java.awt.Dimension;
import java.awt.List;
import java.util.LinkedList;
import java.util.Queue;

/*给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
 * 一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * 输入:
11110
11010
11000
00000

输出: 1
输入:
11000
11000
00100
00011

输出: 3*/
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
    				if(grid[i][j] == '1') { //表示是第一个1
    					count++;
//    					System.err.print(i + " i ");
//    					System.out.print(j + " j ");
//    					System.out.println();
    				}
    				//进行深度优先遍历 
    				dfsVisit(grid, visited, i, j);
    			}
    
    		}
    	}
    	
    	return count;
    }
    
    //深度优先遍历
    public static void dfsVisit(char[][] grid, char[][] visited, int i, int j) {
    	//出口
    	if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1) {
    		return;
    	}else if(grid[i][j] == '0'){  //表示不是岛屿了
    		return; 
    	}else if(visited[i][j] == '1') {  //已经遍历过了 
    		return;
    	}else {   //未搜索过的节点才能继续搜索
    		visited[i][j] = '1';   //
    		
    		dfsVisit(grid, visited, i + 1, j);//往下走一步
    		dfsVisit(grid, visited, i - 1, j);//
    		dfsVisit(grid, visited, i, j + 1);
    		dfsVisit(grid, visited, i, j - 1);
    	}
    }

}
