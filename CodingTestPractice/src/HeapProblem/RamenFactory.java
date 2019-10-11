package HeapProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//2019-10-10
//��� ������ ����ϱ� ���� �����ϴ� �� ������ ���峪 ���� �۾��� �����ϱ� ������ �� ���̳� �ܺο��� ���޹޾ƾ� �ϴ��� ���� ����
//�� ������ �� �־����� ���������� ������ ���캻 ��� �̹� ������������ ���ĵǾ� �ִ� �����̱� ������ ���� �߰�����
//���İ����� �ʿ���� �Ǵ��߰� �Ϲ� ť�� ������ �ذ��ϱ�� �����ߴ�.
//�� �迭�� �� ���� ť�� �־��� �� �ݺ��� �����ϸ� �б⺰�� ������ �ο���  ��¥�� ǥ���ϴ� ������ k-1�� �����ϸ� �� �����
//�ܺ� ���忡�� �������� ���� ��ȯ�ϵ��� ������, ���ÿ� �ִ� �� �Ѱ����� ���ø� �°� �������� ���� Ʋ�� ����� ���� �� �־���.
//�̸� ���� ���� ��� ��ü�� Ʋ�ȴٴ� ���� ������ �� �־��� ���� �ڵ�� ���� ��ü�ϱ�� �����Ծ���.
//������� �����ϴ��Ŀ� ���� ����� �ٽ��ؾ߸� �ߴµ� ���� �������� ��õ�� �켱���� ť�� Ȱ���ؾ� ������ �ذ��� �� �ְڴٴ�
//�����ۿ��� ���� �ʾҴ�. ������ ������� �����ؾ� �ùٸ��� �켱���� ť�� Ȱ���� �� �ִ��� ����� ���� �Ǿ���.
//����� �ŵ��� ��� ���� ���޹޴� ���� �ʿ��� ������ �󸶳� ���� ������ ���� �� �ִ��Ŀ� ���� ������ ���� �߿��ϴٴ� ����
//���ݰ� �Ǿ���. �̸� ���� supplies�迭�� ũ�Ⱑ ū ������ ������ �� �ֵ��� �����ϴ� ���� ���ٴ� ���� �˰� �Ǿ���.
//�������� ������ �� �� �ִ� ����� ã�� �� Comparator�� reverseOrder()�޼ҵ带 Ȱ���ϸ� �����ϰ� �������� ������
//�����ϴٴ� ����� �˰� �Ǿ��� �̸� Ȱ���� �켱���� ť�� �����ϰ� �Ǿ���.
//���� ������ ���� ���Ҵٸ� �켱���� ť�� ���� ������ �� ũ������� ���� �־��ָ� �� ��� 0�� �ȴٸ� ť���� ���� �տ� �ִ�,
//�� �ش� ������ ���� ������ ���� ���� ���� �������ָ� ���ϴ� ��� ������ ����ȭ�Ǵ� k�ϱ��� �����忡 ���������� ����
//�������� �� �ְ� �ȴ�.
//�׽�Ʈ ���̽��� �־�� ArrayIndexOutOfBoundsException�� �߻��߰� ������ ���캸�� supplyDate�� 
//�����Ϻ��� ���� ��, �� �迭�� ���� �߰��� ��Ұ� �������� �� ť�� ��Ҹ� �߰��ϵ��� �߾�� �ߴµ� �̸� count�� �߸�
//������ �������� �ʴ� �ε����� ������ �߻��� ��������.
public class RamenFactory {
	public static void main(String[] args) {
		init();
	}

	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int stock = Integer.parseInt(br.readLine());

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int index = 0;
			int[] dates = new int[st.countTokens()];

			while (st.hasMoreTokens())
				dates[index++] = Integer.parseInt(st.nextToken());

			input = br.readLine();
			st = new StringTokenizer(input);
			index = 0;
			int[] supplies = new int[st.countTokens()];

			while (st.hasMoreTokens())
				supplies[index++] = Integer.parseInt(st.nextToken());

			int k = Integer.parseInt(br.readLine());

			bw.write(String.valueOf(solution(stock, dates, supplies, k)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int solution(int stock, int[] dates, int[] supplies, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		int count = 0, supplyDate = 0;
		
		for (int i = 0; i < k; i++) {
			if (supplyDate < dates.length && i == dates[supplyDate])
				queue.offer(supplies[supplyDate++]);
			
			if (stock == 0) {
				stock += queue.poll();
				count++;
			}
			
			stock--;
		}
		
		return count;
	}
}
