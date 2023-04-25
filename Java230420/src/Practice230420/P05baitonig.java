package Practice230420;

import java.util.*;
public class P05baitonig {
	public int solution(int[] nums){
		int answer = 0;	
		for(int i = 1; i < nums.length - 1; i++) {
			if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
				int count = 1;
				for(int j = i; j > 0; j--) {
					if(nums[j] > nums[j-1]) {
						count++;
					} else break;
				}
				for(int h = i; h < nums.length - 1; h++) {
					if(nums[h] > nums[h+1]) {
						count++;
					} else break;
				}
				if(count > answer) {
					answer = count;
				}
			}
		}				
		return answer;	
	}

	public static void main(String[] args){
		P05baitonig T = new P05baitonig();
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
		System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}