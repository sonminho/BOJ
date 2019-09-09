import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int a1, a2, temp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		a1 = Integer.parseInt(br.readLine());
		a2 = Integer.parseInt(br.readLine());
		temp = a2;
		
		while(temp != 0) {
			ans.append((a1 * (temp%10)) + "\n");
			temp /= 10;			
		}
		
		ans.append(a1 * a2);
		System.out.println(ans.toString());
	}
}
