package ExhaustiveSearchProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//2019-10-14
//답안지가 주어졌을 때 수포자 1, 2, 3중 누가 가장 많이 맞았는지 구하는 문제로 답은 여러명일 수 있다.
//수포자1 : 1 2 3 4 5 ...
//수포자2 : 2 1 2 3 2 4 2 5 ...
//수포자3 : 3 3 1 1 2 2 4 4 5 5 ...
//딱 보기만 해도 별다른 특별한 공식들을 사용하지 않고 각각의 정답여부를 따로 체크해야만 하는 문제였다.
//처음에는 각 학생 3명을 위한 변수를 따로 만들어 작성하기 시작했지만 도중에 굳이 그렇게 할 필요 없이 모두를 배열로서 관리하면
//가독성도 더 좋아질 것이라는 생각이 들었다. 모든 과정을 통해 정답 개수가 정해지면 이들을 내림차순으로 정렬한 후
//제일 많이 맞은 학생들에 대해서만 따로 마련된 배열에 넣어주며 코드를 종료하도록 했다.
public class MockExam {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = 0;
			int[] answers = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				answers[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(Arrays.toString(solution(answers)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int[] solution(int[] answers) {
		int[] stdCount = new int[3];
		int[] stdIndex = new int[3];
		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int comp;

		for (int answer : answers) {
			comp = answer;

			if (student1[stdIndex[0]++] == comp)
				stdCount[0]++;
			if (student2[stdIndex[1]++] == comp)
				stdCount[1]++;
			if (student3[stdIndex[2]++] == comp)
				stdCount[2]++;

			if (stdIndex[0] == student1.length)
				stdIndex[0] = 0;
			if (stdIndex[1] == student2.length)
				stdIndex[1] = 0;
			if (stdIndex[2] == student3.length)
				stdIndex[2] = 0;
		}
		
		int max = 0;
		int count = 0;
		
		for (int i : stdCount) {
			if (max < i) {
				max = i;
				count = 1;
			} else if (max == i)
				count++;
		}
		
		int[] resultArray = new int[count];
		int index = 0;
		
		for (int i = 0; i < stdCount.length; i++) {
			if (max == stdCount[i])
				resultArray[index++] = i + 1;
		}
		
		return resultArray;
	}
}
