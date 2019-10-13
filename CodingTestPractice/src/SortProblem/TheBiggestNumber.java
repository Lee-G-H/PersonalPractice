package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//2019-10-12
//�־��� ���� �迭���� ������ ���� ���� ū ���� ã�ƾ� �ϴ� ����
//ó������ ���� ����� ���� ���� ã�ƾ� �ϴ� ������ ���������� ���� �� �����غ���
//�� �迭�� ��ҵ��� ���ϸ� ���� ū �ڸ����� ũ�⸦ ���� ������������ ���̸� ������ ��������.
//�׳� Comparator.reverseOrder()�޼ҵ带 ����ϰ� �� ��� 9���� 10�� �� ũ�ٴ� ����� ���� ���ϴ� ����� ��Ÿ���� �ʴ´�.
//���� ����� �����غ����� ���� ���� ���� ����� ���ڿ��� ��ȯ�� ���ϴ� ���̶�� �Ǵ��� �ߴ�.
//�����غ��� ArrayList�� ������ �Ҷ� ���ڸ��� ���ϴ��� �ᱹ ������ �Ѵٸ� ���� ���ڸ� �ٽ� �ҷ��� ����� �����ؾ߸� �Ѵٴ� ����
//�˰� �Ǿ���. �̸� �ذ��ϱ� ���ؼ� ArrayList�� �ϳ� �� �����ؾ� �����ϰڴٴ� �Ǵ��� �߰�, �� ��������
//���� ū �ڸ������� �ƴ� ������ ���� �����ϵ��� ���־���.
//�ڵ带 �����ϴ� �� �Ǵٸ� ������ �߻��ߴ�. 3, 30, 34�� ���� ��� �� ���� 3�̱� ������ 3���� ���ױ׷��� ���ϴ� �����
//����� ������ �ʴ� ���̿���. �� ������ ������ �ε������� ���� �� list���� �񱳸� ������ 3�� �̹� �ֱ� �빮�� �Ѿ �߻��� ���̿���.
//�̸� �ذ��ϰ��� �ش� ��� ���� �ڸ����� ���� ��� ���� �ڸ����� ���� �� �ֵ��� ������ fullList�� ���� ���� �Ѿ�� ���� ������ �ߴ�.
//���������� ����������� �� ������ �ڸ����� �ִ� 1000�̶� �߱� ������ �ִ� 1000������ �����ϸ� �ȴٴ� ���� �˰� �Ǿ��� �̿� ����
//�ڵ��� ������ �ڵ�����. �̷л� ���� �ڸ����� ���� ���ٸ� �� ��������, �������� ���ٸ� ���� ���� ���� ���� �������� ���ϸ� �ȴ�.
//������ � ������ ������ �����ؾ� �� �� ���� ���� ������ �ʾҴ�.
//���� ��� ��� �߰����� �ݺ����� ���� charAt()�޼ҵ�� ���� �ڸ����� ã�ư���� �����ߴ�. �� ��� 3�� 30�� ���� �� 
//3�� ���� charAt���� 1�� �Ǿ� 3�� 30�� �񱳸� ������ ������ �� �ְ� �Ǿ���.
//�׽�Ʈ ��� ������ �׽�Ʈ���� ���� Ʋ���� �� ������ ������ �߰��ߴµ� �̸� Ȯ���غ��� StringIndexOutOfBoundException��
//�߻��� Ʋ�ȴٴ� ���� �� �� �־���. �̴� 9�� ���� ���ڸ����� �ִµ� ���� �ڸ����� ã���� �Ͽ� �߻��� ��������, �̸� �ذ��ϰ���
//���ڿ��� ���̰� ������ ��쿡�� �����ϵ��� ������ �ߴ�.
//��ӵ� ������ �ʹ� �� ������� �Ÿ��Ǵ� ���� ���� �ʴ� ������ �Ӹ��� ���� �ð��� ���� �� �������̴� ���ڿ����� Ȱ���ϴ� �����
//����ϱ�� �����ߴ�.
//���ڿ��θ� �ϱ�� �� �Ŀ��� �ξ� �� �����ϰ� �ڵ��� ����Ǿ���. comparator�� Ȱ���Ͽ� compareTo�޼ҵ带 �������ϰ�
//�� ���ڿ��� �� ���ڿ����� Ŭ ��� 1��, ���� �ں��� Ŭ ��� -1��, ���� ��� 0�� ��ȯ�ϴ� ������� ������ ��Ҵ�.
public class TheBiggestNumber {
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
			int[] numbers = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				numbers[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(solution(numbers));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String solution(int[] numbers) {
		String result = "";
		String[] sArray = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++)
			sArray[i] = String.valueOf(numbers[i]);
		
		//ū ������ ������������ �����ȴ�.
		Arrays.sort(sArray, new Comparator<String> () {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
		
		if (sArray[0].equals("0"))
			return "0";
		
		for (String s : sArray)
			result += s;
		
		return result;
	}
}
