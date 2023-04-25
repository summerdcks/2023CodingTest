package Answer230425;

import java.util.*;
public class A17length {
	public int solution(int[] nums){
		int answer = 0;
		HashSet<Integer> set = new HashSet<>();
		for(int x : nums) set.add(x);		
		for(int x : set) {
			if(set.contains(x - 1)) continue;	//x-1값이 있으면 x는 수열의 중간값이므로 연속수열 카운트 시작하지 않음
			//x-1값이 없으면 x부터 시작하는 연속수열 카운트 시작
			int cnt = 0;
			while(set.contains(x)) {
				cnt++;
				x++;
			}
		answer = Math.max(answer, cnt);
		}
		return answer;
	}

	public static void main(String[] args){
		A17length T = new A17length();
		System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
		System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
		System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}
}