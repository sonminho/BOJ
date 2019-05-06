import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		String[] nums = br.readLine().split(" ");
		int[] a = new int[m];
		boolean[] d = new boolean[500501];
		int sum = 0;
		
		for(int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(nums[i]);
			//System.out.println(a[i]);
			
			int temp = a[i];
			
			while(true) {
				if(temp > n) {
					break;
				}
				
				if(!d[temp]) {
					d[temp] = true;
					sum += temp;
				}
				
				temp += a[i];
			}
		}	
		
		System.out.println(sum);
	}
}
