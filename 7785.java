import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		StringBuilder ans = new StringBuilder();
		HashMap<String, String> hashMap = new HashMap<>();
		
		while(n-- > 0) {
			String[] in = br.readLine().split(" ");
			
			if(in[1].equals("enter")) {
				hashMap.put(in[0], in[1]);
			} else {
				hashMap.remove(in[0]);
			}
		}
		
		TreeMap<String, String> tm = new TreeMap<String, String>(hashMap);
		Iterator<String> it = tm.descendingKeySet().iterator();
		
		while(it.hasNext()) {
			ans.append(it.next() + "\n");
		}
		
		System.out.println(ans);
	}
	
}
