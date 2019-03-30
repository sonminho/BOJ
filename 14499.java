import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	// 1. 주사위가 바깥으로 이동시 무시
	// 2. 이동칸에 0이 쓰여져 있으면 주사위 바닥면을 이동칸으로 복사
	// 3. 이동칸이 0이 아니면 이동칸에 쓰여진 수를 바닥면으로 복사
	
	static int[] dx = {0, 0, -1, 1}; // 동서북남
	static int[] dy = {1, -1, 0, 0};
	static int n, m;
	static int sx, sy;
	static int w, z;
	
	static StringBuilder res = new StringBuilder();
	static void rotate(int[][] a, int cmd, int[] dice) {
		w = sx + dx[cmd-1];
		z = sy + dy[cmd-1];
				
		if(w < 0 || w >= n || z < 0 || z >= m) {
			return;
		}
		
		sx = w;
		sy = z;
		
		if(cmd == 1) { // 동쪽 회전
			int temp = dice[0]; 
			dice[0] = dice[1]; 
			dice[1] = dice[2];
			dice[2] = dice[5];
			dice[5] = temp;
		} else if(cmd == 2) { // 서쪽 회전
			int temp = dice[0];
			dice[0] = dice[5];
			dice[5] = dice[2];
			dice[2] = dice[1];
			dice[1] = temp;
		} else if(cmd == 3) { // 북쪽 회전
			int temp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[5];
			dice[5] = dice[4];
			dice[4] = temp;
		} else { // 남쪽회전
			int temp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[5];
			dice[5] = dice[3];
			dice[3] = temp;
		}
		
		if(a[sx][sy] == 0) {
			a[sx][sy] = dice[1];
		} else {
			dice[1] = a[sx][sy];
			a[sx][sy] = 0;
		}
		res.append(dice[5]+"\n");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		sx = Integer.parseInt(stk.nextToken());
		sy = Integer.parseInt(stk.nextToken());
		int cmdCnt = Integer.parseInt(stk.nextToken());
		
		int[][] a = new int[n][m];
		int[] cmd = new int[cmdCnt];
		int[] dice = new int[6];
		
		for(int x = 0; x < n; x++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int y = 0; y < m; y++) {
				a[x][y] = Integer.parseInt(stk.nextToken());
			}
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < cmdCnt; i++) {
			cmd[i] = Integer.parseInt(stk.nextToken());
			rotate(a, cmd[i], dice);			
		}
		System.out.println(res);
	}
}