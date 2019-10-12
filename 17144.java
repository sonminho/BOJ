import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int r, c, t;
	static int[][] a;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static int cr1, cr2, cc1, cc2;
	static int dirIdx1 = 0;
	static int dirIdx2 = 0;
	static int dirX1[] = { 0, -1, 0, 1 }; // 반시계 방향 동 북 서 남
	static int dirY1[] = { 1, 0, -1, 0 };
	static int dirX2[] = { 0, 1, 0, -1 }; // 시계 방향 동 남 서 북
	static int dirY2[] = { 1, 0, -1, 0 };

	static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void spread(int[][] arr) {
		int[][] tmp = new int[r][c];

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != 0 || arr[i][j] != -1) {
					tmp[i][j] = (arr[i][j] / 5);
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != 0 || arr[i][j] != -1) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && nx < r && ny >= 0 && ny < c && arr[nx][ny] != -1) {
							arr[nx][ny] += tmp[i][j];
							arr[i][j] -= tmp[i][j];
						}
					}
				}
			}
		}
	}

	static void clear(int[][] arr) {
		dirIdx1 = 0;
		int cx = cr1;
		int cy = cc1 + dirY1[dirIdx1];
		int tmp = arr[cx][cy];
		arr[cx][cy] = 0;
		while (true) {
			if (cx + dirX1[dirIdx1] < 0 || cx + dirX1[dirIdx1] > cr1 || cy + dirY1[dirIdx1] < 0 || cy + dirY1[dirIdx1] >= c) {
				dirIdx1++;
				dirIdx1 %= 4;
			}
			int nx = cx + dirX1[dirIdx1];
			int ny = cy + dirY1[dirIdx1];			
			if(arr[nx][ny] == -1)
				break;
			int tmp2 = arr[nx][ny];
			arr[nx][ny] = tmp;
			cx += dirX1[dirIdx1];
			cy += dirY1[dirIdx1];
			tmp = tmp2;
		}
		
		dirIdx2 = 0;
		int cx2 = cr2;
		int cy2 = cc2 + dirY2[dirIdx2];
		tmp = arr[cx2][cy2];
		arr[cx2][cy2] = 0;
		while (true) {
			if (cx2 + dirX2[dirIdx2] < cr2 || cx2 + dirX2[dirIdx2] >= r || cy2 + dirY2[dirIdx2] < 0 || cy2 + dirY2[dirIdx2] >= c) {
				dirIdx2++;
				dirIdx2 %= 4;
			}
			int nx = cx2 + dirX2[dirIdx2];
			int ny = cy2 + dirY2[dirIdx2];			
			if(arr[nx][ny] == -1)
				break;
			int tmp2 = arr[nx][ny];
			arr[nx][ny] = tmp;
			cx2 += dirX2[dirIdx2];
			cy2 += dirY2[dirIdx2];
			tmp = tmp2;
		}
	}

	static int calc(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (arr[i][j] > 0)
					sum += arr[i][j];

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		t = Integer.parseInt(stk.nextToken());
		a = new int[r][c];
		int cnt = 0;

		for (int i = 0; i < r; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				if (a[i][j] == -1) {
					cnt++;
					if (cnt == 1) {
						cr1 = i;
						cc1 = j;
					} else {
						cr2 = i;
						cc2 = j;
					}
				}
			}
		}

		for (int i = 0; i < t; i++) {
			spread(a);
			clear(a);
		}

		calc(a);

		System.out.println(calc(a));
	}
}
