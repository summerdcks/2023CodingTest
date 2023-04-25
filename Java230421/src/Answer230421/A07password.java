package Answer230421;

import java.util.*;
public class A07password {
	public int solution(int[] keypad, String password){
		int answer = 0;
		int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
		int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
		//각각 11시, 12시, 1시, 3시, 5시, 6시, 7시, 9시 방향
		int[][] pad = new int[3][3];	//비번키패드
		int[][] dist = new int[10][10];	//10개숫자 격자모양
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				pad[i][j] = keypad[i*3 + j];
				//3x3 격자모양 키패드에 값 대입
			}
		}
		for(int i = 0; i < 10; i++){
			Arrays.fill(dist[i], 2);
			//dist의 모든 값에 2초 대입
		}
		for(int i = 0; i < 10; i++) dist[i][i] = 0;	//같은 번호로 갈 때는 0초
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				int from = pad[i][j];
				for(int k = 0; k < 8; k++){
					if(i+dx[k] >= 0 && i+dx[k] < 3 && j+dy[k] >= 0 && j+dy[k] < 3){
						int to = pad[i+dx[k]][j+dy[k]];
						dist[from][to] = 1;
						//현재 위치에서 이동 가능한 8방향을 탐색
						//이동 가능한 위치의 좌표가 3x3 배열 범위를 벗어나지 않도록 함
						//이동 가능한 위치에 해당하는 to 키패드의 번호를 가져옴
						//현재 위치와 이동 가능한 위치 간의 거리를 1로 설정
					}
				}
			}
		}

		for(int i = 1; i < password.length(); i++){
			int from = (int)password.charAt(i-1)-48;
			int to = (int)password.charAt(i)-48;
			//문자열 password의 문자를 하나씩 가져와서 숫자로 변환
			answer += dist[from][to];	//이동시간 합산
		}	
		return answer;
	}

	public static void main(String[] args){
		A07password T = new A07password();
		System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));	
		System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}