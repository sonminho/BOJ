import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static boolean nextPermutation(int[] a, int N) {
		int i, j;
		
		for(i = N-1; i > 0; i--) {
			if(a[i-1] < a[i])
				break;
		}
		
		if(i == 0) {
			return false;
		}
		
		for(j = N-1; j >= i; j--) {
			if(a[j] > a[i-1])
				break;
		}
		
		swap(a, i-1, j);
		
		j = N-1;
		
		while(i < j) {
			swap(a, i, j);
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());
		int[] a = new int[N];
		
		String[] nums = br.readLine().split(" ");
		
		for(int i = 0; i < N; i++) {
			a[i] = Integer.valueOf(nums[i]);
		}
		
		int sum = Integer.MIN_VALUE;
		int trySum, x;
		
		Arrays.sort(a);
		
		do {
			trySum=0;
			
			for(int k = 0; k < N-1; k++) {
				x = a[k] - a[k+1];
				if(x < 0)
					x *= -1;
				trySum += x;
			}
			
			if(trySum > sum)
				sum = trySum;
		} while(nextPermutation(a, N));
		
		System.out.println(sum);
	}
}