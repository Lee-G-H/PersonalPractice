package ETC;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//2019-12-05
//문자열을 임의의 인덱스 기준으로 오름차순하는 문제
//특정 문자열 배열과 구분할 인덱스값을 입력한 후 해당 기준에 맞춰 배열을 정렬하는 문제다.
//같은 문자일 경우 가장 앞 문자부터 비교하며 사전기준으로 문자열을 배열하게 된다.
//반복문을 사용해 문제를 해결했다.
//조건문을 통해 조건을 분기하는 것이 복잡하여 어느정도의 시간을 잡아먹었지만 기술적으로 어려운 문제는 아니었다.
public class SortStringsAtWill {
    public static void main(String[] args) {
        init();
    }

    static void init() {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] strings = new String[st.countTokens()];
            int index = 0;
            int n = Integer.parseInt(br.readLine());

            while (st.hasMoreTokens())
                strings[index++] = st.nextToken().toLowerCase();

            bw.write(Arrays.toString(solution(strings, n)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String[] solution(String[] strings, int n) {
        int length = strings.length;
        int index = 0;

        while (index < length) {
            for (int i = index + 1; i < length; i++) {
                char comp = strings[index].charAt(n);
                if (comp > strings[i].charAt(n)) {
                    swap(strings, index, i);
                    i = index + 1;
                } else if (comp == strings[i].charAt(n)) {
                    for (int j = 0; j < strings[index].length(); j++) {
                        comp = strings[index].charAt(j);
                        char comp2 = strings[i].charAt(j);
                        if (comp > strings[i].charAt(j) || j == strings[i].length()) {
                            swap(strings, index, i);
                            break;
                        } else if (comp < strings[i].charAt(j))
                            break;
                    }
                }
            }

            index++;
        }

        return strings;
    }

    static void swap(String[] array, int n1, int n2) {
        String comp = array[n1];
        array[n1] = array[n2];
        array[n2] = comp;
    }
}
