import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long calc(long a, long b, long c) {
		a %= c;
		
		if(b == 0)
			return 1;
		if(b%2 == 0)
			return calc(a*a, b/2, c) % c;
		else
			return a * calc(a*a, (b-1)/2, c) %c;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int a = Integer.valueOf(stk.nextToken());
		int b = Integer.valueOf(stk.nextToken());
		int c = Integer.valueOf(stk.nextToken());
		
		System.out.println(calc(a, b, c));
	}
}