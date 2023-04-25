package Practice230420;

import java.util.*;
public class P03puppy {
	public int solution(int[][] board){
		int count = 0;
		int[] hs = new int[2];
		int[] dog = new int[2];
		int n = board.length;
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		int a = 0, b = 0, x = 0, y = 0, d1 = 0, d2 = 0;
		
		//현수찾기
		for(int[] line : board) {
			b = 0;
			for(int i : line) {
				if (i == 2) {
					hs[0] = a;
					hs[1] = b;
				}
				b++;			
			}
			a++;
		}
		a = hs[0];
		b = hs[1];

		//개찾기
		for(int[] line : board) {
			y = 0;
			for(int i : line) {
				if (i == 3) {
					dog[0] = x;
					dog[1] = y;
				}
				y++;			
			}
			x++;
		}		
		x = dog[0];
		y = dog[1];

		//이동하기			
		while(true) {
			count++;
		
			//현수
			int na = a + dx[d1];
			int nb = b + dy[d1];
			if(na < 0 || na >= n || nb < 0 || nb >= n || board[na][nb] == 1) {
				d1 = (d1 + 1) % 4;
				//continue; //이거 때문에!!				
			} else {
				a = na;
				b = nb;	
			}
			
			//개
			int nx = x + dx[d2];
			int ny = y + dy[d2];
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
				d2 = (d2 + 1) % 4;
				//continue; //이거이거이거			
			} else {
				board[x][y] = 0;
				x = nx;
				y = ny;	
				board[nx][ny] = 3;
			}
					
			//둘이 만나거나 10000분 되면 끝!
			if(board[a][b] == 3) {
				break;
			} else if(count >= 10000) {
				count = 0;
				break;
			}
		}	
		return count;		
	}

	public static void main(String[] args){
		P03puppy T = new P03puppy();
		int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; 
		System.out.println(T.solution(arr1));
		int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0}, 
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1}, 
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1}, 
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; 
		System.out.println(T.solution(arr2));
	}
}