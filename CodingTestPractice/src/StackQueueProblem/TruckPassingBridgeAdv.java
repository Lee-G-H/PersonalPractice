package StackQueueProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//adv������ ���� ������ ���⼺�� ����ϳ�, �迭�� ���� �ð��� ǥ���ߴ� �Ͱ��� �޸�
//���� �̵� ��� ť�� ó���Ͽ� ������ ť�θ� ������ Ǯ���� �Ͽ���.
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
		
		//���ť�� ����ť �� �� �ϳ����� Ʈ���� ������ ��� ��� �ݺ�
		while (!wait.isEmpty() || !cross.isEmpty()) {
			time++;
			
			//���� �ٸ��� �ǳʰ� �ִ� Ʈ���� �������� ���� ���
			if (cross.isEmpty()) {
				Truck t = wait.poll();
				currentWeight += t.weight;
				cross.offer(t);
				continue;
			}
			
			//ť�� ����ִ� ��� Ʈ�� ��ü���� �� ĭ�� ������Ų��.
			for (Truck t : cross) 
				t.moving();
			
			if (cross.peek().move > bridgeLength) {
				Truck t = cross.poll();
				currentWeight -= t.weight; //t�� ť���� �������� ��ü�� ������ weight�� �� �� �ִ�.
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

//�� Ʈ������ ��üȭ�Ѵ�.
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