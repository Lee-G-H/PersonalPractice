import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-17
//백준 11021번 문제
//입력한 횟수만큼 덧셈을 수행후 결과값을 출력하는 프로그램
//코드상 어려운 부분은 없다.
//각 기능을 모듈화시켜보기 위해 분할해보았다.
public class PrintPlusResult {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCount = Integer.parseInt(br.readLine());
		int[] resultArray = new int[testCount];
		int number1, number2;
		String input;
		StringTokenizer st;
		
		for (int i = 0; i < testCount; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			number1 = Integer.parseInt(st.nextToken());
			number2 = Integer.parseInt(st.nextToken());
			
			resultArray[i] = number1 + number2;
		}
		
		printResult(testCount, resultArray);
	}
	
	static void printResult(int testCount, int[] resultArray) throws Exception {
		for (int i = 1; i <= testCount; i++)
			bw.write("Case #" + i + ": " + resultArray[i - 1] + "\n");
		
		bw.close();
	}
}
