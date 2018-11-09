import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int cnt, cnt2;
	static int sum, sum2;
	static int ans = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int strLen = str.length();
		
		Stack<String> stack = new Stack<>();
		
		for(int i = 0; i < strLen; i++) {
			String c = str.charAt(i) + "";
			
			if(c.equals("(")) {
				cnt++;
				stack.push(c);
			} else if(c.equals(")")) {
				cnt--;
				if(stack.size() == 0 || stack.peek().equals("[")) {
					System.out.println(0);
					return;
				}
					
				if(stack.peek().equals("(")) {
					stack.pop();
					stack.push("2");
				} else {
					sum = 0;
					while(!stack.empty()) {
						if(stack.peek().equals("(")) {
							//cnt--;
							stack.pop();
							sum *= 2;
							stack.push(sum + "");
							break;
						} else if(stack.peek().equals("[")) {
							System.out.println(0);
							return;
						} else { // ¼ýÀÚ
							sum += Integer.valueOf(stack.pop());
						}
					}
				}							
			} else if(c.equals("[")) {
				cnt2++;
				stack.push("[");
			} else {
				cnt2--;
				if(stack.size() == 0 || stack.peek().equals("(")) {
					System.out.println(0);
					return;
				} 
				if(stack.peek().equals("[")){
					
					stack.pop();
					stack.push("3");
				} else {	
					sum2 = 0;
					while(!stack.isEmpty()) {
						if(stack.peek().equals("[")) {
							//cnt2--;
							stack.pop();
							sum2 *= 3;
							stack.push(sum2 + "");
							break;
						} else if(stack.peek().equals("(")) {
							System.out.println(0);
							return;
						} else {
							sum2 += Integer.valueOf(stack.pop());
						}
					}
				}
			}
			
			if(cnt < 0 || cnt2 < 0) {
				System.out.println(0);
				return;
			}
		}
		
		if(cnt != 0 || cnt2 != 0) {
			System.out.println(0);
			return;
		}
		
		while(!stack.isEmpty()) {
			ans += Integer.valueOf(stack.pop());
		}
		
		System.out.println(ans);
	}
	
}