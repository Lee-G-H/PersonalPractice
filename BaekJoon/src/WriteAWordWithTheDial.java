import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-25
//���� 5622�� ����
//������ �� ���̾� ��ȭ�⸦ ���� �־��� �ܾ �ۼ��ϴ� ����
//1���� �����µ��� 2��, �� �ٿ� ���ں��ʹ� ���� 1�ʾ� �ɸ��� �ð��� �����Ѵ�
//static������ int�� �迭�� �����ϸ�, 2������ 9������ ���̾��� ���� �� �ҿ�Ǵ� �ð��� ����ߴ�
//ó������ switch case���� ����� ������ �ذ��غ��� ������, �ʹ� ���� �ڵ尡 �ʿ��ϴٴ� ����������
//���ǹ��� ����ϴ� ������ ����� ��ȸ�ߴ�
//�ҹ��ڷ� �ԷµǾ��� ���� �ϰ��� ����� �������ְ��� toUpperCase()�޼ҵ带 ����� ���� �빮�ڷ� �����Ѵ�
public class WriteAWordWithTheDial {
	static int[] time = {3, 4, 5, 6, 7, 8, 9, 10};
	
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		
		try {
			input = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		input = input.toUpperCase();
		
		int result = takenTime(input);
		printResult(result);
	}
	
	static int takenTime(String input) {
		int count = 0;
		char[] ex = input.toCharArray();
		
		for (int i = 0; i < ex.length; i++) {
			if (ex[i] <= 'C')
				count += time[0];
			else if (ex[i] <= 'F')
				count += time[1];
			else if (ex[i] <= 'I')
				count += time[2];
			else if (ex[i] <= 'L')
				count += time[3];
			else if (ex[i] <= 'O')
				count += time[4];
			else if (ex[i] <= 'S')
				count += time[5];
			else if (ex[i] <= 'V')
				count += time[6];
			else
				count += time[7];
		}
		
		return count;
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
