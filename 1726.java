import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[] dx = { 0, 0, 1, -1 }; // 동서남북
	static int[] dy = { 1, -1, 0, 0 };

	static int n, m;
	static int sx, sy, sd;
	static int ex, ey, ed;

	static int[][] map;
	static int[][][] visited;
	static Queue<Node> q = new LinkedList<>();

	static class Node {
		int x, y, dir, cost;

		Node(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}

	static void print() {
		for(int i = 0 ; i < n; i++) {
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < 4; k++) {
					System.out.print(visited[i][j][k]+" ");
				}
				System.out.print("\t");
			}
			System.out.println("\n");
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < m)
			return true;
		return false;
	}

	static void bfs() {
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int k = 1; k <= 3; k++) { // GO k - 1, 2 또는 3 현재 방향으로 전진
				int kx = cur.x + (dx[cur.dir] * k);
				int ky = cur.y + (dy[cur.dir] * k);
				
				if (isRange(kx, ky) && visited[kx][ky][cur.dir] == -1) {
					if (map[kx][ky] == 1)
						break;
					visited[kx][ky][cur.dir] = cur.cost+1;
					q.add(new Node(kx, ky, cur.dir, cur.cost+1));
				}
			}
			
			int dir = cur.dir;

			switch (dir) { // 좌회전
			case (0):dir=2;
				break;
			case (1):dir=3;
				break;
			case (2):dir=1;
				break;
			case (3):dir=0;
				break;
			}
			
			if(visited[cur.x][cur.y][dir] == -1) {
				visited[cur.x][cur.y][dir] = cur.cost+1;
				q.add(new Node(cur.x, cur.y, dir, cur.cost+1));
			}		
			
			dir = cur.dir;
			switch (dir) { // 우회전
			case (0):dir=3;
				break;
			case (1):dir=2;
				break;
			case (2):dir=0;
				break;
			case (3):dir=1;
				break;
			}
			
			if(visited[cur.x][cur.y][dir] == -1) {
				visited[cur.x][cur.y][dir] = cur.cost+1;
				q.add(new Node(cur.x, cur.y, dir, cur.cost+1));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		map = new int[n][m];
		visited = new int[n][m][4];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				
				for(int k = 0; k < 4; k++) {
					visited[i][j][k] = -1;
				}
			}
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		sx = Integer.parseInt(stk.nextToken()) - 1;
		sy = Integer.parseInt(stk.nextToken()) - 1;
		sd = Integer.parseInt(stk.nextToken()) - 1;
		stk = new StringTokenizer(br.readLine(), " ");
		ex = Integer.parseInt(stk.nextToken()) - 1;
		ey = Integer.parseInt(stk.nextToken()) - 1;
		ed = Integer.parseInt(stk.nextToken()) - 1;

		visited[sx][sy][sd] = 0;
		q.add(new Node(sx, sy, sd, 0));
		bfs();
		
		System.out.println(visited[ex][ey][ed]);
	}
}
