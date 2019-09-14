import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, cnt;
	static Node root;
	static StringBuilder ans;
	
	static class Node {
		char no;
		Node left;
		Node right;
		
		Node(char no, Node left, Node right) {
			this.no = no;
			this.left = left;
			this.right = right;
		}
	}
	
	static Node findParent(Node node, char no) {		
		Node leftNode = null;
		Node rightNode = null;
		
		if(node.no == no) {
			return node;
		}
		
		if(node.left != null) {
			leftNode = findParent(node.left, no);
		}
		if(node.right != null) {
			rightNode = findParent(node.right, no);
		}
		
		if(leftNode != null) {
			return leftNode;
		} else if(rightNode != null) {
			return rightNode;
		} else {
			return null;
		}
	}
	
	static void preTraversal(Node node) {
		if(node == null)
			return;
		
		ans.append(node.no);
		preTraversal(node.left);
		preTraversal(node.right);
	}
	
	static void inTraversal(Node node) {
		if(node == null) 
			return;
		
		inTraversal(node.left);
		ans.append(node.no);
		inTraversal(node.right);
		
	}
	
	static void postTraversal(Node node) {
		if(node == null)
			return;
		
		postTraversal(node.left);
		postTraversal(node.right);
		ans.append(node.no);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ans = new StringBuilder();
		n = Integer.parseInt(br.readLine());		
		root = new Node('A', null, null);
		
		for(int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			char parentNo = stk.nextToken().charAt(0);
			char leftNo = stk.nextToken().charAt(0);
			char rightNo = stk.nextToken().charAt(0);
			
			Node parentNode = findParent(root, parentNo);
			
			if(parentNode != null) {
				if(leftNo != '.') {					
					parentNode.left = new Node(leftNo, null, null);
				}
				
				if(rightNo != '.') {
					parentNode.right = new Node(rightNo, null, null);
				}
			}
		}
		
		preTraversal(root);
		ans.append("\n");
		inTraversal(root);
		ans.append("\n");
		postTraversal(root);
		System.out.println(ans.toString());
	}
}
