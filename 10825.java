import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Student {
		String name;
		int k;
		int e;
		int m;
		
		Student(String name, int k, int e, int m) {
			this.name = name;
			this.k = k;
			this.e = e;
			this.m = m;
		}
		
		public static Comparator<Student> comparator = new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.k > s2.k) {
					return -1;
				} else if(s1.k == s2.k) {
					if(s1.e < s2.e) {
						return -1;
					} else if(s1.e == s2.e) {
						if(s1.m > s2.m) {
							return -1;
						} else if(s1.m == s2.m) {
							return s1.name.compareTo(s2.name);
						}
					}			
				}
				return 1;
			}
		};
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.valueOf(br.readLine());
			String name;
			int k,e,m;
			
			ArrayList<Student> students = new ArrayList<Student>();
			Student student;
			StringTokenizer stk;
			
			for(int i = 0; i < n; i++) {
				stk = new StringTokenizer(br.readLine(), " ");
				name = stk.nextToken();
				k = Integer.valueOf(stk.nextToken());
				e = Integer.valueOf(stk.nextToken());
				m = Integer.valueOf(stk.nextToken());
				
				student = new Student(name, k, e, m);
				students.add(student);
			}
			
			Collections.sort(students, Student.comparator);
			
			StringBuilder sb = new StringBuilder();
			
			for(Student s : students) {
				sb.append(s.name + "\n");
			}
			System.out.println(sb);
			
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}