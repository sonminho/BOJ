import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.sound.midi.Synthesizer;

public class Main {
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = { 0, 1, 0, -1 }; // µ¿ ³² ¼­ ºÏ
	static int[] dy = { 1, 0, -1, 0 };
	static int r, c;
	static char[][] a;
	static boolean[][] v;
	static int[] lowestRow;
	static int minDiff;
	static List<Node> traverseList = new ArrayList<>();
	
	static void dfs(int x, int y) {
		if(v[x][y] || a[x][y] == '.')
			return;
		
		v[x][y] = true;
		traverseList.add(new Node(x, y));
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(1 <= nx && nx <= r && 1 <= ny && ny <= c) {
				dfs(nx, ny);
			}
		}
	}
	
	static void move() {
		v = new boolean[r+1][c+1];
		
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= c; j++) {
				if(v[i][j] || a[i][j] == '.')
					continue;
				traverseList = new ArrayList<>();
				dfs(i, j);
				lowestRow = new int[c+1];
				
				for(Node node : traverseList) {
					lowestRow[node.y] = Math.max(lowestRow[node.y], node.x);
					a[node.x][node.y] = '.';
				}
				
				minDiff = r + 1;
				
				for(int k = 1; k <= c; k++) {
					if(lowestRow[k] == 0)
						continue;
					
					int x;
					for(x = lowestRow[k]; x <= r && a[x][k] == '.'; x++);

					minDiff = Math.min(minDiff, x-lowestRow[k]-1); 
				}
				
				for(Node node : traverseList) {
					node.x += minDiff;
					a[node.x][node.y] = 'x';
					v[node.x][node.y] = true;
				}				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		StringBuilder ans = new StringBuilder();
		
		r = Integer.parseInt(in[0]);
		c = Integer.parseInt(in[1]);
		a = new char[r+1][c+1];
		v = new boolean[r+1][c+1];
		
		for(int i = 1; i <= r; i++) {
			String str = br.readLine();
			for(int j = 1; j <= c; j++) {
				a[i][j] = str.charAt(j-1);
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			int row = r - Integer.parseInt(stk.nextToken()) + 1;
			
			if(i % 2 == 0) {
				for(int j = 1; j <= c; j++) {
					if(a[row][j] == 'x') {
						a[row][j] = '.';
						break;
					}
				}
			} else {
				for(int j = c; j >= 1; j--) {
					if(a[row][j] == 'x') {
						a[row][j] = '.';
						break;
					}
				}
			}
			move();			
		}
				
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= c; j++) {
				ans.append(a[i][j]);
			}
			ans.append("\n");
		}
		System.out.println(ans);
	}
}