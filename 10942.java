import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/* 

BOJ 10942 �Ӹ����
https://www.acmicpc.net/problem/10942

*/

public class Main {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N+1];
        boolean[][] d = new boolean[N+1][N+1];
        
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        // N���� �ڿ��� �Է�
        for(int i = 1;  i <= N; i++) {
        	a[i] = Integer.parseInt(stk.nextToken());
        }
        
        // ���� 1
        for(int i = 1; i <= N; i++) {
        	d[i][i] = true; 
        }
        
        // ���� 2
        for(int i = 1; i <= N-1; i++) {
        	if(a[i] == a[i+1])
        		d[i][i+1] = true;
        }
        
        // ���� 3 �̻�
        for(int k = 3; k <= N; k++) { // ���ڿ� ũ��
        	for(int i = 1; i <= N-k+1; i++) { // ���ڿ� ���� ��ġ
        		int j = i+k-1;
        		
        		if(a[i] == a[j] && d[i+1][j-1])
        			d[i][j] = true;
        	}
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        // ���
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