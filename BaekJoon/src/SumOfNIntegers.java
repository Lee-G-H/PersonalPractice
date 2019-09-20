import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//2019-09-20
//백준 15596번 문제
//N개의 정수를 입력받은 후 그들의 합을 구하는 프로그램
//정수를 입력받아야 하기 때문에 반복에서 0을 넣으면 종료하도록 설계했다
//함수를 사용할 때 요구한 것이 반환값을 long형태로 하는 것이였기 때문에
//int형 배열의 각 요소들을 Long.valueOf(index)를 통해 long형으로 형변환시켜 계산을 진행했다
//배열을 통하는 문제이나 입력값이 가변형이기 때문에 배열에 바로 저장하기에는 제한되는 사항이 많았다
//그렇기 때문에 ArrayList를 선언 후 add를 통해 넣은 다음 get을 통해 배열로 옮기는 과정을 추가했다
public class SumOfNIntegers {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input;
		ArrayList<Integer> list = new ArrayList<>();
		
		while (true) {
			input = Integer.parseInt(br.readLine());
			if (input == 0)
				break;
			
			list.add(input);
		}
		
		int[] inputArray = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			inputArray[i] = list.get(i);
		}
		
		long result = sum(inputArray);
		
		printResult(result);
	}
	
	static long sum(int[] a) {
		long result = 0;
		
		for (int i : a)
			result += Long.valueOf(i);
		
		return result;
	}
	
	static void printResult(long result) throws Exception {
		bw.write(String.valueOf(result));
		bw.flush();
	}
}