package GreedyProblem;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

//2019-10-21
//총 몇명이 체육복을 입고 체육수업을 들을 수 있을지 그 수를 찾는 문제
//첫 배열에는 잃어버린 학생의 번호를, 두 번째 배열에는 여분의 체육복이 있는 학생의 번호를 입력한다.
//번호는 키순으로 되어있으며 키가 더 큰 학생의 체육복만 빌려입을 수 있다.
//첫 번째 배열은 연결리스트로, 두 번째 배열은 스택을 통해 문제를 풀기로 결정했다.
//문제를 해결하는 것은 쉬웠으나 또다시 문제를 완벽하게 읽지 않아 오류가 발생했다.
//모든 학생이 전부 여분이 있거나 체육복이 없는 사람이 아니라 여분없이 그냥 가져온 학생도 있다는 조건을 확인하지 못했다.
//다시 문제를 발견했는데 처음 비교한 연결리스트의 요소가 스택값보다 클 경우 다음 요소를 비교해보지 않고 그냥 끝내는 것이었다.
//이를 위해서 연결리스트 내부를 확인하며 스택값보다 작은 요소가 있다면 해당 요소를 빼주며 count를 증가시켜주는 방식을 사용했다.
//문제에서 정확하게 제시되지 않았던 부분이 있었던 것 같다. 두 요소 중 같은 학생이 여벌이 있음과 동시에 도난을 당한다면
//그 학생은 본인의 옷을 그냥 입으며 두 그룹에서 사라진다는 조건이다. 이를 확인해보기 위해 추가적인 코드를 작성했다.
//두 배열을 연결리스트와 스택에 넣기 전에 비교하기 위해서는 결국 이중 반복문이 필요해 효율이 그닥 좋지는 않다는 판단을 했다.
//결론적으로는 둘 모두 연결리스트로 만들었으며 여분을 가진 학생을 연결리스트에 등록하는 과정에서 해당 학생의 번호가 잃어버린
//학생 번호에도 존재한다면 둘 모두 빼는 것으로 처리하고자 했다.
//결국 나는 또다시 문제를 제대로 이해하지 못했음을 알게 되었다. 바보같게도 잃어버린 학생들은 바로 앞이나 뒤 학생에게서만 빌릴
//수 있다는 조건과 또한 앞번호는 빌릴 수 없다는 것이 아니라는 조건을 제대로 숙지하지 못했던 것이다.
//코드를 전면 수정할 필요성을 느꼈다. 세 번째 리뉴얼이었다. 이번 아이디어는 초기에 여분을 가짐과 동시에 도난당한 학생은
//지워버린 후 남은 도난당한 학생들을 기준으로 쭉 비교하기로 결정했다. 이때 반복을 무의미하게 반복하는 것을 방지하고자
//두 학생의 차가 -3을 넘어가면 다음 학생으로 넘어가도록 조치했다.
//무조건 오름차순으로 입력받았다는 보장이 없기 때문에 메소드 초반에 두 배열을 각각 sort메소드로 정렬해주는 과정을 거치고 나자
//모든 예시가 다 맞았다는 결과를 얻을 수 있게 되었다.
public class GymSuit {
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
            int[] lost = new int[st.countTokens()];

            while (st.hasMoreTokens())
                lost[index++] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            index = 0;
            int[] reserve = new int[st.countTokens()];

            while (st.hasMoreTokens())
                reserve[index++] = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(solution(n, lost, reserve)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        LinkedList<Integer> lostList = new LinkedList<>();
        LinkedList<Integer> reserveList = new LinkedList<>();

        for (int i : lost)
            lostList.add(i);

        //여벌의 체육복을 가져온 학생의 체육복이 도난당했을 경우 스스로의 체육복을 바로 사용함
        for (int i : reserve) {
            if (lostList.indexOf(i) != -1) {
                lostList.remove((Integer) i);
                continue;
            }

            reserveList.add(i);
        }

        int count = n - lostList.size();

        for (int i : lostList) {
            for (int j : reserveList) {
                if (Math.abs(i - j) <= 1) {
                    count++;
                    reserveList.remove((Integer) j);
                    break;
                }

                //여분을 가진 학생을 전부 찾지 않고 근처만 찾을 수 있도록 조치
                if (i - j < -1)
                    break;
            }
        }

        return count;
    }
}
