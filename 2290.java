import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int[][] a = {
			{1,1,1,0,1,1,1}, // 0
			{0,0,1,0,0,1,0}, // 1
			{1,0,1,1,1,0,1}, // 2
			{1,0,1,1,0,1,1}, // 3
			{0,1,1,1,0,1,0}, // 4
			{1,1,0,1,0,1,1}, // 5
			{1,1,0,1,1,1,1}, // 6
			{1,0,1,0,0,1,0}, // 7
			{1,1,1,1,1,1,1}, // 8
			{1,1,1,1,0,1,1} // 9
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inLine = br.readLine().split(" ");
		int s = Integer.parseInt(inLine[0]);
		String nums = inLine[1];
		int numsSize = nums.length();
		
		String[] groups = {"", "", "", "", ""} ;
		
		for(int i = 0; i < numsSize; i++) {
			char ch = (char)(nums.charAt(i) - '0');
			
			for(int j = 0; j < 7; j++) {			
				if(j == 0) {
					groups[0] += " ";
					for(int k = 0; k < s; k++) {
						if(a[ch][j] == 0) {
							groups[0] += " ";	
						} else {
							groups[0] += "-";
						}
					}
					groups[0] += " ";
				}				
			}
			groups[0] += " ";
		}
		System.out.println(groups[0]);
		
		for(int i = 0; i < numsSize; i++) {
			char ch = (char)(nums.charAt(i) - '0');
			for(int j = 0; j < 7; j++) {				
				if(j == 1) {
					if(a[ch][j] == 0) {
						for(int k = 0; k < s+1; k++)
							groups[1] += " ";
					} else {
						groups[1] += "|";
						for(int k = 0; k < s; k++)
							groups[1] += " ";
					}
				} else if(j == 2) {
					if(a[ch][j] == 0) {
						groups[1] += " ";
					} else {
						groups[1] += "|";
					}
				}
			}
			groups[1] += " ";
		}
		for(int i = 0; i < s; i++)
			System.out.println(groups[1]);
		
		for(int i = 0; i < numsSize; i++) {
			char ch = (char)(nums.charAt(i) - '0');
			
			for(int j = 0; j < 7; j++) {			
				if(j == 3) {
					groups[2] += " ";
					for(int k = 0; k < s; k++) {
						if(a[ch][j] == 0) {
							groups[2] += " ";	
						} else {
							groups[2] += "-";
						}
					}
					groups[2] += " ";
				}				
			}
			groups[2] += " ";
		}
		System.out.println(groups[2]);
		
		for(int i = 0; i < numsSize; i++) {
			char ch = (char)(nums.charAt(i) - '0');
			for(int j = 0; j < 7; j++) {
				
				if(j == 4) {
					if(a[ch][j] == 0) {
						for(int k = 0; k < s+1; k++)
							groups[3] += " ";
					} else {
						groups[3] += "|";
						for(int k = 0; k < s; k++)
							groups[3] += " ";
					}
				} else if(j == 5) {
					if(a[ch][j] == 0) {
						groups[3] += " ";
					} else {
						groups[3] += "|";
					}
				}
			}
			groups[3] += " ";
		}
		
		for(int i = 0; i < s; i++)
			System.out.println(groups[3]);
		
		for(int i = 0; i < numsSize; i++) {
			char ch = (char)(nums.charAt(i) - '0');
			
			for(int j = 0; j < 7; j++) {			
				if(j == 6) {
					groups[4] += " ";
					for(int k = 0; k < s; k++) {
						if(a[ch][j] == 0) {
							groups[4] += " ";	
						} else {
							groups[4] += "-";
						}
					}
					groups[4] += " ";
				}				
			}
			groups[4] += " ";
		}
		System.out.println(groups[4]);
	}
}