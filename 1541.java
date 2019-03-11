import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int strLen = str.length();
		int num = 0;
		int total = 0;
		
		List<Integer> numList = new ArrayList<>();
		List<Integer> signList = new ArrayList<>();
		signList.add(1);
		boolean minusFlag = false;
		
		for(int i = 0; i < strLen; i++) {
			char c = str.charAt(i);
			if(c == '+' || c == '-') {
				if(c == '+') {
					signList.add(1);
				} else {
					signList.add(-1);
				}
				numList.add(num);
				num = 0;
				
			} else { // ¼ýÀÚ
				num = num * 10 + (c - '0');
			}			
		}
		
		numList.add(num);
		
		int numLen = numList.size();
		
		for(int i = 0; i < numLen; i++) {
			if(signList.get(i) == -1) {
				minusFlag = true;
			} 			
			if(minusFlag) { //  - (.. + .. )
				total -= numList.get(i);
			} else {
				total += numList.get(i);
			}
		}
		
		System.out.println(total);
	}

}