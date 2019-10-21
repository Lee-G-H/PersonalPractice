package ExhaustiveSearchProblem;

import java.io.*;
import java.util.Arrays;

//2019-10-20
//카펫의 가로, 세로 길이를 반환하는 문제
//가로의 길이는 세로보다 작을 수 없다는 조건이 있으며 갈색은 빨강의 겉을 한겹 싸고있는 형태를 취한다.
//갈색과 빨강의 수를 합한 후 가로와 세로를 곱해 나올 수 있는 경우의 수들 중 가장 처음으로 가로보다 세로가 작아질 때를
//정답으로 선정하면 되겠다는 생각을 했다.
//처음에는 가로가 무한히 반복하며 세로의 길이를 찾아나가려 했지만 이보다는 세로의 길이를 무한히 줄이는 편이 더 좋을것이라는
//판단으로 둘의 순서를 바꿔주었다.
//두 번째 코딩을 수행한 후 첫 번째 테스트는 무사히 통과했지만 가로가 짝수일 때 홀수인 합의 값을 못 나누는 경우와 같을 때
//세로의 길이가 무한히 작아지는 문제를 발견했다. 이를 해결하기 위해 가로의 길이로 합을 나눌 수 있을 때까지 가로를 늘려주도록
//반복문을 설정했다. 하지만 여전히 무한루프가 발생했고, 이는 가로의 길이를 먼저 한 번 늘리지 않아 1인 상태를 유지하고 반복문의
//조건에 맞아 바로 빠져나간 것이 원인이였음을 알았다. 이를 해결하기 위해서는 또한 do while을 사용해 첫 번째 비교를 하기 전에
//반복문을 한 번 수행할 수 있도록 만들어주었다.
//검사 결과 2, 6, 7번 케이스에서 오류가 발생했다. 접근하는 방식은 올바른 것 같았는데도 틀린 상황이었다고 봤기 때문에 어떤 부분이
//정확하게 틀린 것인지 매우 궁금했지만 사이트 방침은 테스트케이스를 공개하지 않는 것이 원칙이었기 때문에 무척이나 답답했다.
//여러 코맨트들을 읽어보니 red에 대한 제약조건이 없을 경우 위 테스트케이스를 틀리게 된다는 사실을 알 수 있었고, 이에 따라
//아직 완전하게 문제를 이해하지 못했기 대문에 발생한 문제였음을 알게 되었다.
//나머지 케이스들을 해결하고자 규칙을 찾는 과정을 새로이 수행했다. 몇 가지 경우들을 직접 그려가며 빠진 조건에 대해 생각해보니
//내가 설정한 조건 외에도 가로-2*세로-2의 크기가 빨간색의 크기라는 것까지 조건에 포함시켜야 완벽한 코드가 완성될 수 있다는 것을
//알게 되었다.
public class Carpet {
    public static void main(String[] args) {
        init();
    }

    static void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            int brown = Integer.parseInt(br.readLine());
            int red = Integer.parseInt(br.readLine());

            bw.write(Arrays.toString(solution(brown, red)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int[] solution(int brown, int red) {
        int[] resultArray = new int[2];
        int sum = brown + red;
        int horizontal = 1;

        for (int vertical = sum;; vertical--) {
            if (horizontal * vertical == sum) {
                if (horizontal >= vertical && red == (horizontal - 2) * (vertical - 2)) {
                    resultArray[1] = vertical;
                    break;
                }

                do {
                    horizontal++;
                } while (sum % horizontal != 0);
            }
        }

        resultArray[0] = horizontal;

        return resultArray;
    }
}
