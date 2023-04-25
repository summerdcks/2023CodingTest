package Answer230420;

import java.util.*;
public class A02robot {
//청소로봇 k초 후의 좌표 구하기
	public int[] solution(int[][] board, int k){	//메소드 선언
		int[] answer = new int[2];	//크기가 2인 배열 선언
		int n = board.length;		//n x n 배열의 크기 재기
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		//각각 12시, 3시, 6시, 9시 방향으로 90도 회전할 때 좌표에 더해지는 값
		int x = 0, y = 0, d = 1, count = 0;
		//현재 x,y = 0,0부터 시작, 횟수 0부터, 3시 방향을 바라보고 있음
		while(count < k) {	//k초가 되면 반복 종료
			count++;	//+1초
			int nx = x + dx[d];	
			int ny = y + dy[d];
			//한칸 전진했을 때 어떤 좌표값이 나오는지 nx, ny로 가정한다
			if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
			//한칸 전진한 좌표가 배열의 범위를 벗어나거나 벽으로 막혀있을 때
				d = (d + 1) % 4;	//시계방향 90도 전환
				continue;	//방향전환시 while문 처음으로 돌아간다 이동하지 않고 1초 증가
			}
			x = nx;	//한칸 전진한다
			y = ny;			
		}
		answer[0] = x;	//k초가 되면 좌표값 부여
		answer[1] = y;
		return answer;	//해당 좌표를 반환한다
	}

	public static void main(String[] args){
		A02robot T = new A02robot();
		// 0 이동가능, 1 벽
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