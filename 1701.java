import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int kmp(String str) {
		int strlen = str.length();
		int[] pi = new int[strlen];
		pi[0] = 0;
		int j = 0;
		int max = 0;
		
		for(int i = 1; i < strlen; i++) {
			while(j > 0 && str.charAt(i) != str.charAt(j)) {
				j = pi[j-1];
			}
			
			if(str.charAt(i) == str.charAt(j)) {
				pi[i] = ++j;
				if(max < pi[i])
					max = pi[i];
			} else {
				pi[i] = 0;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int ans = 0, temp = 0;
		String input = br.readLine();
		int inputLen = input.length();
		
		for(int i = 0; i < inputLen; i++) {
			temp = kmp(input.substring(i, inputLen));
			if(temp > ans) 
				ans = temp;
		}
		System.out.println(ans);
	}
}