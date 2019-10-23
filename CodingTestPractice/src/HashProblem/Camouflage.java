package HashProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

//2019-09-30
//���� �ٸ� ���� ��Ī�� ������ �����ϴ� ���α׷�
//�����̴� �Ź� �ٸ� �� ������ �Դ´�. �� ������ �־����� ���� �ٸ� �� ������ ���� ��ȯ�� �� �ֵ��� �ؾ� �Ѵ�.
//�ؽ� ���� ����ϱ�� ���������� ������ �迭���� �� ���� �κ��� ������, �� �̸����� Ű�ν� �����ϵ��� ��ȹ�� ������.
//���� �������� �Է°��� String������ �������迭�̱� ������ �������� ������ �Ұ��� �ε����ϰ� �߰������� �ԷµǴ�
//�ʵ��� ���� ǥ���ϴ� ������ �߰��ߴ�.
//������ �̿��� Ǫ�� ����� ����� �Ǵ��� �Ͽ���, headgear 2���� eyewear 1���� ��� 5�� ��ȯ�Ǵ� ����
//H, H, E, HE, HE�� �ټ������̸� HH�� ������ ����� ���� �� �� �־���.
//�̸� ����  3C1 + (2C1 * 1C1)ó�� �� ������ �ϳ��� ������ ������ ���� ���� ������ ����ϸ� ���� ������� �˰� �Ǿ���.
//�������� ������ ����� �ڵ��� ����� ���� ���̵� ���� �������� �ʾҴ�. �̴� �ؽø��� ����� ������ ���� ſ�̶� �����ϰ�
//���� ����� �����غ� ��� String, Integer���� ���� �� ����, �� ������ �ش��ϴ� �� ���� ���� Ű�� ������ ������ �� 
//keySet()�޼ҵ带 �̿��� �ݺ����� ���� �� ����+1�� ���� ���ϸ� �ƹ��͵� ���� ���� �� ���� ��츦 �����Ͽ� ������ ����
//�ش��� �����ϴµ� �����ߴ�.
public class Camouflage {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int number = 0;
		
		try {
			number = Integer.parseInt(br.readLine());
			String input;
			String[][] clothes = new String[number][2];
			
			for (int i = 0; i < number; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				for (int j = 0; j < 2; j++) {
					clothes[i][j] = st.nextToken();
				}
			}
			
			bw.write(String.valueOf(solution(clothes)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int solution(String[][] clothes) {		
		HashMap<String, Integer> map = new HashMap<>();
		int count = 1;
		
		for (int i = 0; i < clothes.length; i++) {
			if (map.get(clothes[i][1]) != null)
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			else
				map.put(clothes[i][1], 1);
		}

		for (String key : map.keySet()) {
			int value = map.get(key);
			
			count *= (value + 1); 
		}
		
		return count - 1;
	}
}
