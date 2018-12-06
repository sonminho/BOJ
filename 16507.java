import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder ans = new StringBuilder();
		
		int r = Integer.valueOf(stk.nextToken());
		int c = Integer.valueOf(stk.nextToken());
		int testCase = Integer.valueOf(stk.nextToken());
		
		int[][] a = new int[r+1][c+1];
		int[][] b = new int[r+1][c+1];
		
		for(int i = 1; i <= r; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 1; j <= c; j++) {
				a[i][j] = Integer.valueOf(stk.nextToken());
				b[i][j] = a[i][j];
			}
		}
		
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= c; j++) {
				b[i][j] += b[i][j-1];
			}
		}
		
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= c; j++) {
				b[i][j] += b[i-1][j];
			}
		}
		
		while(testCase-- > 0) {
			stk = new StringTokenizer(br.readLine(), " ");

			int r1 = Integer.valueOf(stk.nextToken());
			int c1 = Integer.valueOf(stk.nextToken());
			int r2 = Integer.valueOf(stk.nextToken());
			int c2 = Integer.valueOf(stk.nextToken());
			int divide = (r2 - r1 + 1) * (c2 - c1 + 1);
			
			ans.append((b[r2][c2] - b[r1-1][c2] - b[r2][c1-1] + b[r1-1][c1-1]) / divide + "\n");
		}
		
		System.out.println(ans);
	}
}