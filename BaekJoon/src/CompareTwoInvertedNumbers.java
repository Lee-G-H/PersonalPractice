import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//2019-09-25
//백준 2908번 문제
//0이 포함되지 않은 서로 다른 백의 자리 정수를 입력받은 후 백의 자리와 일의 자리를 바꾼 후 두 수를 비교하는 프로그램
//처음에는 두 수를 정수형으로 받아 문제풀이를 시작하려 했으나 수를 뒤집는 데 복잡한 과정이 생길 수도 있다는 생각이 들어
//String으로 둘을 저장 후 StringBuffer를 통해 reverse()메소드를 사용 후 정수형변환을 시키는 방법으로
//문제를 해결했다
//StringBuffer를 사용할 때는 이미 이전 수를 저장한 상태였기 때문에 이전에 저장한 수를 지우고 새로 저장해야 했는데
//이 때 delete()메소드에서 첫 번째 파라미터는 시작 인덱스, 두 번째 파라미터는 끝 파라미터+1을 해야 정상적으로
//모든 수가 삭제된다는 것을 알 수 있었다
public class CompareTwoInvertedNumbers {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input = "";
		String number1 = "", number2 = "";
		
		try {
			input = br.readLine();
			st = new StringTokenizer(input);
			number1 = st.nextToken();
			number2 = st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int result = compareNumbers(number1, number2);
		printResult(result);
	}
	
	static int compareNumbers(String number1, String number2) {
		StringBuffer sb = new StringBuffer();
		
		number1 = String.valueOf(sb.insert(0, number1).reverse());
		number2 = String.valueOf(sb.delete(0, 3).insert(0, number2).reverse());
		
		int comp1 = Integer.parseInt(number1);
		int comp2 = Integer.parseInt(number2);
		
		return comp1 > comp2 ? comp1 : comp2;
	}
	
	static void printResult(int result) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(String.valueOf(result));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
