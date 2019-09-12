package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int n, cnt;
	static int[][] a;
	static int[][] d;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static StringBuilder ans = new StringBuilder();
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x; 
			this.y = y;
		}
	}

	static int bfs(LinkedList<Node> q) {
		int size = 1;
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			int nodeX = node.x;
			int nodeY = node.y;
			
			for(int i = 0; i < 4; i++) {
				int newX = nodeX + dx[i];
				int newY = nodeY + dy[i];
				
				if(newX >= 0 && newX < n && newY >= 0 && newY < n) {
					if(a[newX][newY] == 1 && d[newX][newY] == 0) { // 방문하지 않음
						d[newX][newY] = cnt;
						q.add(new Node(newX, newY));
						size++;
					}
				}
			}			
		}
		
		return size;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n][n];
		d = new int[n][n];
		cnt = 0;
		
		for(int i = 0; i < n; i++) {
			String inLine = br.readLine();
			
			for(int j = 0; j < n; j++) {
				a[i][j] = inLine.charAt(j) - '0';
			}
		}
		
		LinkedList<Node> q = new LinkedList<>();
		List<Integer> sizeList = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(a[i][j] == 1 && d[i][j] == 0) {
					cnt++;
					d[i][j] = cnt;
					q.add(new Node(i, j));					
					sizeList.add(bfs(q));
				}
			}
		}		
		
		ans.append(cnt + "\n");
		
		sizeList.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 < o2)
					return -1;
				else if(o1 > o2)
					return 1;
				else
					return 0;
			}
		});
		
		for(int size : sizeList)
			ans.append(size + "\n");
		
		System.out.println(ans.toString());
	}
}
