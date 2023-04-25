package Answer230421;

import java.util.*;
public class A10frequency {
	public int solution(String s){
		int answer = 0;
		HashMap<Character, Integer> sH = new HashMap<>();
		HashSet<Integer> ch = new HashSet<>();
		for(char x : s.toCharArray()){
			sH.put(x, sH.getOrDefault(x, 0) + 1);
		}
		for(char key : sH.keySet()){
			while(ch.contains(sH.get(key))){	//value값이 똑같은게 있으면
				answer++;						
				sH.put(key, sH.get(key) - 1);	//1 빼줘라
			}
			if(sH.get(key) == 0) continue;		//value가 0이면 넘어가라
			ch.add(sH.get(key));
		}
		return answer;
	}

	public static void main(String[] args){
		A10frequency T = new A10frequency();
		System.out.println(T.solution("aaabbbcc"));	
		System.out.println(T.solution("aaabbc"));	
		System.out.println(T.solution("aebbbbc"));	
		System.out.println(T.solution("aaabbbcccde"));	
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));	
	}
}