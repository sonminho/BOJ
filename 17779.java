
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map, bMap;
	static int n;
	static int startX, startY;
	static int totalSum = 0;
	static int min, max;
	static int ans = Integer.MAX_VALUE;
	
	static void go(int sx, int sy, int mx1, int my1, int btX, int btY, int mx2, int my2, int ex, int ey) {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;

		bMap = new int[n + 1][n + 1];

		for (int i = sx, j = sy; i <= mx1 && j > my1; i++, j--) {
			bMap[i][j] = -1;
		}
		for (int i = mx1, j = my1; i < btX && j < btY; i++, j++) {
			bMap[i][j] = -1;
		}
		for (int i = btX, j = btY; i > mx2 && j < my2; i--, j++) {
			bMap[i][j] = -1;
		}
		for (int i = mx2, j = my2; i > ex && j > ey; i--, j--) {
			bMap[i][j] = -1;
		}

		int sum1 = 0;
		for (int i = 1; i < mx1; i++) {
			for (int j = 1; j <= sy; j++) {
				if (bMap[i][j] != -1) {
					sum1 += map[i][j];
				} else {
					break;
				}
			}
		}
		max = max < sum1 ? sum1 : max;
		min = min > sum1 ? sum1 : min;
		// System.out.println("1 구역 합 : " + sum1);

		int sum2 = 0;
		for (int i = 1; i <= mx2; i++) {
			for (int j = n; j > sy; j--) {
				if (bMap[i][j] != -1) {
					sum2 += map[i][j];
				} else {
					break;
				}
			}
		}
		max = max < sum2 ? sum2 : max;
		min = min > sum2 ? sum2 : min;
		// System.out.println("2 구역 합 : " + sum2);

		int sum3 = 0;
		for (int i = mx1; i <= n; i++) {
			for (int j = 1; j < btY; j++) {
				if (bMap[i][j] != -1) {
					sum3 += map[i][j];
				} else {
					break;
				}
			}
		}
		max = max < sum3 ? sum3 : max;
		min = min > sum3 ? sum3 : min;
		// System.out.println("3 구역 합 : " + sum3);

		int sum4 = 0;
		for (int i = n; i > mx2; i--) {
			for (int j = n; j >= btY; j--) {
				if (bMap[i][j] != -1) {
					sum4 += map[i][j];
				} else {
					break;
				}
			}
		}
		max = max < sum4 ? sum4 : max;
		min = min > sum4 ? sum4 : min;
		// System.out.println("4 구역 합 : " + sum4);

		int sum5 = totalSum - sum1 - sum2 - sum3 - sum4;
		max = max < sum5 ? sum5 : max;
		min = min > sum5 ? sum5 : min;
		// System.out.println("5 구역 합 : " + sum5);

		// System.out.println("최대 최소" + max + ", " + min);

		ans = (max - min) > ans ? ans : (max - min);
	}

	static void traversal(int cnt, int idx, int sx, int sy, int mx1, int my1, int btX, int btY, int mx2, int my2,
			int ex, int ey) {
		if (cnt == 4) {
			if (startX == ex && startY == ey)
				go(sx, sy, mx1, my1, btX, btY, mx2, my2, ex, ey);
			return;
		}

		int nx, ny;
		int dist = 1;
		if (idx == 1) {
			while (true) {
				nx = sx + (1 * dist);
				ny = sy + (-1 * dist);

				if (nx >= 2 && nx <= n - 1 && ny >= 1 && ny <= n - 2) {
					bMap[nx][ny] = -1;
					traversal(cnt + 1, 2, sx, sy, nx, ny, btX, btY, mx2, my2, ex, ey);
					bMap[nx][ny] = 0;
				} else {
					break;
				}
				dist++;
			}
		} else if (idx == 2) {
			while (true) {
				nx = mx1 + 1 * dist;
				ny = my1 + 1 * dist;

				if (nx >= 3 && nx <= n && ny >= 2 && ny <= n - 1) {
					bMap[nx][ny] = -1;
					traversal(cnt + 1, 3, sx, sy, mx1, my1, nx, ny, mx2, my2, ex, ey);
					bMap[nx][ny] = 0;
				} else {
					break;
				}
				dist++;
			}
		} else if (idx == 3) {
			while (true) {
				nx = btX + (-1 * dist);
				ny = btY + (1 * dist);

				if (nx >= 2 && nx <= n - 1 && ny >= 3 && ny <= n) {
					bMap[nx][ny] = -1;
					traversal(cnt + 1, 4, sx, sy, mx1, my1, btX, btY, nx, ny, ex, ey);
					bMap[nx][ny] = 0;
				} else {
					break;
				}
				dist++;
			}
		} else if (idx == 4) {
			while (true) {
				nx = mx2 + (-1 * dist);
				ny = my2 + (-1 * dist);

				if (nx >= 1 && nx <= n - 2 && ny >= 2 && ny <= n - 1) {
					bMap[nx][ny] = -1;
					traversal(cnt + 1, 5, sx, sy, mx1, my1, btX, btY, mx2, my2, nx, ny);
					bMap[nx][ny] = 0;
				} else {
					break;
				}
				dist++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		bMap = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				totalSum += map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		for (int i = 1; i <= n - 2; i++) {
			for (int j = 2; j <= n - 1; j++) {
				startX = i;
				startY = j;
				traversal(0, 1, i, j, 0, 0, 0, 0, 0, 0, 0, 0);
			}
		}

		System.out.println(ans);
	}

}
