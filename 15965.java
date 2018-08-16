import java.util.Scanner;

/*
 * BOJ 15965번
 * 
 * k번째 소수 찾기 
 */

public class Main{
	public static boolean isPrime(int n) { // 소수를 구하는 함수
		for(int i = 2; i*i <= n; i++) {
			if(n % i == 0)
				return false;	
		}
		return true; // 소수이면 참
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int k = sc.nextInt();
    	int i, cnt = 0;
    	
    	for(i = 2; ; i++) {
    		//System.out.println(i + " - > " + isPrime(i));
    		if(isPrime(i) == true)
    			cnt++; // 소수 개수 증가
    		if(cnt == k)
    			break;
    	}
    	
    	System.out.println(i);
    }
    
}