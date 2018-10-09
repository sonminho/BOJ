import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long calc(int N) {
		int t = N;
		int cnt = 0;
		
		long ans = 0;
		
		int i;
		int high = 10;
		int low = 1;
		
		while(t > 0) {
			t /= 10;
			cnt++;
		}
		
		for(i = 1; i < cnt; i++) {
			ans += (i) * (high - low);
			high *= 10;
			low *= 10;
		}
		
		ans += i * (N - low + 1);
		
		return ans;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.valueOf(br.readLine());
		
		System.out.println(calc(N));
	}
}