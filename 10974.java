import java.io.IOException;
import java.util.Scanner;

/*
 * BOJ 10974 ��� ���� ���ϱ� 
 * N�� �Է¹޾�  N! ��ŭ�� �����ϴ� ���� ���
 * EX) 3 �Է½�
 * 
 * 	   ���  1 2 3
 *       1 3 2
 *       2 1 3
 *       2 3 1
 *       3 1 2
 *       3 2 1
 */

public class Main{
	
	public static boolean nextPermutation(int[] a) { // ���� ���� ���ϱ�
		int i = a.length - 1;
		int j = i;
		
		while(i > 0 && a[i-1] >= a[i]) { // �ڿ� �ִ� ���ڰ� �������� ���� ������ �ƴ� �� ���� i ����
			i--;
		}
		
		if(i == 0) {
			return false;
		}
		while(a[i-1] >= a[j]) { // i �������� i-1 ��°���� ũ�ų� ����  �ε��� ��� 
			j--;
		}
				
		int temp = a[i-1]; // ����
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