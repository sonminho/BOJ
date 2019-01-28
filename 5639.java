import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static class Node {
		Node left;
		Node right;
		int value;

		Node(Node left, Node right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}
	}

	static void postorder(Node node, StringBuilder ans) {
		if (node.left != null)
			postorder(node.left, ans);
		if (node.right != null)
			postorder(node.right, ans);
		ans.append(node.value + "\n");
	}

	static Node preorder(Node node, int num) {
		if (node.value > num) {
			if (node.left != null) // 왼쪽 노드가 존재
				return preorder(node.left, num);
		}
		if (node.value < num) {
			if (node.right != null)
				return preorder(node.right, num);
		}

		return node;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();

		Node root = new Node(null, null, Integer.parseInt(br.readLine()));

		String inLine = "";
		while ((inLine = br.readLine()) != null) {
			try {
				int num = Integer.parseInt(inLine);
				Node node = preorder(root, num);

				if (node.value > num) {
					node.left = new Node(null, null, num);
				} else {
					node.right = new Node(null, null, num);
				}
			} catch (Exception e) {

			}
		}

		postorder(root, ans);

		System.out.println(ans);
	}
}