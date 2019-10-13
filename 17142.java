package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static class Node {
		int x, y, cost;

		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	
	static int n, m, zeroCnt;
	static int[][] map;
	static List<Node> mList = new ArrayList<>();
	static List<Node> rList;
	static boolean[] mVisited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;
		
	static void print(int[][] arr) {
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void copy(int[][] from, int[][] to) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				to[i][j] = from[i][j];
			}
		}
	}

	static void go() {
		int[][] copyMap = new int[n][n];
		copy(map, copyMap);

		Queue<Node> q = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		
		for (int i = 0; i < mList.size(); i++) {
			if (mVisited[i]) {
				q.add(new Node(mList.get(i).x, mList.get(i).y, mList.get(i).cost));
				copyMap[mList.get(i).x][mList.get(i).y] = -1;
			} else {
				copyMap[mList.get(i).x][mList.get(i).y] = -3;
			}
		}

		int tmpCnt = 0;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (copyMap[nx][ny] == 0) { // 벽 또는 바이러스 제외
						q.add(new Node(nx, ny, cur.cost + 1));
						copyMap[nx][ny] = cur.cost + 1;
						tmpCnt++;
					} else if(copyMap[nx][ny] == -3) {
						q2.add(new Node(nx, ny, cur.cost + 1));
					}
				}
			}
		}
					
		//print(copyMap);
		if(tmpCnt != zeroCnt) {
			while(!q2.isEmpty()) {
				Node cur = q2.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
						if (copyMap[nx][ny] == 0) { // 벽 또는 바이러스 제외
							q2.add(new Node(nx, ny, cur.cost + 1));
							copyMap[nx][ny] = cur.cost + 1;
						}
					}
				}
			}
		}
		
		int cnt = 0;
		boolean flag = false;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(copyMap[i][j] == 0) {
					flag = true;
				}
				
				if(copyMap[i][j] > cnt) {
					cnt = copyMap[i][j];
				}
			}
		}
		
		if(!flag && min > cnt) {
			min = cnt;
		}
	}

	static void dfs(int cnt, int idx) {
		if (cnt == m) {
			go();
			return;
		}

		if (idx >= mList.size())
			return;

		if (!mVisited[idx]) {
			mVisited[idx] = true;
			dfs(cnt + 1, idx + 1);
			mVisited[idx] = false;
		}

		dfs(cnt, idx + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if (map[i][j] == 2) {
					mList.add(new Node(i, j, 0));
					map[i][j] = 0;
				} else if (map[i][j] == 1)
					map[i][j] = -2;
				else if(map[i][j] == 0)
					zeroCnt++;
			}
		}

		mVisited = new boolean[mList.size()];

		dfs(0, 0);
		
		if(min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
