import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-19
//���� 10818�� ����
//�迭 ������ �ִ밪�� �ּҰ��� ã�� ����
//�ڵ带 �ۼ��ϴ� �������� �迭�� ����� �ʿ䰡 ���ٴ� ����� ã�Ƴ´�.
//�׷��� ���ϴ� ������ �迭�� ����ϴ� ���̿��� ������ �迭�� �̿��� ���ϴ� ����� �����ϱ�� �ߴ�.
//�ִ밪�� �ּҰ��� �迭 ù ��° ��ҷ� ������ �� �迭�� ���� �ش� ������ �۰ų� ū ���� ������ ���
//���� ������ ��ü�ϴ� ������� �ִ�&�ּҰ��� ã�� �ȴ�.
public class MaxNumAndMinNumInArray {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int maxNum, minNum;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int numberAmount = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		if (st.countTokens() > numberAmount)
			System.exit(1);

		int index = 0;
		int[] resultArray = new int[numberAmount];
		
		while (st.hasMoreTokens())
			resultArray[index++] = Integer.parseInt(st.nextToken());
		
		checkNumber(resultArray);
		printResult();
	}
	
	static void checkNumber (int[] array) {
		maxNum = array[0];
		minNum = array[0];
		
		for (int i : array) {
			if (i > maxNum)
				maxNum = i;
			if (i < minNum)
				minNum = i;
		}
	}
	
	static void printResult() throws Exception {
		bw.write(minNum + " " + maxNum);
		bw.close();
	}
}