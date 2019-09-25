import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-25
//���� 1152�� ����
//����� �������� �� ������ �־����� �ش� ���忡�� �� ���� �ܾ �ִ��� ���� ���α׷�
//��� ���� ���� StringTokenizer�� ���� �Է¹��� ������ ���� �� countToken()�޼ҵ带 ����
//���� ���� �� �ܾ��� ���� �˾Ƴ� �� �־���
//�ٸ� ������δ� String���� split()�޼ҵ带 �̿��� ���鹮�� �������� ������ ���� �� �ش� �ܾ����
//���� ���� ���� �ִ�
public class WordCount {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = countInSentence(input);
		printResult(result);
	}
	
	static int countInSentence(String input) {
		StringTokenizer st = new StringTokenizer(input);
		return st.countTokens();
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
