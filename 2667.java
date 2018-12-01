import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static final int[] dx = { 0, 0, 1, -1 };
	static final int[] dy = { 1, -1, 0, 0 };

	static void dfs(int[][] a, int[][] d, int x, int y, int cnt) {
		d[x][y] = cnt;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
				if (a[nx][ny] == 1 && d[nx][ny] == 0) {
					dfs(a, d, nx, ny, cnt);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringBuilder result = new StringBuilder();
		
		int cnt = 0;

		int[][] a = new int[n][n];
		int[][] d = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();

			for (int j = 0; j < n; j++) {
				a[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1 && d[i][j] == 0) {
					dfs(a, d, i, j, ++cnt);
				}
			}
		}
		
		int[] ans = new int[cnt];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(d[i][j] != 0) {
					ans[d[i][j]-1]++;
				}
			}
		}
		
		Arrays.sort(ans);
		
		result.append(cnt+"\n");
		for(int x : ans)
			result.append(x+"\n");
		
		System.out.println(result);
	}

}
