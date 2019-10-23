import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-19
//백준 11022번 문제
//입력한 횟수만큼 덧셈을 수행후 결과값을 출력하는 프로그램
//코드상 어려운 부분은 없다.
//각 기능을 모듈화시켜보기 위해 분할해보았다.
//11021번 문제와 다른 점은 결과창에 더한 값까지 전부 나온다는 것이다.
//이전 문제와 다른 접근을 시도해보았는데, 결과까지의 모든 값을 문자열 배열에 저장하는 것이다.
public class PrintPlusResultAdvance {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCount = Integer.parseInt(br.readLine());
		String[] resultArray = new String[testCount];
		int number1, number2;
		String input;
		StringTokenizer st;
		
		for (int i = 0; i < testCount; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			number1 = Integer.parseInt(st.nextToken());
			number2 = Integer.parseInt(st.nextToken());
			
			resultArray[i] = saveResult(i, number1, number2);
		}
		
		printResult(resultArray);
	}
	
	static String saveResult(int index, int number1, int number2) {
		return "Case #" + (index + 1) + ": " + number1 + " + " + number2 + " = " + (number1 + number2);
	}
	
	static void printResult(String[] resultArray) throws Exception {
		for (String i : resultArray)
			bw.write(i + "\n");
		
		bw.close();
	}
}