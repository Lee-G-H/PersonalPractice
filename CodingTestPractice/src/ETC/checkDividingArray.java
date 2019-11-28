package ETC;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//2019-11-28
//주어진 배열에서 특정 숫자에 나누어 떨어지는 요소를 찾는 문제
//ArrayList를 활용하면 간단하게 구해진다.
public class checkDividingArray {
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

            int divisor = Integer.parseInt(br.readLine());

            bw.write(Arrays.toString(solution(arr, divisor)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] resultArray;

        for (int i : arr)
            if (i % divisor == 0)
                list.add(i);

        if (list.size() == 0)
            return resultArray = new int[]{-1};

        Collections.sort(list);
        resultArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
            resultArray[i] = list.get(i);

        return resultArray;
    }

    //lambda를 통해 한 줄로 깔끔하게 마무리가 가능하다는 것을 배웠다.
    static int[] advSolution(int[] arr, int divisor) {
        return Arrays.stream(arr).filter(value -> value % divisor == 0).sorted().toArray();
    }
}
