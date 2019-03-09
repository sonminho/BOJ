import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
    	StringBuilder ans = new StringBuilder();
    	
    	int n = Integer.parseInt(stk.nextToken());
    	int m = Integer.parseInt(stk.nextToken());
    	int x,y,w,z;
    	int sum;
    	
    	int[][] a = new int[n+1][m+1];
    	int[][] d = new int[n+1][m+1];
    	
    	for(int i = 1; i <= n; i++) {
    		stk = new StringTokenizer(br.readLine(), " ");
    		for(int j = 1; j <= m; j++) {
    			a[i][j] = Integer.parseInt(stk.nextToken());
    			d[i][j] = a[i][j] + d[i][j-1];
    		}
    	}
    	
    	int k = Integer.parseInt(br.readLine());
  
    	while(k-- > 0) {
    		String[] in = br.readLine().split(" ");
    		x = Integer.parseInt(in[0]);
    		y = Integer.parseInt(in[1]);
    		w = Integer.parseInt(in[2]);
    		z = Integer.parseInt(in[3]);
    		sum = 0;
    		
    		for(int r = 0; r <= w-x; r++) {
    			sum += (d[x+r][z] - d[x+r][y-1]);
    		}
    		
    		ans.append(sum + "\n");
    	}
    	
    	System.out.println(ans);
    }
}