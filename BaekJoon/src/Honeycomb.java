import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-27
//���� 2292�� ����
//���� ����� ������ �׸����� �Է��� ��ȣ�� ĭ���� �� �� �ִ� �ּ� ����� ����� ���ϴ� ���α׷�
//������ ����� ��� 7-19-37-...�� ���� �� �׵θ��� �߰��� ������ 6�� ����� �����ϴ� ���������� �� �� �־���
//ó������ �̸� �� ���� ��ȯ���� �� �������� ������ �����غ�������, ȹ������ �������̰� �߻������� ���� ���̶� �Ǵ� ��
//�ݺ����� Ȱ���� ������ �ذ��ϴ� ������ ������ ��ȸ�ߴ�
//�ݺ��� ����� ���� ����ġ�� �ִ� ������ ���� �� �ش� ���� ������ �ִ� ������� �ɸ��� ����� ���� ã�Ҵ�
public class Honeycomb {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long input = 0;
		
		try {
			input = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long result = solveProblem(input);
		printResult(result);
	}
	
	static long solveProblem(long input) {
		if (input == 1)
			return 1;
		
		int count = 1;
		int weight = 6;
		
		for (int i = 1; i < input; i++) {
			if (i == weight + 1) {
				count++;
				weight += 6 * count;
			}
	}
		
		return ++count;
	}
	
	static void printResult(long result) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(String.valueOf(result));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
