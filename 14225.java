import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	static int n, sum;
	static int[] a;
	static boolean[] c;
	
	static void go(int idx, int sum) {
		if(idx == n) {
			c[sum] = true;
			return;
		}		
		go(idx+1, sum + a[idx]);
		go(idx+1, sum);
	}
	
	static void bit() {
		for(int i = 0; i < (1 << n); i++) {
			sum = 0;
			for(int j = 0; j < n; j ++) {
				if((i & (1 << j)) != 0) {
					sum += a[j];
				}
			}
			c[sum] = true;
		}
	}
	
	static void ans() {
		for(int i = 1; ; i++) {
			if(!c[i]) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		a = new int[n];
		c = new boolean[20*100000+1];
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		
		//bit();
		go(0,0);
		ans();
	}
}
