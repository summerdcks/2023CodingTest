package Practice230421;

import java.util.*;
public class P07password {
	public int solution(int[] keypad, String password){
		int answer = 0;
		int[][] pwd = new int[9][9];
		int[][] pad = {{1,2,3},{4,5,6},{7,8,9}};
		int[] dx = {-1, 0, 1, 0, -1, +1, +1, -1};
		int[] dy = {0, 1, 0, -1, +1, +1, -1, -1};
		int x = 0, y = 0, d = 0;
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {				
				pwd[i][j] = 2;				
				if(i == j) {
					pwd[i][j] = 0;
				}						
			}
		}			
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {	
				int a = pad[i][j];
				if() {
					pwd[a][] = 1;
				}					
			}
		}		
//				int nx = x + dx[d];	
//				int ny = y + dy[d];				
		for(int i = 0; i < password.length(); i++) {
			int num = password.charAt(i);
			answer = answer + pwd[num][num+1];			
		}					
		return answer;
	}

	public static void main(String[] args){
		P07password T = new P07password();
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}