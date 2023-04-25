package Answer230421;

import java.util.*;
public class A06fruit {
	public int getMin(int[] fruit){
		//fruit배열 중 최소값 구하기
		int min = 100;
		for(int x : fruit){
			min = Math.min(min, x);
		}
		return min;
	}
	public Boolean isMinUnique(int[] fruit){
		//최소값이 1개면 true 나머지는 false 리턴
		int cnt = 0;
		int min = getMin(fruit);
		for(int x : fruit){
			if(x == min) cnt++;
		}
		return cnt == 1;
	}
	public int getMinIndex(int[] fruit){
		//최소값의 인덱스 구하기 없으면 0
		int min = getMin(fruit);
		for(int i = 0; i < 3; i++){
			if(fruit[i] == min) return i;
		}
		return 0;
	}
	public int solution(int[][] fruit){
		int answer = 0;
		int n = fruit.length;
		int[] ch = new int[n];
		for(int i = 0; i < n; i++){		//교환하는 사람1
			if(ch[i] == 1) continue;	//한번 교환했으면 돌아가
			if(isMinUnique(fruit[i]) == false) continue;	//최소값이 1개가 아니면 돌아가
			for(int j = i+1; j < n; j++){	//교환할 대상2
				if(ch[j] == 1) continue;	//한번 교환했으면 돌아가
				if(isMinUnique(fruit[j]) == false) continue;	//최소값이 1개가 아니면 돌아가
				int a = getMinIndex(fruit[i]);	//1번의 최소값의 인덱스
				int b = getMinIndex(fruit[j]);	//2번의 최소값의 인덱스
				if(a != b && fruit[i][b] > 0 && fruit[j][a] > 0){
					//서로의 최소값의 인덱스가 다르고 교환할 과일이 있을 때
					if(fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1){
						//교환 후 다른 과일이 최소가 되지 않을 때
						fruit[i][a]++;
						fruit[i][b]--;
						fruit[j][b]++;
						fruit[j][a]--;
						ch[i] = 1;
						ch[j] = 1;
						//교환횟수를 1로 카운트해줌
						break;
					}
				}
			}
		}
		for(int[] x : fruit){
			answer += getMin(x);
			//모든 교환이 끝난 후 모든 학생이 가져가는 과일의 총 개수
		}
		return answer;
	}

	public static void main(String[] args){
		A06fruit T = new A06fruit();
		System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
		System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));	
		System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
		System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
	}
}