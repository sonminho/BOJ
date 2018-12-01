import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int cnt;
	static int[][] a;
	static int[][] d;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static class Node {
		int x;
		int y;
		int no;
		
		Node(int x, int y, int no) {
			this.x = x;
			this.y = y;
			this.no = no;
		}
	}

	static void bfs(LinkedList<Node> q, int limitHeight, int limitWidth) {
		while(!q.isEmpty()) {
			Node node = q.removeFirst();
			
			int x = node.x;
			int y = node.y;
			int no = node.no;
			cnt = no;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(0 <= nx && nx < limitHeight && 0 <= ny && ny < limitWidth) {
					if(a[nx][ny] == 0 && d[nx][ny] == 0) {
						d[nx][ny] = no;
						q.add(new Node(nx, ny, no+1));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int width = Integer.valueOf(str[0]);
		int height = Integer.valueOf(str[1]);
		
		a = new int[height][width];
		d = new int[height][width];
		
		LinkedList<Node> q = new LinkedList<Node>();
		cnt = 1;
		
		for(int i = 0; i < height; i++) {
			String[] in  = br.readLine().split(" ");
			for(int j = 0; j < width; j++) {
				a[i][j] = Integer.valueOf(in[j]);
				
				if(a[i][j] == 1) {
					d[i][j] = 1;
					q.add(new Node(i, j, cnt));
				} else if(a[i][j] == -1) {
					d[i][j] = -1;
				}
			}
		}
		
		bfs(q, height, width);
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(d[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(cnt-1);
	}
	
}