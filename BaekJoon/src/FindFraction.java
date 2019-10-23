import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-09-28
//백준 1193번 문제
//무한히 큰 배열에서 입력된 순서에 존재하는 분수를 반환하는 프로그램.
//분모와 분수가 있으며 지그재그로 배열이 진행된다.(ex> 1/1->1/2->2/1->3/1...)
//반복을 진행하기 전에 미리 해당 순서가 존재하는 위치 근처까지 한 번에 갈 수 있을 방법에
//대해 고민해봤지만 쉽사리 떠오르지 않았다. 하여 더 쉬운 접근인 while을 통해 문제를 해결햇으며,
//flag변수를 선언해 지그재그에 대한 조건을 쉽게 파악할 수 있도록 했다.
//최종적으로 count와 input의 값이 같아지면 반복이 빠져나가며 그 당시의 분모, 분자값을 반환해준다.
public class FindFraction {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		
		try {
			input = Integer.parseInt(br.readLine());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String result = solveProblem(input);
		printResult(result);
	}
	
	static String solveProblem(int input) {
		int upper = 1, lower = 1;
		int count = 1, flag = 0;
		
		while (count < input) {
			count++;
			if (flag == 0) {
				if (upper == 1) {
					lower++;
					flag = 1;
					continue;
				}
				upper--;
				lower++;
			} else {
				if (lower == 1) {
					upper++;
					flag = 0;
					continue;
				}
				upper++;
				lower--;
			}
		}
		
		return upper + "/" + lower;
	}
	
	static void printResult(String result) {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			bw.write(result);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}