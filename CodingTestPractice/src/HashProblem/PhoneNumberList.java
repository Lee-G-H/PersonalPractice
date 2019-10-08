package HashProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//2019=09=29
//��ȭ��ȣ ����� ��ȯ�ϴ� ���α׷�
//�� �Է°��� ���λ簡 �� ���� �߿� �ѱ����� �����Ѵٸ� true�� ��ȯ�ϵ��� �ؾ� �ϴµ� ��Ȯ�� � ���� �̿��ؾ� �� �� �����
//���� �Ǵ� ��Ȳ�̿���.
//ó������ ���ڿ��θ� �� ���� �����Ŷ� ������ startsWith�޼ҵ带 ����غ����� ������ �߻��ߴ�.
//������ �����غ��� �ݺ����� �� ���� ����Ͽ� comp������ ��ȭ���� �ٷ� ���� ���ڿ��� ���ϰ� ���ڿ� �迭 ������ �˻����� �ʾ�
//�߻��� ���������� �˰� �Ǿ���. �̸� ���� ���ڿ��� �ܼ��� �ذ��� �Ұ��ϰڴٴ� �Ǵ��� ��� �ؽø��� �̿��ϴ� ������� ��ȸ�ߴ�.
//String, String������ ���������� Ű�� ���� ���� ���ϴ� ����� ����ϰ��� ��ȹ�ߴ�.
//�������δ� ù �ε������� �ٷ� �߰ߵǴ� �һ�縦 �����ϱ� ���� �ʿ� ���� �߰��� �� ���� �� ��Ҹ� remove�Ϸ� ������
//�׳� �ε��� 1���� �����ϸ� �ȴٴ� ���� ���ݰ� �����۾��� �����ߴ�.
//�ؽø� �̿��Ҷ��� ���߹ݺ��� ����ؾ� �ϳ� ����� ������, �ᱹ �ؽø��� ��� Ȱ������ �� ���� ������ �ʰ� ���� 
//�׽�Ʈ 8, 9���� �ڲ� Ʋ���ٴ� ����� ���� �ٸ� ����� ã�ƺ���� �����ߴ�. ������ �ŵ��� ���
//sort�޼ҵ带 Ȱ���� �̸� �迭�� �����صдٸ� �ٷ� �� ��Ҹ� ���ϸ� �Ǳ� ������ �� ���� �˻��� ������ ���̶��
//������ �����. �ش� ����� ����Ͽ� ���ۼ��غ��� �ݺ����� �� ���� ����ϰ� �Ǵ� ���� �ڵ尡 ������ �Ǿ���.
public class PhoneNumberList {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		StringTokenizer st;
		int index = 0;
		
		try {
			input = br.readLine();
			st = new StringTokenizer(input);
			String[] phoneBook = new String[st.countTokens()];
			while (st.hasMoreTokens())
				phoneBook[index++] = st.nextToken();
			
			bw.write(String.valueOf(solution(phoneBook)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static boolean solution(String[] phoneBook) {
		Arrays.sort(phoneBook);
		
		for (int i = 1; i < phoneBook.length; i++)
			if (phoneBook[i].startsWith(phoneBook[i - 1]))
				return false;
		
		return true;
	}
}