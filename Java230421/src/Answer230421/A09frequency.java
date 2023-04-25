package Answer230421;

import java.util.*;
public class A09frequency {
	public int[] solution(String s){
		int[] answer = new int[5];
		HashMap<Character, Integer> sH = new HashMap<>();
		for(char x : s.toCharArray()){
			sH.put(x, sH.getOrDefault(x, 0)+1); 
		}
		//갯수 다 구해
		int max = Integer.MIN_VALUE;
		String tmp = "abcde";
		for(char key : tmp.toCharArray()){
			if(sH.getOrDefault(key, 0) > max){
				max = sH.getOrDefault(key, 0);
			}
		}
		//최대값 구해
		for(int i = 0; i < tmp.length(); i++){
			answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
		}
		//차이 다 더해
		return answer;
	}

	public static void main(String[] args){
		A09frequency T = new A09frequency();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
