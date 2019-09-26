import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer, Integer> map = new HashMap<>(); // (찾은 수열, 필요한 횟수)
	static LinkedList<Integer> q = new LinkedList<>();
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static int org, find;
	
	static void bfs() {
		while(!q.isEmpty()) {
			int now = q.removeFirst();
			int z = Integer.toString(now).indexOf('9');
			int x = z/3;
			int y = z%3;
			
			if(map.containsKey(find)) {
				System.out.println(map.get(find));
				System.exit(0);
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < 3 && ny >=0 && ny < 3) {
					StringBuilder nowStr = new StringBuilder(Integer.toString(now));
					char tmp = nowStr.charAt(x*3+y);
					nowStr.setCharAt(x*3+y, nowStr.charAt(nx*3+ny));
					nowStr.setCharAt(nx*3+ny, tmp);
					
					int next = Integer.parseInt(nowStr.toString());
					
					if(!map.containsKey(next)) {
						map.put(next, map.get(now)+1);
						q.add(next);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		org = 123456789;
		find = 0;
		
		for(int i = 0 ; i < 3; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				int digit = Integer.parseInt(stk.nextToken());
				
				if(digit == 0)
					digit = 9;
				
				find *= 10;
				find += digit;
			}
		}
		
		map.put(org, 0);
		q.add(org);
		bfs();
		
		System.out.println(-1);
	}
	
}
