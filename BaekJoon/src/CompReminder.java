import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//���� 3052�� ����
//10���� ���ڸ� �Է¹��� �� 42�� ���� ������ ���� ������ ���Դ��� ����ϴ� ���α׷�
//�������� ��츦 ����Ʈ�� �߰��� ���ϸ� ���������� �迭�� �̿��� �ذ��ϰ��� �Ͽ��� ������ ����� �� ��� �ߴ�
//���� �ݺ����� ���� �� �ݺ����� ������ ���� ���� count�� �ø� ������ �غ�������
//ȿ���� ���� ���� ���� ���̶�� ������ ��� ���� �ݺ����� �� �� ����� �񱳸� �ϴ� ������ ����� ��ȸ�ߴ�
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
