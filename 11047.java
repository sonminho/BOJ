import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		int n = Integer.valueOf(in[0]);
		int total = Integer.valueOf(in[1]);
		int cnt = 0;
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		
		for(int i = n-1; i >= 0; i--) {
			if(total >= arr[i]) {
				cnt += total / arr[i];
				total %= arr[i];
			}
		}
		
		System.out.println(cnt);
	}
	
}