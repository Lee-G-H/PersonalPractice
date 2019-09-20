import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

//2019-09-20
//���� 15596�� ����
//N���� ������ �Է¹��� �� �׵��� ���� ���ϴ� ���α׷�
//������ �Է¹޾ƾ� �ϱ� ������ �ݺ����� 0�� ������ �����ϵ��� �����ߴ�
//�Լ��� ����� �� �䱸�� ���� ��ȯ���� long���·� �ϴ� ���̿��� ������
//int�� �迭�� �� ��ҵ��� Long.valueOf(index)�� ���� long������ ����ȯ���� ����� �����ߴ�
//�迭�� ���ϴ� �����̳� �Է°��� �������̱� ������ �迭�� �ٷ� �����ϱ⿡�� ���ѵǴ� ������ ���Ҵ�
//�׷��� ������ ArrayList�� ���� �� add�� ���� ���� ���� get�� ���� �迭�� �ű�� ������ �߰��ߴ�
public class SumOfNIntegers {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int input;
		ArrayList<Integer> list = new ArrayList<>();
		
		while (true) {
			input = Integer.parseInt(br.readLine());
			if (input == 0)
				break;
			
			list.add(input);
		}
		
		int[] inputArray = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			inputArray[i] = list.get(i);
		}
		
		long result = sum(inputArray);
		
		printResult(result);
	}
	
	static long sum(int[] a) {
		long result = 0;
		
		for (int i : a)
			result += Long.valueOf(i);
		
		return result;
	}
	
	static void printResult(long result) throws Exception {
		bw.write(String.valueOf(result));
		bw.flush();
	}
}