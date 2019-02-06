import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] a;
	static boolean[][] d;

	static int maxHeight = 1; // 비가 오지 않는 경우 안전영역은 1개의 구역이 존재
	static int maxSize = 0;
	static int size = 0;
	static int countOfParty = 0;

	static void dfs(int x, int y, int height, int n) {
		if (a[x][y] < height)
			return;

		if (!d[x][y]) { // 방문하지 않았으면!
			d[x][y] = true; // 방문

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < n && nx >= 0 && ny < n && ny >= 0) {
					if (a[nx][ny] >= height) {
						dfs(nx, ny, height, n);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		a = new int[n][n];
		StringTokenizer stk = null;

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());

				if (a[i][j] > maxHeight)
					maxHeight = a[i][j];
			}
		}

		for (int h = 1; h <= maxHeight; h++) {
			size = 0;
			d = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!d[i][j] && a[i][j] >= h) {
						dfs(i, j, h, n);
						size++;
					}
				}
			}

			// System.out.println("\n h = " + h + " size = " + size +"\n");
			if (size > maxSize)
				maxSize = size;
		}

		System.out.println(maxSize);
	}
}