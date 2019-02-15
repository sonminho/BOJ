import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(stk.nextToken());
			int m = Integer.parseInt(stk.nextToken());
			int cnt = 0;
			
			if(n == 0 && m == 0)
				break;

			Set<Integer> set = new HashSet<>();

			while (n-- > 0) {
				set.add(Integer.parseInt(br.readLine()));
			}

			while (m-- > 0) {
				if (set.contains(Integer.parseInt(br.readLine())))
					cnt++;
			}

			System.out.println(cnt);
		}
	}
}