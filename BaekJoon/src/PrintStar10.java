import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//2019-06-09
//별 그리기 프로그램
//중간 중간에 빈칸을 넣어줘야 했기 때문에 어떤 식으로 빈칸을 부여해야 할 지 고민하였다.
//패턴을 분석해보았더니 1, 3, 4, 5, 7,...등의 좌표에서 빈칸을 확인할 수 있었다.
//이를 통해 빈칸이 나올 조건은 해당 좌표를 3으로 나눈 몫이 1이거나 3으로 나눈 나머지가 1일 때라는 것을
//확인할 수 있었고, 이를 적용하여 문제를 해결하게 되었다.
public class PrintStar10 {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws Exception {
		init();
	}
	
	static void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write("숫자를 입력해주세요(3의 n제곱만 허용) : ");
		bw.flush();
		
		int inputNumber = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < inputNumber; i++) {
			for (int j = 0; j < inputNumber; j++) {
				print(i, j);
			}
			bw.write("\n");
		}

		bw.close();
	}
	
	static void print(int x, int y) throws Exception {
		while (x > 0) {
			if (x % 3 == 1 && y % 3 == 1) {
				bw.write(" ");
				return;
			}
			x /= 3;
			y /= 3;
		}
		bw.write("*");
	}
}
