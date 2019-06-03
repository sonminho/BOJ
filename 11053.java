import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int[] a, d;
	static int maxNum;
	static int ans = -1;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		a = new int[n];
		d = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken()); 
		}
		
		for(int i = 0; i < n; i++) {
			maxNum = 0;
			
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j]) {
					maxNum = maxNum > d[j] ? maxNum : d[j]; 
				}
			}
			d[i] = maxNum + 1;
			ans = d[i] > ans ? d[i] : ans;
		}
		
		System.out.println(ans);
	}
}
