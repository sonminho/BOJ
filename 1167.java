import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		private int to;
		private int cost;
		
		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
	
	static int[] bfs(int n, ArrayList<Node>[] a, int start) {
		int[] dist = new int[n+1];
		boolean[] check = new boolean[n+1];
		check[start] = true;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int x = q.removeFirst();
			for(Node node : a[x]) {
				int y = node.to;
				int z = node.cost;
				
				if(check[y] == false) {
					check[y] = true;
					dist[y] += dist[x] + z;
					q.add(y);
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		ArrayList<Node>[] a = (ArrayList<Node>[]) new ArrayList[n+1];
		int[] distance = new int[n+1];
		StringTokenizer stk;
		
		for(int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Node>();
		}
		
		
		for(int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int u = Integer.valueOf(stk.nextToken());
			
			while(true) {
				int v = Integer.valueOf(stk.nextToken());
				if(v == -1) break; 
				int cost = Integer.valueOf(stk.nextToken());
				a[u].add(new Node(v, cost));
			}
		}
		
		int start = 1;
	    distance = bfs(n, a, start);
	    
	    for(int i = 2; i <= n; i++) {
	    	if(distance[start] < distance[i])
	    		start = i;
	    }
	    
	    distance = bfs(n, a, start);
	    int ans = distance[1];
	    
	    for(int i = 2; i <= n; i++) {
	    	if(ans < distance[i])
	    		ans = distance[i];
	    }
	    
	    System.out.println(ans);
	}
}