import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] a;
	static boolean visited[];
	static int max = Integer.MIN_VALUE;

	static int left(int idx) {
		if(idx == 0) return 0;
		if(!visited[idx])
			return a[idx];
		else
			return left(idx - 1);
	}
	
	static int right(int idx) {
		if(idx == n + 1) return 0;
		if(!visited[idx])
			return a[idx];
		else 
			return right(idx + 1);
	}
	
	static int calc(int idx) {
		return left(idx - 1) * right(idx + 1);
	}
	
	static void go(int cnt, int sum) {
		if(cnt == n-2) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 2; i <= n-1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				go(cnt + 1, sum + calc(i));
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		a = new int[n+1];
		visited = new boolean[n+1];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.valueOf(stk.nextToken());
		}
		
		go(0, 0);
		
		System.out.println(max);
	}
}