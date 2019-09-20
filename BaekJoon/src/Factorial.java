import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-20
//백준 10872번 문제
//팩토리얼을 계산하는 프로그램
//재귀함수를 이용한다면 금세 해결이 가능하지만
//재귀적으로 문제를 해결하는 것은 효율이 떨어지기 때문에
//while을 이용해 문제를 해결하기로 했다
public class Factorial {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		int result = factorial(input);
		printResult(result);
	}
	
	static int factorial (int input) {
		int fact = 1;
		
		while (input > 1)
			fact *= input--;
		
		return fact;
	}
	
	static void printResult(int result) throws Exception {
		bw.write(String.valueOf(result));
		bw.flush();
	}
}