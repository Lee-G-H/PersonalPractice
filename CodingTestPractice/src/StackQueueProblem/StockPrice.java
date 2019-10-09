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
//�ֽ��� ���� �������� ������ �迭�� �־��� �� �� �ε����� ���ݵ��� ���ʵ��� �������� �ʰ� �����Ǿ�������
//�迭�� ��ȯ�ϴ� ���α׷��̴�.
//�� ��ҵ��� ���������� ��޵Ǿ�� �ϱ� ������ ť�� �̿��� �� �պ��� ���ʴ�� ���ϱ�� ��ȹ�� ������.
//������ �� �� �غ��� ť�� �̿��Ѵٸ� ���� ��ҵ��� ��� �ҷ��� ���� ���� ����� �߻��Ѵٴ� ������ �߻��Ѵٴ� ����
//�˰� �Ǿ���. ���� ���� �ݺ����� ����Ѵٸ� �ݻ� Ǯ �� �������� ����������, �ش� �������� �����ϴ� ���ð� ť��
//����� ������ ȳ���ϰ� �;� ���� ����� �ߴ�.
//���� ������� �����غ� ��� ��ȸ�� �����ϱ� ������ ť�� ���ú��ٴ� ���� ����Ʈ�� �� ��︱ ���̶�� ����� ���ȴ�.
//���� ����Ʈ�� ���� �� get()�޼ҵ带 Ȱ���� �� ��Ҹ� �ҷ����� �ߴ�.
//ù �ڵ� �� �Է� �迭�� [1, 2, 3, 2, 3]���� �־����� ����ߴ� ���� �ƴ� [1. 2. 7. 2. 3]�� ���Դ�.
//������ �м��غ��� �� �� ���� �����ϴ� �κп��� �迭 ��ü�κе��� ���ذ� ���� ��� �迭�� �������� �ʰ�
//�ݺ��� �������� count���� ��µǾ��� ������ �߻��� ���������� �˰� �Ǿ���.
//�̸� �ذ��ϱ� ���� �ι�° �ݺ����� ���ǿ� �����ϰų� �������� �ʰ� �ݺ��� ���������� ��� ��� ������Ű�� ����
//�迭�� �����ϰ� count�� �ʱ�ȭ�ϴ� ������ �ݺ��� ��� ���� �� �����ϵ��� �����ߴ�.
//�̷��� ������ �� �ٽ� �ڵ带 �����غ��� �̹����� [4, 3, 0, 1, 0]�� ���� �ε��� 2�� ���� ������ ���� ����� ��Ÿ����.
//Ȯ�� ��� 1�� �ڿ� �ٷ� ���ذ� �� ��� 1�ʵ����� ���ذ� ���� �ʴ´ٰ� �����ؾ� �ϳ� count�� �ʱⰪ�� 1�� �����
//1�ʵ� ���� ���� ������ ó���Ǿ� ��Ÿ�� ���������� �� �� �־���. �̸� �ذ��ϱ� ���� �񱳸� ���� �ݺ����� �������� ���� �� 
//�ٷ� count�� 1������Ű�� ������� �����ϰ� �Ǿ���. �� ����� ����ϰ� �Ǹ� ������ �ε��������� ������ ���� ��
//�ִ� ���� �ε����� ���� 0�� ó���Ǵ� �ͱ��� �� ���� ���������� �� �ְ� �Ǿ� ��� ������ ���������� �� �ִٴ� ������
//�ִ�.
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