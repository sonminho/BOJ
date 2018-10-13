import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Date{
		int year;
		int month;
		int day;
		
		Date(int year, int month, int day) {
			this.year = year;
			this.month = month;
			this.day = day;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringTokenizer stk2 = new StringTokenizer(br.readLine());
		
		Date born = new Date(Integer.valueOf(stk.nextToken()), Integer.valueOf(stk.nextToken()),Integer.valueOf(stk.nextToken()));
		Date now = new Date(Integer.valueOf(stk2.nextToken()), Integer.valueOf(stk2.nextToken()), Integer.valueOf(stk2.nextToken()));
		
		int diff = now.year - born.year;
		
		if(born.year == now.year) {
			System.out.println(0);
		} else {
			if(born.month == now.month) {
				if(born.day > now.day) {
					System.out.println(diff-1);
				} else {
					System.out.println(diff);
				}
			} else if(born.month < now.month) {
				System.out.println(diff);
			} else {
				System.out.println(diff-1);
			}
		}
		
		System.out.println(diff+1);
		
		System.out.println(diff);
	}
	
}