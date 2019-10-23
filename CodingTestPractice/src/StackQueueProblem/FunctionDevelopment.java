package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-10-07
//기능 개발을 수행하는 프로그램
//우선도 순으로 입력한 배열과 각 기능 개발 속도를 입력한 배열을 각각 넣어주었을 때 각 우선도가 가장 높은 기능이
//릴리즈될 당시 몇개의 기능이 함께 릴리즈되는지를 세는 배열을 반환하도록 하며 100%이상이더라도 각 요일이 끝났을 때
//기능을 공개하도록 한다.
//이를 위해 큐를 도입했으며 함께 공개될 기능을 세는 변수, 며칠이 걸릴지 계산할 변수를 각각 선언해주었다.
//문제 해결을 위해 생각한 방법은 큐에 존재하는 요소가 없을 때까지 반복하며 요일을 계속 1씩 추가하는 동안 기능의 구현도를 계속
//확인하며 100%를 넘겼을 때 해당 기능을 공개하며 poll()후 다음 큐를 한 번에 비교하며 함께 완료가 되었을 경우를 확인하기 위한
//변수까지 활용하는 방안으로 계획을 세웠다.
//정확하게 몇 개의 기능이 함께 공개되는지 알수 없어 배열의 크기는 가변적이 될 수밖에 없다. 하여 ArrayList를 활용해 
//가변적인 크기에 대응하도록 했다.
//계산에는 문제가 없었으나 마지막 부분에서 NullPointerException이 발생했다. 원인을 찾아보니 모든 결과가 나온 후에도 
//while문의 계산결과>100의 조건이 계속 돌며 비어있는 부분을 가리키기 때문인 것이 원인인 것으로 밝혀졌다. 이를 해결하기 위해
//whlie문에 추가적으로 !isEmpty()메소드를 넣어주었다.
//마지막으로 가변 크기를 제어해주기 위한 arraylist는 문제에서 요구하는 int형 배열로 반환에 적합하지 않은 상태였기 때문에
//배열로 변환이 필요했고 Iterator를 활용해 arraylist를 무사히 배열로 변환할 수 있었다.
public class FunctionDevelopment {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int[] progresses = new int[st.countTokens()];
			int index = 0;
			
			while (st.hasMoreTokens())
				progresses[index++] = Integer.parseInt(st.nextToken());
			
			input = br.readLine();
			st = new StringTokenizer(input);
			index = 0;
			int[] speeds = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				speeds[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(Arrays.toString(solution(progresses, speeds)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> prog = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		
		int count = 0; //동시에 완료된 기능이 몇개인지 세는 변수
		int days = 1; //가장 앞선 중요도의 기능이 며칠이나 걸렸는지 세는 변수
		int index = 0;
		
		for (int i : progresses)
			prog.offer(i);
		
		while (!prog.isEmpty()) {
			int comp = prog.peek() + days * speeds[index];
			
			if (comp >= 100) {
				prog.poll();
				index++;
				count++;
				
				while (!prog.isEmpty()) {
					if ((prog.peek() + days * speeds[index]) >= 100) {
						prog.poll();
						index++;
						count++;
					} else
						break;
				}
				
				list.add(count);
				count = 0;
			}
			
			days++;
		}
		
		int[] resultArray = new int[list.size()];
		Iterator<Integer> it = list.iterator();
		
		for (int i = 0; i < list.size(); i++)
			resultArray[i] = it.next();
		
		return resultArray;
	}
}
