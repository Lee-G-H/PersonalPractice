package HashProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

//2019-09-30
//서로 다른 옷을 매칭해 위장을 수행하는 프로그램
//스파이는 매번 다른 옷 조합을 입는다. 옷 종류가 주어지면 서로 다른 옷 조합의 수를 반환할 수 있도록 해야 한다.
//해시 맵을 사용하기로 결정했으며 이차원 배열에서 옷 종류 부분은 값으로, 옷 이름들은 키로써 저장하도록 계획을 세웠다.
//예시 문제에서 입력값은 String형태의 이차원배열이기 때문에 동적으로 저장이 불가해 부득이하게 추가적으로 입력되는
//옷들의 수를 표현하는 변수를 추가했다.
//순열을 이용해 푸는 경우의 수라는 판단을 하였고, headgear 2개와 eyewear 1개일 경우 5가 반환되는 것이
//H, H, E, HE, HE의 다섯가지이며 HH는 제외한 경우라는 것을 알 수 있었다.
//이를 통해  3C1 + (2C1 * 1C1)처럼 옷 종류가 하나씩 증가할 때마다 위와 같은 계산식을 사용하면 답이 도출됨을 알게 되었다.
//생각보다 도출한 결과를 코딩할 방법에 대한 아이디어가 쉽게 떠오르지 않았다. 이는 해시맵을 사용한 경험이 적은 탓이라 생각하고
//여러 방법을 생각해본 결과 String, Integer형을 통해 옷 종류, 그 종류에 해당하는 옷 수를 각각 키와 값으로 저장한 후 
//keySet()메소드를 이용해 반복문을 돌며 옷 종류+1을 각각 곱하며 아무것도 입지 않은 한 가지 경우를 제거하여 문제에 대한
//해답을 도출하는데 성공했다.
public class Camouflage {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		int number = 0;
		
		try {
			number = Integer.parseInt(br.readLine());
			String input;
			String[][] clothes = new String[number][2];
			
			for (int i = 0; i < number; i++) {
				input = br.readLine();
				st = new StringTokenizer(input);
				for (int j = 0; j < 2; j++) {
					clothes[i][j] = st.nextToken();
				}
			}
			
			bw.write(String.valueOf(solution(clothes)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static int solution(String[][] clothes) {		
		HashMap<String, Integer> map = new HashMap<>();
		int count = 1;
		
		for (int i = 0; i < clothes.length; i++) {
			if (map.get(clothes[i][1]) != null)
				map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
			else
				map.put(clothes[i][1], 1);
		}

		for (String key : map.keySet()) {
			int value = map.get(key);
			
			count *= (value + 1); 
		}
		
		return count - 1;
	}
}
