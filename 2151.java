import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Main {
	static class Node {
		int x,y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n; // 변의 길이
	static char[][] a; // 입력 맵
	static int[][] b; // 거리 맵
	static boolean[][] check;
	
	static List<Node> list;
	static int start = -1, end = -1;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	
	// 인접행렬 만들기
	static void traverse() {
		int size = list.size();
		check = new boolean[size][size];
		
		for(int i = 0; i < size; i++) {	
			for(int k = 0; k < 4; k++) {
				int x = list.get(i).x + dx[k];
				int y = list.get(i).y + dy[k];
				
				while(x>=0 && x<n && y>=0 && y<n) {
					char ch = a[x][y];
					
					if(ch == '*')
						break;
					if(ch == '!' || ch == '#') {
						check[i][b[x][y]] = true;
					}
					 
					x += dx[k];
					y += dy[k];
				}
			}
		}
	}
	
	// 거리 계산
	static void bfs() {
		int size = list.size();
		int[] dist = new int[size];
		
		for(int i = 0; i < size; i++) {
			dist[i] = -1;
		}
		
		LinkedList<Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			int now = q.remove();
			
			for(int i = 0; i < size; i++) {
				if(check[now][i] && dist[i] == -1) {
					dist[i] = dist[now] + 1;
					q.add(i);
				}
			}
		}
		
		System.out.println(dist[end] - 1);
	}
	
	static void print() {
		for(int i = 0; i < n; i++) {
			System.out.println();
			for(int j = 0; j < n; j++){ 
				System.out.print(b[i][j]);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new char[n][n];
		b = new int[n][n];
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			String inLine = br.readLine();
			for(int j = 0; j < n; j++){ 
				a[i][j] = inLine.charAt(j);
				
				if(a[i][j] == '#') {
					if(start == -1) {
						start = list.size();
					} else {
						end = list.size();
					}
					
					list.add(new Node(i, j));
					b[i][j] = list.size()-1;					
				} else if(a[i][j] == '!') {
					list.add(new Node(i, j));
					b[i][j] = list.size()-1;
				}
			}
		}
		
		traverse();
		bfs();
	}
}
