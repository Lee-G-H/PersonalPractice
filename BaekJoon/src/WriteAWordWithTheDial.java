import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-25
//백준 5622번 문제
//원으로 된 다이얼 전화기를 통해 주어진 단어를 작성하는 문제
//1번을 돌리는데는 2초, 그 다움 숫자부터는 각각 1초씩 걸리는 시간이 증가한다
//static변수로 int형 배열을 선언하며, 2번부터 9번까지 다이얼을 돌릴 때 소요되는 시간을 기록했다
//처음에는 switch case문을 사용해 문제를 해결해보려 했으나, 너무 많은 코드가 필요하다는 문제때문에
//조건문을 사용하는 것으로 방법을 선회했다
//소문자로 입력되었을 때도 일관된 결과를 도출해주고자 toUpperCase()메소드를 사용해 전부 대문자로 변경한다
public class WriteAWordWithTheDial {
	static int[] time = {3, 4, 5, 6, 7, 8, 9, 10};
	
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		input = input.toUpperCase();
		
		int result = takenTime(input);
		printResult(result);
	}
	
	static int takenTime(String input) {
		int count = 0;
		char[] ex = input.toCharArray();
		
		for (int i = 0; i < ex.length; i++) {
			if (ex[i] <= 'C')
				count += time[0];
			else if (ex[i] <= 'F')
				count += time[1];
			else if (ex[i] <= 'I')
				count += time[2];
			else if (ex[i] <= 'L')
				count += time[3];
			else if (ex[i] <= 'O')
				count += time[4];
			else if (ex[i] <= 'S')
				count += time[5];
			else if (ex[i] <= 'V')
				count += time[6];
			else
				count += time[7];
		}
		
		return count;
	}
	
	static void printResult(int result) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(String.valueOf(result));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
