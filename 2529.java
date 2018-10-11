import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static boolean nextPermutation(int[] a, int n) {
		int i, j;
		
		for(i = n-1; i > 0; i--) {
			if(a[i-1] < a[i])
				break;
		}
		
		if(i <= 0)
			return false;
		
		
		for(j = n-1; j >= i; j--) {
			if(a[i-1] < a[j])
				break;
		}
		
		swap(a, i-1, j);
		
		j = n-1;
		
		while(i <= j) {
			swap(a, i, j);
			i++;
			j--;
		}
		
		return true;
	}
	
	static boolean prevPermutation(int[] a, int n) {
		int i, j;
		
		for(i = n-1; i > 0; i--) {
			if(a[i-1] > a[i]) 
				break;
		}
		
		if(i <= 0)
			return false;
		
		for(j = n-1; j >= i; j--) {
			if(a[i-1] > a[j])
				break;
		}
		
		swap(a, i-1, j);
		
		j = n-1;
		
		while(i <= j) {
			swap(a, i, j);
			i++;
			j--;
		}
		
		return true;
	}
	
	static boolean check(int[] perm, char[] a) {
		int len = a.length;
        for (int i=0; i < len; i++) {
            if (a[i] == '<' && perm[i] > perm[i+1]) {
                return false;
            }
            if (a[i] == '>' && perm[i] < perm[i+1]) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.valueOf(br.readLine());
		StringBuilder ans = new StringBuilder();
		
		char[] a = new char[k+1];
		int[] small = new int[k+1];
		int[] big = new int[k+1];
		
		String[] op = br.readLine().split(" ");
		
		for(int i = 0; i < k; i++) {
			a[i] = op[i].charAt(0);
		}
		
		for(int i = 0; i <= k; i++) {
			small[i] = i;
			big[i] = 9 - i;
		}
		
		do {
			if(check(big, a))
				break;
		} while(prevPermutation(big,k+1));
		
		for(int i = 0; i <= k; i++) {
			ans.append(big[i]);
		}
		ans.append("\n");
		do {
			if(check(small, a))
				break;
		} while(nextPermutation(small,k+1));
		
		for(int i = 0; i <= k; i++) {
			ans.append(small[i]);
		}
		
		System.out.println(ans);
	}
}