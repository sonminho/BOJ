import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int[][] a;
	static boolean[][] isVisit;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	static class Node {
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int bfs(int x, int y, int maxX, int maxY, int cnt) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		isVisit[x][y] = true;
		
		while(!q.isEmpty()) {
			Node node = q.remove();
			int nx = node.x;
			int ny = node.y;
			
			for(int i = 0; i < 4; i++) {
				int newX = nx + dx[i];
				int newY = ny + dy[i];
				
				if(newX >= 0 && newX < maxX && newY >= 0 && newY < maxY) {
					if(!isVisit[newX][newY] && a[newX][newY] == 0) { // 방문이 안됐으면
						q.add(new Node(newX, newY));
						isVisit[newX][newY] = true;
						cnt++;
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		
		int M = Integer.parseInt(in[0]);
		int N = Integer.parseInt(in[1]);
		int K = Integer.parseInt(in[2]);
		a = new int[M][N];
		isVisit = new boolean[M][N];
		
		List<Integer> ansList = new ArrayList<>();
		StringBuilder ans = new StringBuilder();
		int ansCnt = 0;
		
		while(K-- > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(stk.nextToken());
			int y = Integer.parseInt(stk.nextToken());
			int w = Integer.parseInt(stk.nextToken());
			int z = Integer.parseInt(stk.nextToken());
			
			for(int i = y; i < z; i++) {
				for(int j = x; j < w; j++) {
					a[i][j] = 1;
				}
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(!isVisit[i][j] && a[i][j] == 0) {
					ansList.add(bfs(i, j, M, N, 1));
					ansCnt++;
				}
			}
		}

		Collections.sort(ansList);
		
		ans.append(ansCnt + "\n");
		for(int x : ansList)
			ans.append(x + " ");
		
		System.out.println(ans);
	}
}