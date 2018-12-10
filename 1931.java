import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	static class Node {
		int start;
		int end;
		
		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		ArrayList<Node> list = new ArrayList<>();
		
		while(n-- > 0) {
			String[] in = br.readLine().split(" ");
			list.add(new Node(Integer.valueOf(in[0]), Integer.valueOf(in[1])));
		}
		
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.end < o2.end)
					return -1;
				else if(o1.end == o2.end)
					if(o1.start < o2.start)
						return -1;
					else if(o1.start == o2.start)
						return 0;
					else 
						return 1;
				else
					return 1;
			}
		});
		
		int curEnd = -1;
		int cnt = 0;
		
		for(Node node : list) {
			if(curEnd <= node.start) {
				curEnd = node.end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
}