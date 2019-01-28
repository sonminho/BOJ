import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[3][n];

		for (int i = 0; i < n; i++) {
			String[] in = br.readLine().split(" ");
			a[0][i] = Integer.parseInt(in[0]);
			a[1][i] = Integer.parseInt(in[1]);
		}
		
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (j == k)
					continue;
				if (a[0][j] < a[0][k] && a[1][j] < a[1][k]) {
					a[2][j]++;
				}
			}
		}
		
		for(int x : a[2])
			ans.append(x+1 + " ");
		
		System.out.println(ans);
	}
}