import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int x, y, breakCnt;

		Node(int x, int y, int breakCnt) {
			this.x = x;
			this.y = y;
			this.breakCnt = breakCnt;
		}
	}
	
	static int ans = -1;
	static int k, w, h;
	static int[][] a;
	static int[][][] visit;
	static int[] dx = { 0, 0, 1, -1, -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { -1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dCnt = { 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 };

	static void bfs(LinkedList<Node> q) {
		while (!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;
			int breakCnt = node.breakCnt;

			for (int i = 0; i < 12; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nCnt = breakCnt + dCnt[i];
				
				if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
					if (a[nx][ny] == 1) // 장애물
						continue;
					if(nCnt <= k) {
						if (visit[nx][ny][nCnt] == 0) { // 범위 안에 있고 방문하지 않았으면
							visit[nx][ny][nCnt] = visit[x][y][breakCnt] + 1;
							q.add(new Node(nx, ny, nCnt));
						}
					}

				}
			}
		}
	}
	
	static void findMin() {
		for(int i = 0 ; i < 31; i++) {
			if(visit[h-1][w-1][i] == 0) { // 방문하지 않음
				continue;
			}
			if(ans == -1)
				ans = visit[h-1][w-1][i];
			ans = ans > visit[h-1][w-1][i] ? visit[h-1][w-1][i] : ans;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(stk.nextToken());
		h = Integer.parseInt(stk.nextToken());
		a = new int[h][w];
		visit = new int[h][w][31];

		for (int i = 0; i < h; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		LinkedList<Node> q = new LinkedList<>();
		
		if(a[0][0] == 0) {
			q.add(new Node(0,0,0));
			visit[0][0][0] = 0;
		} else {
			System.out.println(-1);
			return;
		}
		
		bfs(q);
		findMin();
		System.out.println(ans);
	}
}
