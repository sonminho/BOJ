import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int n, num, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			
			n = stk.countTokens();
			cnt = 0;
			List<Integer> list = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				num = Integer.parseInt(stk.nextToken());				
				list.add(num);
			}
			
			for(int i = 0; i < n; i++) {
				num = list.get(i);
				
				if(num == -1) { // 프로그램 종료
					return;
				}
				
				if(list.contains(num*2)) {
					cnt++;
				}
				
				if(num == 0) { // 입력의 끝
					System.out.println(cnt-1);
					break;
				}
			}
		}
	}
}