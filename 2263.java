import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] in, post;
	static int[] inIdx;
	static StringBuffer ans = new StringBuffer();
	static List<Integer> list = new ArrayList<>();

	static void traverse(int inL, int inR, int postL, int postR) {
		if (inL > inR)
			return;

		if (inL == inR) {
			ans.append(in[inL] + " ");
			return;
		}

		int root = post[postR]; // post의 마지막은 루트
		ans.append(root + " ");

		int mid = inIdx[root];

		traverse(inL, mid - 1, postL, postL + (mid - 1 - inL));
		traverse(mid + 1, inR, postL + (mid - inL), postR - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		in = new int[n + 1];
		post = new int[n + 1];
		inIdx = new int[n + 1];

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int no = Integer.parseInt(stk.nextToken());
			in[i] = no;
			inIdx[no] = i;
		}

		stk = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			int no = Integer.parseInt(stk.nextToken());
			post[i] = no;
		}

		traverse(1, n, 1, n);
		System.out.println(ans);
	}
}
