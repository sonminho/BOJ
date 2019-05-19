import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static int n, m;
	static int[][] a;
	static int[][][] d;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Node {
		int x, y, t;

		Node(int x, int y, int t) {
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	static int bfs() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(d[i][j], -1);
			}
		}

		LinkedList<Node> q = new LinkedList<>();
		// 0, 0에 0분에 방문
		q.add(new Node(0, 0, 0));
		d[0][0][0] = 0;

		while (!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;
			int t = node.t;

			// 오작교이고 건널수 없을때
			if (a[x][y] >= 2 && (t % a[x][y]) != 0) {
				int nt = (t + 1) % a[x][y];

				if (d[x][y][nt] == -1) {
					d[x][y][nt] = d[x][y][t] + 1;
					q.add(new Node(x, y, nt));
				}
			} else {
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
						if (a[x][y] >= 2 && a[nx][ny] >= 2)
							continue;

						// 이동할 수 있음
						if (a[nx][ny] >= 1) {
							int nt = (d[x][y][t] + 1) % a[nx][ny];
							if (d[nx][ny][nt] == -1) {
								d[nx][ny][nt] = d[x][y][t] + 1;
								q.add(new Node(nx, ny, nt));
							}
						}
					}
				}
			}
		}

		int ans = -1;

		for (int i = 0; i < 20; i++) {
			// 도착점에 방문불가
			if (d[n - 1][n - 1][i] == -1)
				continue;

			if (ans == -1) {
				ans = d[n - 1][n - 1][i];
				continue;
			}

			ans = d[n - 1][n - 1][i] < ans ? d[n - 1][n - 1][i] : ans;
		}

		return ans;
	}

	// 절벽이 교차하면 false 리턴
	static boolean isMovable(int i, int j) {
		boolean hor = false, ver = false;

		if ((j - 1) >= 0 && a[i][j - 1] == 0)
			hor = true;
		if ((j + 1) < n && a[i][j + 1] == 0)
			hor = true;
		if ((i - 1) >= 0 && a[i - 1][j] == 0)
			ver = true;
		if ((i + 1) < n && a[i + 1][j] == 0)
			ver = true;

		return !(hor && ver);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		a = new int[n][n];
		d = new int[n][n][20];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		int ans = -1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0 && isMovable(i, j)) {
					a[i][j] = m;
					int now = bfs();

					if (now != -1) {
						if (ans == -1 || ans > now) {
							ans = now;
						}
					}

					a[i][j] = 0;
				}
			}
		}

		System.out.println(ans);
	}

}
