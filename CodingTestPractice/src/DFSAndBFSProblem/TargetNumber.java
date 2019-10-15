package DFSAndBFSProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-10-14
//주어진 정수 배열이 있을 때  모든 배열 요소를 모두 사용 더하거나 빼서 목표하는 숫자를 만들 수 있는 경우의 수를 구하는 문제다.
//BFS와 DFS에 대한 지식을 얻기 위한 문제로 나는 이 문제를 풀 때 BFS가 효율적일 것이라는 판단을 했다.
//깊이 또는 넓이 우선 탐색을 구현한 경험은 많지 않았었기 때문에 정확하게 어떤 방법으로 코드를 작성할지 고민하는 데 많은 시간이
//소요되었다.
//여러 모로 생각해본 후 각 숫자별로 +일때와 -일때가 나뉘어져 경우의 수를 따져야 하기 때문에 이를 쉽게 판단하기 위해서는
//연결 리스트를 사용하는 것이 좋다는 생각을 했다. 아무리 생각해봐도 구조는 트리 형태를 띄는 것이 맞다는 결론만 나왔으며
//자식 노드를 향해 끝까지 내려가는 과정은 재귀적으로 수행할 수 있도록 만들었다.
//재귀형식으로 문제를 해결하기로 결정한 후 구현 작업을 수행하다 보니 연결 리스트는 굳이 사용할 필요가 없음을 알 수 있게 되었다.
//재귀형식으로 문제를 해결한 후 count를 올리는 방식에 대해 내부 변수화 등 여러 모로 생각해봤지만 지금의 실력으로는 
//단지 static을 선언해 함수 외부에서 불러오도록 하는 것이 최선이었다.
//결과적으로 count변수의 값을 출력해주어 문제를 해결할 수 있었다.
public class TargetNumber {
	static int count = 0;
	
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = 0;
			int[] numbers = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				numbers[index++] = Integer.parseInt(st.nextToken());
			
			int target = Integer.parseInt(br.readLine());
			
			solution(numbers, target);
			
			bw.write(String.valueOf(count));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void solution(int[] numbers, int target) {		
		DFS(numbers, target, 0);
	}
	
	static void DFS(int[] numbers, int target, int depth) {
		if (depth == numbers.length) {
			int summary = 0;
			
			for (int i : numbers)
				summary += i;
			
			if (summary == target)
				count++;
			
			return;
		}
		
		numbers[depth] *= 1;
		DFS(numbers, target, depth + 1);
		
		numbers[depth] *= -1;
		DFS(numbers, target, depth + 1);
	}
}
