import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//백준 8958번 문제
//OX퀴즈의 결과 점수를 계산하는 프로그램
//정답을 연속해서 맞출경우 점수가 1점씩 가중된다
//조건문을 통해 O였을 경우 count만큼 최종 점수를 늘림과 동시에 count값을 1증가시키며 문제를 해결했다
public class CountScore {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int checkAmount = Integer.parseInt(br.readLine());
		String input;
		int[] score = new int[checkAmount];
		
		for (int i = 0; i < checkAmount; i++) {
			input = br.readLine();
			
			score[i] = checkResult(input);
		}
		
		printResult(score);
	}
	
	static int checkResult(String input) {
		int count = 1;
		int resultScore = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == 'O')
				resultScore += count++;
			else
				count = 1;
		}
		
		return resultScore;
	}
	
	static void printResult(int[] result) throws Exception {
		for (int i : result)
			bw.write(i + "\n");
		
		bw.close();
	}
}
