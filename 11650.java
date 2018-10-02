import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		private int x;
		private int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Node that) {
			if(this.x < that.x) {
				return -1;
			} else if(this.x == that.x) {
				if(this.y < that.y)
					return -1;
				else if(this.y == that.y)
					return 0;
				else
					return 1;
			} else {
				return 1;
			}
		}
	}
	
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.valueOf(br.readLine());
    	StringTokenizer stk = null;
    	Node[] nodes = new Node[n];
    	
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine(), " ");
    		int x = Integer.valueOf(stk.nextToken());
    		int y = Integer.valueOf(stk.nextToken());
    		
    		Node node = new Node(x, y);
    		nodes[i] = node;
    	}
    	
    	Arrays.sort(nodes, new Comparator<Node>(){
			@Override
			public int compare(Node o1, Node o2) {
				return o1.compareTo(o2);
			}
    	});
   	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < n; i++) {
    		sb.append(nodes[i].x + " " + nodes[i].y + "\n");
    	}
    	
    	System.out.println(sb);
    }
}