import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static boolean[] check;
	static StringBuilder ans;
	
	static void bfs(ArrayList<Integer>[] lists, LinkedList<Integer> q) {
		while(!q.isEmpty()) {
			int from = q.removeFirst();
			for(int to : lists[from]) {
				if(!check[to]) {
					check[to] = true;
					q.addLast(to);
					ans.append(to + " ");
				}
			}
		}
	}
	
	static void dfs(ArrayList<Integer>[] lists, int from) {
		for(int to : lists[from]) {
			if(!check[to]) { // 방문하지 않은 정점이라면
				check[to] = true;
				ans.append(to + " ");
				dfs(lists, to);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		ans = new StringBuilder();
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int v = Integer.parseInt(stk.nextToken());
		
		ArrayList<Integer>[] lists = (ArrayList<Integer>[])new ArrayList[n+1];
		check = new boolean[n+1];
		
		for(int i = 1; i <= n; i++)
			lists[i] = new ArrayList<Integer>();
		
		for(int i = 1; i <= m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			
			lists[start].add(end);
			lists[end].add(start);
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(lists[i]);
		}
		
		check[v] = true;
		ans.append(v + " ");
		dfs(lists, v);
		ans.append("\n");
		
		check = new boolean[n+1];
		check[v] = true;		
		ans.append(v + " ");
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(v);
		bfs(lists, q);
		
		System.out.println(ans);
	}
}