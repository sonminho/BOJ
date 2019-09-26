import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static StringBuilder ans = new StringBuilder();
	static int n;
	static int[][] d;
	static LinkedList<Node> q = new LinkedList<>();
	
	static class Node {
		int s;
		int c;
		
		Node(int s, int c) {
			this.s = s;
			this.c = c;
		}
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Node node = q.removeFirst();
			int nodeS = node.s;
			int nodeC = node.c;
						
			if(nodeS == n) {
				System.out.println(d[nodeS][nodeC]);
				break;
			}
			
			if(d[nodeS][nodeS] == -1) { // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.				 
				d[nodeS][nodeS] = d[nodeS][nodeC] + 1;
				q.add(new Node(nodeS, nodeS));
			}
			
			if((nodeS + nodeC <= 1000) && d[nodeS + nodeC][nodeC] == -1) { // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
				d[nodeS + nodeC][nodeC] = d[nodeS][nodeC] + 1;
				q.add(new Node(nodeS + nodeC, nodeC));
			}
			
			if((nodeS - 1 >= 0) && d[nodeS - 1][nodeC] == -1) { // 화면에 있는 이모티콘 중 하나를 삭제한다.
				d[nodeS-1][nodeC] = d[nodeS][nodeC] + 1;
				q.add(new Node(nodeS-1, nodeC));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		d = new int[1001][1001];
		
		for(int i = 0; i <= n; i++) {
			Arrays.fill(d[i], -1);
		}
		
		d[1][0] = 0; // 초기 이모티콘 1개, 클립보드 0개 상태
		q.add(new Node(1, 0));
		bfs();
	}
}
