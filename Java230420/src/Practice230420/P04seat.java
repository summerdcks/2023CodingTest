package Practice230420;

import java.util.*;
public class P04seat {
	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		int[][] seat = new int[c][r];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int x = 0, y = 0, d = 1, count = 1;
		if(c*r >= k) {
			while(count < k) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] == 1) {
					d = (d + 1) % 4;
					continue;
				}
				seat[x][y] = 1;
				count++;
				x = nx;
				y = ny;					
			}
			System.out.println(count);
			answer[0] = x + 1;
			answer[1] = y + 1;
		} else {
			answer[0] = 0;
			answer[1] = 0;
		}
		return answer;
	}

	public static void main(String[] args){
		P04seat T = new P04seat();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}