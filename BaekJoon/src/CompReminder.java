import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//백준 3052번 문제
//10개의 숫자를 입력받은 후 42로 나눠 나머지 값이 몇종류 나왔는지 출력하는 프로그램
//나머지의 경우를 리스트에 추가해 비교하면 간단하지만 배열만 이용해 해결하고자 하였기 때문에 고민을 더 길게 했다
//이중 반복문을 통해 각 반복마다 나머지 값을 비교해 count를 올릴 생각을 해보았지만
//효율이 별로 좋지 못할 것이라는 생각이 들어 단일 반복문을 세 번 사용해 비교를 하는 것으로 방법을 선회했다
public class CompReminder {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int[] inputArray = new int[10];
		
		for (int i = 0; i < 10; i++) {
			inputArray[i] = Integer.parseInt(br.readLine());
		}
		
		int result = checkArray(inputArray);
		printResult(result);
	}
	
	static int checkArray(int[] inputArray) {
		int[] array = new int[42];
		int count = 0;
		
		for (int i = 0; i < 42; i++)
			array[i] = 0;
		
		for (int i = 0; i < inputArray.length; i++) {
			int remind = inputArray[i] % 42;
			if (array[remind] == 0)
				array[remind]++;
		}
		
		for (int i : array)
			if (i != 0)
				count++;
		
		return count;
	}
	
	static void printResult(int result) throws Exception {
		bw.write(String.valueOf(result));
		bw.close();
	}
}
