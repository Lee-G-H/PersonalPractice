package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//2019-10-12
//주어진 숫자 배열에서 조합을 통해 가장 큰 수를 찾아야 하는 문제
//처음에는 여러 경우의 수를 전부 찾아야 하는 문제라 생각했지만 조금 더 생각해보니
//각 배열의 요소들을 비교하며 가장 큰 자리수의 크기를 비교해 오름차순으로 붙이면 끝나는 문제였다.
//그냥 Comparator.reverseOrder()메소드를 사용하게 될 경우 9보다 10이 더 크다는 결론이 나와 원하는 결과가 나타나지 않는다.
//여러 방안을 생각해봤지만 역시 가장 편한 방법은 문자열로 변환해 비교하는 것이라는 판단을 했다.
//생각해보니 ArrayList에 정렬을 할때 앞자리만 비교하더라도 결국 저장을 한다면 원래 숫자를 다시 불러올 방법을 생각해야만 한다는 것을
//알게 되었다. 이를 해결하기 위해서 ArrayList를 하나 더 선언해야 수월하겠다는 판단을 했고, 이 변수에는
//가장 큰 자리수만이 아닌 원래의 수를 저장하도록 해주었다.
//코드를 검증하던 중 또다른 문제가 발생했다. 3, 30, 34와 같은 경우 다 같은 3이기 때문에 3으로 뭉뚱그려져 원하는 결과가
//제대로 나오지 않는 것이였다. 이 현상의 원인은 인덱스값을 비교할 때 list에서 비교를 수행해 3이 이미 있기 대문에 넘어가 발생한 것이였다.
//이를 해결하고자 해당 경우 다음 자리수가 있을 경우 다음 자리수를 비교할 수 있도록 했으며 fullList의 값을 비교해 넘어가는 일이 없도록 했다.
//문제에서의 제약사항으로 각 숫자의 자리수는 최대 1000이라 했기 때문에 최대 1000까지만 생각하면 된다는 것을 알게 되었고 이에 따른
//코드의 수정이 뒤따랐다. 이론상 같은 자리수의 값이 같다면 그 다음수와, 다음수가 없다면 가장 작은 수와 비교할 다음수를 비교하면 된다.
//하지만 어떤 식으로 구현을 진행해야 할 지 감이 쉽게 잡히지 않았다.
//오랜 고민 결과 추가적인 반복문을 통해 charAt()메소드로 다음 자리수를 찾아가기로 결정했다. 그 결과 3과 30을 비교할 때 
//3의 다음 charAt값이 1이 되어 3과 30의 비교를 무사히 수행할 수 있게 되었다.
//테스트 결과 나머지 테스트들이 전부 틀리게 된 문제를 새로이 발견했는데 이를 확인해보니 StringIndexOutOfBoundException이
//발생해 틀렸다는 것을 알 수 있었다. 이는 9와 같이 한자리수만 있는데 다음 자리수를 찾고자 하여 발생한 문제였고, 이를 해결하고자
//문자열의 길이가 적당할 경우에만 진행하도록 수정을 했다.
//계속된 오류에 너무 한 방법에만 매몰되는 것은 좋지 않다 생각해 머리를 비우는 시간을 가진 후 쉬워보이는 문자열만을 활용하는 방법을
//사용하기로 결정했다.
//문자열로만 하기로 한 후에는 훨씬 더 수월하게 코딩이 진행되었다. comparator을 활용하여 compareTo메소드를 재정의하고
//뒤 문자열이 앞 문자열보다 클 경우 1을, 앞이 뒤보다 클 경우 -1을, 같을 경우 0을 반환하는 방식으로 순서를 잡았다.
public class TheBiggestNumber {
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
			int[] numbers = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				numbers[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(solution(numbers));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static String solution(int[] numbers) {
		String result = "";
		String[] sArray = new String[numbers.length];

		for (int i = 0; i < numbers.length; i++)
			sArray[i] = String.valueOf(numbers[i]);
		
		//큰 수부터 내림차순으로 구성된다.
		Arrays.sort(sArray, new Comparator<String> () {
			@Override
			public int compare(String s1, String s2) {
				return (s2 + s1).compareTo(s1 + s2);
			}
		});
		
		if (sArray[0].equals("0"))
			return "0";
		
		for (String s : sArray)
			result += s;
		
		return result;
	}
}
