import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CroatianAlphabet {
	static String[] croatian = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("크로아티아 알파벳을 입력해주세요(c=, c-, dz=, d-, lj, nj, s=, z=) : ");
		bw.flush();
		String input = br.readLine();
		
		bw.write("크로아티아 알파벳은 입력 문자열에서 " + String.valueOf(function(input)) + "개 들어있습니다.");
		bw.flush();
		bw.close();
	}
	
	static int function (String input) {
		for (int i = 0; i < 8; i++)
			input = input.replace(croatian[i], "o");
		
		return input.length();
	}
}
