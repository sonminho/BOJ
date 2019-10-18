package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int x, y, dist;

		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	static int ans = 0;
	static int n, l, r;
	static int[][] map, visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static Queue<Node> q;

	static boolean isRange(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < n)
			return true;
		return false;
	}

	static int bfs() {
		Node first = q.peek();
		int cnt = 1;
		int sum = map[first.x][first.y];
		
		List<int[]> arrList = new ArrayList<>();
		arrList.add(new int[] {first.x, first.y});
		
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (isRange(nx, ny) && visited[nx][ny] == 0) {
					int now = map[cur.x][cur.y];
					int next = map[nx][ny];
					int diff = Math.abs(now - next);

					if (diff >= l && diff <= r) {
						q.add(new Node(nx, ny, cur.dist));
						visited[nx][ny] = cur.dist;
						cnt++;
						sum += map[nx][ny];
						arrList.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		for(int i = 0; i < cnt; i++) {
			map[arrList.get(i)[0]][arrList.get(i)[1]] = sum / cnt;
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		l = Integer.parseInt(stk.nextToken());
		r = Integer.parseInt(stk.nextToken());
		map = new int[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		while(true) {
			int no = 1;
			q = new LinkedList<>();
			boolean updated = false;
			
			for(int i = 0; i < n; i++) 
				Arrays.fill(visited[i], 0);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == 0) {
						q.add(new Node(i, j, no));
						visited[i][j] = no;
						if(bfs() > 1)
							updated = true;
						no++;
					}
				}
			}

			if(!updated)
				break;
			ans++;
		}

		System.out.println(ans);
	}

}
