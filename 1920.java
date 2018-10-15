import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] a, b;
	
	static int search(int x, int start, int end) {
		int mid;
		int t = 0;
		
		while(start <= end) {
			mid = (start + end)/2;
			
			if(a[mid] < x) {
				start = mid+1;
			} else {
				end = mid-1;
				t = mid;
			}
		}
		
		if(a[t] == x) 
			return 1;
		else
			return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n  = Integer.valueOf(br.readLine());
		a = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++)
			a[i] = Integer.valueOf(stk.nextToken()); 
		
		int m  = Integer.valueOf(br.readLine());
		b = new int[m];
		stk = new StringTokenizer(br.readLine(), " ");
		
		StringBuilder ans = new StringBuilder();
		
		Arrays.sort(a);
		
		for(int i = 0; i < m; i++) {
			b[i] = Integer.valueOf(stk.nextToken());
			ans.append(search(b[i], 0, n-1) + "\n");
		}
		
		System.out.println(ans);
	}
	
}