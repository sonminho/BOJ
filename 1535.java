import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] hp = new int[n];
		int[] pleasure = new int[n];
		
		String[] in = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			hp[i] = Integer.parseInt(in[i]);
		}
		
		in = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			pleasure[i] = Integer.parseInt(in[i]);
		}
		
		int hpSum = 100;
		int pleasureSum = 0;
		int maxP = 0;
		
		LABEL:
		for(int i = 1; i < (1 << n); i++) {
			hpSum = 100;
			pleasureSum = 0;
			
			for(int j = 0; j < n; j++) {
				if((i & (1 << j)) != 0) {
					hpSum -= hp[j];
					
					if(hpSum <= 0)
						continue LABEL;
					
					pleasureSum += pleasure[j];
				}
			}
			
			if(pleasureSum > maxP)
				maxP = pleasureSum;
		}
		
		System.out.println(maxP);
	}
}