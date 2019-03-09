import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static void visit(int[] a, boolean[] check, int i) {
		while(true) {
			if(check[i])
				break;
			check[i] = true;
			i = a[i];
		}
	}
	
	public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    	
    	int t = Integer.parseInt(br.readLine());
	    StringBuilder ans = new StringBuilder();
	    
    	while(t-- > 0) {
	    	int n = Integer.parseInt(br.readLine());
	    	int[] a = new int[n+1];
	    	boolean[] check = new boolean[n+1];
	    	String[] in = br.readLine().split(" ");
	    	int cnt = 0;
	    	
	    	for(int i = 1; i <= n; i++) {
	    		a[i] = Integer.parseInt(in[i-1]);
	    	}
	    	
	    	for(int i = 1; i <= n; i++) {
	    		if(!check[i]) {
	    			visit(a, check, a[i]);
	    			cnt++;
	    		}
	    	}
	    	ans.append(cnt + "\n");
		}
    	System.out.println(ans);
    }
	
}