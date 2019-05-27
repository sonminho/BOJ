import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static int t[], p[], d[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		t = new int[n+1];
		p = new int[n+1];
		d = new int[n+51];
		
		for(int i = 1; i <= n; i++) {
			String[] in = br.readLine().split(" ");
			t[i] = Integer.parseInt(in[0]);
			p[i] = Integer.parseInt(in[1]);
		}
		
		for(int i = 1; i <= n; i++) {
			d[i+t[i]] = d[i+t[i]] > (d[i] + p[i]) ? d[i+t[i]] : (d[i] + p[i]);
			d[i+1] = d[i+1] > d[i] ? d[i+1] : d[i];
		}
		
		System.out.println(d[n+1]);
	}
}
