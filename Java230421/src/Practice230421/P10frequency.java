package Practice230421;

import java.util.*;
public class P10frequency {
	public int solution(String s){
		int answer = 0;
		HashMap<Character, Integer> a = new HashMap<>();
		for(int i = 97; i < 123; i++) {
			if(a.getOrDefault((char)i, -1) == -1) {
				a.put((char)i, 0);
			}
		}	
		for(char x : s.toCharArray()) {
			a.put(x, a.get(x) + 1);
		}	
		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			if(a.get(s.charAt(i)) > max) {
				max = a.get(s.charAt(i));
			};
		}
		for(int i = max; i > 0; i--) {
			int count = -1;
			for(int j = 97; j < 123; j++) {
				if(a.get((char)j) == i) {
					count++;
					if(count > 0) {
						a.put((char)j, a.get((char)j) - 1);
					}
				}
			}
			if (count > 0) {
				answer = answer + count;
			}
		}		
		return answer;
	}
	
	public static void main(String[] args){
		P10frequency T = new P10frequency();
		System.out.println(T.solution("aaabbbcc"));	
		System.out.println(T.solution("aaabbc"));	
		System.out.println(T.solution("aebbbbc"));	
		System.out.println(T.solution("aaabbbcccde"));	
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));	
	}
}