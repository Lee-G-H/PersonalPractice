import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//2019-06-22
//���� 2448�� ����
//���� �ݺ����� �̿��Ͽ� ������ �ذ��Ϸ� �Ͽ����� �޸� ȿ���� ���� ���� �� ���� map�� ���� �������� ��ȸ�Ͽ���.
//
public class PrintStar11 {
	static BufferedWriter bw;
	static Map<Integer, String> star;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		star = new HashMap<>();
		
		bw.write("���� ���� �Է��ϼ��� : ");
		bw.flush();
		int input = Integer.parseInt(br.readLine());
		
		printResult(input);
	}
	
	static void printResult(int input) throws Exception {
		for (int i = 0; i < input; i++) {
			
		}
	}
}
