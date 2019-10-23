import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-19
//백준 2920번 문제
//입력받은 음계를 ascending인지 descending인지 아니면 mixed인지 판단하는 프로그램
//입력값을 배열에 넣은 후 비교를 수행해 첫 인덱스가 1, 8일때로 나누어 배열 내 비교를 진행한다.
//코딩을 진행하던 중 stringtokenizer가 제대로 작동하지 않는 문제가 발견했고
//원인을 분석하던 중 while(st.hasMoreTokens())로 되어야 하는 부분이 if로 작성되어있었다는 문제를 발견했다.
//또한 descending이라 써야하는 것을 decending이라 작성해 오류가 발생했다.
public class CheckScale {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int[] inputArray = new int[st.countTokens()];
		int index = 0;
		
		while (st.hasMoreTokens()) {
			inputArray[index++] = Integer.parseInt(st.nextToken());
		}
		
		String result = checkArray(inputArray);
		printResult(result);
	}
	
	static String checkArray(int[] inputArray) {
		int next = inputArray[0];
		
		if (next == 8) {
			for (int i = 1; i < inputArray.length; i++) {
				if (next <= inputArray[i])
					return "mixed";
				next = inputArray[i];
			}
			
			return "descending";
		} else if (next == 1) {
			for (int i = 1; i < inputArray.length; i++) {
				if (next >= inputArray[i])
					return "mixed";
				next = inputArray[i];
			}
			
			return "ascending";
		}
		return "mixed";
	}
	
	static void printResult(String result) throws Exception {
		bw.write(result);
		bw.close();
	}
}
