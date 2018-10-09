import java.util.Scanner;

public class Main {
	static boolean[] button = new boolean[10];
	
	static int getCount(int ch) {
		int len = 0;
		
		if(ch == 0) {
			return button[0] ? 0 : 1;
		} else {
			while(ch > 0) {
				if(button[ch%10]) { // 버튼이 고장 났으면
					return 0;
				} else {
					len++;
					ch /= 10;
				}
			}
		}
		return len;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int ans = N-100;
		
		if(ans < 0)
			ans *= -1;
		
		for(int i = 0; i < M; i++) { // 고장난 버튼 입력
			int x = sc.nextInt();
			button[x] = true;
		}
		
		for(int i = 0; i < 1000000; i++) {
			int ch = i;
			int count = getCount(ch);
			
			if(count > 0) {
				int press = N - ch;
				if(press < 0)
					press *= -1;
				if(ans > press + count)
					ans = press + count;
			}
		}
		
		System.out.println(ans);
	}
}