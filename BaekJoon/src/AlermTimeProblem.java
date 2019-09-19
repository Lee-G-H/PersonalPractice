import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-17
//백준 2884번 문제
//일어나야 할 시간보다 45분 전으로 알람을 맞추는 프로그램
//풀이 방법에 어려움은 없으며 24시계를 사용하기 때문에
//시간이 0인 상태에서 이전 시간으로 돌아갈 경우 24를 더하며
//분이 0보다 작을 때 60을 더해주면 문제가 해결된다.
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