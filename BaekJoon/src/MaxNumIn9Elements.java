import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//���� 2562�� ����
//9���� ���ڸ� �Է¹��� �� �ش� ���� �ִ밪�� �� ���� �� ��°�� �Է¹��� �������� ����ϴ� ����
//�� ��ҵ��� �迭�� ���� �� �񱳸� ���� �Լ��� ȣ���Ѵ�.
//�ִ밪�� ã���� �ش� �ε����� 1�� ���� ���� ������ ���� �� ��ȯ���־� �ش� ���� �ִ밪�� ��½����ش�.
//������ �߰��ϰ� �Ǿ��µ�, ù ��° ��Ұ� �ִ밪�� ��� count������ 0���� �ʱ�ȭ�߱� ������
//������ 0��°�� �Ǵ� ��������. �̸� �ذ��ϱ� ���� count������ 1�� �ʱ�ȭ�ߴ�.
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
