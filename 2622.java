import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int cnt = 0;

		for (int a = 1; a <= n/3; a++) { // a : 제일 작은 변
			for (int b = a; b < n - 2; b++) {
				int c = n - a - b; // c : 제일 큰 변

				if (c < b)
					break;

				if (c < a + b)
					cnt++;
			}
		}

		System.out.println(cnt);
	}
}
