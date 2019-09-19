import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//���� 2577�� ����
//�� ���� ���� �� ������� �� �ڸ����� ����
//0���� 9������ ���� ��ִ��� �Ǻ��ϴ� ���α׷�
//�� �ڸ����� ���� �迭�� �������ش�
//�� ���� �Է¹��� �� ���� ����� ���ϸ� �ش� ���� ���ڿ��� ������ �� ������ char���� int�� ����ȯ�� �� 
//�ش� ���� ���� �迭 �ε����� ���� 1�� �߰��ϴ� ����� ����ߴ�.
public class CountNumInMultify {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[] countNum = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int number1 = Integer.parseInt(br.readLine());
		int number2 = Integer.parseInt(br.readLine());
		int number3 = Integer.parseInt(br.readLine());
		int multify = number1 * number2 * number3;
		
		checkNumber(multify);
		printResult();
	}
	
	static void checkNumber(int multify) {
		String comp = String.valueOf(multify);
		
		for (int i = 0; i < comp.length(); i++) {
			int index = comp.charAt(i) - '0';
			countNum[index]++;
		}
	}
	
	static void printResult() throws Exception {
		for (int i : countNum)
			bw.write(i + "\n");
		bw.close();
	}
}