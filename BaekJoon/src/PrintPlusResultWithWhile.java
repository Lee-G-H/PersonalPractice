import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//백준 10951번 문제
//두 수를 입력받을 때마다 결과값을 출력해주는 프로그램
//입력에 0보다 크며 10보다 작다는 조건이 있는 것을 통해 무한 반복이 아닌
//해당 값을 벗어나면 반복을 종료하도록 설정했다.
//여전히 문제가 해결되지 않아 다시 살펴보니 조건에는 명시되어 있지는 않았지만
//EOF문제를 해결해야 하는 문제였다.
//현재 작성중인 BufferedReader에서 EOF가 발생했을 경우에는 null이 반환되기 때문에
//while을 탈출하는 조건에 null이 되었을 경우를 넣어준다.
//null일 때의 종료조건을 넣었음에도 계쏙 진행되어 stringtokenizer에서 오류가 발생했다.
//이를 해결하기 위해 토큰 대신 split 메소드를 사용해 입력값을 나누는 방식을 차용했다.
public class PrintPlusResultWithWhile {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		
		while ((input = br.readLine()) != null) {			
			String[] inputArray = input.split(" ");
			if (checkNumber(inputArray))
				break;
			printResult(inputArray);
		}
		bw.close();
	}
	
	static boolean checkNumber (String[] array) {
		for (String i : array)
			if (Integer.parseInt(i) < 0 || Integer.parseInt(i) > 10)
				return true;
		
		return false;
	}
	
	static void printResult(String[] array) throws Exception {
		int result = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
		bw.write(result + "\n");
		bw.flush();
	}
}