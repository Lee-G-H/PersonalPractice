import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-17
//백준 2588번 문제
//여러 자리 수의 곱셈을 각 자리수마다 곱한 값을 출력하며
//최종적으로 곱한 결과값을 출력해주는 프로그램
//처음에는 result변수를 두어 각 자리수의 곱셈 결과를 10의 지수만큼 곱하며
//더한 총 값을 최종적으로 출력해주려 하였으나 다시 코드를 리뷰하며 생각해보니
//최종적인 결과값은 그냥 두 숫자를 곱하기만 하면 간단히 나온다는 사실을 깨닫고
//더욱 간단해지도록 수정을 완료했다.
//BufferedWriter의 write메소드에서 그냥 정수형을 출력하려 하면 해당 수의 아스키코드에 해당하는 값이 나오는
//오류를 발견해 String.valueOF()메소드를 통해 정수를 있는 그대로 출력하도록 했다.
public class MulfityNumber {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main (String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		bw.write("첫 번째 숫자를 입력하세요 : ");
		bw.flush();
		int number1 = Integer.parseInt(br.readLine());
		bw.write("두 번째 숫자를 입력하세요 : ");
		bw.flush();
		String number2 = br.readLine();
		for (int i = number2.length() - 1; i >= 0; i--) {
			bw.write(number1 * (number2.charAt(i) - '0') + "\n");
			bw.flush();
		}
		
		bw.write(String.valueOf(number1 * Integer.parseInt(number2)));
		bw.flush();
		bw.close();
	}
}
