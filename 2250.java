import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int order = 0;
	static int maxDepth = 1;
	static Node root;
	static StringBuilder ans;
	static List<Integer>[] orderList = new ArrayList[10001];

	static class Node {
		int no;
		Node left;
		Node right;
		int order;
		int depth;

		Node(int no, int depth, Node left, Node right) {
			this.no = no;
			this.depth = depth;
			this.left = left;
			this.right = right;
		}
	}

	static Node findParent(Node node, int no, int depth) {
		if (node.no == no)
			return node;

		Node lNode = null;
		Node rNode = null;

		if (node.left != null) {
			lNode = findParent(node.left, no, depth + 1);
		}
		if (node.right != null) {
			rNode = findParent(node.right, no, depth + 1);
		}

		if (lNode != null)
			return lNode;
		else if (rNode != null)
			return rNode;
		else
			return null;
	}

	static void dfs(Node node, int depth) {
		if (node == null)
			return;

		dfs(node.left, depth + 1);
		node.order = ++order;
		orderList[depth].add(node.order);
		dfs(node.right, depth + 1);
	}

	public static void main(String[] args) throws Exception {
		List<String> inputList = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] check = new int[n + 1];
		int rootNo = 0;

		for (int i = 0; i < n; i++) {
			String inLine = br.readLine();
			inputList.add(inLine);
			StringTokenizer stk = new StringTokenizer(inLine);
 
			int p = Integer.parseInt(stk.nextToken());
			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());

			if (l != -1) {
				check[l]++;
			}

			if (r != -1) {
				check[r]++;
			}
		}

		for(int i = 1; i <= n; i++) {
			if(check[i] == 0)
				rootNo = i;
		}
		
		root = new Node(rootNo, 1, null, null);
				
		for (int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(inputList.get(i));

			int p = Integer.parseInt(stk.nextToken());
			int l = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());

			Node pNode = findParent(root, p, root.depth);

			if (pNode != null) {
				if (l != -1) {
					if(maxDepth < pNode.depth + 1)
						maxDepth = pNode.depth + 1;
					pNode.left = new Node(l, pNode.depth + 1, null, null);
				}

				if (r != -1) {
					if(maxDepth < pNode.depth + 1)
						maxDepth = pNode.depth + 1;
					pNode.right = new Node(r, pNode.depth + 1, null, null);
				}
			}
		}
		
		for (int i = 1; i <= maxDepth; i++) {
			orderList[i] = new ArrayList<Integer>();
		}

		dfs(root, 1);

		int idx = 0;
		int maxGap = 0;
		for (int i = 1; i <= maxDepth; i++) {
			if (orderList[i].size() > 0) {
				int gap = orderList[i].get(orderList[i].size() - 1) - orderList[i].get(0) + 1;

				if (gap > maxGap) {
					idx = i;
					maxGap = gap;
				}
			}
		}

		System.out.println(idx + " " + maxGap);
	}
}
