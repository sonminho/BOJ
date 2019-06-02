import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int[] a, d, d2;
	static int maxNum;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		a = new int[n];
		d = new int[n];
		d2 = new int[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken()); 
		}
			
		for(int i = 0; i < n; i++) {
			maxNum = 0;
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j])
					maxNum = maxNum > d[j] ? maxNum : d[j];
			}
			d[i] = maxNum + 1;
		}
		
		for(int i = n-1; i >= 0; i--) {
			maxNum = 0;
			for(int j = n-1; j > i; j--) {
				if(a[i] > a[j]) 
					maxNum = maxNum > d2[j] ? maxNum : d2[j];
			}
			d2[i] = maxNum + 1;
		}
		
		
		maxNum = 0;
		for(int i = 0; i < n; i++) {
			maxNum = maxNum < (d[i] + d2[i]) ? (d[i] + d2[i]) : maxNum;
		}
		
		System.out.println(maxNum-1);
	}
}
