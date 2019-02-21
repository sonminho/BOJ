
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String convert(long num) {
		String result = "";
		
		while(num > 0) { 
			result += num%2;
			num /= 2;
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseUnsignedLong(br.readLine());
		long x = Long.parseUnsignedLong(br.readLine());
		String result = convert(x);
		int resultLen = result.length();
		long ans = 1;
		
		long[] nums = new long[resultLen + 1];
		nums[1] = a %  1000000007L;
		
		for(int i = 2; i <= resultLen; i++) {
			nums[i] = nums[i-1] * nums[i-1];
			nums[i] %= 1000000007L;
		}
		
		for(int i = 0; i < resultLen; i++) {
			if(result.charAt(i) == '1') {
				ans *= nums[i+1];
				ans %= 1000000007L;
			}
		}
		
		System.out.println(ans);
	}
}