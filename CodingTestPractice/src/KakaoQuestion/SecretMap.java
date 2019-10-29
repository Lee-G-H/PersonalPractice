package Kakao;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//2019-10-29
//카카오 비밀지도 문제
//정수 배열 두개가 주어졌을 때 암호를 해독한 지도를 배열로 반환하는 문제
//입력값이 10진수로 이루어져있기 때문에 2진수로 변환하며 양 배열의 각 요소를 and연산해야 한다.
//배열을 그대로 둔 상태로 이진수로 변환 후 결과를 다시 해당 인덱스에 넣어주는 아이디어를 채택했다.
//하지만 코딩 과정에서 이진수를 쉽게 비교하기 위해서는 문자열로 만들어주는 것이 좋다는 것을 알게 되어
//별개의 문자열 배열 두 개를 추가적으로 선언하기로 계획을 변경했다.
//두 배열을 이진수로 만드는 과정은 절차가 거울을 보듯 똑같았기 때문에 별도의 메소드를 만들어 중복을 제거해봤다.
//다 작성 후 시험 운용시 이진수의 길이가 6일 경우 ArrayIndexOutOfBoundException이 발생했는데, 이는 입력 정수에 따라 결과
//이진수의 길이가 5이상이 될 수 있는데도 이진수 변환 메소드에서 길이 제한을 5로 두어 발생한 문제였음을 금새 알아냈다.
public class SecretMap {
    public static void main(String[] args) {
        init();
    }

    static void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = 0;
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            while (st.hasMoreTokens())
                arr1[index++] = Integer.parseInt(st.nextToken());

            index = 0;
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens())
                arr2[index++] = Integer.parseInt(st.nextToken());

            bw.write(Arrays.toString(solution(n, arr1, arr2)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] resultArray = new String[n];
        String[] stringArr1 = new String[n];
        String[] stringArr2 = new String[n];

        convertBinaryString(stringArr1, arr1, n);
        convertBinaryString(stringArr2, arr2, n);

        for (int i = 0; i < n; i++) {
            resultArray[i] = "";

            for (int j = 0; j < n; j++) {
                int comp1 = stringArr1[i].charAt(j) - '0';
                int comp2 = stringArr2[i].charAt(j) - '0';

                if (comp1 == 0 && comp2 == 0)
                    resultArray[i] += " ";
                else
                    resultArray[i] += "#";
            }
        }

        return resultArray;
    }

    static String[] convertBinaryString(String[] stringArr, int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            String comp = Integer.toBinaryString(arr[i]);
            stringArr[i] = "";

            for (int j = n; j > comp.length(); j--)
                stringArr[i] += "0";

            stringArr[i] += comp;
        }

        return stringArr;
    }
}
