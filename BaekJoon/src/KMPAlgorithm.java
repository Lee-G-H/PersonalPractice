import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class KMPAlgorithm {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("문자열을 입력해주세요 : ");
		bw.flush();
		String input = br.readLine();
		
		bw.write("입력된 문자열에 대한 약어는 " + function(input) + "입니다.");
		bw.flush();
		bw.close();
	}
	
	static String function (String input) {
		String result = "";
		StringTokenizer st = new StringTokenizer(input, "-");
		
		while(st.hasMoreTokens())
			result += st.nextToken().charAt(0);
		
		return result;
	}
}
