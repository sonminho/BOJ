import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int min = 4000;
	static int max = -4000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		int[] check = new int[8001];
		double sum = 0;
		int frequentNum = -1;
		int ans = 0;
		int emergedCnt = 0;
		
		for(int i = 0; i < n; i++) {			
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			
			if(min > arr[i]) 
				min = arr[i];
			if(max < arr[i]) 
				max = arr[i];
			
			check[arr[i]+4000]++;
			
			if(frequentNum < check[arr[i]+4000]) {
				frequentNum = check[arr[i]+4000];
			}
		}
		
		for(int i = 0; i <= 8000; i++) {
			if(check[i] == frequentNum && emergedCnt < 2) {
				emergedCnt++;
				ans = i-4000;
			}
		}
		
		Arrays.sort(arr);	
		
		System.out.format("%.0f\n" + arr[n/2] + "\n" + ans + "\n" + (max-min), sum/n);
	}
	
}