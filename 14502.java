import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 0) 빈 칸 , 1) 벽, 2) 바이러스
class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] a, temp;
	static boolean[][] c;
	static int n, m;
	static LinkedList<Node> q; 
	static int ans = 0;
	
	static class Node {
		int x,y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static void copy() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				temp[i][j] = a[i][j];
			}
		}
	}
	
	static void count() {
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(temp[i][j] == 0) { // 감염되지 않은 영역
					cnt++;
				}
			}
		}
		
		ans = cnt > ans ? cnt : ans;
	}
	
	static void bfs() {		
		while(!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;
			c[x][y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(!c[nx][ny] && temp[nx][ny] == 0) {
						temp[nx][ny] = 2; // 바이러스 감염
						q.add(new Node(nx, ny));
					}
				}
			}
		}
	}
	
	static void go(int cnt) {
		if (cnt == 3) { // 벽을 3개 세웠다면
			q = new LinkedList<>();
			c = new boolean[n][m];
			copy();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!c[i][j] && temp[i][j] == 2) { // 바이러스이면 감염시작
						q.add(new Node(i, j));
					}
				}
			}
			bfs();
			count();
			
			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(a[i][j] == 0) {
					a[i][j] = 1; // 벽 세우기
					go(cnt+1);
					a[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		a = new int[n][m];
		c = new boolean[n][m];
		temp = new int[n][m];
		for(int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		go(0);
		System.out.println(ans);
	}
}
