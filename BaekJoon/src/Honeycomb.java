import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-27
//백준 2292번 문제
//벌집 모양의 육각형 그림에서 입력한 번호의 칸까지 갈 수 있는 최소 경로의 비용을 구하는 프로그램
//패턴을 계산한 결과 7-19-37-...과 같이 매 테두리가 추가될 때마다 6의 배수씩 증가하는 등비수열임을 알 수 있었다
//처음에는 이를 한 번에 반환해줄 수 있을만한 공식을 생각해보았으나, 획기적인 성능차이가 발생하지는 않을 것이라 판단 후
//반복문을 활용해 문제를 해결하는 쪽으로 방향을 선회했다
//반복을 사용할 때는 가중치를 주는 변수를 선언 후 해당 값에 가중을 주는 방식으로 걸리는 경로의 값을 찾았다
public class Honeycomb {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long input = 0;
		
		try {
			input = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long result = solveProblem(input);
		printResult(result);
	}
	
	static long solveProblem(long input) {
		if (input == 1)
			return 1;
		
		int count = 1;
		int weight = 6;
		
		for (int i = 1; i < input; i++) {
			if (i == weight + 1) {
				count++;
				weight += 6 * count;
			}
	}
		
		return ++count;
	}
	
	static void printResult(long result) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(String.valueOf(result));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
