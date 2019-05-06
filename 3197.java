import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main {
	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int r, c;
	static char[][] a;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] checkW;
	static boolean[][] checkL;

	static int sx, sy, ex, ey;
	static boolean isFirst;

	static LinkedList<Node> nextWaterQ, nextIceQ, iceQ, nextSwanQ, swanQ;

	static void prepare() {
		checkW = new boolean[r][c];
		nextWaterQ = new LinkedList<>();
		iceQ = new LinkedList<>();
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (a[i][j] == '.') {
					if (!checkW[i][j]) {
						checkW[i][j] = true;
						nextWaterQ.add(new Node(i, j));
						nextWaterBfs();
					}
				}
			}
		}
	}

	static void nextWaterBfs() {
		while (!nextWaterQ.isEmpty()) {
			Node node = nextWaterQ.remove();
			int x = node.x;
			int y = node.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if (!checkW[nx][ny]) { // 첫 방문
						if (a[nx][ny] == 'X') { // 빙판
							a[nx][ny] = '.';
							checkW[nx][ny] = true;
							iceQ.add(new Node(nx, ny));
							continue;
						}

						checkW[nx][ny] = true;
						nextWaterQ.add(new Node(nx, ny));
					}
				}
			}
		}
	}

	static void nextIceBfs() {
		nextIceQ = new LinkedList<>();
		
		while (!iceQ.isEmpty()) {
			Node node = iceQ.remove();
			int x = node.x;
			int y = node.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if(!checkW[nx][ny]) {
						if (a[nx][ny] == 'X') { // 빙판
							a[nx][ny] = '.';
							checkW[nx][ny] = true;
							nextIceQ.add(new Node(nx, ny));
						}
					}
				}
			}
		}
	}

	static void swanBfs() {
		nextSwanQ = new LinkedList<>();
		
		while (!swanQ.isEmpty()) {
			Node node = swanQ.remove();
			int x = node.x;
			int y = node.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if (!checkL[nx][ny]) {
						if (a[nx][ny] == '.') {
							checkL[nx][ny] = true;
							swanQ.add(new Node(nx, ny));
						} else {
							checkL[nx][ny] = true;
							nextSwanQ.add(new Node(nx, ny));
						}
					}
				}
			}
		}
	}

	static boolean check(int ex, int ey) {
		if (checkL[ex][ey])
			return true;
		else
			return false;
	}

	static void print() {
		for (int i = 0; i < r; i++) {
			System.out.println();
			for (int j = 0; j < c; j++) {
				System.out.print(a[i][j]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rc = br.readLine().split(" ");
		r = Integer.parseInt(rc[0]);
		c = Integer.parseInt(rc[1]);
		a = new char[r][c];
		isFirst = true;
		checkW = new boolean[r][c];
		checkL = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String inLine = br.readLine();
			for (int j = 0; j < c; j++) {
				a[i][j] = inLine.charAt(j);
				if (a[i][j] == 'L') {
					if (isFirst) {
						sx = i;
						sy = j;
						isFirst = false;
					} else {
						ex = i;
						ey = j;
					}
					a[i][j] = '.';
				}
			}
		}	
		
		int cnt = 0;
		
		swanQ = new LinkedList<>();
		checkL[sx][sy] = true;
		swanQ.add(new Node(sx, sy));
		swanBfs();
		swanQ = nextSwanQ;
		
		if(check(ex, ey)) {
			System.out.println(cnt);
			return;
		} else {
			cnt++;
			prepare();
		}
		
		while(true) {
			if(check(ex, ey)) {
				System.out.println(cnt);				
				break;
			}
			
			cnt++;
			nextIceBfs();
			iceQ = nextIceQ;
			swanBfs();
			swanQ = nextSwanQ;
		}
	}
}
