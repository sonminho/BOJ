import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * BOJ 11724 ���� ����� ����
 * https://www.acmicpc.net/problem/11724
 * ���� ����Ʈ
 */

public class Main{
	// ���� �켱 Ž�� ( ��� ȣ�� )
	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
		// ��� Ż�� ���� - �湮�� ����
		if(c[x]) {
			return;
		}
		
		// �湮���� ���� �����̶��
		c[x] = true;
		
		// ����Ʈ�� ��Ҹ��� ��� ȣ��
		for(int y : a[x]) {
			if(c[y] == false) {
				dfs(a, c, y);
			}
		}
	}
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
    	
    	// N = ���� ��, M = ���� ��  
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