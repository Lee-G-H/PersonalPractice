package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//2019-10-12
//�Էµ� �迭���� k��° ���� ã�� ����
//�䱸�ϴ� ������ �Էµ� �迭 ��ü�� �ƴ� ���ĵ� ���¿��� ���ϴ� ���� ã���� �ϱ� ������ �迭�� ���Ľ����ش�.
//�����ϵ� �ϴ� �䱸�ϴ� �ε����� ������ ���� ���� �迭�� �ڸ� �� ������ �����ϱ� ������ �ڸ��� �� ������ ������Ű�� ���ϴ�
//���� ������ �ʴ´�. �׷��� ������ �켱 ���Ḯ��Ʈ�� ���� �� ���ǿ� ���� list�� �����ش�. �� �� Collection��
//sort()�޼ҵ带 ���� �������ְ� �� ��������� ���ϴ� ���� ��� �迭�� �߰������ش�.
//��� ������ ���� ������ clear()�޼ҵ带 ����� ����Ʈ�� ������ ���� ������� ������ �ʰ� ����� ����� �� �� �ִ�.
public class KthNumber {
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
			int[] array = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				array[index++] = Integer.parseInt(st.nextToken());
			
			input = br.readLine();
			st = new StringTokenizer(input);
			index = 0;
			int[][] commands = new int[st.countTokens() / 3][3];

			for (int i = 0; i < commands.length; i++)
				for (int j = 0; j < 3; j++)
					commands[i][j] = Integer.parseInt(st.nextToken());
			
			bw.write(Arrays.toString(solution(array, commands)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] resultArray = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++)
				list.add(array[j]);
			
			Collections.sort(list);
			resultArray[i] = list.get(commands[i][2] - 1);
			list.clear();
		}
		
		return resultArray;
	}
}
