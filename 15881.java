import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] kmp(String str) {
		int strlen = str.length();
		int[] pi = new int[strlen];
		pi[0] = 0;
		int j = 0;		

		for(int i = 1; i < strlen; i++) {
			while(j > 0 && str.charAt(i) != str.charAt(j))
				j = pi[j-1];	
			if(str.charAt(i) == str.charAt(j))
				pi[i] = ++j;
			else
				pi[i] = 0;
		}

		return pi;
	}
	
	static int search(String str, String pat) {
		int ans = 0;
		int[] pi = kmp(pat);
		int strLen = str.length();
		int patLen = pat.length();
		int j = 0;
		
		for(int i = 0; i < strLen; i++) {
			while(j > 0 && str.charAt(i) != pat.charAt(j)) {
				j = pi[j-1];
			}
			
			if(str.charAt(i) == pat.charAt(j)) {
				if(j == patLen-1) {
					ans++;
					j = 0;
				} else {
					j++;
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String... args) throws Exception {
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
		int n = Integer.valueOf(br.readLine());
		
		String str = br.readLine();		
		String pat = "pPAp";
		
		System.out.println(search(str, pat));
	}
}