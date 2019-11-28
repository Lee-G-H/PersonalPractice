package ETC;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//2019-11-28
//같은 숫자일 때는 1개로 압축해 배열로 반환하는 문제
//처음에는 중복을 제거하기만 하면 되는 간단한 문제라 생각해 set을 이용했으나 순서가 있고
//같은 숫자도 나올 수 있다는 사실을 알게 되어 ArrayList를 사용하기로 결정했다.
//범위는 0~9로 제한되어있기 때문에 절대 나올 수 없는 숫자인 -1을 변수로 초기화해두었다.
public class hateSameNumber {
    public static void main(String[] args) {
        init();
    }

    static void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[st.countTokens()];
            int index = 0;

            while (st.hasMoreTokens())
                arr[index++] = Integer.parseInt(st.nextToken());

            bw.write(Arrays.toString(solution(arr)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int comp = -1;

        for (int i : arr) {
            if (comp != i)
                list.add(i);
            comp = i;
        }

        int[] resultArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
            resultArray[i] = list.get(i);

        return resultArray;
    }
}
