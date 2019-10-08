package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//2019-10-07
//잘린 쇠막대기의 조각수를 세는 프로그램
//쇠막대기는 겹칠 수 있으며 이 때는 긴 막대가 짧은 막대 뒤에 온다
//스택을 활용한다면 레이저가 나온 당시 쌓인 쇠막대기의 수를 쉽게 알 수 있게 된다.
//레이저가 나오는 "()"부분은 다른 쇠막대기와 구별이 쉽지 않기 때문에 '|'로 바꿔주어 레이저로서의 구분감을 부여해주기로 했다.
//세 가지 조건을 걸었으며, 레이저 '|'가 나올 경우 여태까지 스택에 쌓인 쇠막대기를 반환하며 또한 가중치 변수를 통해 맨 위 쇠조각이
//세지지 않고 지나치지 않도록 만들어주었다. 다음으로 ')'가 나올 경우 지금까지 쌓인 스택에서 한 개의 스택을 빼주며 가중치 변수에 1을
//추가해준다. 두 경우가 아닐 경우 '('라는 것을 의미하기 때문에 스택에 push시켜준다.
//테스트 결과 의도했던 예시의 답이였던 17보다 1적은 16이 나오게 되었는데 이를 잠시 살펴보니 레이저를 통해 마지막으로 자른 후
//남는 쇠막대기들을 버려버렸기 때문에 발생한 오류였음을 알 수 있었다. 이를 해결하기 위해 weight값을 반환시의 count에 추가해주었다.
public class IronStick {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String arrangement = br.readLine();
			
			bw.write(String.valueOf(solution(arrangement)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//|(((||)(|)|))(|) => 17
	//(가 계속 나오는 동안 가중치를 증가시키고 )가 나오면 가중치를 하나 빼며 카운트에 가중치 더함
	static int solution(String arrangement) {
		Stack<Character> iron = new Stack<>();
		int count = 0;
		int weight = 0; //pop에 의해 버려지는 쇠막대기 조각을 세는 변수
		arrangement = arrangement.replace("()", "|");
		
		for (int i = 0; i < arrangement.length(); i++) {
			if (arrangement.charAt(i) == '|') {
				count += iron.size() + weight;
				weight = 0;
			} else if (arrangement.charAt(i) == ')') {
				iron.pop();
				weight++;
			} else {
				iron.push(arrangement.charAt(i));
			}			
		}
		
		//마지막 레이저로 인해 잘린 쇠막대기를 세서 반환한다.
		return count + weight;
	}
}
