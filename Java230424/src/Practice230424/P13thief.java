package Practice230424;

import java.util.*;
//sort안함
public class P13thief {
	public String[] solution(String[] reports, String times){
		HashMap<String, Integer> Tmp = new HashMap<>();
		for(String x : reports) {
			String a = x.split(" ")[0];	//문자열을 띄어쓰기로 구분해 나누고 앞부분이 a
			String b = x.split(" ")[1];	//뒷부분이 b
			Tmp.putIfAbsent(a, 0);
			//앞부분을 key값에 넣어줌 
			String c = b.split(":")[0];
			String d = b.split(":")[1];
			int time = Integer.parseInt(c) * 60 + Integer.parseInt(d);
			Tmp.put(a, time);
			//뒷부분을 value값에 넣어줌			
		}
		
		String From = times.split(" ")[0];	
		String a = From.split(":")[0];
		String b = From.split(":")[1];
		int from = Integer.parseInt(a) * 60 + Integer.parseInt(b);
		
		String To = times.split(" ")[1];			
		String c = To.split(":")[0];
		String d = To.split(":")[1];
		int to = Integer.parseInt(c) * 60 + Integer.parseInt(d);
	
		ArrayList<String> res = new ArrayList<>();
		for(String x : Tmp.keySet()) {
			if(Tmp.get(x) >= from && Tmp.get(x) <= to) {
				res.add(x);
			}
		}			
		String[] answer = new String[res.size()];
		for(int i = 0; i < res.size(); i++) {
			answer[i] = res.get(i);
		}
		return answer;
	}

	public static void main(String[] args){
		P13thief T = new P13thief();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}