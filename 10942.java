import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* 

BOJ 10942 팰린드롬
https://www.acmicpc.net/problem/10942

*/

public class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N+1];
        boolean[][] d = new boolean[N+1][N+1];
        
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        // N개의 자연수 입력
        for(int i = 1;  i <= N; i++) {
        	a[i] = Integer.parseInt(stk.nextToken());
        }
        
        // 길이 1
        for(int i = 1; i <= N; i++) {
        	d[i][i] = true; 
        }
        
        // 길이 2
        for(int i = 1; i <= N-1; i++) {
        	if(a[i] == a[i+1])
        		d[i][i+1] = true;
        }
        
        // 길이 3 이상
        for(int k = 3; k <= N; k++) { // 문자열 크기
        	for(int i = 1; i <= N-k+1; i++) { // 문자열 시작 위치
        		int j = i+k-1;
        		
        		if(a[i] == a[j] && d[i+1][j-1])
        			d[i][j] = true;
        	}
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // 출력
        while(M-- > 0) {
	        stk = new StringTokenizer(br.readLine());
	        
	        int S = Integer.parseInt(stk.nextToken());
	        int E = Integer.parseInt(stk.nextToken());
	        
	        if(d[S][E] == true)
	        	sb.append("1\n");
	        else
	        	sb.append("0\n");
        }
        
        System.out.print(sb);
    }
}