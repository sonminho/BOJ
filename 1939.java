import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



/*
 * BOJ 1939
 * https://www.acmicpc.net/problem/1939
 * 한 번의 이동에서 옮길 수 있는 물품들의 중량의 최대값을 구하는  문제
*/
class Edge {
	int to, cost;
	
	Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
}

public class Main {
	
	static ArrayList<Edge>[] a = new ArrayList[10001];
	static boolean[] check = new boolean[10001];
	static int n, m , start, end;
	
	static boolean go(int node, int limit) {
		if(check[node]) // 방문한 노드라면 리턴
			return false;
		
		check[node] = true;
		
		if(node == end) // 시작점과 끝점이 같으면 참
			return true;
		
		for(Edge e : a[node]) {
			int next = e.to;
			int cost = e.cost;
			
			if(cost >= limit) { // 비용이 제한보다 작으면 DFS
				if(go(next, limit))
					return true;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		n  = sc.nextInt();
		m = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			a[i] = new ArrayList<Edge>();
		}
		
		while(m-- > 0) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int cost = sc.nextInt();
			
			a[from].add(new Edge(to, cost));
			a[to].add(new Edge(from, cost));
		}
		
		start = sc.nextInt();
		end = sc.nextInt();
		
		int left = 1;
		int right = 1000000000;
		int ans = 0;
		
		while(left <= right) {
			//int mid = left + (right - left) / 2;
			int mid = (left +right) / 2;
			Arrays.fill(check, false);
			
			if(go(start, mid)) { // 시작점부터 끝까지 도달할 수 있으면
				ans = mid;
				left = mid + 1;
			} else { // 제한을 낮춤
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}

}