import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/10026
 * BOJ 적록색약
 * */
public class Main {
	static class Node {
		int x;
		int y;
		char c;
		
		Node(int x, int y, char c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
	
	static char[][] in;
	static boolean[][] isVisit;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	// BFS 탐색
	static void bfs(int x, int y, char current, int n) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y, current));
		
		while(!q.isEmpty()) {
			Node node = q.remove();

			for(int i = 0; i < 4; i++) {
				// 인접행 인덱스 계산
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					// 방문하지 않았고 인접 행렬과 문자가 일치할 경우
					if(!isVisit[nx][ny] && (node.c == in[nx][ny])) {
						isVisit[nx][ny] = true;
						q.add(new Node(nx, ny, current));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		in = new char[n][n];
		isVisit = new boolean[n][n];
		int[] cnt = {0, 0};
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				in[i][j] = str.charAt(j); 
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!isVisit[i][j]) {
					bfs(i, j, in[i][j], n);
					cnt[0]++;
				}
			}
		}
		
		// 적록색약 모든 녹색을 적색으로 치환 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(in[i][j] == 'G') {
					in[i][j] = 'R';
				}
			}
		}
		
		isVisit = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!isVisit[i][j]) {
					bfs(i, j, in[i][j], n);
					cnt[1]++;
				}
			}
		}
		
		System.out.println(cnt[0] + " " + cnt[1]);
	}
}
