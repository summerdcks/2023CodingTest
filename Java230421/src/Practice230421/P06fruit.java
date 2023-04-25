package Practice230421;

import java.util.*;
public class P06fruit {
	public int solution(int[][] fruit){
		int answer = 0;
		int index = 0;
		int count = 0;
		for(int i = 0; i < fruit.length; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < 3; j++) {			
				if(fruit[i][j] == min) {
					count++;
				}
				min = Math.min(min, fruit[i][j]);
				if(fruit[i][j] <= min) {
					index = j;
				}	
			}
			System.out.println(count + "," + min + "," + index);
			count = 0;
		}
		
		return answer;
	}

	public static void main(String[] args){
		P06fruit T = new P06fruit();
		System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
		System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));	
		System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
		System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
	}
}