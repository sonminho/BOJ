import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] a = new int[n+1];
		int[] d = new int[n+1];
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.valueOf(stk.nextToken());
		}
		
		int i, j;
		
		for(i = 1; i <= n; i++) {
			d[i] = a[i];
			
			for(j = 1; j < i; j++) {
				d[i] = d[i-j] + a[j] < d[i] ? d[i-j] + a[j] : d[i]; 
			}
		}
		
		System.out.print(d[n]);		
	}
}