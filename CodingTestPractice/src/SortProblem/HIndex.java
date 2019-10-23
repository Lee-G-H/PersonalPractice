package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

//2019-10-13
//입력된 정수 배열에 대한 H-Index를 구하는 문제
//H-Index는 n개의 논문 중 h번 인용된 논문이 h개 있을 때 h가 답이 되는 것이다.
//처음에는 반복을 돌며 left의 값이 right의 값보다 커질 당시의 left-1인덱스 값을 HIndex로 하면 되겠다 생각했으나
//예시 케이스만 맞고 나머지는 전부 틀리는 문제가 발생했다.
//문제에 대한 이해가 완전하지 않아 생긴 문제라 판단하고 다시 제대로 H-Index에 대해 공부를 해보았다. 그 결과
//특정 연구자의 논문을 인용된 횟수가 많은 순으로 정렬 후 순위와 인용된 수가 같아지거나 순위가 인용된 수보다 작은
//최대값이 구하고자 하는 h라는 사실을 알 수 있었다.
//계속 구현을 시도해도 문제에 오류가 자꾸 발생했다. 아무래도 완전한 문제 이해가 부족하다는 생각이 들어 더 많은
//연구를 했고, 그 결과 인덱스 값보다 해당 요소값이 더 작을 때 당시의 인덱스가 답임을 알게 되었다.
//계획대로 코딩을 진행한 후 테스트해본 결과 9번 케이스만이 오류가 발생했다. 이를 확인 후 원인을 분석해보았고
//배열의 길이보다 입력값의 최소값이 더 크거나 같을 경우 해당 배열의 길이가 답이 되지 않는 문제가 있었다.
//이를 위해 조건문을 하나 더 추가해주며 문제를 해결했다.
public class HIndex {
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
			int[] citations = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				citations[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(solution(citations)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int solution(int[] citations) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i : citations)
			list.add(i);
		
		list.sort(Comparator.reverseOrder());
		int comp, hIndex = 1, count;
		
		if (list.get(0) == 0)
			return 0;
		
		if (list.get(list.size() - 1) >= list.size())
			return list.size();
		
		for (int i = 0; i < list.size(); i++) {
			comp = list.get(i);

			if (i >= comp) {
				hIndex = i;
				break;
			}
		}
		
		return hIndex;
	}
}