package HeapProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//2019-10-09
//입력한 스코빌 지수를 가지고 있는 음식들을 서로 섞에 입력한 목표의 스코빌 지수까지 도달하도록
//만드는 데 소요되는 섞는 횟수를 반환하는 프로그램.
//둘을 섞에 되면 제일 낮은 요소+(다음 요소*2)가 섞은 후 스코빌이 된다.
//입력된 값이 덜 매운 음식부터 오름차순으로 구성될 수 있도록 Arrays.sort()메소드를 사용했다.
//그 후 선입선출이 가능한 큐를 활용해 섞는 과정을 진행했다.
//생각을 해보니 어차피 위의 두 단계는 우선순위 큐를 활용한다면 더 간편하게 가능하다는 사실을 깨달았으며 또한 계산 후의
//결과 요소도 다시 큐에 넣어줘야 할 경우 크기를 비교해줘야 했기 때문에 우선순위 큐를 활용하는 것으로 계획을 선회했다.
//따로 Spicy라는 클래스를 선언해준 후 우선순위 큐에 대한 메소드를 재정의해줬는데 코드를 실행했을 당시
//ClassCastException오류가 발생했다. 웹을 통해 원인을 알아본 결과 어떠한 객체의 형태가 다른 형태로 캐스팅 시
//맞지 않은 형태로 캐스팅을 하고자 할 때 발생하는 문제였음을 알 수 있었다.
//따로 클래스를 만들어 계산하자 다른 모든 케이스들이나 시간적 효율에는 합격처리를 받았으나, 몇 가지 테스트에서는 불합격이
//나왔다. 이유를 알고자 문제를 다시 한 번 찾아보자 원하는 스코빌 지수에 도달하지 못했을 때 -1을 반환하도록 해야했는데
//그렇게 하지 않아 생긴 오류라는 사실을 알게 되었다.
//이 조건도 해결하고자 while반복 탈출의 조건을 큐의 사이즈가 1일때로 변경 후 마지막 남은 큐의 값이 반복문을 빠져나갔을 당시
//K보다 작다면 원하는 스코빌값에 도달하지 못한 것이기 때문에 -1을 반환해주도록 했다.
public class MoreSpicy {
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
			int[] scoville = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				scoville[index++] = Integer.parseInt(st.nextToken());
			
			int K = Integer.parseInt(br.readLine());
			
			bw.write(String.valueOf(solution(scoville, K)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int solution(int[] scoville, int K) {
		PriorityQueue<Spicy> scovQ = new PriorityQueue<>();
		int count = 0;
		
		for (int i : scoville)
			scovQ.offer(new Spicy(i));
		
		while (scovQ.size() != 1) {
			Spicy comp1 = scovQ.poll();
			if (comp1.valueOf() >= K)
				break;
			
			Spicy comp2 = scovQ.poll();
			//계산을 거친 후 우선순위 큐에 다시 넣어준다.
			scovQ.offer(new Spicy(comp1.summaryScoville(comp2)));
			count++;
		}
		
		if (scovQ.peek().valueOf() < K)
			return -1;
		
		return count;
	}
}

class Spicy implements Comparable<Spicy> {
	int scoville;
	
	public Spicy(int scoville) {
		this.scoville = scoville;
	}
	
	public int valueOf() {
		return scoville;
	}
	
	//compareTo메소드를 통해 큐에 들어오는 요소들의 순서를 맞추게 된다.
	@Override
	public int compareTo(Spicy comp) {
		if (this.scoville > comp.scoville)
			return 1;
		else if (this.scoville < comp.scoville)
			return -1;
		return 0;
	}
	
	public int summaryScoville(Spicy comp2) {
		if (comp2 == null)
			return -1;
		return this.scoville + (comp2.scoville * 2);
	}
}