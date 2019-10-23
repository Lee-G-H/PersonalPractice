import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-21
//백준 11729번 문제
//하노이 탑 문제
//입력값으로는 탑의 높이가, 출력값에는 첫 줄에 총 이동 횟수, 둘째줄부터는
//정수 2개를 띄어쓰기 하나 사이에 넣어주는데 왼쪽 수번째 탑의 가장 높이있는 블럭을 오른쪽 수번째 탑으로 옮긴다는 의미다
//3층 높이의 하노이 문제를 직접 풀어보며 총 이동 수는 2^h-1번이 된다는 것을 찾아냈다
//또한 짝수 높이일때는 2번을 처음으로, 홀수번째일때는 3번 먼저이며 아래 단계의 높이 풀이과정을 거친다는 것을 발견했다
//하노이탑은 재귀함수를 이용한다면 해결이 빠르게 이루어질 수 있으며, n-1높이의 탑을 1에서 2로, 제일 아래 탑을 1에서 3으로
//가는 과정을 반복하면 된다
//6-a-b를 각 위치에 넣어주며 하노이 탑의 왕복을 무사히 수행 가능하도록 만들어준다.
public class HanoiTowerProblem {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static int solid;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int height = Integer.parseInt(br.readLine());
		int result = (int)Math.pow(2, height) - 1;
		sb.insert(0, result + "\n");
		solid = height;
		
		solveHanoi(height, 1, 3);
		printResult();
	}
	
	static void solveHanoi(int height, int A, int C) {		
		if (height == 0)
			return;
		solveHanoi(height - 1, A, 6 - A - C);
		sb.append(A + " " + C + "\n");
		solveHanoi(height - 1, 6 - A - C, C);
	}
	
	static void printResult() throws Exception {
		bw.write(String.valueOf(sb));
		bw.flush();
	}
}