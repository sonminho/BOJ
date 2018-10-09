import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int N = Integer.valueOf(br.readLine());
		int[] a = new int[N];
		String[] s = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			a[i] = Integer.valueOf(s[i]);
		}
		
		int i, j;
		
		for(i = N-1; i > 0; i--) {
			if(a[i-1] > a[i]) break;
		}
		
		if(i == 0) { // 마지막 순열
			System.out.println(-1);
			return;
		}
		
		for(j = N-1; j >= i; j--) {
			if(a[i-1] > a[j]) break;
		}
		
		swap(a, i-1, j);
		
		j = N-1;
		
		while(i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
		
		for(int k = 0; k < N; k++) {
			ans.append(a[k] + " ");
		}
		
		System.out.println(ans);
	}
}