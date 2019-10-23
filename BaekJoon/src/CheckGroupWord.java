import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-25
//백준 1316번 문제
//n개의 단어들을 입력받은 후 그룹 단어의 수를 찾는 프로그램
//그룹 단어란 단어를 구성하는 각 문자들이 각각 연속된 것이다
//ex) happy는 각 알파벳들이 전부 연속되기 때문에 그룹단어가 성립한다
//이 문제에서는 모든 단어가 소문자로 이루어져 있다고 가정한다 하지만 대문자를 입력하는 사용자가 있을 수 있기 때문에
//toLowerCase()메소드를 사용해 전부 소문자로 바꿔준다
//배열 내의 각 요소들을 어떤 방식으로 반복시켜야 할 지 감이 잘 오지 않아 한참을 고민했다
//아무리 고빈해봐도 for문은 최소한 2번정도 사용해야 해결이 가능하다 판단했으며 더 가독성과 효율을 좋게 하고자
//그룹 단어를 판별하는 함수를 따로 작성했다
//해당 함수 내에서는 알파벳 크기에 해당하는 논리형 배열을 선언 후 단어를 한바퀴 지나며 
//우선 현재 문자에 해당하는 배열 인덱스 요소값을 판단해 참이면 그룹 문자가 아닌 것으로 보고, 앞 문자와 다른 문자가 나올 때
//이전 문자에 해당하는 논리형 배열 인덱스의 값을 참으로 바꿔주는 방식으로 문제를 해결했다
public class CheckGroupWord {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = 0, result = 0;
		String input = "";
		
		try {
			number = Integer.parseInt(br.readLine());
			String[] inputArray = new String[number];
			
			for (int i = 0; i < number; i++) {
				input = br.readLine();
				input.toLowerCase();
				inputArray[i] = input;
			}
			
			result = countGroupWord(inputArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		printResult(result);
	}
	
	static int countGroupWord(String[] inputArray) {
		int count = 0;
		for (int i = 0; i < inputArray.length; i++) {
			if (checkWord(inputArray[i]))
				count++;
		}
		
		return count;
	}
	
	static boolean checkWord(String line) {
		boolean[] check = new boolean[26];
		
		for (int i = 1; i < line.length(); i++) {
			if (check[line.charAt(i) - 'a'])
				return false;
			if (line.charAt(i) != line.charAt(i - 1))
				check[line.charAt(i - 1) - 'a'] = true;
		}
		
		return true;
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