import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-19
//���� 2920�� ����
//�Է¹��� ���踦 ascending���� descending���� �ƴϸ� mixed���� �Ǵ��ϴ� ���α׷�
//�Է°��� �迭�� ���� �� �񱳸� ������ ù �ε����� 1, 8�϶��� ������ �迭 �� �񱳸� �����Ѵ�.
//�ڵ��� �����ϴ� �� stringtokenizer�� ����� �۵����� �ʴ� ������ �߰��߰�
//������ �м��ϴ� �� while(st.hasMoreTokens())�� �Ǿ�� �ϴ� �κ��� if�� �ۼ��Ǿ��־��ٴ� ������ �߰��ߴ�.
//���� descending�̶� ����ϴ� ���� decending�̶� �ۼ��� ������ �߻��ߴ�.
public class CheckScale {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int[] inputArray = new int[st.countTokens()];
		int index = 0;
		
		while (st.hasMoreTokens()) {
			inputArray[index++] = Integer.parseInt(st.nextToken());
		}
		
		String result = checkArray(inputArray);
		printResult(result);
	}
	
	static String checkArray(int[] inputArray) {
		int next = inputArray[0];
		
		if (next == 8) {
			for (int i = 1; i < inputArray.length; i++) {
				if (next <= inputArray[i])
					return "mixed";
				next = inputArray[i];
			}
			
			return "descending";
		} else if (next == 1) {
			for (int i = 1; i < inputArray.length; i++) {
				if (next >= inputArray[i])
					return "mixed";
				next = inputArray[i];
			}
			
			return "ascending";
		}
		return "mixed";
	}
	
	static void printResult(String result) throws Exception {
		bw.write(result);
		bw.close();
	}
}
