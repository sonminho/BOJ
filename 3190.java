import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { 0, 1, 0, -1 }; // 동 남 서 북
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] a;
	static int direction, snakeLen;
	static int sx, sy; // 뱀의 머리의 위치
	static int second;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		a = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				a[i][j] = -1;
			}
		}

		for (int i = 0; i < k; i++) { // 사과 좌표 입력
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			a[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())] = -2;
		}

		int l = Integer.parseInt(br.readLine());

		a[1][1] = 0;
		direction = 0;
		snakeLen = 1;
		sx = sy = 1;
		second = 0;

		for (int i = 0; i < l; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(stk.nextToken());
			char c = stk.nextToken().charAt(0);
			
			while(second < cnt) {
				second++;
				
				sx += dx[direction];
				sy += dy[direction];
				
				if(sx < 1 || sx > n || sy < 1 || sy > n) { // 벽을 만남
					System.out.println(second);
					return;
				}
				
				if(a[sx][sy] == -2) { // 사과를 만남
					snakeLen++;
				}
								
				if(a[sx][sy] != -1 && a[sx][sy] != -2 && second - a[sx][sy] <= snakeLen) { // 몸을 만남
					System.out.println(second);
					return;
				}
				
				a[sx][sy] = second;
			}
			
			if(c == 'L') {
				direction = (direction + 3) % 4;
			}
			else {
				direction = (direction + 1) % 4;
			}	
		}
		
		while(true) {
			second++;
			sx += dx[direction];
			sy += dy[direction];
			
			if(sx < 1 || sx > n || sy < 1 || sy > n) { // 벽을 만남
				System.out.println(second);
				return;
			}
			if(a[sx][sy] != -1 && a[sx][sy] != -2 && second - a[sx][sy] <= snakeLen) { // 몸을 만남
				System.out.println(second);
				return;
			}
		}		
	}
}