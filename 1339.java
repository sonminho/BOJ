import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static boolean nextPermutation(int[] a, int n) {
		int i, j;
		
		for(i = n-1; i > 0; i--) {
			if(a[i-1] < a[i]) break;
		}
		
		if(i <= 0)
			return false;
		
		for(j = n-1; i <= j; j--) {
			if(a[i-1] < a[j])
				break;
		}
		
		swap(a, i-1, j);
		
		j = n-1;
		
		while(i <= j) {
			swap(a, i++, j--);
		}
	
		return true;
	}
	
	static int[] alpha = new int[256];
	
	static int getSum(String[] strings, int[] a, Character[] charSet) {
		int sum = 0;
		int charSetLen = charSet.length;
		
		for(int i = 0; i < charSetLen; i++) {
			alpha[charSet[i]] = a[i];
		}
		
		for(String s : strings) {
			int now = 0;
			
			for(char x : s.toCharArray()) {
				now = (now*10) + alpha[x];
			}
			
			sum += now;
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		String[] strings = new String[n];
		HashSet<Character> hashSet = new HashSet<>();
		
		for(int i = 0; i < n; i++) {
			strings[i] = br.readLine();
			
			for(char x : strings[i].toCharArray()) {
				hashSet.add(x);
			}
		}
		
		int ans = 0;
		
		int hashSetLen = hashSet.size();
		int[] a = new int[hashSetLen];
		
		Character[] charSet = hashSet.toArray(new Character[hashSetLen]);
		
		for(int i = 0; i < hashSetLen; i++) {
			a[i] = 9-i;
		}
		
		Arrays.sort(a);
		
		do { 
			int sum = getSum(strings, a, charSet);
			
			if(ans < sum)
				ans = sum;
		} while(nextPermutation(a, hashSetLen));
		
		System.out.println(ans);
	}
}