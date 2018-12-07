import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static boolean isPossible(int num) {
		int cnt = 0;
		
		while(num != 0) {
			if(num%2 == 1) 
				cnt++;
			
			num /= 2;
			
			if(cnt > 1)
				return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.valueOf(br.readLine());
		StringBuilder ans = new StringBuilder();
		
		while(testCase-- > 0) {
			int n = Integer.valueOf(br.readLine());
			
			if(isPossible(n))
				ans.append("Gazua\n");
			else
				ans.append("GoHanGang\n");
		}
		
		System.out.println(ans);
	}
	
}