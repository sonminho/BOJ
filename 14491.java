import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String convert(int n) {
		String result = "";
		
		while(n > 0) {			
			result = n % 9 + result;
			n /= 9;
		}
				
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		System.out.println(convert(n));
	}
	
}