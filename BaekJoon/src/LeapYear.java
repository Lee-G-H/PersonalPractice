import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-17
//������ �Ǻ��ϴ� ���α׷�
//���ǹ��� ����Ͽ� ������ ���Ǹ� ������ �Ǵ� ������ ���α׷�
//&&�� ||�� Ȱ���� and�� or������ �������ν� if �ϳ��� ��� ������ �־���.
public class LeapYear {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int year = Integer.parseInt(br.readLine());
		
		if (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0)) {
			printResult(1);
		} else {
			printResult(0);
		}
	}
	
	static void printResult(int result) throws Exception {
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
	}
}
