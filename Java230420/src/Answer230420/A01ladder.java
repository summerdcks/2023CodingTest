package Answer230420;

import java.util.Arrays;

public class A01ladder {
//사다리타기
	public char[] solution(int n, int[][] ladder){		//메소드 선언
		char[] answer = new char[n];		//크기가 n인 문자열형 배열 선언
		for(int i = 0; i < n; i++) {		//0번째부터 n-1번째까지 변수 할당
			answer[i] = (char)(i + 65);		//A부터 차례대로 알파벳 할당
		}
	
//for each구문
		for(int[] line : ladder) {	//2차원배열 ladder의 변수를 0부터 끝까지 1차원배열인 line으로 받아 차례대로 살펴본다
			for(int x : line) {	//1차원배열 line의 변수를 0부터 끝까지 정수 x로 받아 차례대로 살펴본다
				//사다리 가로줄에 걸린 알파벳은 배열 안에서 서로 자리를 바꾼다
				char tmp = answer[x];
				answer[x] = answer[x-1];
				answer[x-1] = tmp;
			}
		}	
		return answer;	//사다리 결과
	}

	public static void main(String[] args){
		A01ladder T = new A01ladder();
		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
													//세로줄 갯수, 가로줄 윗줄부터 차례대로 위치
		System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
		
	}

}
