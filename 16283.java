import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static class Pet {
		int a;
		int b;
		
		Pet(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public String toString() {
			return a + " " + b;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int a = Integer.valueOf(str[0]);
		int b = Integer.valueOf(str[1]);
		int n = Integer.valueOf(str[2]);
		int w = Integer.valueOf(str[3]);
		
		List<Pet> ansList = new ArrayList<Pet>();
		
		for(int i = 1; i < n; i++) {
			int A = n - i;
			int B = i;
			
			if((A*a + B*b) == w) {
				ansList.add(new Pet(A, B));
			}
		}
		
		if(ansList.size() == 1)
			System.out.println(ansList.get(0));
		else
			System.out.println(-1);
	}
}