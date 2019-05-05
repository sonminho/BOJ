import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, m;
	static int ans = 0;
	static int[][] a;
	static int[][] v;
	static int[] roomArea;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int bfs(LinkedList<Node> q, int cnt) {
		int area = 1; // 방 크기

		while (!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					if (v[nx][ny] != 0)
						continue;

					if ((a[x][y] & (1 << i)) == 0) { // 벽이 겹치지 않으면
						v[nx][ny] = cnt;
						area++;
						q.add(new Node(nx, ny));
					}
				}
			}
		}

		return area;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder result = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		a = new int[m + 1][n + 1];
		v = new int[m + 1][n + 1];
		roomArea = new int[2501];

		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		int cnt = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (v[i][j] == 0) {
					cnt++;
					LinkedList<Node> q = new LinkedList<Node>();
					q.add(new Node(i, j));
					v[i][j] = cnt;
					int localArea = bfs(q, cnt);
					roomArea[cnt] = localArea; // 방 번호에 대한 방 크기 입력
					ans = ans < localArea ? localArea : ans;
				}
			}
		}

		result.append(cnt + "\n");
		result.append(ans + "\n");

		ans = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
						if (v[i][j] == v[nx][ny]) // 방 번호가 같음
							continue;

						int newRoomArea = roomArea[v[i][j]] + roomArea[v[nx][ny]];
						ans = ans < newRoomArea ? newRoomArea : ans;
					}
				}
			}
		}
		result.append(ans);
		System.out.println(result);
	}
}
