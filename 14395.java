import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static long s,t;
	static final long MAX = 1000000000L;
	static HashSet<Long> set;
	static LinkedList<Long> q;
	static LinkedList<String> ans;
	
	static void bfs() {
		while(!q.isEmpty()) {
			long x = q.remove();			
			String str = ans.remove();
					
			if(x == t) { // 정답을 찾음
				System.out.println(str);
				return;
			}
			
			if(x*x >= 1 && x*x <= MAX && !set.contains(x*x)) {
				q.add(x*x);
				ans.add(str+"*");
				set.add(x*x);
			}
			
			if(x+x >= 1 && x+x <= MAX && !set.contains(x+x)) {
				q.add(x+x);
				ans.add(str+"+");
				set.add(x+x);
			}
			
			if(x-x >= 0 && x-x <= MAX && !set.contains(x-x)) {
				q.add(x-x);
				ans.add(str+"-");
				set.add(x-x);
			}
			
			if(x != 0 && x/x >= 1 && x/x <= MAX && !set.contains(x/x)) {
				q.add(x/x);
				ans.add(str+"/");
				set.add(x/x);
			}
		}
		
		System.out.println(-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		s = Long.parseLong(stk.nextToken());
		t = Long.parseLong(stk.nextToken());
		
		q = new LinkedList<>();
		ans = new LinkedList<>();
		set = new HashSet<>();
		
		if(s == t) {
			System.out.println(0);
			return;
		}
		
		q.add(s);
		ans.add("");
		set.add(s);
		bfs();
	}
}1
