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
		String[] str = br.readLine().split(" ");

		int n = Integer.valueOf(str[0]);
		int m = Integer.valueOf(str[1]);
		int k = Integer.valueOf(str[2]);
		
		if(m == k)
			System.out.println(n);
		else if(m < k)
			System.out.println(m + n - k);
		else
			System.out.println(k + n- m);
	}
}