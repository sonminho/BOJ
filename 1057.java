import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(stk.nextToken());
		int kim = Integer.parseInt(stk.nextToken());
		int im = Integer.parseInt(stk.nextToken());
		
		int cnt = 0;
		
		while(true) {
			if(kim%2 == 1) {
				kim++;
			}
			if(im%2 == 1)  {
				im++;
			}
			cnt++;			
			if(kim/2 == im/2) {
				break;
			} else {
				kim /= 2;
				im /= 2;
			}
		}
		System.out.println(cnt);
	}
}