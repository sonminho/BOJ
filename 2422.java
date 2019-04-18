import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[] c;
	static boolean[][] a;
	static int ans = 0;

	static void go(int idx, int cnt) {
		if (cnt == 3) { // 아이스크림을 3가지 고름
			//print();
			if(check())
				ans++;
			return;
		}

		for (int i = idx; i <= n; i++) {
			if (!c[i]) {
				c[i] = true;
				go(i, cnt + 1);
				c[i] = false;
			}
		}
	}

	static boolean check() {
		for (int i = 1; i <= n; i++) {
			if(c[i])
				for (int j = i + 1; j <= n; j++) {
					if(c[j]) {
						if (a[i][j])
							return false;
					}
				}
		}

		return true;
	}

	static void print() {
		for (int i = 1; i <= n; i++) {
			if (c[i]) {
				System.out.print(i);
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());

		a = new boolean[n + 1][n + 1];
		c = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			a[x][y] = true;
			a[y][x] = true;
		}
		
		go(1, 0);
		System.out.println(ans);
	}
}
