package Practice230425;

import java.util.*;
public class P17length {
	public int solution(int[] nums){
		int answer = 0;
//		HashSet<Integer> num = new HashSet<>();
//		for(int x : nums) {
//			num.add(x);		
//		}
//		for(int x : num) {
//			if(num.contains(x - 1)) continue;
//			int count = 0;
//			while(num.contains(x)) {
//				count++;
//				x++;
//			}
//		answer = Math.max(answer, count);
//		}
//		return answer;
		
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 1; i++) {
			int count = 1;
			for(int j = i; j < nums.length - 1; j++) {
				if(nums[j+1] == nums[j]) {
					
				} else if (nums[j+1] == nums[j] + 1) {
					count++;
				} else {
					break;
				}
			}
			answer = Math.max(answer, count);
		}
		return answer;
	}

	public static void main(String[] args){
		P17length T = new P17length();
		System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
		System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
		System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}
}