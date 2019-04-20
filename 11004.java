import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	static void quickSort(int[] a, int left, int right) {
		int pl = left;
		int pr = right;
		int x = a[(pl+pr)/2]; // 피벗
		
		do{
			while(a[pl] < x) pl++;
			while(a[pr] > x) pr--;
			
			if(pl <= pr)
				swap(a, pl++, pr--);
		}while(pl <= pr);
		
		if(left < pr) quickSort(a, left, pr);
		if(pl < right) quickSort(a, pl, right);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]);
		int[] a = new int[n];
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}
		
		quickSort(a, 0, n-1);
		System.out.println(a[k-1]);
	}
}
