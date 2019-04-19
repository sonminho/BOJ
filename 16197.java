import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static char[][] a;
	static boolean drop1, drop2;
	static ArrayList<Node> list;
	static int ans = -1;

	static void go(int cnt, int x1, int y1, int x2, int y2) {
		if (cnt == 10) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx1 = x1 + dx[i];
			int ny1 = y1 + dy[i];
			int nx2 = x2 + dx[i];
			int ny2 = y2 + dy[i];
			
			if (nx1 >= 0 && nx1 < n && ny1 >= 0 && ny1 < m) {
				if (a[nx1][ny1] == '#') {
					nx1 = x1;
					ny1 = y1;
				}
				drop1 = false;
			} else {
				drop1 = true;
			}
			if (nx2 >= 0 && nx2 < n && ny2 >= 0 && ny2 < m) {
				if (a[nx2][ny2] == '#') {
					nx2 = x2;
					ny2 = y2;
				}
				drop2 = false;
			} else {
				drop2 = true;
			}
			
			if (drop1==true && drop2==true) { // 둘다 떨어짐
				continue;
			}
			
			if (drop1==false && drop2==false) { // 둘다 안떨어짐
				go(cnt + 1, nx1, ny1, nx2, ny2);
				continue;
			}
			
			if (drop1 != drop2) { // 답을 찾음
				if(ans == -1) {
					ans = cnt;
				} else {
					ans = ans > cnt ? cnt : ans;
				}
				return;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		a = new char[n][m];
		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				a[i][j] = str.charAt(j);
				if (a[i][j] == 'o') {
					list.add(new Node(i, j));
				}
			}
		}
		
		go(0, list.get(0).x, list.get(0).y, list.get(1).x, list.get(1).y);
		if(ans==-1)
			System.out.println(-1);
		else
			System.out.println(ans+1);
	}
}
