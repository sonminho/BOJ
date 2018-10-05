import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
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
	
	static int search(String a, String b) {
		int ans = 0;
		int[] pi = kmp(b);
		int alen = a.length();
		int blen = b.length();
		int j = 0;
		
		for(int i = 0; i < alen; i++) {
			while(j > 0 && a.charAt(i) != b.charAt(j))
				j = pi[j-1];
			if(a.charAt(i) == b.charAt(j)) {
				if(j == blen-1) { // ¹ß°ß
					ans++;
					j = pi[j];
				} else {
					j += 1;
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine();
		String B = br.readLine();
		String P = B+B;
		System.out.println(search(P.substring(0, P.length()-1), A));
	}
}