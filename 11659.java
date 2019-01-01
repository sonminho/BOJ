import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken()); // test case
		int[] a = new int[n+1];
		
		stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.valueOf(stk.nextToken());
			a[i] += a[i-1];
		}
		
		while(m-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			ans.append((a[y] - a[x-1]) +  "\n");
		}
		
		System.out.println(ans);
	}
}