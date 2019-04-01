import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static int[][] a;
	static int[] distArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 톱니의 갯수
		int ans = 0;
		a = new int[n][8];

		// 데이터 입력
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}

		int rotateCnt = Integer.parseInt(br.readLine()); // 회전횟수
		while (rotateCnt-- > 0) {
			distArr = new int[n];

			String[] in = br.readLine().split(" ");
			int idx = Integer.parseInt(in[0]) - 1; // 회전할 톱니의 인덱스
			int dist = Integer.parseInt(in[1]); // 회전할 톱니의 방향 1 오른쪽, -1 왼쪽 회전 방향 결정
			distArr[idx] = dist;

			for (int i = idx - 1; i >= 0; i--) { // 왼족 톱니들의 방향 결정
				if (a[i][2] != a[i + 1][6]) { // 두 톱니의 극이 다르면
					distArr[i] = -distArr[i + 1];
				} else {
					break;
				}
			}

			for (int i = idx + 1; i < n; i++) {
				if (a[i - 1][2] != a[i][6]) {
					distArr[i] = -distArr[i - 1];
				} else {
					break;
				}
			}

			for (int i = 0; i < n; i++) { // 각 톱니의 회전
				if (distArr[i] == 0)
					continue;
				else if (distArr[i] == 1) { // 시계 방향 회전
					int temp = a[i][7];
					for (int j = 7; j > 0; j--) {
						a[i][j] = a[i][j - 1];
					}
					a[i][0] = temp;
				} else { // 반시계 방향 회전
					int temp = a[i][0];
					for (int j = 0; j < 7; j++) {
						a[i][j] = a[i][j + 1];
					}
					a[i][7] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (a[i][0] == 1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}