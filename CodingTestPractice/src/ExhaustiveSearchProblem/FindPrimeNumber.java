package ExhaustiveSearchProblem;

import java.io.*;
import java.util.*;

//2019-10-19
//소수 찾기 문제
//입력된 문자열에 들어있는 숫자들을 재조합해 몇 개의 소수가 만들어질 수 있는지 구하는 문제
//문자열에 들어있는 숫자가 많아질 수록 점점 더 많은 경우의 수가 생겨나기 때문에 절대 간단하지 않은 문제라는 생각을 했다.
//실제로도 문자열 내에서 최소 1개부터 문자열 길이만큼의 크기까지 숫자를 생성해낼 수 있기 때문에 수많은 경우가 생겨나게 된다.
//생각 끝에 재귀함수를 활용해 문제를 풀어보는 방향으로 우선 결정했다.
//아무리 생각해봐도 재귀함수로 해결할만한 뾰족한 수가 생각나지 않았고 일단은 그냥 hashmap을 이용해 중복을 제거하겠다는 아이디어만
//우선 유지하기로 했다. 얼마간의 고민 끝에 입력된 숫자값들의 조합은 순열의 구조로 이루어질 수 있다는 것을 알 수 있었다.
//한동안 계속 입력값에서 숫자를 분류하는 방법에 대한 아이디어를 찾는데 고생을 했다. 여러 모로 고민한 후 일단 입력값으로 만들 수
//있는 가장 큰 수는 sort를 통해 내림차순으로 정렬하면 만들어진다는 사실을 발견할 수 있었다.
//이 후의 아이디어로는 해당 값 범위 내에서 존재하는 소수들 중에 주어진 숫자배열로 만들어지는 수들만 최종적으로 세면 어떨까 하는
//생각이 들었다.
//소수를 구하는 데에는 에라토스테네스의 접근법을 이용하기로 했다. 이 방식은 주어진 자연수 n이 있으면
//그 범위 내 소수의 값은 n의 제곱근보다 클 수 없다는 것이다.
//위 방식처럼 최대값을 두고 소수를 구하는 방식으로 했지만 고민이 되었던 것은 과연 이 방식이 초반에 생각했엇던 입력 배열로 만들
//수 있는 모든 숫자들을 각각 소수여부를 구하는 방식보다 더 효율적인지에 대한 것이었다.
//일단은 도출된 해결방안을 고수하기로 마음먹고 코딩을 진행하던 중 문제가 발생하게 되었는데. 소수임을 발견한 후 입력값에 해당
//소수를 비교하며 입력값을 이용해 그 소수를 만들어낼 수 있는지 비교하는 부분에서 ArrayList를 제거하게 되면 진짜 list에서도 함께
//지워져 이후의 비교연산에도 큰 영향을 미친다는 것을 발견해냈다.
//처음에는 배열을 통해 리스트를 복사하는 것이 어떨까 하는 아이디어를 생각해냈으나, 매 함수가 시작될 때마다 반복문을 돌며
//리스트를 복사하는 것과 또 다시 리스트를 반복문을 통해 복사해오는 것은 별로 큰 효율이 없지 않을까 하는 생각으로 이 아이디어를
//버리게 되었다. 다음 생각으로는 또다른 리스트를 만들어 거기에 복사해오는 것이었다. 이 또한 처음에는 반복문을 통해 순차적으로
//복사할 생각을 했으나, 리스트.addAll()메소드를 이용하면 한 번에 된다는, 나아가 아예 ArrayList를 선언할 당시에 바로 리스트를
//복사할 수 있다는 것을 알게 되었다.
//기본 테스트는 통과햇으나 2, 10, 11, 12번 테스트케이스에 부합하지 않는다는 결과를 받았다. 개인적인 생각으로는 아무래도 시간적
//효율이 떨어지기 때문이라는 생각이 들었고, 구현해보지 못했던 에라토스테네스의 체를 활용한다면 이를 해결할 수 있겠다는 생각을
//했다.
//결국 에라토스테네스의 체를 구현하고 나자 나머지 케이스들이 성공하게 되어 내가 알지 못했던 부분에서 소수값을 답안에 추가시킨
//케이스가 있었다는 것을 알 수 있었다.
public class FindPrimeNumber {
    public static void main(String[] args) {
        init();
    }

    static void init() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String numbers = br.readLine();

            bw.write(String.valueOf(solution(numbers)));
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int solution(String numbers) {
        int length = numbers.length(); //입력된 숫자의 길이를 측정

        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;

        ArrayList<Integer> numberList = new ArrayList<>(); //에라토스테네스를 구현하기 위한 리스트

        for (int i = 0; i < length; i++)
            list.add(numbers.charAt(i) - '0');

        list.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (Integer i : list)
            sb.append(i);

        int maxNum = Integer.parseInt(String.valueOf(sb));

        for (int i = 0; i <= maxNum; i++)
            numberList.add(i);

        for (int i = 2; i <= maxNum; i++) {
            if (numberList.get(i) == 1)
                continue;

            if (isPrime(i, maxNum, numberList) && compareToInput(i, list))
                count++;
        }

        return count;
    }

    static boolean isPrime(int number, int maxNum, ArrayList<Integer> numberList) {
        for (int i = 2; i < (int)Math.sqrt(number); i++)
            if (number % i == 0)
                return false;

        int index = number;

        for (int i = 2; index < maxNum; i++) {
            numberList.set(index, 1);
            index = number * i;
        }

        return true;
    }

    static boolean compareToInput(int number, ArrayList<Integer> list) {
        char[] comp = String.valueOf(number).toCharArray();
        ArrayList<Integer> spare = new ArrayList<>(list); //비교하며 list의 값 삭제시 이후에도 영향을 끼치는 현상 해결

        for (char c : comp) {
            int index = list.indexOf(c - '0');
            if (index != -1) {
                list.remove(index);
            } else {
                list.clear();
                list.addAll(spare);
                return false;
            }
        }

        list.clear();
        list.addAll(spare);
        return true;
    }
}
