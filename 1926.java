import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] check;
	static int partySize;

	static void dfs(int[][] a, int x, int y, int maxX, int maxY, int cnt) {
		if (check[x][y] == false) {
			check[x][y] = true;
			partySize++;
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < maxX && ny >= 0 && ny < maxY) {
					if (check[nx][ny] == false && a[nx][ny] == 1) {
						dfs(a, nx, ny, maxX, maxY, cnt++);
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		check = new boolean[n][m];
		int[][] a = new int[n][m];
		
		List<Integer> partySizeList = new ArrayList<>();
		int partiesCount = 0;

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (check[i][j] == false && a[i][j] == 1) {
					partySize = 0;
					dfs(a, i, j, n, m, 1);
					partiesCount++;
					partySizeList.add(partySize);					
				}
			}
		}

		System.out.println(partiesCount);

		if (partySizeList.size() > 0) {
			Collections.sort(partySizeList);
			System.out.println(partySizeList.get(partySizeList.size() - 1));
		} else {
			System.out.println(0);
		}
	}
}
