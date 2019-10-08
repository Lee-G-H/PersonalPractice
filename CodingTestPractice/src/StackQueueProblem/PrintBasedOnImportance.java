package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-10-04
//중요도에 따라 먼저 출력하는 것과 나중에 출력하는 것에 차이를 주는 프로그램
//기본적으로 선입 선출의 스택구조를 띄고 있으나, 해당 요소보다 더 중요도가 높은
//요소가 존재한다면 가장 뒤로 보내는 큐의 형태를 띄어야 한다.
//중요도를 표시한 정수형 배열에 요청할 인덱스 번호를 각각 입력하면 해당 요소는 몇 번째로 출력될지를 반환해야 한다.
//이를 위해 큐에 입력받은 배열값을 전부 넣어주었으며 반복문을 돌며 조건대로 출력값을 계산하는 과정을 거쳤다.
//이 때 count의 값이 계속 늘어나게 되는 문제를 발견했는데, 이를 해결하기 위해 큐의 크기를 저장하는 변수를 선언 후
//해당 값과 현재 큐의 크기를 비교 후 크기가 작아졌다면 출력이 정상적으로 이루어졌다는 뜻이므로 count를 증가시키도록 했다.
//다음으로는 location의 값을 줄여주는 부분이 큐를 돌며 값을 비교하는 반복문보다 앞에 있어 정상적으로 원하는 요소를
//가리키지 못하는 문제를 발견했는데, 이를 해결하기 위해 반복문이 끝난 후 location의 값을 줄여주는 방식을 통해
//해당 값을 정상적으로 원하는 요소와 동기화시킬 수 있게 되었다.
//또 다른 문제를 발견하게 되었는데 반복문 내에서 원하는 값이 아직 나올 때가 되지 않아 offer()메소드를 통해 다시 
//큐에 들어가게 될 때 location의 값을 size()-1로 하여 원하는 요소보다 한 칸 앞 요소를 가리키는 문제를 발견했으며
//1을 추가로 빼는 과정을 삭제하여 문제를 해소할 수 있었다.
//마지막으로 [1,1,9,1,1,1]배열의 1번 요소가 출력되는 순서를 따지고자 할 때 첫 번째로 나간다는 결과가 출력되는
//문제가 발생했는데, 확인 결과 while문을 빠져나오는 조건이 location값을 줄이는 조건문보다 뒤에 있어
//location이 0이 되자마자 빠져나간 것 때문이였다. 이 두 조건식을 교환하자 원하는 값이 정상적으로 나오게 되었다.
public class PrintBasedOnImportance {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int[] priorities = new int[st.countTokens()];
			int index = 0;
			
			while (st.hasMoreTokens())
				priorities[index++] = Integer.parseInt(st.nextToken());
			
			int location = Integer.parseInt(br.readLine());
			if (location > priorities.length - 1)
				System.exit(1);
			
			bw.write(solution(priorities, location) + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int solution(int[] priorities, int location) {
		Queue<Integer> waitQ = new LinkedList<>();
		int count = 1;
		
		for (int i : priorities)
			waitQ.offer(i);
		
		int size = waitQ.size();
		
		while (!waitQ.isEmpty()) {
			int index = waitQ.poll();
			
			for (Integer i : waitQ) {
				if (i > index) {
					waitQ.offer(index);
					if (location == 0)
						location = waitQ.size();
					break;
				}
			}
			
			if (location == 0)
				break;
			
			if (location != 0)
				location--;
		
			if (size > waitQ.size()) {
				count++;
				size = waitQ.size();
			}
		}
		
		return count;
	}
}
