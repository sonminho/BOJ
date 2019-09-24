package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] dist, from;
	static boolean[] check;
	static final int MIN = 0;
	static final int MAX = 100000;
	static Stack<Integer> stack = new Stack<>();
	static StringBuilder ans = new StringBuilder();
	
	static void bfs(LinkedList<Integer> q) {
		while(!q.isEmpty()) {
			int now = q.removeFirst();
			
			if(now == k) {
				System.out.println(dist[now]);
				
				for(int i = k; i != n; i = from[i]) 
					stack.push(i);
				
				stack.push(n);
				
				while(!stack.isEmpty())
					ans.append(stack.pop()).append(" ");
								
				return;
			}
			
			if(now-1 >= MIN) {
				if(check[now-1] == false) {
					check[now-1] = true;
					q.add(now-1);
					from[now-1] = now;
					dist[now-1] = dist[now] + 1;
				}
			}
			
			if(now+1 <= MAX) {
				if(check[now+1] == false) {
					check[now+1] = true;
					q.add(now+1);
					from[now+1] = now;
					dist[now+1] = dist[now] + 1;
				}
			}
			
			if(now*2 <= MAX) {
				if(check[now*2] == false) {
					check[now*2] = true;
					q.add(now*2);
					from[now*2] = now;
					dist[now*2] = dist[now] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		dist = new int[100001];
		from = new int[100001];
		check = new boolean[100001];
		
		check[n] = true;
		dist[n] = 0;
		
		LinkedList<Integer> q = new LinkedList<>();
		q.add(n);
		bfs(q);
		
		System.out.println(ans.toString());
	}
}
