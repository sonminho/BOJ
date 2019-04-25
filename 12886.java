import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int sum = 0;
	static boolean[][] visit;

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void bfs(LinkedList<Node> q) {
		while (!q.isEmpty()) {
			Node node = q.remove();
			int x = node.x;
			int y = node.y;

			int[] a = { x, y, sum - x - y };

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (a[i] < a[j]) {
						if(!visit[a[i]*2][a[j]-a[i]]) {
							q.add(new Node(a[i]*2, a[j]-a[i]));
							visit[a[i]*2][a[j]-a[i]] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		visit = new boolean[1501][1501];

		sum = a + b + c;

		// 돌을 같은 개수로 만들 수 없음
		if (sum % 3 != 0) {
			System.out.println(0);
			return;
		}

		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(a, b));
		visit[a][b] = true;
		bfs(q);
		
		if (visit[sum / 3][sum / 3])
			System.out.println(1);
		else
			System.out.println(0);
	}
}
