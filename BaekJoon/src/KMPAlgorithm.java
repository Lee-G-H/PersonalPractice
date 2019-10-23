import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class KMPAlgorithm {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("���ڿ��� �Է����ּ��� : ");
		bw.flush();
		String input = br.readLine();
		
		bw.write("�Էµ� ���ڿ��� ���� ���� " + function(input) + "�Դϴ�.");
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
