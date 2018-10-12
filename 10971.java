import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static boolean nextPermutation(int[] a, int n) {
		int i, j;
		
		for(i = n-1; i > 0; i--) {
			if(a[i-1] < a[i]) break;
		}
		
		if(i <= 0)
			return false;
		
		for(j = n-1; i <= j; j--) {
			if(a[i-1] < a[j])
				break;
		}
		
		swap(a, i-1, j);
		
		j = n-1;
		
		while(i <= j) {
			swap(a, i++, j--);
		}
	
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int[][] a = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.valueOf(stk.nextToken());
			}
		}
		
		int[] d = new int[n];
		
		for(int i = 0; i < n; i++) {
			d[i] = i;
		}
		
		int ans = Integer.MAX_VALUE;
		
		do {
			if(d[0] != 0) break;
			boolean possible = true;
			int sum = 0;
			
			for(int i = 0; i < n-1; i++) {
				if(a[d[i]][d[i+1]] == 0)
					possible = false;
				else
					sum += a[d[i]][d[i+1]];
			}
			
			if(possible && a[d[n-1]][d[0]] != 0) {
				sum += a[d[n-1]][d[0]];
				
				if(ans > sum)
					ans = sum;
			}
        } while(nextPermutation(d,n));

        System.out.println(ans);
	}
	
}