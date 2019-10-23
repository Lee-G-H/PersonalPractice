import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//백준 2562번 문제
//9개의 숫자를 입력받은 후 해당 값중 최대값과 그 값이 몇 번째로 입력받은 값인지를 출력하는 문제
//각 요소들을 배열에 넣은 후 비교를 위한 함수를 호출한다.
//최대값을 찾으면 해당 인덱스에 1을 더한 값을 변수에 넣은 후 반환해주어 해당 값과 최대값을 출력시켜준다.
//오류를 발견하게 되었는데, 첫 번째 요소가 최대값일 경우 count변수를 0으로 초기화했기 때문에
//순서가 0번째가 되는 오류였다. 이를 해결하기 위해 count변수를 1로 초기화했다.
public class MaxNumIn9Elements {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int maxNum;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int input;
		int[] inputArray = new int[9];
		
		for (int i = 0; i < 9; i++) {
			input = Integer.parseInt(br.readLine());
			if (input > 100) 
				System.exit(1);
			
			inputArray[i] = input;
		}
		
		int count = checkNumber(inputArray);
		printResult(count);
	}
	
	static int checkNumber (int[] array) {
		maxNum = array[0];
		int count = 1;
		
		for (int i = 0; i < array.length; i++) {
			if (maxNum < array[i]) {
				maxNum = array[i];
				count = i + 1;
			}
		}
		
		return count;
	}
	
	static void printResult(int count) throws Exception {
		bw.write(maxNum + "\n" + count);
		bw.close();
	}
}
