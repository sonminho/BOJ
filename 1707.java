import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int k, n, m;
	static int[] check;
	static StringBuilder ans = new StringBuilder();
	static ArrayList<Integer>[] a;

	static void dfs(int from) {
		for (int to : a[from]) {
			if (check[to] == 0) {
				check[to] = 3 - check[from];
				dfs(to);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());

		A:
		while (k-- > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());

			n = Integer.parseInt(stk.nextToken()); // 정점 수
			m = Integer.parseInt(stk.nextToken()); // 간선 수

			a = new ArrayList[n + 1];
			check = new int[n + 1];

			for (int i = 1; i <= n; i++)
				a[i] = new ArrayList<Integer>();

			for (int i = 0; i < m; i++) { // 간선 입력
				stk = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(stk.nextToken());
				int v = Integer.parseInt(stk.nextToken());
				a[u].add(v);
				a[v].add(u);
			}

			for (int i = 1; i <= n; i++) {
				if (check[i] == 0) {
					check[i] = 1;
					dfs(i);
				}
			}
			
			for (int i = 1; i <= n; i++) {
				for (int to : a[i]) {
					if (check[to] == check[i]) {
						ans.append("NO\n");
						continue A;
					}
				}
			}
			ans.append("YES\n");
		}
		System.out.println(ans.toString());
	}
}
