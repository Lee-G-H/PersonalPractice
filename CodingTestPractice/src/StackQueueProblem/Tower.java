package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-10-06
//�۽�ž���� ���ĸ� �۽����� �� �����ϴ� ž�� ��ġ�� ��ȯ�ϴ� ���α׷�
//ť�� �̿��� ���� ��ҿ� �񱳸� �����ϸ� �۽� ������ ž�� ã�Ƴ�����.
//�����ϴ� ���������� ���� ���� ������ �߻��ߴµ�, ť���� ��Ҹ� ã�ư��� �޼ҵ尡 ���ٴ� ���̿���.
//�̸� �ذ��ϱ� ���� �Է¹��� �迭�� ��ĭ�� ������ ���� ���ǹ����� ���ϴ� ����� ����ߴ�.
//ó������ ť�� ���� �迭�� ���ϴ� �� IndexOutOfBoundException�� �߻��� ������ �˰��� �м��� �����߰�
//�� ��� ���� �ݺ��� �κ��� ������ ����־� �� �κ��� j++�� ���� �������� �� �����̶�� ���� �ľ��ߴ�.
//���� [6, 9, 5, 7, 4]�� ��� �迭���� [0, 0, 2, 2, 4]���� �ߴµ� [0, 0, 2, 0, 0]���� ������ ������ ã�Ұ�
//Ȯ�� ��� ù ��° �ݺ������� �ݺ��� ����Ǵ� ������ beforeQ.size()�� ������ ��ȭ�ϴ� ť�� ����� ���� 3, 4�� �ε�����
//�ƿ� �ڵ� ������ ���� �ʰ� �ݺ��� ����� ���̿���. �� ������ ���� ������ �Է� �迭�� ���̷� �ٲ����μ� �ذ��ߴ�.
public class Tower {
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
			int[] heights = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				heights[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(Arrays.toString(solution(heights)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int[] solution(int[] heights) {
		int[] resultArray = new int[heights.length];
		Queue<Integer> beforeQ = new LinkedList<>(); //���� ��ȸ���� ���� �۽�ž ����
		
		for (int i = 1; i < heights.length; i++)
			beforeQ.offer(heights[i]);
		
		for (int i = 1; i < heights.length; i++) {
			int comp = beforeQ.poll();
			
			for (int j = i - 1; j >= 0; j--)
				if (comp < heights[j]) {
					resultArray[i] = j + 1;
					break;
				}
		}
		
		return resultArray;
	}
}
