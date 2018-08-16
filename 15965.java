import java.util.Scanner;

/*
 * BOJ 15965��
 * 
 * k��° �Ҽ� ã�� 
 */

public class Main{
	public static boolean isPrime(int n) { // �Ҽ��� ���ϴ� �Լ�
		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0)
				return false;	
		}
		return true; // �Ҽ��̸� ��
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int k = sc.nextInt();
    	int i, cnt = 0;
    	
    	for(i = 2; ; i++) {
    		//System.out.println(i + " - > " + isPrime(i));
    		if(isPrime(i) == true)
    			cnt++; // �Ҽ� ���� ����
    		if(cnt == k)
    			break;
    	}
    	
    	System.out.println(i);
    }
    
}