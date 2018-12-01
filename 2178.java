import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static class Node {
		private int x;
		private int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[][] a;
	static int[][] d;
	
	static final int[] dx = {0, 0, 1, -1};
	static final int[] dy = {1, -1, 0, 0};
	
	static void bfs(LinkedList<Node> q, int n, int m) {		
		while(!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(0 <= nx && nx < n && 0 <= ny && ny < m) {
					if(d[nx][ny] == 0 && a[nx][ny] == 1) {
						q.add(new Node(nx, ny));
						d[nx][ny] = d[x][y] + 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int n = Integer.valueOf(in[0]);
		int m = Integer.valueOf(in[1]);
		
		a = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String inLine = br.readLine();
			for(int j = 0; j < m; j++) {
				a[i][j] = inLine.charAt(j) - '0';
			}
		}
		
		d = new int[n][m];
		
		LinkedList<Node> q = new LinkedList<>();
		d[0][0] = 1;
		q.add(new Node(0, 0));
		bfs(q, n, m);
		
		System.out.println(d[n-1][m-1]);
	}	
}