import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[][] a = new int[n+1][n+1];
		boolean[][] d = new boolean[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			String[] in = br.readLine().split(" ");
			for(int j = 1; j <= n; j++) {
				a[i][j] = Integer.valueOf(in[j-1]);
			}
		}
		
		d[1][1] = true;
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(d[i][j] && a[i][j] > 0) {
					if(j+a[i][j] <= n) {
						d[i][a[i][j] + j] = true;
					}
					if(i+a[i][j] <= n) {
						d[a[i][j] + i][j] = true;
					}
				}
			}
		}
		if(d[n][n])
			System.out.println("HaruHaru");
		else
			System.out.println("Hing");
	}
}