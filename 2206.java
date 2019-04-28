import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽을 한 개 까지 부수고 이동하여도 된다.
class Main {
	static class Node {
		int x;
		int y;
		int breakCnt;

		Node(int x, int y, int breaCnt) {
			this.x = x;
			this.y = y;
			this.breakCnt = breaCnt;
		}
	}

	static int n, m;
	static int[][] a;
	static int[][][] visit;
	static int ans = -1;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	
	static void bfs(LinkedList<Node> q) {
		while (!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;
			int breakCnt = node.breakCnt;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(visit[nx][ny][breakCnt] == 0) { // 범위 안에 있고 방문 가능
						if(a[nx][ny] == 0) {
							visit[nx][ny][breakCnt] = visit[x][y][breakCnt] + 1;
							q.add(new Node(nx,ny,breakCnt));
						} else { // 벽
							if(breakCnt < 1) {
								visit[nx][ny][breakCnt+1] = visit[x][y][breakCnt] + 1;
								q.add(new Node(nx, ny, breakCnt+1));
							}
						}
					}
				}
			}
		}
	}

	static void print() {
		for(int i = 0; i <= 1; i++) {
			//System.out.println(visit[n-1][m-1][i]);
			if(visit[n-1][m-1][i] == 0)
				continue;
			if(ans == -1)
				ans = visit[n-1][m-1][i];
			ans = ans > visit[n-1][m-1][i] ? visit[n-1][m-1][i] : ans;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		visit = new int[n][m][2];
		a = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String in = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = in.charAt(j) - '0';
			}
		}
		
		LinkedList<Node> q = new LinkedList<>();
		
		if(a[0][0] == 0) {
			visit[0][0][0] = 1;
			q.add(new Node(0,0,0));
		} else {
			visit[0][0][1] = 1;
			q.add(new Node(0,0,1));
		}
		bfs(q);
		print();
		System.out.println(ans);
	}
}
