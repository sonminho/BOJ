import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] a;
	static int[] direction;
	static int startIdx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		a = new int[4][8];		

		for (int i = 0; i < 4; i++) {
			String in = br.readLine();
			for (int j = 0; j < 8; j++) {
				a[i][j] = in.charAt(j) - '0';
			}
		}

		int t = Integer.parseInt(br.readLine());
		int ans = 0;
		
		while (t-- > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			startIdx = Integer.parseInt(stk.nextToken()) - 1;
			direction = new int[4];
			direction[startIdx] = Integer.parseInt(stk.nextToken());
			
			for (int i = startIdx - 1; i >= 0; i--) { // 왼측 순회
				if (a[i][2] != a[i + 1][6]) { // 맞닿은 톱니가 다름
					direction[i] = -direction[i + 1];
				} else {
					break;
				}
			}
			
			for (int i = startIdx + 1; i < 4; i++) { // 우측 순회
				if (a[i-1][2] != a[i][6]) {
					direction[i] = -direction[i-1];					
				} else {
					break;
				}
			}
			
			for (int i = 0; i < 4; i++) {
				if (direction[i] == -1) { // 반시계 방향 회전
					int temp = a[i][0];
					for (int j = 1; j <= 7; j++) {
						a[i][j - 1] = a[i][j];
					}
					a[i][7] = temp;
				} else if (direction[i] == 1) { // 시계 방향 회전
					int temp = a[i][7];
					for (int j = 6; j >= 0; j--) {
						a[i][j + 1] = a[i][j];
					}
					a[i][0] = temp;
				}
			}
		}
		for(int i = 0; i < 4; i++) {
			if(a[i][0] == 1) {
				ans |= (1<<i);
			}
		}
		System.out.println(ans);
	}
}