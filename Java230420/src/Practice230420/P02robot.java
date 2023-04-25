package Practice230420;

import java.util.*;
public class P02robot {
	public int[] solution(int[][] board, int k){
		int[] answer = new int[2]; 
		answer[0] = 0;
		answer[1] = 0;
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int d = 1;

		for(int i = 0; i < k; i++) {
										
				if( == 1 | ) {						
					d++;
					if(d == 4) {
						d = 0;
					}
				}
				answer[0] = answer[0] + dx[d];
				answer[1] = answer[1] + dy[d];																		
														
		}
					
		return answer;
	}

	public static void main(String[] args){
		P02robot T = new P02robot();
		int[][] arr1 = {{0, 0, 0, 0, 0}, 
			{0, 1, 1, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {{0, 0, 0, 1, 0, 1}, 
			{0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 1}, 
			{1, 1, 0, 0, 1, 0}, 
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {{0, 0, 1, 0, 0}, 
			{0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 1}, 
			{0, 0, 0, 0, 0}};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
		
	}
}

//while(true) {
//
//	if(board[][] == 1 | ) {						
//		d++;
//		if(d == 4) {
//			d = 0;
//		}
//		k--;
//		if(k == 0) {
//			break;
//		}						
//	}
//	
//	answer[0] = answer[0] + dx[d];
//	answer[1] = answer[1] + dy[d];
//	
//	k--;
//	if(k == 0) {
//		break;
//	}
//}