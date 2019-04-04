import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static boolean[][] visit;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	
	static ArrayList<Integer> curve(int dir, int gen) {
		List<Integer> ansList = new ArrayList<Integer>();
		ansList.add(dir);
		
		for(int i = 1; i <= gen; i++) {
			List<Integer> tempList = new ArrayList<Integer>(ansList);
			Collections.reverse(tempList);
			int tempSize = tempList.size();
			
			for(int j = 0; j < tempSize; j++) {
				tempList.set(j, (tempList.get(j) + 1) % 4);
			}
			ansList.addAll(tempList);
		}
			
		return (ArrayList<Integer>) ansList;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int y, x, d, g;
		int ans = 0;
		visit = new boolean[101][101];		
		
		for(int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			
			y = Integer.parseInt(stk.nextToken());
			x = Integer.parseInt(stk.nextToken());
			d = Integer.parseInt(stk.nextToken());
			g = Integer.parseInt(stk.nextToken());
			
			List<Integer> dirList = curve(d, g);
			visit[x][y] = true;
			
			for(Integer dir : dirList) {
				x += dx[dir];
				y += dy[dir];
				visit[x][y] = true;
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(visit[i][j] && visit[i+1][j] && visit[i][j+1] && visit[i+1][j+1])
					ans++;
			}
		}
		
		System.out.println(ans);
	}
}

