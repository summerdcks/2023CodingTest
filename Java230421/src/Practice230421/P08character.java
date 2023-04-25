package Practice230421;

import java.util.HashMap;

public class P08character {
	public int solution(String s){
		int answer = -1;
		HashMap<String, Integer> a = new HashMap<>();		
		for(char x : s.toCharArray()) {
			String xx = Character.toString(x);
			if(a.getOrDefault(xx, -1) == -1) {
				a.put(xx, 1);
			} else if(a.get(xx) == 1) {			
				a.put(xx, 2);
			}
		}
		int count = 1;
		for(char x : s.toCharArray()) {
			if(a.get(Character.toString(x)) == 1) {
				answer = count;
				break;
			}
			count++;
		}
		return answer;
	}

	public static void main(String[] args){
		P08character T = new P08character();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}