import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int E = Integer.valueOf(str[0]);
		int S = Integer.valueOf(str[1]);
		int M = Integer.valueOf(str[2]);
		
		int e, s, m;
		e=s=m=1;
		int count = 1;
		
		while(true) {
			if(e == E && s == S && m == M)
				break;
			e++;
			s++;
			m++;
			count++;
			if(e > 15)
				e = 1;
			if(s > 28)
				s = 1;
			if(m > 19)
				m = 1;
		}
		
		System.out.println(count);
	}
}