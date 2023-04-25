package Answer230420;

import java.util.*;
public class A04seat {
//좌석 배정하기
	public int[] solution(int c, int r, int k){	//메소드 선언
		int[] answer = new int[2];	//크기가 2인 answer배열 선언 좌표값을 의미
		if(k > c * r) return new int[] {0, 0};
		//횟수가 칸수보다 많으면 0,0을 리턴
		int[][] seat = new int[c][r];	//c행r열의 2차원배열 선언 주어진 좌석들
		int[] dx = {-1, 0, 1, 0};	
		int[] dy = {0, 1, 0, -1};
		//각각 12시, 3시, 6시, 9시 방향으로 90도 회전할 때 좌표에 더해지는 값
		int x = 0, y = 0, count = 1, d = 1;
		//현재 x,y = 0,0부터 시작, 횟수 1부터, 3시 방향을 바라보고 있음
		while(count < k){	//k=count될 때까지 반복
			int nx = x + dx[d];
			int ny = y + dy[d];
			//한칸 전진했을 때 어떤 좌표값이 나오는지 nx, ny로 가정한다
			if(nx < 0 || nx >= c || ny < 0 || ny >=r || seat[nx][ny] > 0){
				//nx와 ny가 배열의 크기를 벗어날 때(벽일 때), 그 자리가 비어있지 않을 때
				d = (d + 1) % 4;	//90도 회전한다 d값은 0~3이므로 이렇게 표현
				continue;	//아래의 코드를 실행하지 않고 while문의 처음으로 돌아간다
			}
			seat[x][y] = count;	//지나온 자리에 0보다 큰 값을 부여한다
			count++;	//횟수 증가
			x = nx;		//전진
			y = ny;		//전진
		}
		answer[0] = x + 1;	//실제 좌표는 1,1부터 시작이므로
		answer[1] = y + 1;	//각각 1을 더해준다
		return answer;	//좌표 리턴
	}

	public static void main(String[] args){
		A04seat T = new A04seat();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
													//행, 열, 몇번째 자리인지
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}