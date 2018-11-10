import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		boolean[] check = new boolean[10001];
		int a, b, ans = 0;
		
		for(int i = 0; i < n; i++) {
			String[] in = br.readLine().split(" ");
			
			a = Integer.valueOf(in[0]);
			b = Integer.valueOf(in[1]);
			
			for(int j = a+1; j <= b; j++) {
				if(!check[j]) {
					ans++;
					check[j] = true;
				}
			}
		}
		
		System.out.println(ans);
	}
	
}