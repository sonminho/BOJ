import java.util.Scanner;

public class Main {
	static int[] buff, a;
	
	static void mergeSort(int[] a, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			int p = 0; // ¹öÆÛ ÀÎµ¦½º
			int j = 0;
			int k = left;
			int i;
			
			mergeSort(a, k, mid);
			mergeSort(a, mid+1, right);
			
			for(i = left; i <= mid; i++) 
				buff[p++] = a[i];
			
			
			while(j < p && i <= right) 
				a[k++] = (buff[j] > a[i]) ? a[i++] : buff[j++];
			
			
			while(j < p)
				a[k++] = buff[j++];
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		a = new int[n];
		buff = new int[n];
		
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
		mergeSort(a, 0, n-1);
		
		for(int i = 0; i < n; i++)
			System.out.println(a[i]);
	}
}