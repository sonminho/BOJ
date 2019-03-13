import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	static class Node {
		int no;
		String name;
		
		Node(int no, String name) {
			this.no = no;
			this.name = name;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder ans = new StringBuilder();
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			ArrayList<Node> list = new ArrayList<>();
			
			while(n-- > 0) {
				String[] in = br.readLine().split(" ");
				list.add(new Node(Integer.parseInt(in[0]), in[1]));
				
				list.sort(new Comparator<Node>() {

					@Override
					public int compare(Node arg0, Node arg1) {
						if(arg0.no < arg1.no)
							return 1;
						else if(arg0.no == arg1.no)
							return 0;
						else
							return -1;
					}
				});
			}
			ans.append(list.get(0).name + "\n");
		}
		System.out.println(ans);
	}

}