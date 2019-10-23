package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-10-06
//송신탑에서 전파를 송신했을 때 수신하는 탑의 위치를 반환하는 프로그램
//큐를 이용해 이전 요소와 비교를 수행하며 송신 가능한 탑을 찾아나간다.
//간단하다 생각했으나 생각 외의 문제가 발생했는데, 큐에는 요소를 찾아가는 메소드가 없다는 것이였다.
//이를 해결하기 위해 입력받은 배열을 한칸씩 앞으로 돌며 조건문으로 비교하는 방식을 사용했다.
//처음에는 큐의 값과 배열을 비교하는 데 IndexOutOfBoundException이 발생해 원인을 알고자 분석을 진행했고
//그 결과 이중 반복문 부분의 뺄셈을 진행애야 할 부분이 j++과 같이 더해지는 것 때문이라는 것을 파악했다.
//또한 [6, 9, 5, 7, 4]의 결과 배열값이 [0, 0, 2, 2, 4]여야 했는데 [0, 0, 2, 0, 0]으로 나오는 문제를 찾았고
//확인 결과 첫 번째 반복문에서 반복이 종료되는 조건을 beforeQ.size()로 설정해 변화하는 큐의 사이즈에 따라 3, 4번 인덱스는
//아예 코드 진행이 되지 않고 반복이 종료된 것이였다. 이 문제는 종료 조건을 입력 배열의 길이로 바꿈으로서 해결했다.
public class Tower {
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
			int[] heights = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				heights[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(Arrays.toString(solution(heights)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int[] solution(int[] heights) {
		int[] resultArray = new int[heights.length];
		Queue<Integer> beforeQ = new LinkedList<>(); //아직 조회되지 않은 송신탑 저장
		
		for (int i = 1; i < heights.length; i++)
			beforeQ.offer(heights[i]);
		
		for (int i = 1; i < heights.length; i++) {
			int comp = beforeQ.poll();
			
			for (int j = i - 1; j >= 0; j--)
				if (comp < heights[j]) {
					resultArray[i] = j + 1;
					break;
				}
		}
		
		return resultArray;
	}
}
