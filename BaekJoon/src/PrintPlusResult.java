import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-17
//���� 11021�� ����
//�Է��� Ƚ����ŭ ������ ������ ������� ����ϴ� ���α׷�
//�ڵ�� ����� �κ��� ����.
//�� ����� ���ȭ���Ѻ��� ���� �����غ��Ҵ�.
public class PrintPlusResult {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCount = Integer.parseInt(br.readLine());
		int[] resultArray = new int[testCount];
		int number1, number2;
		String input;
		StringTokenizer st;
		
		for (int i = 0; i < testCount; i++) {
			input = br.readLine();
			st = new StringTokenizer(input);
			number1 = Integer.parseInt(st.nextToken());
			number2 = Integer.parseInt(st.nextToken());
			
			resultArray[i] = number1 + number2;
		}
		
		printResult(testCount, resultArray);
	}
	
	static void printResult(int testCount, int[] resultArray) throws Exception {
		for (int i = 1; i <= testCount; i++)
			bw.write("Case #" + i + ": " + resultArray[i - 1] + "\n");
		
		bw.close();
	}
}
