import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int x = n/5;

		int a, b;
	    boolean possible = false;
	    
		for(int i = x; i >= 0; i--) {
			a = n - i*5;
			b = a%3;
			
			if(b == 0) {
				possible = true;
				System.out.println(i + a/3);
				return;
			} else {
				possible = false;
			}
		}
		
		if(!possible)
			System.out.println(-1);
	}
}