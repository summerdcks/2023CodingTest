package Answer230424;

import java.util.*;
public class A14mail {
	public int getTime(String time){
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);
		return H*60+M;
		//문자열로 입력된 시간을 분단위 integer로 바꿔주는 메소드
	}
	public String[] solution(String[] reports, int time){
		//String[] answer ={};
		HashMap<String, Integer> inT = new HashMap<>();		//들어온 시간
		HashMap<String, Integer> sumT = new HashMap<>();	//머문 시간
		for(String x : reports){
			//reports의 모든 키 값을 순회하며 반복문 실행. 현재 키 값을 x에 할당
			String a = x.split(" ")[0];	//이름
			String b = x.split(" ")[1];	//시간
			String c = x.split(" ")[2];	//in or out
			if(c.equals("in")) inT.put(a, getTime(b));
			//in이면 해당시간을 value에 넣음
			else sumT.put(a, sumT.getOrDefault(a, 0) + (getTime(b) - inT.get(a)));
			//out이면 해당시간에 추가된 시간을 더해서 value에 넣음
		}
		ArrayList<String> res = new ArrayList<>();
		for(String name : sumT.keySet()){
			//sumT의 모든 키 값을 순회하며 반복문 실행. 현재 키 값을 name에 할당
			if(sumT.get(name) > time) res.add(name);
			//sumT해시맵에서 name키의 value값이 제한시간을 넘으면 res에 담아줌 
		}
		res.sort((a, b) -> a.compareTo(b));	//오름차순 정렬
		String[] answer = new String[res.size()];
		for(int i = 0; i < res.size(); i++){
			answer[i] = res.get(i);
			//res를 answer배열에 담아줌
		}
		return answer;
	}

	public static void main(String[] args){
		A14mail T = new A14mail();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));	
		System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
		System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
	}
}