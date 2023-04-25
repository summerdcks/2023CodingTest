package Answer230424;

import java.util.*;
public class A12election {
	public String solution(String[] votes, int k){
		String answer = " ";
		HashMap<String, HashSet<String>> voteHash = new HashMap<>();
		//모든 투표결과를 담을 HashMap선언(a가 b를 추천함)
		HashMap<String, Integer> candidate = new HashMap<>();
		//후보, 추천받은횟수
		HashMap<String, Integer> present = new HashMap<>();
		//선물받을사람, 후보추천한횟수
		for(String x : votes) {
			String a = x.split(" ")[0];	//문자열을 띄어쓰기로 구분해 나누고 앞부분이 a
			String b = x.split(" ")[1];	//뒷부분이 b
			voteHash.putIfAbsent(a, new HashSet<String>());
			//앞부분을 key값에 넣어줌 
			voteHash.get(a).add(b);
			//뒷부분을 value값에 넣어줌
			candidate.put(b, candidate.getOrDefault(b, 0) + 1);
			//candidate 해시맵 key가 b일때 value가 없으면 0을 넣어주고 있으면 1을 더해준다
		}
		int max=Integer.MIN_VALUE;
		//최대값 비교 위한 선언
		for(String a : voteHash.keySet()) {	
			//voteHash의 모든 키 값을 순회하며 반복문 실행. 현재 키 값을 a에 할당
			int cnt = 0;	//횟수 세기 위한 선언
			for(String b : voteHash.get(a)) {	
				//voteHash에서 현재 키 값 a에 해당하는 HashSet 객체를 가져와 모든 값을 순회하며 반복문 실행. 현재 값을 b에 할당
				if(candidate.get(b) >= k) cnt++;
				//candidate에서 현재 값을 키로 가지는 값을 가져와 k보다 크거나 같은지 확인하고, 참이면 cnt를 1 증가시킴
			}
			present.put(a, cnt);	//present에 a:cnt 추가
			max = Math.max(max, cnt);	//cnt중에 최대값 구하기
		}
		ArrayList<String> tmp = new ArrayList<>();
		//정렬하기 위해 tmp리스트 선언
		for(String name : present.keySet()) {
			//present의 모든 키 값을 순회하며 반복문 실행. 현재 키 값을 name에 할당
			if(present.get(name) == max) tmp.add(name);
			//name키의 value값이 최대면 tmp에 담아줌
		}
		tmp.sort((a, b) -> a.compareTo(b));	//오름차순 정렬(이름알파벳순)
		answer = tmp.get(0);	//0번째 변수
		return answer;
	}

	public static void main(String[] args){
		A12election T = new A12election();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}