import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//���� 8958�� ����
//OX������ ��� ������ ����ϴ� ���α׷�
//������ �����ؼ� ������ ������ 1���� ���ߵȴ�
//���ǹ��� ���� O���� ��� count��ŭ ���� ������ �ø��� ���ÿ� count���� 1������Ű�� ������ �ذ��ߴ�
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
