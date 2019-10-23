package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//adv버전과 이전 버전의 방향성은 비슷하나, 배열로 도착 시간을 표시했던 것과는 달리
//대기와 이동 모두 큐로 처리하여 온전히 큐로만 문제를 풀도록 하였다.
public class TruckPassingBridgeAdv {	
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
		Queue<Truck> wait = new LinkedList<>();
		Queue<Truck> cross = new LinkedList<>();
		
		for (int i : truckWeights)
			wait.offer(new Truck(i));
		
		int time = 0, currentWeight = 0;
		
		//대기큐나 진행큐 둘 중 하나에라도 트럭이 존재할 경우 계속 반복
		while (!wait.isEmpty() || !cross.isEmpty()) {
			time++;
			
			//현재 다리를 건너고 있는 트럭이 존재하지 않을 경우
			if (cross.isEmpty()) {
				Truck t = wait.poll();
				currentWeight += t.weight;
				cross.offer(t);
				continue;
			}
			
			//큐에 들어있는 모든 트럭 객체들을 한 칸씩 전진시킨다.
			for (Truck t : cross) 
				t.moving();
			
			if (cross.peek().move > bridgeLength) {
				Truck t = cross.poll();
				currentWeight -= t.weight; //t를 큐에서 꺼내더라도 객체를 선언해 weight를 볼 수 있다.
			}
			
			if (!wait.isEmpty() && currentWeight + wait.peek().weight <= weight) {
				Truck t = wait.poll();
				cross.offer(t);
				currentWeight += t.weight;
			}
			
		}
		
		return time;
	}
}

//각 트럭들을 객체화한다.
class Truck {
	int weight;
	int move;
	
	public Truck(int weight) {
		this.weight = weight;
		this.move = 1;
	}
	
	public void moving() {
		move++;
	}
}