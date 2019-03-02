import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
    public static void main(String args[]) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int[] a = new int[3];
    	int[] b = new int[2];
    	
    	for(int i = 0; i < 3; i++)
    		a[i] = Integer.parseInt(br.readLine());
    	for(int i = 0; i < 2; i++)
    		b[i] = Integer.parseInt(br.readLine());
   
    	Arrays.sort(a);
    	Arrays.sort(b);
    	
    	System.out.println(a[0] + b[0] - 50);
    }
}