import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static int n;
	static int[][] a;
	static int[][] d;

	static class Node {
		int x;
		int y;
		int dist;

		Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int bfs(LinkedList<Node> q, int endX, int endY) {
		while (!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;

			if (x == endX && y == endY)
				return node.dist;

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (d[nx][ny] == 0) {
						d[nx][ny] = node.dist + 1;
						q.add(new Node(nx, ny, node.dist + 1));
					}
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
			a = new int[n][n];
			d = new int[n][n];

			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int startX = Integer.parseInt(stk.nextToken());
			int startY = Integer.parseInt(stk.nextToken());
			stk = new StringTokenizer(br.readLine(), " ");
			int endX = Integer.parseInt(stk.nextToken());
			int endY = Integer.parseInt(stk.nextToken());

			LinkedList<Node> q = new LinkedList<>();
			q.add(new Node(startX, startY, 0));

			int result = bfs(q, endX, endY);			
			ans.append(result + "\n");
		}
		
		System.out.println(ans);
	}
}