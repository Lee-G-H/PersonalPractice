import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-20
//���� 10872�� ����
//���丮���� ����ϴ� ���α׷�
//����Լ��� �̿��Ѵٸ� �ݼ� �ذ��� ����������
//��������� ������ �ذ��ϴ� ���� ȿ���� �������� ������
//while�� �̿��� ������ �ذ��ϱ�� �ߴ�
public class Factorial {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input = Integer.parseInt(br.readLine());
		
		int result = factorial(input);
		printResult(result);
	}
	
	static int factorial (int input) {
		int fact = 1;
		
		while (input > 1)
			fact *= input--;
		
		return fact;
	}
	
	static void printResult(int result) throws Exception {
		bw.write(String.valueOf(result));
		bw.flush();
	}
}