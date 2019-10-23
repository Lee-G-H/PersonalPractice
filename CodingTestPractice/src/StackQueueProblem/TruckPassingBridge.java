package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//2019-10-01
//�ٸ��� ������ Ʈ������ �� ���ʰɷ� ���� �ǳ� �� ������ ���ϴ� ���α׷�
//ť�� �̿��� ������ Ǯ���� �䱸�ϴ� ������.
//ť�� ��ũ�� ����Ʈ�� Ȱ���� ������ �ذ��Ϸ� �Ͽ��µ� �� Ʈ���� �ٸ� ���� ���¸� Ȯ���� �� ��� �ؾ� �� �� ����� ���̵Ǿ���.
//ť�� Ȱ���� ������ �þ ���� ������ ������ ��Ȯ�ϰ� � ������� ť�� Ȱ���ؾ� �� �� ���� �� ���� �ʾҰ�,
//���� �θ� ���̴� ����� Queue-LinkedList�� ���·� ������ �ذ��غ���� �Ͽ���.
//Ʈ���� �ٸ��� ���� �ϸ� ���� ���Կ� ������ �־� �� ���� ���ϰ� �ϴ� ���� �ݻ� �ذ��� �� �־�����,
//�� Ʈ���� ���� �ٸ� ���� �ð��� �־� ���� �ð��� �����ϴ� �ڵ忡 ���ؼ��� ���縮 �ش��� �������� �ʾҴ�.
//�ѵ��� ����� �غ� ��� ���� ����� �ð����� �ٸ� ���̰��� ���� ���� �߰����� �迭�� ������ �����ϴ� ����� ����ϸ�
//���� �ٸ� �ǳͽð����� ������ �� ���� ���̶� �����ߴ�. �ٸ����� Ʈ�� �ϳ��� �������� ������ �ش� Ʈ����ŭ�� �������� ���̸�
//���������� ������ �迭 �ε����� ���� �� ��� �ݺ��� �������� �� �� ����� ���� ��ȯ�ϵ��� �Ͽ� ������ �ذ��ߴ�.
public class TruckPassingBridge {
	public static void main(String[] args) {
		init();
	}
	
	static void init() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int bridgeLength = Integer.parseInt(br.readLine());
			int bridgeWeight = Integer.parseInt(br.readLine());
			String truckInput = br.readLine();
			StringTokenizer st = new StringTokenizer(truckInput);
			int index = 0;
			int[] truckWeights = new int[st.countTokens()];
			
			while (st.hasMoreTokens())
				truckWeights[index++] = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(solution(bridgeLength, bridgeWeight, truckWeights)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int solution(int bridgeLength, int weight, int[] truckWeights) {
		int time = 0, truckNum = 0, sum = 0, index = 0;
		Queue<Integer> cross = new LinkedList<>();
		int[] timer = new int[truckWeights.length];
		
		while (true) {
			time++;
			
			if (timer[index] == time) {
				sum -= cross.peek();
				cross.poll();
				index++;
			}
			
			if (truckNum < truckWeights.length) {
				if (sum + truckWeights[truckNum] <= weight) {
					cross.offer(truckWeights[truckNum]);
					sum += truckWeights[truckNum];
					timer[truckNum++] = time + bridgeLength;
				}
			}
			
			if (timer[truckWeights.length - 1] != 0)
				break;
		}
		
		return timer[truckWeights.length - 1];
	}
}
