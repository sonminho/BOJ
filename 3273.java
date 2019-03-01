import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] a = new int[1000001];
		boolean[] check = new boolean[1000001];
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
			check[a[i]] = true;
		}
		
		for(int i = 0; i < n; i++) {
			int temp = k - a[i];
			
			if(temp < 1 || temp > 1000000 || temp == a[i])
				continue;
	
			if(check[temp]) {
				cnt++;
				check[temp] = false;
				check[a[i]] = false;
			}
		}
		
		System.out.println(cnt);
	}
}