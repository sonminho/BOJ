import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int r, c;
	static char[][] a;
	static boolean[][] v;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Pair {
		int o, v;
		
		Pair(int o, int v) {
			this.o = o;
			this.v = v;
		}
	}
	
	static Pair bfs(LinkedList<Node> q) {
		int oCnt = 0;
		int vCnt = 0;
		
		Node first = q.getFirst();
		if(a[first.x][first.y] == 'o') {
			oCnt++;
			a[first.x][first.y] = '.';
		} else if(a[first.x][first.y] == 'v') { 
			vCnt++;
			a[first.x][first.y] = '.';
		}
		v[first.x][first.y] = true;
		
		while (!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;
						
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < r && ny >= 0 && ny < c) {					
					if(!v[nx][ny] && a[nx][ny] != '#') {									
						if(a[nx][ny] == 'o') { // 양
							oCnt++;
							a[nx][ny] = '.';
						} else if(a[nx][ny] == 'v') { // 늑대
							vCnt++;
							a[nx][ny] = '.';
						}
						v[nx][ny] = true;
						q.add(new Node(nx,ny));
					}
				}
			}
		}
		
		if(oCnt > vCnt)
			vCnt = 0;
		else
			oCnt = 0;
		
		return new Pair(oCnt, vCnt);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		r = Integer.parseInt(in[0]);
		c = Integer.parseInt(in[1]);
		a = new char[r][c];
		v = new boolean[r][c];
		int oCnt = 0, vCnt = 0;
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				a[i][j] = str.charAt(j);
			}
		}
		
		LinkedList<Node> q = new LinkedList<Node>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(!v[i][j] && a[i][j] != '#') {
					q.clear();					
					q.add(new Node(i, j));
					Pair pair = bfs(q);
					oCnt += pair.o;
					vCnt += pair.v;
				}
			}
		}
		
		System.out.println(oCnt + " " + vCnt);
	}
}
