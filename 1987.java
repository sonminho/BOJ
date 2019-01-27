import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int maxCnt = 0;
	
	static int dfs(char[][] a, boolean[] visit, int x, int y, int maxX, int maxY, int cnt) {
		int curCnt = cnt;
		
		for(int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx >= 0 && nx < maxX && ny >= 0 && ny < maxY && !visit[a[nx][ny] - 'A']) {
				visit[a[nx][ny] - 'A'] = true;
				curCnt = dfs(a, visit, nx, ny, maxX, maxY, cnt+1);
				visit[a[nx][ny] - 'A'] = false;
			}
		}
		
		if(maxCnt < curCnt)
			maxCnt = curCnt;
		
		return curCnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		boolean[] visit = new boolean[26];
		
		char[][] a = new char[r][c];
		
		for(int i = 0; i < r; i++) {
			String inLine = br.readLine();

			for(int j = 0; j < inLine.length(); j++) {
				a[i][j] = inLine.charAt(j);
			}
		}
		
		visit[a[0][0] - 'A'] = true;
		dfs(a, visit, 0, 0, r, c, 1);
		System.out.println(maxCnt);
	}
}