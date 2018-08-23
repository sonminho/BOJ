import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ 11723
 * С§Че
 */
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 20;
        int M = Integer.valueOf(br.readLine());
        int S = 0;
        
        int num = 0;
        String cmd;
        
        StringTokenizer stk;
        StringBuilder ans = new StringBuilder();
        
        while(M-- > 0) {
        	String[] in = br.readLine().split(" ");
           
        	cmd = in[0];
	        
        	if(!cmd.equals("all") && !cmd.equals("empty"))
        		num = Integer.valueOf(in[1]) - 1;
	        
	        if(cmd.equals("add")) {
	        	S = (S | (1 << num));
	        } else if(cmd.equals("remove")) {
	        	S = (S & ~(1 << num));
	        } else if(cmd.equals("check")) {
	        	if((S & (1 << num)) == 0) {
	        		ans.append("0\n");
	        	} else {
	        		ans.append("1\n");
	        	}
	        } else if(cmd.equals("toggle")) {
	        	S = (S ^ (1 << num));
	        } else if(cmd.equals("all")) {
	        	S = (1 << N) - 1;
	        } else if(cmd.equals("empty")) {
	        	S = 0;
	        }
        }
        
        System.out.println(ans);
    }
}