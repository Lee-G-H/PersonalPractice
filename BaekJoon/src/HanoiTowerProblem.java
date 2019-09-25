import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-21
//���� 11729�� ����
//�ϳ��� ž ����
//�Է°����δ� ž�� ���̰�, ��°����� ù �ٿ� �� �̵� Ƚ��, ��°�ٺ��ʹ�
//���� 2���� ���� �ϳ� ���̿� �־��ִµ� ���� ����° ž�� ���� �����ִ� ���� ������ ����° ž���� �ű�ٴ� �ǹ̴�
//3�� ������ �ϳ��� ������ ���� Ǯ��� �� �̵� ���� 2^h-1���� �ȴٴ� ���� ã�Ƴ´�
//���� ¦�� �����϶��� 2���� ó������, Ȧ����°�϶��� 3�� �����̸� �Ʒ� �ܰ��� ���� Ǯ�̰����� ��ģ�ٴ� ���� �߰��ߴ�
//�ϳ���ž�� ����Լ��� �̿��Ѵٸ� �ذ��� ������ �̷���� �� ������, n-1������ ž�� 1���� 2��, ���� �Ʒ� ž�� 1���� 3����
//���� ������ �ݺ��ϸ� �ȴ�
//6-a-b�� �� ��ġ�� �־��ָ� �ϳ��� ž�� �պ��� ������ ���� �����ϵ��� ������ش�.
public class HanoiTowerProblem {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int solid;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int height = Integer.parseInt(br.readLine());
		int result = (int)Math.pow(2, height) - 1;
		sb.insert(0, result + "\n");
		solid = height;
		
		solveHanoi(height, 1, 3);
		printResult();
	}
	
	static void solveHanoi(int height, int A, int C) {		
		if (height == 0)
			return;
		solveHanoi(height - 1, A, 6 - A - C);
		sb.append(A + " " + C + "\n");
		solveHanoi(height - 1, 6 - A - C, C);
	}
	
	static void printResult() throws Exception {
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}