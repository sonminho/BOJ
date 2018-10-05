import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main{
	static int[] kmp(String str) {
		int strlen = str.length();
		int[] pi = new int[strlen];
		pi[0] = 0;
		int j = 0;
		
		for(int i = 1; i < strlen; i++) {
			while(j > 0 && str.charAt(i) != str.charAt(j)) {
				j = pi[j-1];
			}
			
			if(str.charAt(i) == str.charAt(j)) {
				pi[i] = ++j;
			} else {
				pi[i] = 0;
			}
		}
		
		return pi;
	}
	
	static ArrayList<Integer> kmp(String s, String p) {
		int[] pi = kmp(p);
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int n = s.length();
		int m = p.length();
		int j = 0;
		
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
				continue;
			while(j > 0 && s.charAt(i) != p.charAt(j)) {
				j = pi[j -1];
			}
			if(s.charAt(i) == p.charAt(j)) {
				if(j == m-1) {
					ans.add(i-m+1);
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
	
		String str = br.readLine();
		String key = br.readLine();
		ArrayList<Integer> matched = kmp(str, key);
		System.out.println(matched.size());
	}
}