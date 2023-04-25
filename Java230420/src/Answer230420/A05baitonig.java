package Answer230420;

import java.util.ArrayList;
//바이토닉 수열은 값이 커졌다가 작아지는 범위를 말함
public class A05baitonig {
	public int solution(int[] nums){	//메소드 선언
		int answer = 0;		//리턴할 최대값 초기화
		int n = nums.length;	//받아온 배열의 크기값
		ArrayList<Integer> peaks = new ArrayList<>();	//피크값을 받아올 배열 선언
		for(int i = 1; i < n - 1; i++) {	//배열의 1번째부터 n-1번째 변수까지 살펴봄
			if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){ 	//이전 변수와 다음 변수보다 크면 peak
				peaks.add(i);	//몇번째 변수인지 배열에 담는다
			}
			for(int x : peaks){		//peaks들을 차례대로 살펴봄
				int left = x; 	//x번째부터 왼쪽으로 살펴봄
				int right = x;	//x번째부터 오른쪽으로 살펴봄
				int cnt = 1;	//시작값 카운트하므로 1로 매번 초기화
				while(left-1 >= 0 && nums[left-1] < nums[left]){
					//배열범위 벗어나지 않게 && 왼쪽값이 오른쪽보다 작으면
					left--;	//하나 왼쪽으로 가고
					cnt++;	//카운트함
				}
				while(right+1 < n && nums[right] > nums[right+1]){
					//배열범위 벗어나지 않게 && 오른쪽값이 왼쪽보다 작으면
					right++; //하나 오른쪽으로 가고
					cnt++;	//카운트함
				}
				answer = Math.max(answer, cnt);	//최대값 선택
			}	
		}
		return answer;	//최대값 리턴
	}
	
	public static void main(String[] args){
		A05baitonig T = new A05baitonig();
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
												//숫자의 나열
		System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}

}
