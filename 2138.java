import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static int n;
	static int[] a;
	static int[] b;
	static int[] a2;
	static int ans = Integer.MAX_VALUE;
	
	// 인접한 인덱스와 현재 인덱스의 값 변경
	static void reverse(int[] arr, int idx) {
		if(idx > 0) {
			if (arr[idx-1] == 1)
				arr[idx-1] = 0;
			else
				arr[idx-1] = 1;
		}
		
		if (arr[idx] == 1)
			arr[idx] = 0;
		else
			arr[idx] = 1;
		
		if(idx+1 < n) {
			if (arr[idx+1] == 1)
				arr[idx+1] = 0;
			else
				arr[idx+1] = 1;
		}
	}
	
	static boolean check(int[] arr, boolean isAnswer) {
		for(int i = 0; i < n; i++) {
			if(arr[i] != b[i]) {
				isAnswer = false;
				break;
			}
		}
		
		return isAnswer;
	}
	
	static void dfs(int[] arr, int cnt, int idx) {
		if(idx == n-1) {
			boolean isAnswer = true;
			isAnswer = check(arr, isAnswer);
			
			// 답을 찾은 경우
			if(isAnswer) {
				ans = ans > cnt ? cnt : ans;
			}
			
			// 마지막 버튼을 누르고 답을 확인
			reverse(arr, idx);
			isAnswer = true;
			isAnswer = check(arr, isAnswer);			
			if(isAnswer) {
				ans = ans > cnt+1 ? cnt+1 : ans;
			}
			
			return;
		}
		
		// 스위치 안누름
		if(arr[idx-1] == b[idx-1]) {
			dfs(arr, cnt, idx+1);
		}
		
		reverse(arr, idx);
		if(arr[idx-1] == b[idx-1]) {
			dfs(arr, cnt+1, idx+1);
		}
		
		reverse(arr, idx);
	}
	
	static void print(int[] arr) {
		for(int i =0 ; i < arr.length; i++)
			System.out.print(arr[i]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		b = new int[n];
		a2 = new int[n];
		
		String now = br.readLine();
		String res = br.readLine();
		
		for(int i = 0; i < n; i++) {
			a[i] = now.charAt(i) - '0';
			b[i] = res.charAt(i) - '0';
			a2[i] = a[i];
		}
		
		dfs(a, 0, 1);
		reverse(a2, 0);
		dfs(a2, 1, 1);
		
		if(ans != Integer.MAX_VALUE)
			System.out.println(ans);
		else
			System.out.println(-1);
	}
}
