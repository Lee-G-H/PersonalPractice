package HashProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//2019=09=29
//전화번호 목록을 반환하는 프로그램
//앞 입력값의 접두사가 뒤 값들 중에 한군데라도 존재한다면 true를 반환하도록 해야 하는데 정확히 어떤 값을 이용해야 할 지 고민이
//많이 되는 상황이였다.
//처응에는 문자열로만 할 수도 있을거란 생각에 startsWith메소드를 사용해봤으나 오류가 발생했다.
//원인을 생각해보니 반복문을 한 번만 사용하여 comp변수를 변화시켜 바로 다음 문자열만 비교하고 문자열 배열 끝까지 검색하지 않아
//발생한 문제였음을 알게 되었다. 이를 보고 문자열로 단순히 해결은 불가하겠다는 판단이 들어 해시맵을 이용하는 방식으로 선회했다.
//String, String형으로 설정했으며 키데 대한 값을 비교하는 방식을 사용하고자 계획했다.
//다음으로는 첫 인덱스에서 바로 발견되는 불상사를 제거하기 위해 맵에 값을 추가한 후 제일 앞 요소를 remove하려 했으나
//그냥 인덱스 1부터 저장하면 된다는 것을 깨닫고 수정작업을 진행했다.
//해시를 이용할때도 이중반복을 사용해야 하나 고민을 했으나, 결국 해시맵을 어떻게 활용할지 영 감이 잡히지 않고 또한 
//테스트 8, 9번이 자꾸 틀리다는 결과를 낳아 다른 방식을 찾아보기로 결정했다. 생각을 거듭한 결과
//sort메소드를 활용해 미리 배열을 정렬해둔다면 바로 뒤 요소만 비교하면 되기 때문에 더 빠른 검색이 가능할 것이라는
//생각이 들었다. 해당 방식을 사용하여 재작성해보니 반복문도 한 번만 사용하게 되는 좋은 코드가 나오게 되었다.
public class PhoneNumberList {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		StringTokenizer st;
		int index = 0;
		
		try {
			input = br.readLine();
			st = new StringTokenizer(input);
			String[] phoneBook = new String[st.countTokens()];
			while (st.hasMoreTokens())
				phoneBook[index++] = st.nextToken();
			
			bw.write(String.valueOf(solution(phoneBook)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static boolean solution(String[] phoneBook) {
		Arrays.sort(phoneBook);
		
		for (int i = 1; i < phoneBook.length; i++)
			if (phoneBook[i].startsWith(phoneBook[i - 1]))
				return false;
		
		return true;
	}
}