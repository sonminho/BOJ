import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		StringTokenizer stk2 = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			b[i] = Integer.parseInt(stk2.nextToken());
		}
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		long sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum += a[i] * b[n-i-1];
		}
		
		System.out.println(sum);
	}
}