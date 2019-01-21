import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();

		LABEL:
		for(int t = 0; t < n; t++) {
			Stack<Integer> stack = new Stack<>();
			String str = br.readLine();
			int strLen = str.length();


			for (int i = 0; i < strLen; i++) {
				if (str.charAt(i) == '(') { // ¿©´Â °ýÈ£
					if (stack.size() == 0) {
						stack.push(1);
					} else if (stack.size() > 0) {
						stack.push(stack.peek() + 1);
					}
				} else { // ´Ý´Â °ýÈ£
					if (stack.isEmpty()) {
						ans.append("NO\n");
						continue LABEL;
					} else {
						stack.pop();
					}
				}
			}

			int stackSize = stack.size();

			if (stackSize != 0) {
				ans.append("NO\n");
			} else {
				ans.append("YES\n");
			}
		}
		
		System.out.println(ans);
	}
}