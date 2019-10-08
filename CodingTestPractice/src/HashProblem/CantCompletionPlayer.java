package HashProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

//2019-09-29
//������ �� �������� ���� ������ ��ȯ�ϴ� ���α׷�
//�迭�� ����� ���� ������, �ؽ��� ���� ���ص��� ���̰��� �ؽ��� ����ϱ�� �Ѵ�.
//Ű�� �ߺ��� ����� �ϳ� ���� �ߺ��� ���Ǵ� Ư���� �־� � �迭�� Ű�� �������� ���� ����� �ߴ�.
//�����ڿ� ������ �� �ؽø��� ������ ���������� ���� �̸� String, �������� �� Integer�� ���� Ű�� ������ �����ߴ�.
//�ʿ� ������ �ִ� �������� �� �ʿ� ����ϴ� ������ ������ �Ȱ��ٴ� ���� �߰��� addValue��� �޼ҵ带 ����
//�ߺ��Ǵ� �ڵ带 �ٿ��ô�.
//�ڵ带 �ۼ��ϸ� �����غ��� �����ں��ٴ� �����ڰ� �� ���� ������ �����ڸ� ���� �ʿ� �ְ� �����ڸ� ������ ���ϴ� ���� ���ڴٴ�
//������ ������, ���� �׷��� �ȴٸ� �ؽø��� ������ �� �Ѱ��� �ʿ��ϰ� �ȴٴ� ��ǵ� �߰��س� �� �־� addValue�޼ҵ带
//�����Ͽ� �ٽ� solution�޼ҵ忡 ���Խ��״�. ���� ���ֿ� ������ ����� �� �Ѹ��̶�� ������ �־� containsKey�޼ҵ带
//�̿��� ������ ���� ���� �ش� Ű�� �����Ѵٸ� continue��, �׷��� �ʴٸ� answer�� �� ����� �̸��� ���� �� �ֵ��� �ߴ�.
//���������� ������ ã�� �Ǹ� �ݺ����� ������ ������ �������� ������ break�� ���� �ݺ��� Ż���ϵ��� �ߴ�.
//�������� �ʾҴ� ������ ���������� �߻����� �� ������ ��Ͽ� ��� �����ϱ� ������ �� �� ����ó���� �ȴٴ� ����� �� �� �־���.
//�̸� �ذ��ϰ��� continue�� �ϱ� ���� ������ �ؽø��� Ű�� ���̴� ������ �ߴ�.
public class CantCompletionPlayer {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input1 = "", input2 = "";
		StringTokenizer st;
		int index = 0;
		
		try {
			input1 = br.readLine();
			st = new StringTokenizer(input1);
			String[] participant = new String[st.countTokens()];
			while (st.hasMoreTokens())
				participant[index++] = st.nextToken();
			
			index = 0;
			input2 = br.readLine();
			st = new StringTokenizer(input2);
			String[] completion = new String[st.countTokens()];
			while (st.hasMoreTokens())
				completion[index++] = st.nextToken();
			
			bw.write(solution(participant, completion));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> compl = new HashMap<>();
		
		for (String index : completion) {
			if (compl.containsKey(index))
				compl.put(index, compl.get(index) + 1);
			else
				compl.put(index, 1);
		}
		
		for (String index : participant) {
			if (compl.containsKey(index)) {
				if (compl.get(index) > 1)
					compl.put(index, compl.get(index) - 1);
				else
					compl.remove(index);
				
				continue;
			}
			answer = index;
			break;
		}
		
		return answer;
	}
}