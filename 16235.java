import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static class Tree implements Comparable<Tree> {
		int x, y, age;

		Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o1) {
			return this.age <= o1.age ? -1 : 1;
		}
	}

	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int now = 0, next = 0;
	static int n, m, k;
	static int x, y, z;	
	static int[][] winterMap, sourceMap;
	
	static PriorityQueue<Tree>[] qs = new PriorityQueue[2];
	
	static void print() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(sourceMap[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void go() {
		next = (now+1) % 2;
		Queue<Tree> deadQ = new LinkedList<>();
		Queue<Tree> lifeQ = new LinkedList<>();
				
		// 봄
		// 1. 자신의 나이만큼 양분 먹고 나이 1 증가
		// 2. 어린 나무부터 양분 먹음
		// 3. 자신의 나이만큼 양분이 존재하지 않으면 나무는 양분 먹지못하고 죽음
		while (!qs[now].isEmpty()) {
			Tree cur = qs[now].remove();

			if (cur.age <= sourceMap[cur.x][cur.y]) {
				sourceMap[cur.x][cur.y] -= cur.age;
				cur.age += 1;
				lifeQ.add(cur);
				qs[next].add(cur);
			} else {
				deadQ.add(cur);
			}
		}

		// 여름
		// 1. 죽은 나무가 양분으로 변함
		// 2. 각각의 죽은 나무가 (나이/2)로 나무가 있던 칸에 양분으로 추가 된다.
		while (!deadQ.isEmpty()) {
			Tree deadTree = deadQ.remove();
			sourceMap[deadTree.x][deadTree.y] += (deadTree.age / 2);
		}

		// 가을
		// 1. 5 배수 나이 나무는 범위 내 인접한 8개 칸에 나이가 1인 나무가 생김
		while (!lifeQ.isEmpty()) {
			Tree cur = lifeQ.remove();

			if (cur.age % 5 == 0) {
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
						qs[next].add(new Tree(nx, ny, 1));
					}
				}
			}
		}
		
		// 겨울
		// 1. 땅에 양분을 추가한다
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sourceMap[i][j] += winterMap[i][j];
			}
		}
		
		now = next;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());

		winterMap = new int[n + 1][n + 1];
		sourceMap = new int[n + 1][n + 1];

		qs[0] = new PriorityQueue<Tree>();
		qs[1] = new PriorityQueue<Tree>();
		
		// 맵 입력
		for (int i = 1; i <= n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				winterMap[i][j] = Integer.parseInt(stk.nextToken());
				sourceMap[i][j] = 5;
			}
		}

		// 나무 위치 (x, y)와 나이 입력
		for (int i = 1; i <= m; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(stk.nextToken());
			y = Integer.parseInt(stk.nextToken());
			z = Integer.parseInt(stk.nextToken());
			qs[now].add(new Tree(x, y, z));
		}

		for (int i = 0; i < k; i++) {
			go();
		}
		
		System.out.println(qs[next].size());
	}
}
