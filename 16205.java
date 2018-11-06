import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		String s = str[1];
		
		StringBuilder ans = new StringBuilder();
		StringBuilder ans2 = new StringBuilder();
		
		if(Integer.valueOf(str[0]) == 1) {
			ans.append(s + "\n");
			
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
					ans.append("_" + (char)(s.charAt(i) + 32));
				} else {
					ans.append(s.charAt(i));
				}
			}
			ans.append("\n" + (char)(s.charAt(0) - 32) + s.substring(1, s.length()));
		} else if (Integer.valueOf(str[0]) == 2) {
			String[] temp = s.split("_");
			
			ans.append(temp[0].substring(0, temp[0].length()));
			ans2.append((char)(temp[0].charAt(0) - 32) + temp[0].substring(1, temp[0].length()));
			
			if(temp.length > 0) {
				for(int i = 1; i < temp.length; i++) {
					char a = (char) (temp[i].charAt(0) - 32);
					ans.append(a).append(temp[i].substring(1, temp[i].length()));
					ans2.append(a).append(temp[i].substring(1, temp[i].length()));
				}
			}
			
			ans.append("\n" + s + "\n" + ans2);
		} else if (Integer.valueOf(str[0]) == 3) {
			ans.append((char)(s.charAt(0) + 32) + s.substring(1, s.length()) + "\n");
			
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
					ans2.append("_" + (char)(s.charAt(i) + 32));
				} else {
					ans2.append(s.charAt(i));
				}
			}

			ans.append(ans2.substring(1, ans2.length()));
			ans.append("\n" + s);
		}
		
		System.out.println(ans);
	}
}