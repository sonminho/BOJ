import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int num;
		int cnt;

		Node(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static final int MAX = 101;
	static int[][] map, copyMap;
	static int[] cnt;
	static int sec = -1;
	static int rCnt, cCnt;
	static int r, c, k;

	static void listSort(List<Node> list) {
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.cnt < o2.cnt)
					return -1;
				else if (o1.cnt == o2.cnt) {
					return o1.num - o2.num;
				} else
					return 1;
			}
		});
	}

	static void copy() {
		map = new int[MAX][MAX];
		for (int i = 1; i < MAX; i++) {
			for (int j = 1; j < MAX; j++) {
				map[i][j] = copyMap[i][j];
			}
		}
	}

	static void print() {
		for (int i = 1; i < MAX; i++) {
			for (int j = 1; j < MAX; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;

		map = new int[MAX][MAX];
		rCnt = 3;
		cCnt = 3;

		// (r, c) 값이 k가 되기 위한 연산 최소시간 100 넘으면 -1 출력
		stk = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());

		for (int i = 1; i <= rCnt; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= cCnt; j++)
				map[i][j] = Integer.parseInt(stk.nextToken());
		}

		while (true) {
			sec++;

			if (sec == MAX)
				break;

			if (map[r][c] == k) {
				System.out.println(sec);
				System.exit(0);
			}

			copyMap = new int[MAX][MAX];

			if (rCnt >= cCnt) {
				for (int i = 1; i <= rCnt; i++) {
					int tmpC = 1;
					int maxC = 1;

					cnt = new int[MAX];
					List<Node> nList = new ArrayList<>();
					for (int j = 1; j < MAX; j++) {
						cnt[map[i][j]]++;
					}

					for (int k = 1; k < MAX; k++) {
						if (cnt[k] != 0) {
							nList.add(new Node(k, cnt[k]));
						}
					}

					listSort(nList);

					for (int k = 0; k < nList.size() && tmpC < MAX; k++, tmpC++) {
						copyMap[i][tmpC] = nList.get(k).num;
						copyMap[i][++tmpC] = nList.get(k).cnt;
						if (tmpC > maxC)
							maxC = tmpC;
					}
					cCnt = maxC > cCnt ? maxC : cCnt;
				}
			} else {
				for (int j = 1; j <= cCnt; j++) {
					int tmpR = 1;
					int maxR = 1;

					cnt = new int[MAX];
					List<Node> nList = new ArrayList<>();

					for (int i = 1; i < MAX; i++) {
						cnt[map[i][j]]++;
					}

					for (int k = 1; k < MAX; k++) {
						if (cnt[k] != 0)
							nList.add(new Node(k, cnt[k]));
					}

					listSort(nList);

					for (int k = 0; k < nList.size() && tmpR < MAX; k++, tmpR++) {
						copyMap[tmpR][j] = nList.get(k).num;
						copyMap[++tmpR][j] = nList.get(k).cnt;
						if (tmpR > maxR)
							maxR = tmpR;
					}

					rCnt = maxR > rCnt ? maxR : rCnt;
				}

			}
			copy();
		}

		System.out.println(-1);
	}

}
