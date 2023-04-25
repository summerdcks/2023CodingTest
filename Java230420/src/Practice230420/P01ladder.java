package Practice230420;

import java.util.Arrays;

public class P01ladder {

	public char[] solution(int n, int[][] ladder){
		char[] answer = new char[n];
		int[] temp = new int[n];
		
		for(int i = 0; i < n; i++) {
			answer[i] = (char)(65 + i);
		}
		
		for(int i = 0; i < n; i++) {
			temp[i] = i + 1;
		}
					
		for(int i = 0; i < ladder.length; i++) {
			for(int j = 0; j < ladder[i].length ; j++) {
				if(n == temp[i][j]) {
					n = n + 1;
				} else if(n == temp[i][j] - 1) {
					n = n - 1;
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args){
		P01ladder T = new P01ladder();
		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
		System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
		
	}

}