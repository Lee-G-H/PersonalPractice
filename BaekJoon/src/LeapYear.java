import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-17
//윤년을 판별하는 프로그램
//조건문을 사용하여 윤년의 조건만 넣으면 되는 간단한 프로그램
//&&와 ||를 활용해 and와 or조건을 넣음으로써 if 하나에 모든 조건을 넣었다.
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
