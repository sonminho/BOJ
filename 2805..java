import java.util.Scanner;

/*
 *  BOJ 2805 나무 자르기
 *  https://www.acmicpc.net/problem/2805
 *  M 미터 이상의 나무를 가져가기 위해 절단기에 설정할수 있는 높이의 최대값 구하는 문제
 *  이분 탐색으로 해결  
 */

public class Main{
	public static long calc(int[] a, int m) { // a 나무 배열, m 자르려는 높이
		long ans = 0;
		int arrLen = a.length;
		
		for(int i = 0; i < arrLen; i++) { // m 높이 이상의 나무들의 합
			if(a[i] >= m) {
				ans += (a[i] - m);
			}
		}
		
		return ans;
	}
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt(); // 나무의 수
    	int M = sc.nextInt(); // 가져가려는 나무의 길이
    	
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
    		
    		if(M <= calc(a, mid)) { // 절단 높이를 올려야 함
    			ans = mid;
    			left = mid + 1;
    		} else { // 절단 높이를 낮춰야 함
    			right = mid - 1;
    		}
    	}
    	
    	System.out.println(ans);
    }
   
}