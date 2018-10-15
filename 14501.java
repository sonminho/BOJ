import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] t;
	static int[] p;
	static int max = Integer.MIN_VALUE;
	
	static void go(int day, int sum) {
		if(day == n+1) {
			if(max < sum)
				max = sum;
			
			return;
		}
		
		if(day > n)
			return;
		
		go(day + t[day], sum + p[day]);
		go(day + 1, sum);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.valueOf(br.readLine());
		t = new int[n+1];
		p = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			
			t[i] = Integer.valueOf(stk.nextToken());
			p[i] = Integer.valueOf(stk.nextToken());
		}
		
		go(1, 0);
			
		System.out.println(max);
	}
}