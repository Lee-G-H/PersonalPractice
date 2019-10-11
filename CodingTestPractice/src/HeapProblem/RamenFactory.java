package HeapProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//2019-10-10
//라면 공장을 운용하기 위해 공급하는 밀 공장이 고장나 정상 작업이 가능하기 전까지 몇 번이나 외부에서 공급받아야 하는지 세는 문제
//힙 문제에 들어가 있었지만 개인적으로 문제를 살펴본 결과 이미 내림차순으로 정렬되어 있는 상태이기 때문에 굳이 추가적인
//정렬과정이 필요없다 판단했고 일반 큐로 문제를 해결하기로 결정했다.
//각 배열을 두 개의 큐에 넣어준 후 반복을 수행하며 분기별로 조건을 부여해  날짜를 표시하는 변수가 k-1에 도달하면 그 당시의
//외부 공장에서 지원받은 수를 반환하도록 했지만, 예시에 있던 단 한가지의 예시만 맞고 나머지는 전부 틀린 결과를 받을 수 있었다.
//이를 통해 접근 방법 자체가 틀렸다는 것을 깨달을 수 있었고 이전 코드는 전면 교체하기로 마음먹었다.
//어떤식으로 구현하느냐에 대한 고민을 다시해야만 했는데 역시 문제에서 추천한 우선순위 큐를 활용해야 문제를 해결할 수 있겠다는
//생각밖에는 들지 않았다. 하지만 어떤식으로 구현해야 올바르게 우선순위 큐를 활용할 수 있는지 고민이 많이 되었다.
//고민을 거듭한 결과 밀을 공급받는 것은 필요한 시점에 얼마나 많이 공급을 받을 수 있느냐에 대한 문제가 가장 중요하다는 것을
//깨닫게 되었다. 이를 통해 supplies배열의 크기가 큰 순으로 저장할 수 있도록 유도하는 것이 좋다는 것을 알게 되었다.
//내림차순 정렬을 할 수 있는 방법을 찾던 중 Comparator의 reverseOrder()메소드를 활용하면 간단하게 내림차순 정렬이
//가능하다는 사실을 알게 되었고 이를 활용해 우선순위 큐를 선언하게 되었다.
//아직 공급할 밀이 남았다면 우선순위 큐에 공급 가능한 밀 크기순으로 밀을 넣어주며 밀 재고가 0이 된다면 큐에서 가장 앞에 있는,
//즉 해당 시점에 공급 가능한 가장 많은 밀을 공급해주면 원하는 대로 공장이 정상화되는 k일까지 라면공장에 정상적으로 밀을
//공급해줄 수 있게 된다.
//테스트 케이스를 넣어보자 ArrayIndexOutOfBoundsException이 발생했고 원인을 살펴보자 supplyDate가 
//공급일보다 작을 때, 곧 배열에 아직 추가할 요소가 남아있을 때 큐에 요소를 추가하도록 했어야 했는데 이를 count로 잘못
//기입해 존재하지 않는 인덱스를 참조해 발생한 문제였다.
public class RamenFactory {
	public static void main(String[] args) {
		init();
	}

	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			int stock = Integer.parseInt(br.readLine());

			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input);
			int index = 0;
			int[] dates = new int[st.countTokens()];

			while (st.hasMoreTokens())
				dates[index++] = Integer.parseInt(st.nextToken());

			input = br.readLine();
			st = new StringTokenizer(input);
			index = 0;
			int[] supplies = new int[st.countTokens()];

			while (st.hasMoreTokens())
				supplies[index++] = Integer.parseInt(st.nextToken());

			int k = Integer.parseInt(br.readLine());

			bw.write(String.valueOf(solution(stock, dates, supplies, k)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int solution(int stock, int[] dates, int[] supplies, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		int count = 0, supplyDate = 0;
		
		for (int i = 0; i < k; i++) {
			if (supplyDate < dates.length && i == dates[supplyDate])
				queue.offer(supplies[supplyDate++]);
			
			if (stock == 0) {
				stock += queue.poll();
				count++;
			}
			
			stock--;
		}
		
		return count;
	}
}
