
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] map;
	static int[] nums;
	static List<Integer> list1, list2;
	static int min = Integer.MAX_VALUE;
	
	static void go() {
		list1 = new ArrayList<>();
		list2 = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (nums[i] == 1) {
				list1.add(i);
			} else {
				list2.add(i);
			}
		}
		
		int sum1 = 0;
		int list1Size = list1.size();
		for(int i = 0; i < list1Size-1; i++) {
			for(int j = i+1; j < list1Size; j++) {
				sum1 += map[list1.get(i)][list1.get(j)] + map[list1.get(j)][list1.get(i)];
			}
		}
		
		
		int sum2 = 0;
		int list2Size = list2.size();
		for(int i = 0; i < list2Size-1; i++) {
			for(int j = i+1; j < list2Size; j++) {
				sum2 += map[list2.get(i)][list2.get(j)] + map[list2.get(j)][list2.get(i)];
			}
		}
		
		int tmp = Math.abs(sum1 - sum2);
		min = min > tmp ? tmp : min;
	}

	static void dfs(int cnt, int idx) {
		if (n/2 == cnt) {
			go();
			return;
		}

		if (idx > n)
			return;

		if (nums[idx] == 0) {
			nums[idx] = 1;
			dfs(cnt + 1, idx + 1);
			nums[idx] = 0;
		}

		dfs(cnt, idx + 1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		nums = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		dfs(0, 1);
		
		System.out.println(min);
	}

}
