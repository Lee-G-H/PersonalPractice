package DFSAndBFSProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-10-14
//�־��� ���� �迭�� ���� ��  ��� �迭 ��Ҹ� ��� ��� ���ϰų� ���� ��ǥ�ϴ� ���ڸ� ���� �� �ִ� ����� ���� ���ϴ� ������.
//BFS�� DFS�� ���� ������ ��� ���� ������ ���� �� ������ Ǯ �� BFS�� ȿ������ ���̶�� �Ǵ��� �ߴ�.
//���� �Ǵ� ���� �켱 Ž���� ������ ������ ���� �ʾҾ��� ������ ��Ȯ�ϰ� � ������� �ڵ带 �ۼ����� ����ϴ� �� ���� �ð���
//�ҿ�Ǿ���.
//���� ��� �����غ� �� �� ���ں��� +�϶��� -�϶��� �������� ����� ���� ������ �ϱ� ������ �̸� ���� �Ǵ��ϱ� ���ؼ���
//���� ����Ʈ�� ����ϴ� ���� ���ٴ� ������ �ߴ�. �ƹ��� �����غ��� ������ Ʈ�� ���¸� ��� ���� �´ٴ� ��и� ��������
//�ڽ� ��带 ���� ������ �������� ������ ��������� ������ �� �ֵ��� �������.
//����������� ������ �ذ��ϱ�� ������ �� ���� �۾��� �����ϴ� ���� ���� ����Ʈ�� ���� ����� �ʿ䰡 ������ �� �� �ְ� �Ǿ���.
//����������� ������ �ذ��� �� count�� �ø��� ��Ŀ� ���� ���� ����ȭ �� ���� ��� �����غ����� ������ �Ƿ����δ� 
//���� static�� ������ �Լ� �ܺο��� �ҷ������� �ϴ� ���� �ּ��̾���.
//��������� count������ ���� ������־� ������ �ذ��� �� �־���.
public class TargetNumber {
	static int count = 0;
	
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = 0;
			int[] numbers = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				numbers[index++] = Integer.parseInt(st.nextToken());
			
			int target = Integer.parseInt(br.readLine());
			
			solution(numbers, target);
			
			bw.write(String.valueOf(count));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void solution(int[] numbers, int target) {		
		DFS(numbers, target, 0);
	}
	
	static void DFS(int[] numbers, int target, int depth) {
		if (depth == numbers.length) {
			int summary = 0;
			
			for (int i : numbers)
				summary += i;
			
			if (summary == target)
				count++;
			
			return;
		}
		
		numbers[depth] *= 1;
		DFS(numbers, target, depth + 1);
		
		numbers[depth] *= -1;
		DFS(numbers, target, depth + 1);
	}
}
