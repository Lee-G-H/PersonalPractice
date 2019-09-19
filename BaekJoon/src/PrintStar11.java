import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

//2019-06-22
//백준 2448번 문제
//이중 반복문을 이용하여 문제를 해결하려 하였으나 메모리 효율이 좋지 못할 것 같아 map을 통한 구현으로 선회하였다.
//
public class PrintStar11 {
	static BufferedWriter bw;
	static Map<Integer, String> star;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		star = new HashMap<>();
		
		bw.write("줄의 수를 입력하세요 : ");
		bw.flush();
		int input = Integer.parseInt(br.readLine());
		
		printResult(input);
	}
	
	static void printResult(int input) throws Exception {
		for (int i = 0; i < input; i++) {
			
		}
	}
}
