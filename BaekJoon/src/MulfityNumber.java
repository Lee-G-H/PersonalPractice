import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-17
//���� 2588�� ����
//���� �ڸ� ���� ������ �� �ڸ������� ���� ���� ����ϸ�
//���������� ���� ������� ������ִ� ���α׷�
//ó������ result������ �ξ� �� �ڸ����� ���� ����� 10�� ������ŭ ���ϸ�
//���� �� ���� ���������� ������ַ� �Ͽ����� �ٽ� �ڵ带 �����ϸ� �����غ���
//�������� ������� �׳� �� ���ڸ� ���ϱ⸸ �ϸ� ������ ���´ٴ� ����� ���ݰ�
//���� ������������ ������ �Ϸ��ߴ�.
//BufferedWriter�� write�޼ҵ忡�� �׳� �������� ����Ϸ� �ϸ� �ش� ���� �ƽ�Ű�ڵ忡 �ش��ϴ� ���� ������
//������ �߰��� String.valueOF()�޼ҵ带 ���� ������ �ִ� �״�� ����ϵ��� �ߴ�.
public class MulfityNumber {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main (String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		bw.write("ù ��° ���ڸ� �Է��ϼ��� : ");
		bw.flush();
		int number1 = Integer.parseInt(br.readLine());
		bw.write("�� ��° ���ڸ� �Է��ϼ��� : ");
		bw.flush();
		String number2 = br.readLine();
		for (int i = number2.length() - 1; i >= 0; i--) {
			bw.write(number1 * (number2.charAt(i) - '0') + "\n");
			bw.flush();
		}
		
		bw.write(String.valueOf(number1 * Integer.parseInt(number2)));
		bw.flush();
		bw.close();
	}
}
