import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-19
//���� 11022�� ����
//�Է��� Ƚ����ŭ ������ ������ ������� ����ϴ� ���α׷�
//�ڵ�� ����� �κ��� ����.
//�� ����� ���ȭ���Ѻ��� ���� �����غ��Ҵ�.
//11021�� ������ �ٸ� ���� ���â�� ���� ������ ���� ���´ٴ� ���̴�.
//���� ������ �ٸ� ������ �õ��غ��Ҵµ�, ��������� ��� ���� ���ڿ� �迭�� �����ϴ� ���̴�.
public class PrintPlusResultAdvance {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCount = Integer.parseInt(br.readLine());
		String[] resultArray = new String[testCount];
		int number1, number2;
		String input;
		StringTokenizer st;
		
		for (int i = 0; i < testCount; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			number1 = Integer.parseInt(st.nextToken());
			number2 = Integer.parseInt(st.nextToken());
			
			resultArray[i] = saveResult(i, number1, number2);
		}
		
		printResult(resultArray);
	}
	
	static String saveResult(int index, int number1, int number2) {
		return "Case #" + (index + 1) + ": " + number1 + " + " + number2 + " = " + (number1 + number2);
	}
	
	static void printResult(String[] resultArray) throws Exception {
		for (String i : resultArray)
			bw.write(i + "\n");
		
		bw.close();
	}
}