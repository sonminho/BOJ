import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for(int i = 1; i <= n; i++) {
			String str = br.readLine();
			int strLen = str.length();
			ans.append("String #" + i + "\n");
			for (int j = 0; j < strLen; j++) {
				if(str.charAt(j) == 'Z') {
					ans.append((char)'A');
				} else {
					ans.append((char)(str.charAt(j) + 1));
				}
			}
			ans.append("\n\n");
		}
		System.out.println(ans);
	}
}
