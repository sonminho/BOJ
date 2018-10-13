import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	
	static int calc(int[] a, int[] op, int n) {
		int sum = 0;
		sum = a[0];
		
		for(int i = 1; i < n; i++) {
			if(op[i-1] == 0)
				sum += a[i];
			else if(op[i-1] == 1)
				sum -= a[i];
			else if(op[i-1] == 2)
				sum *= a[i];
			else
				sum /= a[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		int[] a = new int[n];
		int[] op = new int[n-1];
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			int x =  Integer.valueOf(stk.nextToken());
			a[i] = x;
		}
		
		stk = new StringTokenizer(br.readLine(), " ");
		int t = 0;
		for(int i = 0; i < 4; i++) {
			int cnt = Integer.valueOf(stk.nextToken());
			for(int j = 0; j < cnt; j++) {
				op[t++] = i;
			}
		}
		
		ArrayList<Integer> ansList = new ArrayList<Integer>();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		do {
			int sum = calc(a, op, n);
			ansList.add(sum);
		} while(nextPermutation(op, n-1));
		
		for(int x : ansList) {
			if(x < min)
				min = x;
			if(x > max)
				max = x;
		}
		
		System.out.println(max);
		System.out.println(min);
	}
	
}