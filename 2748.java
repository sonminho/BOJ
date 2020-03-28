import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long n;
		
	static long[][] matrixMul(long[][] a, long[][] b) {
		long[][] ret = new long[a.length][b[0].length];
		
		for(int i = 0; i < ret.length; i++) {
			for(int j = 0; j < ret[0].length; j++) {
				for(int k = 0; k < ret[0].length; k++) {
					ret[i][j] += a[i][k]*b[k][j];					
				}
				ret[i][j] %= 1000000;
			}
		}
		
		return ret;
	}
		
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			n = Long.parseLong( br.readLine() );
			
			long[][] a = {{1,1},{1,0}};

			long[][] ret ={{1,1},{1,0}};
			
			for(int i = 0; i < n-2; i++) {
				ret = matrixMul(ret, a);
			}
			
			System.out.println(ret[0][0]);
		} catch(Exception e) {
			System.exit(1);
		}
	}
}
