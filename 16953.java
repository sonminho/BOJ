import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		long start;
		long end;
		long cnt;
		
		Node(long start, long end, long cnt) {
			this.start = start;
			this.end = end;
			this.cnt = cnt;
		}
	}
	
	static void bfs(LinkedList<Node> q) {
		while(!q.isEmpty()) {
			Node node = q.remove();
			
			long start = node.start;
			long end = node.end;
			
			if(start == end) {
				System.out.println(node.cnt);
				return;
			}
			
			if(start * 2 <= end) {
				q.add(new Node(start*2, end, node.cnt+1));
			}
			
			if(start * 10 + 1 <= end) {
				q.add(new Node(start*10+1, end, node.cnt+1));
			}
		}		
		System.out.println(-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		long start = Long.parseUnsignedLong(stk.nextToken());
		long end = Long.parseUnsignedLong(stk.nextToken());
	
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(start, end, 1));
		bfs(q);
	}
}