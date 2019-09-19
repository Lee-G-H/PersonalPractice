import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-19
//���� 10951�� ����
//�� ���� �Է¹��� ������ ������� ������ִ� ���α׷�
//�Է¿� 0���� ũ�� 10���� �۴ٴ� ������ �ִ� ���� ���� ���� �ݺ��� �ƴ�
//�ش� ���� ����� �ݺ��� �����ϵ��� �����ߴ�.
//������ ������ �ذ���� �ʾ� �ٽ� ���캸�� ���ǿ��� ��õǾ� ������ �ʾ�����
//EOF������ �ذ��ؾ� �ϴ� ��������.
//���� �ۼ����� BufferedReader���� EOF�� �߻����� ��쿡�� null�� ��ȯ�Ǳ� ������
//while�� Ż���ϴ� ���ǿ� null�� �Ǿ��� ��츦 �־��ش�.
//null�� ���� ���������� �־������� ��� ����Ǿ� stringtokenizer���� ������ �߻��ߴ�.
//�̸� �ذ��ϱ� ���� ��ū ��� split �޼ҵ带 ����� �Է°��� ������ ����� �����ߴ�.
public class PrintPlusResultWithWhile {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		
		while ((input = br.readLine()) != null) {			
			String[] inputArray = input.split(" ");
			if (checkNumber(inputArray))
				break;
			printResult(inputArray);
		}
		bw.close();
	}
	
	static boolean checkNumber (String[] array) {
		for (String i : array)
			if (Integer.parseInt(i) < 0 || Integer.parseInt(i) > 10)
				return true;
		
		return false;
	}
	
	static void printResult(String[] array) throws Exception {
		int result = Integer.parseInt(array[0]) + Integer.parseInt(array[1]);
		bw.write(result + "\n");
		bw.flush();
	}
}