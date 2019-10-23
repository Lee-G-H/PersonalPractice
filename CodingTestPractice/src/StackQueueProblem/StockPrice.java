package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//2019-10-09
//주식의 가격 변동폭이 정수형 배열로 주어질 때 각 인덱스의 가격들은 몇초동안 떨어지지 않고 유지되었는지를
//배열로 반환하는 프로그램이다.
//각 요소들은 독자적으로 취급되어야 하기 때문에 큐를 이용해 맨 앞부터 차례대로 비교하기로 계획을 세웠다.
//생각을 좀 더 해보니 큐를 이용한다면 다음 요소들은 어떻게 불러올 지에 대한 고민이 발생한다는 문제가 발생한다는 것을
//알게 되었다. 물론 이중 반복문을 사용한다면 금새 풀 수 있을법한 문제였지만, 해당 문제에서 권장하는 스택과 큐를
//사용해 문제를 홰결하고 싶어 많은 고민을 했다.
//여러 방면으로 생각해본 결과 조회를 수행하기 때문에 큐나 스택보다는 연결 리스트가 더 어울릴 것이라는 결론을 내렸다.
//연결 리스트에 저장 후 get()메소드를 활용해 각 요소를 불러오게 했다.
//첫 코딩 후 입력 배열을 [1, 2, 3, 2, 3]으로 주었더니 기대했던 값이 아닌 [1. 2. 7. 2. 3]이 나왔다.
//원인을 분석해보니 비교 후 값을 대입하는 부분에서 배열 전체부분동안 손해가 없을 경우 배열에 저장하지 않고
//반복을 빠져나와 count값이 계승되었기 때문에 발생한 문제였음을 알게 되었다.
//이를 해결하기 위해 두번째 반복에서 조건에 부합하거나 부합하지 않고 반복을 빠져나왔을 경우 모두 만족시키기 위해
//배열에 저장하고 count를 초기화하는 과정을 반복이 모두 끝난 후 진행하도록 수정했다.
//이렇게 진행한 후 다시 코드를 실행해보니 이번에는 [4, 3, 0, 1, 0]이 나와 인덱스 2의 값이 원하지 않은 결과가 나타났다.
//확인 결과 1초 뒤에 바로 손해가 날 경우 1초동안은 손해가 나지 않는다고 간주해야 하나 count의 초기값이 1인 관계로
//1초도 유지 못한 것으로 처리되어 나타난 문제였음을 알 수 있었다. 이를 해결하기 위해 비교를 위한 반복문의 루프마다 진입 후 
//바로 count를 1증가시키는 방식으로 수정하게 되었다. 이 방식을 사용하게 되면 마지막 인덱스에서의 가격을 비교할 수
//있는 다음 인덱스가 없어 0초 처리되는 것까지 한 번에 충족시켜줄 수 있게 되어 모든 조건을 만족시켜줄 수 있다는 장점이
//있다.
public class StockPrice {
   public static void main(String[] args) {
      init();
   }
   
   static void init() {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      try {
         String input = br.readLine();
         StringTokenizer st = new StringTokenizer(input);
         int index = 0;
         int[] prices = new int[st.countTokens()];
         
         while (st.hasMoreTokens())
            prices[index++] = Integer.parseInt(st.nextToken());
         
         bw.write(Arrays.toString(solution(prices)));
         bw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   static int[] solution(int[] prices) {
      ArrayList<Integer> list = new ArrayList<>();
      int count = 0;
      
      for (int i : prices)
         list.add(i);
      
      for (int i = 0; i < list.size(); i++) {
         int comp = list.get(i);
         
         for (int j = i + 1; j < list.size(); j++) {
            count++;
            if (comp > list.get(j)) 
               break;
         }
         
         prices[i] = count;
         count = 0;
      }
      
      return prices;
   }
}