import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int limit = Integer.parseInt(stk.nextToken()) * Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder ans = new StringBuilder();
		
		for(int i = 0; i < 5; i++) {
			ans.append((Integer.parseInt(stk.nextToken()) - limit) + " ");
		}
		System.out.println(ans);
	}
}