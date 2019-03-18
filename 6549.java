import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		while (true) {
			String[] in = br.readLine().split(" ");

			if (Integer.parseInt(in[0]) == 0)
				break;

			int n = in.length - 1;
			int[] a = new int[n];
			Stack<Integer> stack = new Stack<>();
			long result = 0;
			long w, h;

			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(in[i + 1]);
			}

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty()) {
					if (a[i] >= a[stack.peek()])
						break;

					h = a[stack.pop()];
					w = i;

					if (!stack.isEmpty())
						w = i - stack.peek() - 1;

					if (result < w * h)
						result = w * h;
				}
				stack.push(i);
			}

			while (!stack.isEmpty()) {
				h = a[stack.pop()];
				w = n;

				if (!stack.isEmpty()) {
					w = n - stack.peek() - 1;
				}
				if (result < w * h)
					result = w * h;
			}

			ans.append(result + "\n");
		}
		
		System.out.println(ans);
	}
}