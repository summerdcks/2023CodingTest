package Answer230421;

import java.util.*;
//연속하는 부분수열
public class A11CNSsequence {
	public int solution(int[] nums, int m){
		int answer = 0;
		HashMap<Integer, Integer> nH = new HashMap<>();
		int sum = 0;
		nH.put(0, 1);	//sum이 m일 때 카운트해주기 위해 sum이 0인 값 미리 넣어줌
		for(int x : nums){
			sum += x;	//0번째부터 합산
			if(nH.containsKey(sum-m)) {	//sum-m이 앞에 있을 때
				answer += nH.get(sum-m);	//경우의 수만큼 카운트해줌
			}
			nH.put(sum, nH.getOrDefault(sum, 0) + 1);	//sum의 경우의 수 1 더해줌
		}
		return answer;
	}

	public static void main(String[] args){
		A11CNSsequence T = new A11CNSsequence();
		System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));	
		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));	
		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));	
	}
}