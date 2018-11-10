import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int n = Integer.valueOf(in[0]);
		int k = Integer.valueOf(in[1]);
		
		int[][] a = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			a[i][1] = 1;
			
			for(int j = 2; j <= (i+1)/2; j++) {
				if(i % 2 == 1 && j == (i+1)/2) {
					a[i][j] = a[i-1][j-1] * 2;
				} else {
					a[i][j] = a[i-1][j-1] + a[i-1][j];
				}
			}
		}
		
		if(k > (n+1)/2) {
				k = n-k+1;
		}
		
		System.out.println(a[n][k]);
	}
	
}