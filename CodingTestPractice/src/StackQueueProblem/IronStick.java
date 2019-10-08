package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//2019-10-07
//�߸� �踷����� �������� ���� ���α׷�
//�踷���� ��ĥ �� ������ �� ���� �� ���밡 ª�� ���� �ڿ� �´�
//������ Ȱ���Ѵٸ� �������� ���� ��� ���� �踷����� ���� ���� �� �� �ְ� �ȴ�.
//�������� ������ "()"�κ��� �ٸ� �踷���� ������ ���� �ʱ� ������ '|'�� �ٲ��־� �������μ��� ���а��� �ο����ֱ�� �ߴ�.
//�� ���� ������ �ɾ�����, ������ '|'�� ���� ��� ���±��� ���ÿ� ���� �踷��⸦ ��ȯ�ϸ� ���� ����ġ ������ ���� �� �� ��������
//������ �ʰ� ����ġ�� �ʵ��� ������־���. �������� ')'�� ���� ��� ���ݱ��� ���� ���ÿ��� �� ���� ������ ���ָ� ����ġ ������ 1��
//�߰����ش�. �� ��찡 �ƴ� ��� '('��� ���� �ǹ��ϱ� ������ ���ÿ� push�����ش�.
//�׽�Ʈ ��� �ǵ��ߴ� ������ ���̿��� 17���� 1���� 16�� ������ �Ǿ��µ� �̸� ��� ���캸�� �������� ���� ���������� �ڸ� ��
//���� �踷������ �������ȱ� ������ �߻��� ���������� �� �� �־���. �̸� �ذ��ϱ� ���� weight���� ��ȯ���� count�� �߰����־���.
public class IronStick {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String arrangement = br.readLine();
			
			bw.write(String.valueOf(solution(arrangement)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//|(((||)(|)|))(|) => 17
	//(�� ��� ������ ���� ����ġ�� ������Ű�� )�� ������ ����ġ�� �ϳ� ���� ī��Ʈ�� ����ġ ����
	static int solution(String arrangement) {
		Stack<Character> iron = new Stack<>();
		int count = 0;
		int weight = 0; //pop�� ���� �������� �踷��� ������ ���� ����
		arrangement = arrangement.replace("()", "|");
		
		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '|') {
				count += iron.size() + weight;
				weight = 0;
			} else if (arrangement.charAt(i) == ')') {
				iron.pop();
				weight++;
			} else {
				iron.push(arrangement.charAt(i));
			}			
		}
		
		//������ �������� ���� �߸� �踷��⸦ ���� ��ȯ�Ѵ�.
		return count + weight;
	}
}
