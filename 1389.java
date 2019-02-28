import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int no;
		int cost;
		
		Node(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
	}
	
	static boolean[] check;
	static int[] sum;
	
	static void bfs(LinkedList<Node> q, ArrayList<Integer>[] list, int start) {
		while(!q.isEmpty()) {
			Node node = q.remove();
			check[node.no] = true;
			
			for(int x : list[node.no]) {
				if(!check[x]) {
					Node newNode = new Node(x, node.cost+1);
					q.add(newNode);
					check[x] = true;
					sum[start] += node.cost + 1; 
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int min = Integer.MAX_VALUE;
		int minNo = 0;
		
		ArrayList<Integer>[] list = new ArrayList[n+1];
		check = new boolean[n+1];
		sum = new int[n+1];
		
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 1; i <= m; i++) {
			stk = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			list[from].add(to);
			list[to].add(from);
		}

		for(int i = 1; i <= n; i++) {
			LinkedList<Node> q = new LinkedList<>();
			check = new boolean[n+1];
			q.add(new Node(i, 0));			
			bfs(q, list, i);
			
			if(sum[i] < min) {
				min = sum[i];
				minNo = i;
			}
		}
		
		System.out.println(minNo);
	}
}
