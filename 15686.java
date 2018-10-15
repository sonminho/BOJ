import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int[][] a;
	static int[] visited;
	static int sum;
	
	static ArrayList<Node> chickens;
	static ArrayList<Node> houses;
	static ArrayList<Integer> ansList = new ArrayList<>();
	static Node[] place;
	
	static class Node {
		int x, y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void go(int m, int[] visited, String order, int i) {
		StringTokenizer stk = new StringTokenizer(order, " ");
		int cnt = stk.countTokens();
		
		if(cnt == m) {
			for(int k = 0; k < m; k++) {
				place[k] = chickens.get(Integer.valueOf(stk.nextToken()));
			}
			sum = 0;
			for(Node house : houses) {
				int dist;
				int min = Integer.MAX_VALUE;
			
				
				for(int k = 0; k < m; k++) {
					dist = Math.abs(place[k].x - house.x) + Math.abs(place[k].y - house.y);
					
					if(dist < min)
						min = dist;
				}
				sum += min;
			}	
			ansList.add(sum);
			
			return;
		}
		
		if(i < visited.length) {
			go(m, visited, order + visited[i] + " ", i+1);
			go(m, visited, order, i+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		StringTokenizer stk;
		
		n = Integer.valueOf(in[0]);
		m = Integer.valueOf(in[1]);
		a = new int[n][n];
		
		chickens = new ArrayList<Node>();
		houses = new ArrayList<Node>();
		
		for(int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				a[i][j] = Integer.valueOf(stk.nextToken());
				
				if(a[i][j] == 1)
					houses.add(new Node(i, j));
				else if(a[i][j] == 2)
					chickens.add(new Node(i, j));
			}
		}
		
		int chickenSize = chickens.size();
		visited = new int[chickenSize];
		place = new Node[m];
		for(int i = 0; i < chickenSize; i++) {
			visited[i] = i;
		}
		 
		go(m, visited, "", 0);
		
		int min = Integer.MAX_VALUE;
		for(int x : ansList)
			if(x < min) 
				min = x;
		
		System.out.println(min);
	}
}