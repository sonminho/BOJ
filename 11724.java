import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * BOJ 11724 연결 요소의 갯수
 * https://www.acmicpc.net/problem/11724
 * 인접 리스트
 */

public class Main{
	// 깊이 우선 탐색 ( 재귀 호출 )
	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
		// 재귀 탈출 조건 - 방문한 정점
		if(c[x]) {
			return;
		}
		
		// 방문하지 않은 정점이라면
		c[x] = true;
		
		// 리스트의 요소마다 재귀 호출
		for(int y : a[x]) {
			if(c[y] == false) {
				dfs(a, c, y);
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
    	
    	// N = 정점 수, M = 간선 수  
    	int N = Integer.parseInt(stk.nextToken());
    	int M = Integer.parseInt(stk.nextToken());
    	
    	ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[N+1];
    	
    	for(int i = 1; i <= N; i++) {
    		a[i] = new ArrayList<Integer>();
    	}
    	
    	for(int i = 0; i < M; i++) {
    		stk = new StringTokenizer(br.readLine(), " ");
    		
    		int u = Integer.parseInt(stk.nextToken());
    		int v = Integer.parseInt(stk.nextToken());
    		
    		a[u].add(v);
    		a[v].add(u);
    	}
    	
    	boolean[] check = new boolean[N+1];
    	
    	int ans = 0;
    	
    	for(int i = 1; i <= N; i++) {
    		if(check[i] == false) {
    			dfs(a, check, i);
    			ans += 1;
    		}
    	}
    	
    	System.out.println(ans);
    }
}