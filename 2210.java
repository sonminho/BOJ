import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] a;	
	static HashSet<Integer> set;	
	
	static void go(int x, int y, int cnt, int num) {
		if(cnt == 6) {
			set.add(num);
			
			return;
		}
		
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
				go(nx, ny, cnt+1, num*10+a[x][y]);			
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = new int[5][5];
		set = new HashSet<>();
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}	
		
		for(int i = 0; i < 5; i++) {			
			for(int j = 0; j < 5; j++) {
				go(i, j, 0, a[i][j]);
			}
		}
		
		//System.out.println(set);
		System.out.println(set.size());
	}
}
