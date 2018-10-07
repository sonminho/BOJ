import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[9];
		int sum = 0;
		for(int i = 0; i < 9; i++) {
			a[i] = Integer.valueOf(br.readLine());
			sum += a[i];
		}
		sum -= 100;
		
		int i = 0, j = 1;
		
		Arrays.sort(a);
		
		A:
		for(i = 0; i < 8; i++) {
			for(j = i+1; j < 9; j++) {
				if((a[i] + a[j]) == sum) {
					break A;
				}
			}
		}
		
		for(int k = 0; k < 9; k++) {
			if(k == i || k == j)
				continue;
			else
				System.out.println(a[k]);
		}
	}
}