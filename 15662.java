import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	static int[][] a;
	static int[] distArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // ����� ����
		int ans = 0;
		a = new int[n][8];

		// ������ �Է�
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}

		int rotateCnt = Integer.parseInt(br.readLine()); // ȸ��Ƚ��
		while (rotateCnt-- > 0) {
			distArr = new int[n];

			String[] in = br.readLine().split(" ");
			int idx = Integer.parseInt(in[0]) - 1; // ȸ���� ����� �ε���
			int dist = Integer.parseInt(in[1]); // ȸ���� ����� ���� 1 ������, -1 ���� ȸ�� ���� ����
			distArr[idx] = dist;

			for (int i = idx - 1; i >= 0; i--) { // ���� ��ϵ��� ���� ����
				if (a[i][2] != a[i + 1][6]) { // �� ����� ���� �ٸ���
					distArr[i] = -distArr[i + 1];
				} else {
					break;
				}
			}

			for (int i = idx + 1; i < n; i++) {
				if (a[i - 1][2] != a[i][6]) {
					distArr[i] = -distArr[i - 1];
				} else {
					break;
				}
			}

			for (int i = 0; i < n; i++) { // �� ����� ȸ��
				if (distArr[i] == 0)
					continue;
				else if (distArr[i] == 1) { // �ð� ���� ȸ��
					int temp = a[i][7];
					for (int j = 7; j > 0; j--) {
						a[i][j] = a[i][j - 1];
					}
					a[i][0] = temp;
				} else { // �ݽð� ���� ȸ��
					int temp = a[i][0];
					for (int j = 0; j < 7; j++) {
						a[i][j] = a[i][j + 1];
					}
					a[i][7] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (a[i][0] == 1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}