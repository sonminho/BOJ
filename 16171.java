import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String key = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int strLen = str.length();
		
		for(int i = 0; i < strLen; i++) {
			if(!(str.charAt(i) <= ('9') && str.charAt(i) >= ('0'))) {
				sb.append(str.charAt(i));
			}
		}
		
		if(sb.indexOf(key) < 0)
			System.out.println(0);
		else
			System.out.println(1);
	}
}