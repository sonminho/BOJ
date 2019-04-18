import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	static int n, sum;
	static int[][] a;
	static int[] b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n + 1][n + 1];
		b = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		if (n > 2) {
			b[1] = (a[1][2] + a[1][3] + a[2][3])/2 - a[2][3];
			
			for(int i = 2; i <= n; i++) {
				b[i] = a[i][1] - b[1];
			}
		} else {
			b[1] = 1;
			b[2] = a[1][2] - b[1];
		}

		for(int i = 1; i <= n; i++) {
			System.out.print(b[i] + " ");
		}
	}
}
