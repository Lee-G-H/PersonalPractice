package HeapProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//2019-10-09
//�Է��� ���ں� ������ ������ �ִ� ���ĵ��� ���� ���� �Է��� ��ǥ�� ���ں� �������� �����ϵ���
//����� �� �ҿ�Ǵ� ���� Ƚ���� ��ȯ�ϴ� ���α׷�.
//���� ���� �Ǹ� ���� ���� ���+(���� ���*2)�� ���� �� ���ں��� �ȴ�.
//�Էµ� ���� �� �ſ� ���ĺ��� ������������ ������ �� �ֵ��� Arrays.sort()�޼ҵ带 ����ߴ�.
//�� �� ���Լ����� ������ ť�� Ȱ���� ���� ������ �����ߴ�.
//������ �غ��� ������ ���� �� �ܰ�� �켱���� ť�� Ȱ���Ѵٸ� �� �����ϰ� �����ϴٴ� ����� ���޾����� ���� ��� ����
//��� ��ҵ� �ٽ� ť�� �־���� �� ��� ũ�⸦ ������� �߱� ������ �켱���� ť�� Ȱ���ϴ� ������ ��ȹ�� ��ȸ�ߴ�.
//���� Spicy��� Ŭ������ �������� �� �켱���� ť�� ���� �޼ҵ带 ����������µ� �ڵ带 �������� ���
//ClassCastException������ �߻��ߴ�. ���� ���� ������ �˾ƺ� ��� ��� ��ü�� ���°� �ٸ� ���·� ĳ���� ��
//���� ���� ���·� ĳ������ �ϰ��� �� �� �߻��ϴ� ���������� �� �� �־���.
//���� Ŭ������ ����� ������� �ٸ� ��� ���̽����̳� �ð��� ȿ������ �հ�ó���� �޾�����, �� ���� �׽�Ʈ������ ���հ���
//���Դ�. ������ �˰��� ������ �ٽ� �� �� ã�ƺ��� ���ϴ� ���ں� ������ �������� ������ �� -1�� ��ȯ�ϵ��� �ؾ��ߴµ�
//�׷��� ���� �ʾ� ���� ������� ����� �˰� �Ǿ���.
//�� ���ǵ� �ذ��ϰ��� while�ݺ� Ż���� ������ ť�� ����� 1�϶��� ���� �� ������ ���� ť�� ���� �ݺ����� ���������� ���
//K���� �۴ٸ� ���ϴ� ���ں����� �������� ���� ���̱� ������ -1�� ��ȯ���ֵ��� �ߴ�.
public class MoreSpicy {
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
			int[] scoville = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				scoville[index++] = Integer.parseInt(st.nextToken());
			
			int K = Integer.parseInt(br.readLine());
			
			bw.write(String.valueOf(solution(scoville, K)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int solution(int[] scoville, int K) {
		PriorityQueue<Spicy> scovQ = new PriorityQueue<>();
		int count = 0;
		
		for (int i : scoville)
			scovQ.offer(new Spicy(i));
		
		while (scovQ.size() != 1) {
			Spicy comp1 = scovQ.poll();
			if (comp1.valueOf() >= K)
				break;
			
			Spicy comp2 = scovQ.poll();
			//����� ��ģ �� �켱���� ť�� �ٽ� �־��ش�.
			scovQ.offer(new Spicy(comp1.summaryScoville(comp2)));
			count++;
		}
		
		if (scovQ.peek().valueOf() < K)
			return -1;
		
		return count;
	}
}

class Spicy implements Comparable<Spicy> {
	int scoville;
	
	public Spicy(int scoville) {
		this.scoville = scoville;
	}
	
	public int valueOf() {
		return scoville;
	}
	
	//compareTo�޼ҵ带 ���� ť�� ������ ��ҵ��� ������ ���߰� �ȴ�.
	@Override
	public int compareTo(Spicy comp) {
		if (this.scoville > comp.scoville)
			return 1;
		else if (this.scoville < comp.scoville)
			return -1;
		return 0;
	}
	
	public int summaryScoville(Spicy comp2) {
		if (comp2 == null)
			return -1;
		return this.scoville + (comp2.scoville * 2);
	}
}