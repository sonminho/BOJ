import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] a, temp;
	static int n, m, h;
	static ArrayList<Node> list, tempList;
	static int ans = -1;
	
	static void copy() {
		for(int i = 1; i <= h; i++) {
			for(int j = 1; j <= n; j++) {
				temp[i][j] = a[i][j];
			}
		}
	}
	
	static int down(int y) {
		int r = 1;
		int c = y;
		
		while(r <= h) {
			if(temp[r][c] == 1) {
				c++;
			} else if(temp[r][c] == 2) {
				c--;
			}
			r++;
		}
		
		return c;
	}
	
	static void go(int idx, int cnt) {
		if(idx == cnt) {			
			if(check()) {
				if(ans == -1) {
					ans = cnt;
				} else {
					ans = ans < cnt ? ans : cnt;
				}
			} 
		
			return;
		}
		
		for(int i = 1; i <= h; i++) {
			for(int j = 1; j < n; j++) {
				if(temp[i][j] == 0 && temp[i][j+1] == 0) {
					temp[i][j] = 1;
					temp[i][j+1] = 2;
					go(idx+1, cnt);
					temp[i][j] = 0;
					temp[i][j+1] = 0;
				}
			}
		}
	}
	
	static boolean check() {
		for(int i = 1 ; i <= n; i++) {
			if(i != down(i))
				return false;
		}
		return true;
	}
	
	static void print() {
		System.out.println();
		for(int i = 1; i <= h; i++) {
			for(int j = 1; j <= n; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		h = Integer.parseInt(stk.nextToken());
		
		a = new int[h+1][n+1];
		temp = new int[h+1][n+1];
		
		list = new ArrayList<>();
		tempList = new ArrayList<>();
		
		for(int i = 0 ; i < m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			list.add(new Node(x, y));
			a[x][y] = 1;
			a[x][y+1] = 2;
		}
		
		for(int i = 0; i < 4; i++) {
			copy();
			go(0, i);
			if(ans != -1)
				break;
		}
		
		System.out.println(ans);
	}
}
