package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-10-07
//��� ������ �����ϴ� ���α׷�
//�켱�� ������ �Է��� �迭�� �� ��� ���� �ӵ��� �Է��� �迭�� ���� �־��־��� �� �� �켱���� ���� ���� �����
//������� ��� ��� ����� �Բ� ������Ǵ����� ���� �迭�� ��ȯ�ϵ��� �ϸ� 100%�̻��̴��� �� ������ ������ ��
//����� �����ϵ��� �Ѵ�.
//�̸� ���� ť�� ���������� �Բ� ������ ����� ���� ����, ��ĥ�� �ɸ��� ����� ������ ���� �������־���.
//���� �ذ��� ���� ������ ����� ť�� �����ϴ� ��Ұ� ���� ������ �ݺ��ϸ� ������ ��� 1�� �߰��ϴ� ���� ����� �������� ���
//Ȯ���ϸ� 100%�� �Ѱ��� �� �ش� ����� �����ϸ� poll()�� ���� ť�� �� ���� ���ϸ� �Բ� �Ϸᰡ �Ǿ��� ��츦 Ȯ���ϱ� ����
//�������� Ȱ���ϴ� ������� ��ȹ�� ������.
//��Ȯ�ϰ� �� ���� ����� �Բ� �����Ǵ��� �˼� ���� �迭�� ũ��� �������� �� ���ۿ� ����. �Ͽ� ArrayList�� Ȱ���� 
//�������� ũ�⿡ �����ϵ��� �ߴ�.
//��꿡�� ������ �������� ������ �κп��� NullPointerException�� �߻��ߴ�. ������ ã�ƺ��� ��� ����� ���� �Ŀ��� 
//while���� �����>100�� ������ ��� ���� ����ִ� �κ��� ����Ű�� ������ ���� ������ ������ ��������. �̸� �ذ��ϱ� ����
//whlie���� �߰������� !isEmpty()�޼ҵ带 �־��־���.
//���������� ���� ũ�⸦ �������ֱ� ���� arraylist�� �������� �䱸�ϴ� int�� �迭�� ��ȯ�� �������� ���� ���¿��� ������
//�迭�� ��ȯ�� �ʿ��߰� Iterator�� Ȱ���� arraylist�� ������ �迭�� ��ȯ�� �� �־���.
public class FunctionDevelopment {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int[] progresses = new int[st.countTokens()];
			int index = 0;
			
			while (st.hasMoreTokens())
				progresses[index++] = Integer.parseInt(st.nextToken());
			
			input = br.readLine();
			st = new StringTokenizer(input);
			index = 0;
			int[] speeds = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				speeds[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(Arrays.toString(solution(progresses, speeds)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> prog = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		int count = 0; //���ÿ� �Ϸ�� ����� ����� ���� ����
		int days = 1; //���� �ռ� �߿䵵�� ����� ��ĥ�̳� �ɷȴ��� ���� ����
		int index = 0;
		
		for (int i : progresses)
			prog.offer(i);
		
		while (!prog.isEmpty()) {
			int comp = prog.peek() + days * speeds[index];
			
			if (comp >= 100) {
				prog.poll();
				index++;
				count++;
				
				while (!prog.isEmpty()) {
					if ((prog.peek() + days * speeds[index]) >= 100) {
						prog.poll();
						index++;
						count++;
					} else
						break;
				}
				
				list.add(count);
				count = 0;
			}
			
			days++;
		}
		
		int[] resultArray = new int[list.size()];
		Iterator<Integer> it = list.iterator();
		
		for (int i = 0; i < list.size(); i++)
			resultArray[i] = it.next();
		
		return resultArray;
	}
}
