import java.io.IOException;
import java.util.Scanner;

/*
 * BOJ 10974 모든 순열 구하기 
 * N을 입력받아  N! 만큼의 증가하는 순열 출력
 * EX) 3 입력시
 * 
 * 	   출력  1 2 3
 *       1 3 2
 *       2 1 3
 *       2 3 1
 *       3 1 2
 *       3 2 1
 */

public class Main{
	
	public static boolean nextPermutation(int[] a) { // 다음 순열 구하기
		int i = a.length - 1;
		int j = i;
		
		while(i > 0 && a[i-1] >= a[i]) { // 뒤에 있는 숫자가 앞쪽으로 오름 차순이 아닐 때 까지 i 감소
			i--;
		}
		
		if(i == 0) {
			return false;
		}
		while(a[i-1] >= a[j]) { // i 우측에서 i-1 번째보다 크거나 같은  인덱스 계산 
			j--;
		}
				
		int temp = a[i-1]; // 스왑
		a[i-1] = a[j];
		a[j] = temp;
		
		j = a.length - 1;
		
		while(i < j) {
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
		
		return true;
	}
	
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int n  = 1;
    	
    	for(int i = 2; i <= N; i++) {
    		n *= i;
    	}
    	
    	int[] a = new int[N];
    	
    	for(int i = 0; i < N; i++) {
    		a[i] = i+1;
    		System.out.print(a[i] + " ");
    	}
    	
    	System.out.println();
    	
    	for(int i = 0; i < n; i++) {
    		if(nextPermutation(a)) {
        		for(int j = 0; j < N; j++) {
            		System.out.print(a[j] + " ");
            	}
        		System.out.println();
        	} else {
        		break;
        	}
    	}
    	
    }
    
}