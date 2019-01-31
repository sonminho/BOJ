import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[12];
			a[1] = 1;
			a[2] = 2;
			a[3] = 4;

			for (int i = 4; i <= n; i++) {
				for (int j = 1; j <= 3; j++) {
					a[i] += a[i - j];
				}
			}

			ans.append(a[n] + "\n");
		}
		
		System.out.println(ans);
	}
}