import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[][] a;
	static boolean[][] visit;
	
	static boolean search(int[] arr, int n, int l) {
		boolean[] arrCheck = new boolean[n];
		int i, j;
		
		for(i = 1; i < n; i++) {
			if(arr[i-1] > arr[i]) {
				for(j = i; j < i+l; j++) {
					if(j >= n || arr[i-1] - arr[j] != 1) {
						
						return false;
					}
					if(!arrCheck[j])
						arrCheck[j] = true;
					else
						return false;
				}
				i = j-1;
			} else if(arr[i-1] < arr[i]) {
				for(j = i-1; j >= i-l; j--) {
					if(j < 0 || arr[i] - arr[j] != 1) {
						return false;
					}
					if(!arrCheck[j])
						arrCheck[j] = true;
					else
						return false;
				}
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int l = Integer.parseInt(stk.nextToken());
		a = new int[n][n];
		visit = new boolean[n][n];

		int ans = 0; // 지나갈 수 있는 길의 수

		// 입력
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				a[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(search(a[i], n, l)) {
				ans++;				
			}
		}
		
		int[] temp = new int[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				temp[j] = a[j][i];
			}
			if(search(temp, n, l)) {
				ans++;				
			}
		}
		System.out.println(ans);
	}
}
