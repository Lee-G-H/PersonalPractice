import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-28
//���� 1193�� ����
//������ ū �迭���� �Էµ� ������ �����ϴ� �м��� ��ȯ�ϴ� ���α׷�.
//�и�� �м��� ������ ������׷� �迭�� ����ȴ�.(ex> 1/1->1/2->2/1->3/1...)
//�ݺ��� �����ϱ� ���� �̸� �ش� ������ �����ϴ� ��ġ ��ó���� �� ���� �� �� ���� �����
//���� ����غ����� ���縮 �������� �ʾҴ�. �Ͽ� �� ���� ������ while�� ���� ������ �ذ�������,
//flag������ ������ ������׿� ���� ������ ���� �ľ��� �� �ֵ��� �ߴ�.
//���������� count�� input�� ���� �������� �ݺ��� ���������� �� ����� �и�, ���ڰ��� ��ȯ���ش�.
public class FindFraction {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		
		try {
			input = Integer.parseInt(br.readLine());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String result = solveProblem(input);
		printResult(result);
	}
	
	static String solveProblem(int input) {
		int upper = 1, lower = 1;
		int count = 1, flag = 0;
		
		while (count < input) {
			count++;
			if (flag == 0) {
				if (upper == 1) {
					lower++;
					flag = 1;
					continue;
				}
				upper--;
				lower++;
			} else {
				if (lower == 1) {
					upper++;
					flag = 0;
					continue;
				}
				upper++;
				lower--;
			}
		}
		
		return upper + "/" + lower;
	}
	
	static void printResult(String result) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(result);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}