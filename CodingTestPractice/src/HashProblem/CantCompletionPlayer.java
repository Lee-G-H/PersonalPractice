package HashProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

//2019-09-29
//참가자 중 완주하지 못한 선수를 반환하는 프로그램
//배열을 사용할 수도 있으나, 해쉬에 대한 이해도를 높이고자 해쉬를 사용하기로 한다.
//키는 중복이 없어야 하나 값은 중복이 허용되는 특성이 있어 어떤 배열을 키로 설정할지 많은 고민을 했다.
//참가자와 완주자 두 해시맵을 만들기로 결정했으며 또한 이름 String, 동명이인 수 Integer를 각각 키와 값으로 결정했다.
//맵에 값들을 넣는 과정에서 두 맵에 사용하는 과정이 완전히 똑같다는 것을 발견해 addValue라는 메소드를 통해
//중복되는 코드를 줄여봤다.
//코드를 작성하며 생각해보니 참가자보다는 완주자가 더 적기 때문에 완주자를 먼저 맵에 넣고 참가자를 넣으며 비교하는 것이 좋겠다는
//생각을 했으며, 또한 그렇게 된다면 해시맵은 완주자 단 한개만 필요하게 된다는 사실도 발견해낼 수 있어 addValue메소드를
//삭제하여 다시 solution메소드에 편입시켰다. 또한 완주에 실패한 사람은 단 한명이라는 조건이 있어 containsKey메소드를
//이용해 완주자 맵을 돌며 해당 키가 존재한다면 continue를, 그렇지 않다면 answer에 그 사람의 이름을 넣을 수 있도로 했다.
//마지막으로 정답을 찾게 되면 반복문을 지속할 이유가 없어지기 때문에 break를 통해 반복을 탈출하도록 했다.
//생각하지 않았던 문제는 동명이인이 발생했을 때 완주자 목록에 계속 존재하기 때문에 둘 다 완주처리가 된다는 사실을 알 수 있었다.
//이를 해결하고자 continue를 하기 전에 완주자 해시맵의 키를 줄이는 선택을 했다.
public class CantCompletionPlayer {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input1 = "", input2 = "";
		StringTokenizer st;
		int index = 0;
		
		try {
			input1 = br.readLine();
			st = new StringTokenizer(input1);
			String[] participant = new String[st.countTokens()];
			while (st.hasMoreTokens())
				participant[index++] = st.nextToken();
			
			index = 0;
			input2 = br.readLine();
			st = new StringTokenizer(input2);
			String[] completion = new String[st.countTokens()];
			while (st.hasMoreTokens())
				completion[index++] = st.nextToken();
			
			bw.write(solution(participant, completion));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> compl = new HashMap<>();
		
		for (String index : completion) {
			if (compl.containsKey(index))
				compl.put(index, compl.get(index) + 1);
			else
				compl.put(index, 1);
		}
		
		for (String index : participant) {
			if (compl.containsKey(index)) {
				if (compl.get(index) > 1)
					compl.put(index, compl.get(index) - 1);
				else
					compl.remove(index);
				
				continue;
			}
			answer = index;
			break;
		}
		
		return answer;
	}
}