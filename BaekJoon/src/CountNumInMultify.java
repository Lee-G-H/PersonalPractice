import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//백준 2577번 문제
//세 수를 곱한 후 결과값의 각 자리수를 비교해
//0부터 9까지의 수가 몇개있는지 판별하는 프로그램
//각 자리수를 세는 배열을 선언해준다
//세 수를 입력받은 후 곱한 결과를 비교하며 해당 수를 문자열로 변경해 각 문자의 char값을 int로 형변환한 후 
//해당 값에 대한 배열 인덱스의 값을 1씩 추가하는 방식을 사용했다.
public class CountNumInMultify {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] countNum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int number1 = Integer.parseInt(br.readLine());
		int number2 = Integer.parseInt(br.readLine());
		int number3 = Integer.parseInt(br.readLine());
		int multify = number1 * number2 * number3;
		
		checkNumber(multify);
		printResult();
	}
	
	static void checkNumber(int multify) {
		String comp = String.valueOf(multify);
		
		for (int i = 0; i < comp.length(); i++) {
			int index = comp.charAt(i) - '0';
			countNum[index]++;
		}
	}
	
	static void printResult() throws Exception {
		for (int i : countNum)
			bw.write(i + "\n");
		bw.close();
	}
}