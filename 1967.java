import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static boolean[] visit;
	static int maxCost = 0;
	static Node maxNode = null;
	
	static class Node {
		int num;
		int cost;
		
		Node(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
	}
	
	static void dfs(List<Node>[] lists, List<Node> list, Node node, int cost) {
		for(Node nextNode : list) {
			if(!visit[nextNode.num]) { // �湮���� ���� �����̶��
				visit[nextNode.num] = true;
				dfs(lists, lists[nextNode.num], nextNode, cost + nextNode.cost);
				visit[nextNode.num] = false;
			}
		}
		
		if(cost > maxCost) { // ���̻� �湮�� ���� ���� ���
			maxCost = cost;
			maxNode = node;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int from, to, cost;
		int n = Integer.parseInt(br.readLine());
		List<Node>[] lists = new ArrayList[n+1];
		
		for(int i = 1; i <= n; i++)
			lists[i] = new ArrayList<>();
		
		
		for(int i = 1; i < n; i++) { // �Է�
			stk = new StringTokenizer(br.readLine(), " ");
			
			from = Integer.parseInt(stk.nextToken()); // ���
			to = Integer.parseInt(stk.nextToken()); // ����
			cost = Integer.parseInt(stk.nextToken()); // ���
			
			lists[from].add(new Node(to, cost)); // ����� ���� ����Ʈ
			lists[to].add(new Node(from, cost));
		}
		
		visit = new boolean[n+1]; // 1�� ���κ��� ���� �� ��� Ž��
		visit[1] = true;
		dfs(lists, lists[1], new Node(1, 0), 0);
		
		visit = new boolean[n+1]; // ���� �� ��忡�� ���� �� ��� Ž��
		visit[maxNode.num] = true;
		cost = 0;
		dfs(lists, lists[maxNode.num], new Node(maxNode.num, 0), 0);
		System.out.println(maxCost);
	}
}