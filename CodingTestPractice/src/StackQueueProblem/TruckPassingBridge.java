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
//다리를 지나는 트럭들이 총 몇초걸려 전부 건널 수 있을지 구하는 프로그램
//큐를 이용해 문제를 풀도록 요구하는 문제다.
//큐와 링크드 리스트를 활용해 문제를 해결하려 하였는데 각 트럭당 다리 현재 상태를 확인할 때 어떻게 해야 할 지 고민이 많이되었다.
//큐를 활용해 문제를 플어본 적은 없었기 때문에 정확하게 어떤 방식으로 큐를 활용해야 할 지 감이 잘 오지 않았고,
//가장 널리 쓰이는 방식인 Queue-LinkedList의 형태로 문제를 해결해보기로 하였다.
//트럭을 다리에 들어가게 하며 또한 무게에 제한을 주어 더 들어가지 못하게 하는 것은 금새 해결할 수 있었지만,
//각 트럭당 서로 다른 진입 시간을 주어 나간 시간을 추측하는 코드에 대해서는 쉽사리 해답이 떠오르지 않았다.
//한동안 고민을 해본 결과 진입 당시의 시간값과 다리 길이값을 더한 값을 추가적인 배열을 생성해 저장하는 방식을 사용하면
//서로 다른 건넌시간들을 구별할 수 있을 것이라 생각했다. 다리에서 트럭 하나가 빠져나갈 때마다 해당 트럭만큼의 무게합을 줄이며
//최종적으로 마지막 배열 인덱스에 값이 들어갈 경우 반복을 나오도록 해 그 요소의 값을 반환하도록 하여 문제를 해결했다.
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
