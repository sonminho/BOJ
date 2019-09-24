import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static final int MIN = 0;
	static final int MAX = 10000;
	static int t, a, b;
	static LinkedList<Integer> q;
	static boolean[] check;
	static int[] dist;
	static int[] from;
	static char[] how;
	static Stack<String> stack;
	static StringBuilder ans = new StringBuilder();
	
	static void bfs() {
		while (!q.isEmpty()) {
			int now = q.removeFirst();

			if (now == b) { // 정답을 찾음				
				for(int i = b; i != a; i = from[i]) {
					stack.add(Character.toString(how[i]));
				}
				
				while(!stack.isEmpty()) {
					ans.append(stack.pop());
				}
				break;
			}

			int d = now * 2;
			int s = now - 1;
			int l = (now % 1000) * 10 + (now / 1000);
			int r = (now % 10) * 1000 + now / 10;

			if (d >= MAX) {
				d %= 10000;
			}
			if (s < 0) {
				s = 9999;
			}

			if (!check[d]) {
				q.add(d);
				check[d] = true;
				dist[d] = dist[now] + 1;
				from[d] = now;
				how[d] = 'D';
			}

			if (!check[s]) {
				q.add(s);
				check[s] = true;
				dist[s] = dist[now] + 1;
				from[s] = now;
				how[s] = 'S';
			}
			
			if(!check[l]) {
				q.add(l);
				check[l] = true;
				dist[l] = dist[now] + 1;
				from[l] = now;
				how[l] = 'L';
			}
			
			if(!check[r]) {
				q.add(r);
				check[r] = true;
				dist[r] = dist[now] + 1;
				from[r] = now;
				how[r] = 'R';
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			q = new LinkedList<>();
			check = new boolean[MAX];
			dist = new int[MAX];
			from = new int[MAX];
			how = new char[MAX];
			stack = new Stack<>();
			
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			
			a = Integer.parseInt(stk.nextToken());
			b = Integer.parseInt(stk.nextToken());
			
			q.add(a);
			check[a] = true;
			bfs();
			
			ans.append("\n");
		}
		
		System.out.println(ans.toString());
	}
}
