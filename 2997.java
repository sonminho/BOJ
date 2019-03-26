import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[3];
		for(int i = 0; i < 3; i++)
			a[i] = Integer.parseInt(stk.nextToken());
		Arrays.sort(a);
		
		int dl = a[1]-a[0];
		int dr = a[2]-a[1];
		
		if(dl == dr) {
			if(a[2] + dr >= 100) {
				System.out.println(a[0] - dl);
			} else {
				System.out.println(a[2] + dr);
			}
		} else if(dl < dr) {
			System.out.println(a[1] + dl);
		} else {
			System.out.println(a[0] + dr);
		}
	}
}