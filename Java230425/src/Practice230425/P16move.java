package Practice230425;

import java.util.*;
public class P16move {
	public int solution(int[] nums){
		int answer = 0;
		int m = 5;
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			if(nums[left] + nums[right] <= m) {
				answer++;
				left++;
				right--;
			} else {
				answer++;
				right--;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		P16move T = new P16move();
		System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
		System.out.println(T.solution(new int[]{2, 3, 4, 5}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
	}
}