import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CroatianAlphabet {
	static String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("ũ�ξ�Ƽ�� ���ĺ��� �Է����ּ���(c=, c-, dz=, d-, lj, nj, s=, z=) : ");
		bw.flush();
		String input = br.readLine();
		
		bw.write("ũ�ξ�Ƽ�� ���ĺ��� �Է� ���ڿ����� " + String.valueOf(function(input)) + "�� ����ֽ��ϴ�.");
		bw.flush();
		bw.close();
	}
	
	static int function (String input) {
		for (int i = 0; i < 8; i++)
			input = input.replace(croatian[i], "o");
		
		return input.length();
	}
}
