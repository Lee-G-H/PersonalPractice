import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-17
//���� 1330�� ����
//�� ���� ���� �� ����� ����ϴ� ���α׷�
//���ǹ��� Ȱ���ϸ� �Ǵ� ������ ���α׷��̴�.
//���� �����ڿ� �� �ͼ��������� ���ؼ� �� ���� ��츦 ���� �����ڷ� ǥ���� �� �ٷ� ����ߴ�.
public class CompareNumber {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int number1 = Integer.parseInt(st.nextToken());
		int number2 = Integer.parseInt(st.nextToken());
		
		String result = number1 > number2 ? ">" : (number1 == number2 ? "=" : "<");
		
		printResult(result);
	}
	
	static void printResult(String result) throws Exception {
		bw.write(result);
		bw.close();
	}
}
