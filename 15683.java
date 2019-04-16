import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int x;
		int y;
		int t;
		int d;
		
		Node(int x, int y, int t, int d) {
			this.x = x;
			this.y = y;
			this.t = t;
			this.d = d;
		}
	}
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] a, temp;
	static int n, m;
	static ArrayList<Node> list;
	static int ans = 64;
	
	static void check(int x, int y, int d) {
		while(true) {
			x += dx[d];
			y += dy[d];
			if (x >= 0 && x < n && y >= 0 && y < m) {
				if(temp[x][y] == 6)
					break;
				temp[x][y] = 7;
			} else
				break;
		}
	}
	
	static void copy (){
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				temp[i][j] = a[i][j];
			}
		}
	}
	
	static void go(int cnt) {
		if(cnt == list.size()) {
			copy();
			for(Node node : list) {
				int t = node.t;
				int x = node.x;
				int y = node.y;
				int d = node.d;
				
				if(t == 1) {
					check(x, y, d);
				} else if(t == 2) {
					check(x, y, d);
					check(x, y, (d+2)%4);
				} else if(t == 3) {
					check(x, y, d);
					check(x, y, (d+1)%4);
				} else if(t == 4) {
					check(x, y, d);
					check(x, y, (d+1)%4);
					check(x, y, (d+2)%4);
				} else if(t == 5) {
					check(x, y, d);
					check(x, y, (d+1)%4);
					check(x, y, (d+2)%4);
					check(x, y, (d+3)%4);
				}
			}
			
			int num = count();
			ans = ans > num ? num : ans;
			
			return;
		}
		
		for(int i = 0; i < 4; i++) { // 회전 
			list.get(cnt).d = i;
			go(cnt + 1);
		}
	}
	
	static int count() {
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(temp[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	
	static void print() {
		for(int i = 0; i < n; i++) {
			System.out.println();
			for(int j = 0; j < m; j++) {
				System.out.print(temp[i][j]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		a = new int[n][m];
		temp = new int[n][m];
		list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				if(a[i][j] != 6 && a[i][j] != 0) {
					list.add(new Node(i, j, a[i][j], 0));
				}
			}
		}
		go(0);
		
		System.out.println(ans);
	}
}
