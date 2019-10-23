import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-17
//���� 2884�� ����
//�Ͼ�� �� �ð����� 45�� ������ �˶��� ���ߴ� ���α׷�
//Ǯ�� ����� ������� ������ 24�ð踦 ����ϱ� ������
//�ð��� 0�� ���¿��� ���� �ð����� ���ư� ��� 24�� ���ϸ�
//���� 0���� ���� �� 60�� �����ָ� ������ �ذ�ȴ�.
public class AlermTimeProblem {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		
		movingTime(hour, minute);
	}
	
	static void movingTime(int hour, int minute) throws Exception {
		minute -= 45;
		
		if (minute < 0) {
			minute += 60;
			hour--;
			if (hour < 0) {
				hour += 24;
			}
		}
		
		printResult(hour, minute);
	}
	
	static void printResult(int hour, int minute) throws Exception {
		bw.write(hour + " " + minute);
		bw.flush();
		bw.close();
	}
}