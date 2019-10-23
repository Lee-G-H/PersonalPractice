import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-17
//백준 1330번 문제
//두 수를 비교한 후 결과를 출력하는 프로그램
//조건문을 활용하면 되는 간단한 프로그램이다.
//삼항 연산자에 더 익숙해져보기 위해서 세 가지 경우를 삼항 연산자로 표현해 한 줄로 축약했다.
public class CompareNumber {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int number1 = Integer.parseInt(st.nextToken());
		int number2 = Integer.parseInt(st.nextToken());
		
		String result = number1 > number2 ? ">" : (number1 == number2 ? "=" : "<");
		
		printResult(result);
	}
	
	static void printResult(String result) throws Exception {
		bw.write(result);
		bw.close();
	}
}
