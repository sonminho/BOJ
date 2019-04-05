import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {
	static List<StringBuilder> prepare(String inputLine) {
		List<StringBuilder> list = new ArrayList<>();
		StringBuilder temp = new StringBuilder();
		
		for(char c : inputLine.toCharArray()) {
			if(c == ' ' || c == ',' || c == ';') {
				if(temp.length() > 0) {
					list.add(temp);
				}
				temp = new StringBuilder();
			} else {
				temp.append(c);
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder ans = new StringBuilder();
		
		List<StringBuilder> list = prepare(br.readLine());
		StringBuilder varType = new StringBuilder().append(list.get(0).toString());
		
		for(int i = 1; i < list.size(); i++) {
			String str = list.get(i).toString();
			StringBuilder type = new StringBuilder();
			StringBuilder name = new StringBuilder();
			
			type.append(varType);
			
			for(int j = str.length()-1; j >= 0; j--) {
				char ch = str.charAt(j);
				if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
					name.append(str.substring(0, j+1));
					break;
				} else if(ch == '[') {
					type.append("]");
				} else if(ch == ']') {
					type.append("[");
				} else {
					type.append(ch);
				}
			}
			ans.append(type)
				.append(" ")
				.append(name)
				.append(";\n");
		}
		System.out.println(ans);
	}
}