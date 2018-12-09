import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());		
		long[] arr = new long[120];
		
		arr[1] = 1;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i = 4; i <= n; i++) {
			arr[i] = arr[i-1] + arr[i-3];
		}
		
		System.out.println(arr[n]);
	}
	
}