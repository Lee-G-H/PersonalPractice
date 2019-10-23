import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-06-09
//�� �׸��� ���α׷�
//�߰� �߰��� ��ĭ�� �־���� �߱� ������ � ������ ��ĭ�� �ο��ؾ� �� �� ����Ͽ���.
//������ �м��غ��Ҵ��� 1, 3, 4, 5, 7,...���� ��ǥ���� ��ĭ�� Ȯ���� �� �־���.
//�̸� ���� ��ĭ�� ���� ������ �ش� ��ǥ�� 3���� ���� ���� 1�̰ų� 3���� ���� �������� 1�� ����� ����
//Ȯ���� �� �־���, �̸� �����Ͽ� ������ �ذ��ϰ� �Ǿ���.
public class PrintStar10 {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("���ڸ� �Է����ּ���(3�� n������ ���) : ");
		bw.flush();
		
		int inputNumber = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < inputNumber; i++) {
			for (int j = 0; j < inputNumber; j++) {
				print(i, j);
			}
			bw.write("\n");
		}

		bw.close();
	}
	
	static void print(int x, int y) throws Exception {
		while (x > 0) {
			if (x % 3 == 1 && y % 3 == 1) {
				bw.write(" ");
				return;
			}
			x /= 3;
			y /= 3;
		}
		bw.write("*");
	}
}
