import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-25
//���� 1316�� ����
//n���� �ܾ���� �Է¹��� �� �׷� �ܾ��� ���� ã�� ���α׷�
//�׷� �ܾ�� �ܾ �����ϴ� �� ���ڵ��� ���� ���ӵ� ���̴�
//ex) happy�� �� ���ĺ����� ���� ���ӵǱ� ������ �׷�ܾ �����Ѵ�
//�� ���������� ��� �ܾ �ҹ��ڷ� �̷���� �ִٰ� �����Ѵ� ������ �빮�ڸ� �Է��ϴ� ����ڰ� ���� �� �ֱ� ������
//toLowerCase()�޼ҵ带 ����� ���� �ҹ��ڷ� �ٲ��ش�
//�迭 ���� �� ��ҵ��� � ������� �ݺ����Ѿ� �� �� ���� �� ���� �ʾ� ������ ����ߴ�
//�ƹ��� ����غ��� for���� �ּ��� 2������ ����ؾ� �ذ��� �����ϴ� �Ǵ������� �� �������� ȿ���� ���� �ϰ���
//�׷� �ܾ �Ǻ��ϴ� �Լ��� ���� �ۼ��ߴ�
//�ش� �Լ� �������� ���ĺ� ũ�⿡ �ش��ϴ� ���� �迭�� ���� �� �ܾ �ѹ��� ������ 
//�켱 ���� ���ڿ� �ش��ϴ� �迭 �ε��� ��Ұ��� �Ǵ��� ���̸� �׷� ���ڰ� �ƴ� ������ ����, �� ���ڿ� �ٸ� ���ڰ� ���� ��
//���� ���ڿ� �ش��ϴ� ���� �迭 �ε����� ���� ������ �ٲ��ִ� ������� ������ �ذ��ߴ�
public class CheckGroupWord {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = 0, result = 0;
		String input = "";
		
		try {
			number = Integer.parseInt(br.readLine());
			String[] inputArray = new String[number];
			
			for (int i = 0; i < number; i++) {
				input = br.readLine();
				input.toLowerCase();
				inputArray[i] = input;
			}
			
			result = countGroupWord(inputArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		printResult(result);
	}
	
	static int countGroupWord(String[] inputArray) {
		int count = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (checkWord(inputArray[i]))
				count++;
		}
		
		return count;
	}
	
	static boolean checkWord(String line) {
		boolean[] check = new boolean[26];
		
		for (int i = 1; i < line.length(); i++) {
			if (check[line.charAt(i) - 'a'])
				return false;
			if (line.charAt(i) != line.charAt(i - 1))
				check[line.charAt(i - 1) - 'a'] = true;
		}
		
		return true;
	}
	
	static void printResult(int result) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(String.valueOf(result));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}