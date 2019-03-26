import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static class Node {
		boolean valid;
		int[] child;
		
		Node() {
			valid = false;
			child = new int[10];

			for (int i = 0; i < 10; i++)
				child[i] = -1;
		}
	}

	static List<Node> list;

	static class Trie {
		Trie() {
			list = new ArrayList<>();
			init();
		}

		int init() {
			Node node = new Node();
			list.add(node);
			return list.size() - 1;
		}

		void add(int idx, String str, int depth) {
			if (str.length() == depth) {
				list.get(idx).valid = true;
				return;
			}

			int ch = str.charAt(depth) - '0';

			if (list.get(idx).child[ch] == -1) {
				list.get(idx).child[ch] = init();
			}

			add(list.get(idx).child[ch], str, depth + 1);
		}

		boolean search(int idx) {
			for(int i = 0; i < 10; i++) {
				if(list.get(idx).child[i] != -1) { // 방문할 노드 존재
					if(list.get(idx).valid == true) // 이미 존재하는 번호
						return false;
					if(!search(list.get(idx).child[i])) // 재귀호출로 끝까지 검사
						return false;
				}
			}
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				trie.add(0, str, 0);
			}
			if(trie.search(0))
				ans.append("YES\n");
			else
				ans.append("NO\n");
		}
		
		System.out.println(ans);
	}
}