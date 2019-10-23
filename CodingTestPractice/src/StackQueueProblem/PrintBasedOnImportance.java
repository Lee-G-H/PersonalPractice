package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-10-04
//�߿䵵�� ���� ���� ����ϴ� �Ͱ� ���߿� ����ϴ� �Ϳ� ���̸� �ִ� ���α׷�
//�⺻������ ���� ������ ���ñ����� ��� ������, �ش� ��Һ��� �� �߿䵵�� ����
//��Ұ� �����Ѵٸ� ���� �ڷ� ������ ť�� ���¸� ���� �Ѵ�.
//�߿䵵�� ǥ���� ������ �迭�� ��û�� �ε��� ��ȣ�� ���� �Է��ϸ� �ش� ��Ҵ� �� ��°�� ��µ����� ��ȯ�ؾ� �Ѵ�.
//�̸� ���� ť�� �Է¹��� �迭���� ���� �־��־����� �ݺ����� ���� ���Ǵ�� ��°��� ����ϴ� ������ ���ƴ�.
//�� �� count�� ���� ��� �þ�� �Ǵ� ������ �߰��ߴµ�, �̸� �ذ��ϱ� ���� ť�� ũ�⸦ �����ϴ� ������ ���� ��
//�ش� ���� ���� ť�� ũ�⸦ �� �� ũ�Ⱑ �۾����ٸ� ����� ���������� �̷�����ٴ� ���̹Ƿ� count�� ������Ű���� �ߴ�.
//�������δ� location�� ���� �ٿ��ִ� �κ��� ť�� ���� ���� ���ϴ� �ݺ������� �տ� �־� ���������� ���ϴ� ��Ҹ�
//����Ű�� ���ϴ� ������ �߰��ߴµ�, �̸� �ذ��ϱ� ���� �ݺ����� ���� �� location�� ���� �ٿ��ִ� ����� ����
//�ش� ���� ���������� ���ϴ� ��ҿ� ����ȭ��ų �� �ְ� �Ǿ���.
//�� �ٸ� ������ �߰��ϰ� �Ǿ��µ� �ݺ��� ������ ���ϴ� ���� ���� ���� ���� ���� �ʾ� offer()�޼ҵ带 ���� �ٽ� 
//ť�� ���� �� �� location�� ���� size()-1�� �Ͽ� ���ϴ� ��Һ��� �� ĭ �� ��Ҹ� ����Ű�� ������ �߰�������
//1�� �߰��� ���� ������ �����Ͽ� ������ �ؼ��� �� �־���.
//���������� [1,1,9,1,1,1]�迭�� 1�� ��Ұ� ��µǴ� ������ �������� �� �� ù ��°�� �����ٴ� ����� ��µǴ�
//������ �߻��ߴµ�, Ȯ�� ��� while���� ���������� ������ location���� ���̴� ���ǹ����� �ڿ� �־�
//location�� 0�� ���ڸ��� �������� �� �����̿���. �� �� ���ǽ��� ��ȯ���� ���ϴ� ���� ���������� ������ �Ǿ���.
public class PrintBasedOnImportance {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int[] priorities = new int[st.countTokens()];
			int index = 0;
			
			while (st.hasMoreTokens())
				priorities[index++] = Integer.parseInt(st.nextToken());
			
			int location = Integer.parseInt(br.readLine());
			if (location > priorities.length - 1)
				System.exit(1);
			
			bw.write(solution(priorities, location) + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int solution(int[] priorities, int location) {
		Queue<Integer> waitQ = new LinkedList<>();
		int count = 1;
		
		for (int i : priorities)
			waitQ.offer(i);
		
		int size = waitQ.size();
		
		while (!waitQ.isEmpty()) {
			int index = waitQ.poll();
			
			for (Integer i : waitQ) {
				if (i > index) {
					waitQ.offer(index);
					if (location == 0)
						location = waitQ.size();
					break;
				}
			}
			
			if (location == 0)
				break;
			
			if (location != 0)
				location--;
		
			if (size > waitQ.size()) {
				count++;
				size = waitQ.size();
			}
		}
		
		return count;
	}
}
