package ETC;

import java.io.*;

//2019-12-05
//문자열 내에서 P와 Y의 개수를 비교해 개수가 일치하는지를 판별하는 문제
//대소문자를 구분하지 않는다고 했으나 쉬운 비교를 위해 toLowerCase()메소드를 활용해 전부 소문자로 치환했다.
//그 후 문자열을 돌며 count의 개수를 확인하여 같으면 참, 아니면 거짓을 반환하도록 했다.
public class ComparePandY {
    public static void main(String[] args) {
        init();
    }

    static void init() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = br.readLine();

            bw.write(String.valueOf(solution(s)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static boolean solution(String s) {
        s = s.toLowerCase();
        int count1 = 0, count2 = 0;

        for (int i = 0; i < s.length(); i++) {
            char comp = s.charAt(i);

            if (comp == 112)
                count1++;

            if (comp == 121)
                count2++;
        }

        return count1 == count2;
    }
}
