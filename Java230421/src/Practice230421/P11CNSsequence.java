package Practice230421;

import java.util.*;
public class P11CNSsequence {
	public int solution(int[] nums, int m){
		int answer = 0;
		int n = nums.length;
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j < i; j++) {
					int sum = 0;
					for(int h = j; h < i; h++) {
						sum += nums[h];
					}
					if(sum == m) {
						answer++;
					}
				}
			}
		return answer;
	}

	public static void main(String[] args){
		P11CNSsequence T = new P11CNSsequence();
		System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));	
		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));	
		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));	
	}
}