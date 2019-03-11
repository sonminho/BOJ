import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] in = br.readLine().split(" ");
		int[] a = new int[n];
		int sum = 0;
		int total = 0;
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(in[i]);
		}
		
		Arrays.sort(a);		
		
		for(int i = 0; i < n; i++) {
			sum += a[i];
			total += sum;
		}
		
		System.out.println(total);
	}

}