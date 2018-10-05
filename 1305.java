import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	static int[] kMp(String str) {
		int m = str.length();
		int[] pi = new int[m];
		pi[0] = 0;
		int j = 0;
		
		for(int i = 1; i < m; i++) {
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
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.valueOf(br.readLine());
			String S = br.readLine();
			int[] pi = kMp(S);
			System.out.println(N - pi[N-1]);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}