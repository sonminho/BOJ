import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static class Node {
		int[] child;

		Node() {
			child = new int[2];

			for (int i = 0; i < 2; i++) {
				child[i] = -1;
			}
		}
	}

	static List<Node> list;

	static class Trie {
		Trie() {
			list = new ArrayList<Node>();
			init();
		}

		int init() {
			list.add(new Node());
			return list.size() - 1;
		}

		void add(int idx, int num, int bit) {
			if (bit < 0)
				return;

			int a = (num >> bit) & 1;

			if (list.get(idx).child[a] == -1) // 없으면 추가
				list.get(idx).child[a] = init();

			add(list.get(idx).child[a], num, bit - 1);
		}

		int search(int idx, int num, int bit) {
			if (bit < 0)
				return 0;

			int a = (num >> bit) & 1;
			a = 1 - a;

			if (list.get(idx).child[a] == -1)
				a = 1 - a;
			if (list.get(idx).child[a] == -1)
				return 0;

			int next = 0;
			if (a == 1)
				next = a << bit;

			return next | search(list.get(idx).child[a], num, bit - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int result = 0;
			int addNum, searchNum;
			int pre = 0;

			Trie trie = new Trie();
			String[] nums = br.readLine().split(" ");

			trie.add(0, 0, 31);

			for (int i = 0; i < n; i++) {
				addNum = Integer.parseInt(nums[i]);
				pre ^= addNum;

				trie.add(0, pre, 31);
				searchNum = trie.search(0, pre, 31) ^ pre; 

				if (searchNum > result)
					result = searchNum;
			}

			ans.append(result+"\n");
		}
		System.out.println(ans);
	}
}