import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static class Node {
		int height;
		int count;
		
		Node(int height, int count) {
			this.height = height;
			this.count = count;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		Stack<Node> stack = new Stack<>();
		long ans = 0;
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			Node newNode = new Node(a[i], 1);
			
			while(!stack.isEmpty()) {
				if(stack.peek().height > a[i])
					break;
				else {
					ans += stack.peek().count;

					if(stack.peek().height == a[i]) {
						newNode.count += stack.peek().count;
					} 
					stack.pop();
				}
			}
			
			if(!stack.isEmpty())
				ans += 1;
			
			stack.push(newNode);
		}
		System.out.println(ans);
	}
}