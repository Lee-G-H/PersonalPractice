import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-25
//���� 2908�� ����
//0�� ���Ե��� ���� ���� �ٸ� ���� �ڸ� ������ �Է¹��� �� ���� �ڸ��� ���� �ڸ��� �ٲ� �� �� ���� ���ϴ� ���α׷�
//ó������ �� ���� ���������� �޾� ����Ǯ�̸� �����Ϸ� ������ ���� ������ �� ������ ������ ���� ���� �ִٴ� ������ ���
//String���� ���� ���� �� StringBuffer�� ���� reverse()�޼ҵ带 ��� �� ��������ȯ�� ��Ű�� �������
//������ �ذ��ߴ�
//StringBuffer�� ����� ���� �̹� ���� ���� ������ ���¿��� ������ ������ ������ ���� ����� ���� �����ؾ� �ߴµ�
//�� �� delete()�޼ҵ忡�� ù ��° �Ķ���ʹ� ���� �ε���, �� ��° �Ķ���ʹ� �� �Ķ����+1�� �ؾ� ����������
//��� ���� �����ȴٴ� ���� �� �� �־���
public class CompareTwoInvertedNumbers {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = "";
		String number1 = "", number2 = "";
		
		try {
			input = br.readLine();
			st = new StringTokenizer(input);
			number1 = st.nextToken();
			number2 = st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = compareNumbers(number1, number2);
		printResult(result);
	}
	
	static int compareNumbers(String number1, String number2) {
		StringBuffer sb = new StringBuffer();
		
		number1 = String.valueOf(sb.insert(0, number1).reverse());
		number2 = String.valueOf(sb.delete(0, 3).insert(0, number2).reverse());
		
		int comp1 = Integer.parseInt(number1);
		int comp2 = Integer.parseInt(number2);
		
		return comp1 > comp2 ? comp1 : comp2;
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
