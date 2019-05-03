import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1 X 2, 2 X 1 타일로 2 X N 개의 타일 채우기
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] d = new int[n+1];
		
		if(n == 1) {
			System.out.println(1);
			System.exit(0);
		}
		
		d[1] = 1;
		d[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			d[i] = d[i-1] + d[i-2];
			d[i] %= 10007;
		}
		
		System.out.println(d[n]);
	}
}
