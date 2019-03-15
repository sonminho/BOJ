import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static class Node {
		int[] a;
		
		Node() {
			a = new int[2];
			a[0] = -1;
			a[1] = -1;
		}
	}
	
	static int addNode(List<Node> list) {
		list.add(new Node());
		
		return list.size()-1;
	}
	
	static void add(List<Node> list, int idx, int num, int shift) {
		if(shift < 0)
			return;
		
		int n = (num >> shift) & 1;
		
		if(list.get(idx).a[n] == -1) { // 노드가 없으면
			int size = addNode(list);
			list.get(idx).a[n] = size;
		}
		
		add(list, list.get(idx).a[n], num, shift-1);
	}
	
	static int search(List<Node> list, int idx, int num, int shift) {
		if(shift < 0)
			return 0;
		
		int n = (num >> shift) & 1;
		n = 1-n;
		
		if(list.get(idx).a[n] == -1)
			n = 1-n;
		
		if(list.get(idx).a[n] == -1) 
			return 0;
		
		int next = 0;
		
		if(n == 1)
			next = 1 << shift;
		
		return next | search(list, list.get(idx).a[n], num, shift-1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		
		int max = 0;
		String[] in = br.readLine().split(" ");
		
		List<Node> list = new ArrayList<>();
		addNode(list);
		
		for(String inLine : in) {
			int num = Integer.parseInt(inLine);
			add(list, 0, num, 31);
			int res = search(list, 0, num, 31) ^ num;
			
			if(max < res)
				max = res;
		}
		
		System.out.println(max);
	}

}