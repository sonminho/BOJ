import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int n, m;
	static int[][] a;
	static boolean[][] v;
	static int ans = 0;
	
	static void dfs(int x, int y, int cnt, int sum) {
		if(cnt > 3) {
			ans = Math.max(sum, ans);
			return;
		}	

		if( x < 0 || x >= n || y < 0 || y >= m || v[x][y])
			return;		
		
		v[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			dfs(x+dx[i], y+dy[i], cnt+1, sum+a[x][y]);
		}
		
		v[x][y] = false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		
		n = Integer.parseInt(in[0]);
		m = Integer.parseInt(in[1]);
		a = new int[n][m];
		v = new boolean[n][m];
				
		for(int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
				
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dfs(i, j, 0, 0);
				
				if(i + 2 < n) { // た, っ
					int temp = a[i][j] + a[i+1][j] + a[i+2][j];
					if(j + 1 < m) { // た 
						temp += a[i+1][j+1];
						ans = Math.max(temp, ans);
						temp -= a[i+1][j+1];
					}
					if(j - 1 >= 0) { // っ
						temp += a[i+1][j-1];
						ans = Math.max(temp, ans);
					}
				} 
				
				if(j + 2 < m) { // で , ぬ
					int temp = a[i][j] + a[i][j+1] + a[i][j+2];
					if(i - 1 >= 0) {
						temp += a[i-1][j+1];
						ans = Math.max(temp, ans);
						temp -= a[i-1][j+1];
					}
					if(i + 1 < n) {
						temp += a[i+1][j+1];
						ans = Math.max(temp, ans);
					}
				}
			}
		}
		System.out.println(ans);
	}
}