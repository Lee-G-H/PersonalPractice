import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-25
//백준 1152번 문제
//띄어쓰기로 나누어진 한 문장이 주어지면 해당 문장에서 몇 개의 단어가 있는지 세는 프로그램
//평소 자주 쓰던 StringTokenizer를 통해 입력받은 문장을 나눈 후 countToken()메소드를 통해
//쉽게 문장 내 단어의 수를 알아낼 수 있었다
//다른 방법으로는 String에서 split()메소드를 이용해 공백문을 기준으로 문장을 나눈 후 해당 단어들의
//수를 세는 것이 있다
public class WordCount {
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
		
		int result = countInSentence(input);
		printResult(result);
	}
	
	static int countInSentence(String input) {
		StringTokenizer st = new StringTokenizer(input);
		return st.countTokens();
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
