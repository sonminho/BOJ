import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Person{
		private int no;
		private int age;
		private String name;
		
		Person(int age, String name, int no) {
			this.age = age;
			this.name = name;
			this.no = no;
		}
		
		private static Comparator<Person> comparator = new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				if(p1.age < p2.age) {
					return -1;
				} else if(p1.age == p2.age) {
					if(p1.no < p2.no)
						return -1;
					else if(p1.no == p2.no)
						return 0;
					else
						return 1;
				} else {
					return 1;
				}
			}	
		};
	}
	
    public static void main(String args[]) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.valueOf(br.readLine());
    	ArrayList<Person> people = new ArrayList<>();
    	
    	StringTokenizer stk = null;
    	int age;
    	String name;
    	
    	for(int i = 0; i < n; i++) {
    		stk = new StringTokenizer(br.readLine(), " ");
    		
    		age = Integer.valueOf(stk.nextToken());
    		name = stk.nextToken();
    		
    		Person p = new Person(age, name, i);
    		people.add(p);
    	}
    	
    	Collections.sort(people, Person.comparator);
    	StringBuilder sb = new StringBuilder();
    	
    	for(Person p : people) {
    		sb.append(p.age + " " + p.name + "\n");
    	}
    	 
    	System.out.println(sb);
    }
}
