package Practice230421;

import java.util.*;
public class P09frequency {
	public int[] solution(String s){
		int[] answer = new int[5];
		HashMap<Character, Integer> a = new HashMap<>();	
		for(int i = 97; i < 102; i++) {
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
		System.out.println(max);
		for(int i = 0; i < 5; i++) {
			answer[i] = max - a.get((char)(i+97));		
		}		
		return answer;
	}

	public static void main(String[] args){
		P09frequency T = new P09frequency();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
