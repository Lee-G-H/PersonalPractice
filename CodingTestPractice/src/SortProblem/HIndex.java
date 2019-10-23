package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

//2019-10-13
//�Էµ� ���� �迭�� ���� H-Index�� ���ϴ� ����
//H-Index�� n���� �� �� h�� �ο�� ���� h�� ���� �� h�� ���� �Ǵ� ���̴�.
//ó������ �ݺ��� ���� left�� ���� right�� ������ Ŀ�� ����� left-1�ε��� ���� HIndex�� �ϸ� �ǰڴ� ����������
//���� ���̽��� �°� �������� ���� Ʋ���� ������ �߻��ߴ�.
//������ ���� ���ذ� �������� �ʾ� ���� ������ �Ǵ��ϰ� �ٽ� ����� H-Index�� ���� ���θ� �غ��Ҵ�. �� ���
//Ư�� �������� ���� �ο�� Ƚ���� ���� ������ ���� �� ������ �ο�� ���� �������ų� ������ �ο�� ������ ����
//�ִ밪�� ���ϰ��� �ϴ� h��� ����� �� �� �־���.
//��� ������ �õ��ص� ������ ������ �ڲ� �߻��ߴ�. �ƹ����� ������ ���� ���ذ� �����ϴٴ� ������ ��� �� ����
//������ �߰�, �� ��� �ε��� ������ �ش� ��Ұ��� �� ���� �� ����� �ε����� ������ �˰� �Ǿ���.
//��ȹ��� �ڵ��� ������ �� �׽�Ʈ�غ� ��� 9�� ���̽����� ������ �߻��ߴ�. �̸� Ȯ�� �� ������ �м��غ��Ұ�
//�迭�� ���̺��� �Է°��� �ּҰ��� �� ũ�ų� ���� ��� �ش� �迭�� ���̰� ���� ���� �ʴ� ������ �־���.
//�̸� ���� ���ǹ��� �ϳ� �� �߰����ָ� ������ �ذ��ߴ�.
public class HIndex {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int index = 0;
			int[] citations = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				citations[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(solution(citations)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int solution(int[] citations) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i : citations)
			list.add(i);
		
		list.sort(Comparator.reverseOrder());
		int comp, hIndex = 1, count;
		
		if (list.get(0) == 0)
			return 0;
		
		if (list.get(list.size() - 1) >= list.size())
			return list.size();
		
		for (int i = 0; i < list.size(); i++) {
			comp = list.get(i);

			if (i >= comp) {
				hIndex = i;
				break;
			}
		}
		
		return hIndex;
	}
}