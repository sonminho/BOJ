import java.util.Scanner;

/*
 *  BOJ 2805 ���� �ڸ���
 *  https://www.acmicpc.net/problem/2805
 *  M ���� �̻��� ������ �������� ���� ���ܱ⿡ �����Ҽ� �ִ� ������ �ִ밪 ���ϴ� ����
 *  �̺� Ž������ �ذ�  
 */

public class Main{
	public static long calc(int[] a, int m) { // a ���� �迭, m �ڸ����� ����
		long ans = 0;
		int arrLen = a.length;
		
		for(int i = 0; i < arrLen; i++) { // m ���� �̻��� �������� ��
			if(a[i] >= m) {
				ans += (a[i] - m);
			}
		}
		
		return ans;
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt(); // ������ ��
    	int M = sc.nextInt(); // ���������� ������ ����
    	
    	int[] a = new int[N+1];
    	int max = 0;
    	
    	for(int i = 0 ; i < N; i++) {
    		a[i] = sc.nextInt();
    		if(a[i] > max)
    			max = a[i];
    	}
    	
    	int left = 1;
    	int right = max;
    	int ans = 0;
    	int mid;
    	
    	while(left <= right) {
    		mid = (left + right) / 2;
    		
    		if(M <= calc(a, mid)) { // ���� ���̸� �÷��� ��
    			ans = mid;
    			left = mid + 1;
    		} else { // ���� ���̸� ����� ��
    			right = mid - 1;
    		}
    	}
    	
    	System.out.println(ans);
    }
   
}