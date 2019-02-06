import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] a;
	static int[] d;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		a = new int[n+1];
		d = new int[n+1];
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());			
			
			if(i == 1) { // ù��° ĭ���� ����
				for(int j = 1; j <= a[i]; j++) {
					d[i + j] = d[i] + 1;
				}	
				continue;
			}
			
			if(d[i] == 0) // �湮�� �� ���°��̶��
				continue;
			
			for(int j = 1; j <= a[i]; j++) {
				if(i + j <= n) {
					if(d[i + j] == 0) // ó�� �湮�ϸ�
						d[i + j] = d[i] + 1;
					else {
						if(d[i + j] > d[i + j] + 1)
							d[i + j] = d[i + j] + 1;
					}
				}
			}
		}
		
		if(n == 1)
			System.out.println(0);
		else if(d[n] == 0) // ���������� ������ �� ����
			System.out.println(-1);
		else
			System.out.println(d[n]);
	}
}
