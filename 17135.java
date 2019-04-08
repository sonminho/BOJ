import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static int x, y, d;
	static int[][] a;
	static int[][] t;
	static int[][] board;
	static boolean[][] c;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static class Node {
		int x;
		int y;
		int cost;

		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

	static void bfs(LinkedList<Node> q) {
		while (!q.isEmpty()) {
			Node node = q.remove();
			int nx = node.x;
			int ny = node.y;
			int ncost = node.cost;
			c[nx][ny] = true;

			for (int i = 0; i < 4; i++) {
				int newX = nx + dx[i];
				int newY = ny + dy[i];

				if (0 <= newX && newX < x && 0 <= newY && newY < y) {
					if (!c[newX][newY] && d > ncost) {
						if (a[newX][newY] == 1)
							board[newX][newY] = ncost + 1;
						else
							board[newX][newY] = -1;
						q.add(new Node(newX, newY, ncost + 1));
					}
				}
			}
		}
	}

	static ArrayList<Node> findMin() {
		int min = Integer.MAX_VALUE;
		ArrayList<Node> list = new ArrayList<>();

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (min > board[i][j] && board[i][j] > 0) {
					min = board[i][j];
				}
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (min == board[i][j]) {
					list.add(new Node(i, j, 0));
				}
			}
		}

		list.sort(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.y < o2.y)
					return -1;
				else if (o1.y == o2.y)
					return 0;
				else
					return 1;
			}
		});

		return list;
	}

	static void move() {
		for (int i = x - 1; i > 0; i--) {
			for (int j = 0; j < y; j++) {
				a[i][j] = a[i - 1][j];
			}
		}
		Arrays.fill(a[0], 0);
	}

	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	static boolean nextP(int[] a) {
		int i, j;

		for (i = a.length - 1; i > 0; i--) {
			if (a[i - 1] < a[i])
				break;
		}

		if (i <= 0)
			return false;

		for (j = a.length - 1; i <= j; j--) {
			if (a[i - 1] < a[j])
				break;
		}

		swap(a, i - 1, j);
		j = a.length - 1;

		while (i <= j) {
			if (a[i] > a[j]) {
				swap(a, i, j);
				i++;
				j--;
			} else
				break;
		}

		return true;
	}

	static void printBoard() {
		System.out.println();
		for (int[] w : board) {
			for (int z : w)
				System.out.print(z + " ");
			System.out.println();
		}
	}

	static void copy() {
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				a[i][j] = t[i][j];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		x = Integer.parseInt(stk.nextToken()); // 행
		y = Integer.parseInt(stk.nextToken()); // 열
		d = Integer.parseInt(stk.nextToken()); // 사정거리

		a = new int[x + 1][y];
		c = new boolean[x + 1][y];
		t = new int[x][y];
		
		board = new int[x][y];

		for (int i = 0; i < x; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < y; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
				t[i][j] = a[i][j];
			}
		}

		a[x][y - 1] = 1;
		a[x][y - 2] = 1;
		a[x][y - 3] = 1;

		ArrayList<Integer> ansList = new ArrayList<Integer>();

		while(nextP(a[x])) {
			int ans = 0;
			copy();
			for (int m = 0; m < x; m++) { // 적군이 내려오는 횟수
				ArrayList<Node> removeList = new ArrayList<>();
				for (int i = 0; i < y; i++) { // 궁수 3명이 발사
					if (a[x][i] == 1) { // 궁수
						c = new boolean[x + 1][y];
						board = new int[x][y];

						LinkedList<Node> q = new LinkedList<>();
						q.add(new Node(x, i, 0));
						bfs(q);

						ArrayList<Node> list = findMin();
						
						if (list.size() > 0) {
							Node node = list.get(0);
							a[node.x][node.y] = 0;
							removeList.add(new Node(node.x, node.y, 0));
							ans++;
						}
					}
				}
				for (Node node : removeList) { // 적군 제거
					a[node.x][node.y] = 0;
				}
				move(); // 적군 하강
			}
			ansList.add(ans);
		}
		
		Collections.sort(ansList);
		System.out.println(ansList.get(ansList.size()-1));
	}
}