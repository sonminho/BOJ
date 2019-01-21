import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int gcd(int a, int b) {
		if(a % b == 0) {
			return b;
		} else {
			return gcd(b, a%b);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		int a = Integer.parseInt(in[0]);
		int b = Integer.parseInt(in[1]);
		
		System.out.println(gcd(a, b));
		System.out.println(a * b / gcd(a, b));
	}
}