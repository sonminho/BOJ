import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] hw;
	static int[][] d;
	static int cnt;
	static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
	static int[] dy = {1, -1, 0, 0, -1, -1, 1, 1};
	
	static void dfs(int height, int width, int h, int w, int cnt) {
		d[height][width] = cnt;
		
		for(int i = 0; i < 8; i++) {
			int nHeight = height + dx[i];
			int nWidth = width + dy[i];
			
			if(nHeight >= 0 && nHeight < h && nWidth >= 0 && nWidth < w) {
				if(d[nHeight][nWidth] == 0 && hw[nHeight][nWidth] == 1) {
					dfs(nHeight, nWidth, h, w, cnt);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		while(true) {
			String[] in = br.readLine().split(" ");
			int w = Integer.valueOf(in[0]);
			int h = Integer.valueOf(in[1]);
			cnt = 0;
			
			if(w == 0 && h == 0) {
				System.out.println(ans);
				return;
			}
			
			hw = new int[h][w];
			d = new int[h][w];
			
			for(int i = 0; i < h; i++) {
				in = br.readLine().split(" ");
				
				for(int j = 0; j < w; j++) {
					hw[i][j] = Integer.valueOf(in[j]);
				}
			}
			
			for(int i = 0; i < h; i++) {				
				for(int j = 0; j < w; j++) {
					if(d[i][j] == 0 && hw[i][j] == 1) {
						dfs(i, j, h, w, ++cnt);
					}
				}
			}
			
			ans.append(cnt + "\n");
		}
	}
}