package StringProblem;

import java.io.*;

//2019-11-27
//문자열을 입력받은 후 가장 가운데 문자를 반환하는 문제
//만일 문자열이 짝수라면 가운데 2개 문자를 반환해야 한다.
//문자열 길이에 2를 나누어 남은 값이 1이라면 홀수이기 때문에 길이의 절반인덱스의 char값을 반환하도록 했다.
//위 조건에 만족하지 않는다면 짝수임을 의미하기 때문에 중간 두개의 문자를 substring()메소드를 통해 찾아 반환하도록 했다.
public class getCenterCharacter {
    public static void main(String[] args) {
        init();
    }

    static void init() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = br.readLine();

            bw.write(solution(s));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String solution(String s) {
        int length = s.length() / 2;

        if (s.length() % 2 == 1)
            return String.valueOf(s.charAt(length));
        return s.substring(length - 1, length + 1);
    }
}
