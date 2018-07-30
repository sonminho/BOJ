import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 *  BOJ 2293 동전 1
 *  https://www.acmicpc.net/problem/2293
 */


public class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());
        
        int[] a = new int[n+1]; // 동전의 종류
        int[] d = new int[k+1];
        
        for(int i = 0; i < n; i++) {
        	a[i] = Integer.parseInt(br.readLine());
        }
        
        d[0] = 1;
        
        for(int i = 0; i < n; i++) {
        	for(int j = 0; j <= k; j++) {
        		if(j - a[i] >= 0)
        			d[j] += d[j-a[i]];
        	}
        }
        
        System.out.println(d[k]);
    }
}