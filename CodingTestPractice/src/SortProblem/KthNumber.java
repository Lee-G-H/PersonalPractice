package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//2019-10-12
//입력된 배열에서 k번째 수를 찾는 문제
//요구하는 문제는 입력된 배열 자체가 아닌 정렬된 상태에서 원하는 수를 찾고자 하기 때문에 배열을 정렬시켜준다.
//정렬하되 일단 요구하는 인덱스들 범위에 따라 기준 배열을 자른 후 정렬을 수행하기 때문에 자르기 전 정렬을 먼저시키면 원하는
//값이 나오지 않는다. 그렇기 때문에 우선 연결리스트를 선언 후 조건에 맞춰 list에 더해준다. 그 후 Collection의
//sort()메소드를 통해 정렬해주고 그 결과물에서 원하는 값을 결과 배열에 추가시켜준다.
//모든 과정이 끝날 때마다 clear()메소드를 사용해 리스트를 비워줘야 이전 결과값과 섞이지 않고 깔끔한 결과를 얻어낼 수 있다.
public class KthNumber {
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
			int[] array = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				array[index++] = Integer.parseInt(st.nextToken());
			
			input = br.readLine();
			st = new StringTokenizer(input);
			index = 0;
			int[][] commands = new int[st.countTokens() / 3][3];

			for (int i = 0; i < commands.length; i++)
				for (int j = 0; j < 3; j++)
					commands[i][j] = Integer.parseInt(st.nextToken());
			
			bw.write(Arrays.toString(solution(array, commands)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int[] solution(int[] array, int[][] commands) {
		ArrayList<Integer> list = new ArrayList<>();
		int[] resultArray = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			for (int j = commands[i][0] - 1; j < commands[i][1]; j++)
				list.add(array[j]);
			
			Collections.sort(list);
			resultArray[i] = list.get(commands[i][2] - 1);
			list.clear();
		}
		
		return resultArray;
	}
}
