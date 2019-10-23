import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-19
//백준 10818번 문제
//배열 내에서 최대값과 최소값을 찾는 문제
//코드를 작성하는 과정에서 배열을 사용할 필요가 없다는 사실을 찾아냈다.
//그래도 원하는 과정이 배열을 사용하는 것이였기 때문에 배열을 이용해 원하는 결과를 도출하기로 했다.
//최대값과 최소값을 배열 첫 번째 요소로 지정한 후 배열을 돌며 해당 값보다 작거나 큰 값이 존재할 경우
//원래 값에서 교체하는 방식으로 최대&최소값을 찾게 된다.
public class MaxNumAndMinNumInArray {
	static BufferedReader br;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int maxNum, minNum;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int numberAmount = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		if (st.countTokens() > numberAmount)
			System.exit(1);

		int index = 0;
		int[] resultArray = new int[numberAmount];
		
		while (st.hasMoreTokens())
			resultArray[index++] = Integer.parseInt(st.nextToken());
		
		checkNumber(resultArray);
		printResult();
	}
	
	static void checkNumber (int[] array) {
		maxNum = array[0];
		minNum = array[0];
		
		for (int i : array) {
			if (i > maxNum)
				maxNum = i;
			if (i < minNum)
				minNum = i;
		}
	}
	
	static void printResult() throws Exception {
		bw.write(minNum + " " + maxNum);
		bw.close();
	}
}