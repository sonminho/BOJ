import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] a;
	static int[][] b;
	static int[] c;
	static boolean[] visit;

	static void bfs(ArrayList<Integer>[] list, int cur) {
		Queue<Integer> q = new LinkedList<>();
		q.add(cur);

		while (!q.isEmpty()) {
			int t = q.remove();
			
			for (int x : list[t]) {
				if (!visit[x]) {
					visit[x] = true;
					b[cur][x] = 1;
					q.add(x);
				}
			}
		}
	}

	static Queue<Integer> dfs(ArrayList<Integer>[] list, int row, Queue<Integer> q) {
		
		for(int x : list[row]) {
			b[row][x] = 1;
						
			if(!visit[x]) {
				visit[x] = true;
				q.add(x);
				dfs(list, x, q);
			}
		}
		
		return q;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		a = new int[n + 1][n + 1];
		b = new int[n + 1][n + 1];
		StringBuilder ans = new StringBuilder();
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		StringTokenizer stk;

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());

				if (a[i][j] == 1) {
					list[i].add(j);
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			visit = new boolean[n+1];
			//bfs(list, i);
			Queue<Integer> q = dfs(list, i, new LinkedList<Integer>());
			
			for(int x : q) {
				b[i][x] = 1;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				ans.append(b[i][j] + " ");
			}
			ans.append("\n");
		}
		
		System.out.println(ans);
	}
}