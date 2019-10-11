import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n, b, c;
	static int[] a;
	static long ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		stk = new StringTokenizer(br.readLine(), " ");
		b = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		
		for(int i = 0; i < n; i++) { 
			a[i] -= b; 
			ans++; // 감독관 1명
			
			if(a[i] > 0) {
				int temp = a[i] / c;
				if(a[i] % c != 0) {
					ans++;
				}
				ans += temp; // 부감독관
			}
		}
		
		System.out.println(ans);
	}
}
