import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		
		while (t-- > 0) {
			ArrayList<Node> list = new ArrayList<>();

			int n = Integer.parseInt(br.readLine());

			for (int i = 1; i <= n / 2; i++) {
				if (n - i > n / 2) {
					list.add(new Node(i, n - i));
				}
			}

			ans.append("Pairs for " + n + ": ");

			int listLen = list.size();

			for (int i = 0; i < listLen - 1; i++) {
				ans.append(list.get(i).x + " " + list.get(i).y + ", ");
			}
			
			if(listLen > 0)
				ans.append(list.get(listLen - 1).x + " " + list.get(listLen - 1).y);
			
			ans.append("\n");
		}
		
		System.out.println(ans);
	}

}