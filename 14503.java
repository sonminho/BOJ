import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] a;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		a = new int[n][m];
		
		stk = new StringTokenizer(br.readLine(), " ");
		int sx = Integer.parseInt(stk.nextToken());
		int sy = Integer.parseInt(stk.nextToken());
		int driection = Integer.parseInt(stk.nextToken());
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j = 0;  j < m; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		A:
		while(true) {
			if(a[sx][sy] == 0) {
				a[sx][sy] = 2;
				ans++;
			}
			
			int d = driection;
			for(int i = 1; i <= 4; i++) {
				if(d == 0) 
					d = 3;
				else 
					d -= 1;
				
				if(sx+dx[d] >= 0 && sx+dx[d] < n && sy+dy[d] >= 0 && sy+dy[d] < m) {
					driection = d;
					if(a[sx+dx[d]][sy+dy[d]] == 0) { // 청소하지 않은 공간이라면 						
						a[sx+dx[d]][sy+dy[d]] = 2; // 청소후 전진
						ans++;
						sx += dx[d];
						sy += dy[d];
						continue A;
					}
				}
			}
			
			if(a[sx-dx[d]][sy-dy[d]] == 1) { // 뒤쪽이 벽이면
				break A;
			} else { // 뒤쪽이 벽이 아니므로 후진
				sx -= dx[d];
				sy -= dy[d];
				continue A;
			}
		}

		System.out.println(ans);
	}
}