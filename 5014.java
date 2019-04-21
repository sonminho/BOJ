import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static boolean[] v;
	static int[] dist;
	static int f,s,g,u,d;
	static LinkedList<Integer> q;
	
	static void bfs() {
		while(!q.isEmpty()) {
			int cur = q.remove();
			
			if(cur+u <= f && !v[cur+u]) {
				v[cur+u] = true;
				dist[cur+u] = dist[cur]+1;
				q.add(cur+u);
			}
			
			if(cur-d > 0 && !v[cur-d]) {
				v[cur-d] = true;
				dist[cur-d] = dist[cur]+1;
				q.add(cur-d);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		
		f = Integer.parseInt(in[0]); // 층의 수
		s = Integer.parseInt(in[1]); // 시작 층
		g = Integer.parseInt(in[2]); // 목적지
		u = Integer.parseInt(in[3]);
		d = Integer.parseInt(in[4]);
		
		dist = new int[f+1];
		v = new boolean[f+1];
		
		q = new LinkedList<>();
		dist[s] = 0;
		v[s] = true;
		q.add(s);
		bfs();
		
		if(v[g])
			System.out.println(dist[g]);
		else
			System.out.println("use the stairs");
	}
}
