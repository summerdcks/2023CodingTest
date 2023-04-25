package Answer230421;

import java.util.HashMap;

public class A08character {
	public int solution(String s){
		HashMap<Character, Integer> sH = new HashMap<>();
		for(char x : s.toCharArray()){
			sH.put(x, sH.getOrDefault(x, 0) + 1); 
			//키가 x인 value가 없으면 0을 넣고 있으면 1 더해줌
		}
		for(int i = 0; i < s.length(); i++){
			if(sH.get(s.charAt(i)) == 1) return i+1;
			//처음부터 차례대로 봐서 한번만 사용한 문자가 있으면 인덱스 번호를 리턴
		}
		return -1;
		//한번만 사용한 문자가 없을 때 -1 리턴
	}

	public static void main(String[] args){
		A08character T = new A08character();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}


//import java.util.*;
//public class A08character {
//	public int[] solution(String s){
//		int[] answer = new int[5];
//		HashMap<Character, Integer> sH = new HashMap<>();
//		for(char x : s.toCharArray()){
//			sH.put(x, sH.getOrDefault(x, 0)+1); 
//		}
//		int max = Integer.MIN_VALUE;
//		String tmp = "abcde";
//		for(char key : tmp.toCharArray()){
//			if(sH.getOrDefault(key, 0) > max){
//				max = sH.getOrDefault(key, 0);
//			}
//		}
//		for(int i = 0; i < tmp.length(); i++){
//			answer[i] = max - sH.getOrDefault(tmp.charAt(i), 0);
//		}
//		return answer;
//	}
//
//	public static void main(String[] args){
//		A08character T = new A08character();
//		System.out.println(Arrays.toString(T.solution("aaabc")));
//		System.out.println(Arrays.toString(T.solution("aabb")));
//		System.out.println(Arrays.toString(T.solution("abcde")));
//		System.out.println(Arrays.toString(T.solution("abcdeabc")));
//		System.out.println(Arrays.toString(T.solution("abbccddee")));
//	}
//}
//
//
//import java.util.*;
//public class A08character {
//	public int solution(String s){
//		int answer = 0;
//		HashMap<Character, Integer> sH = new HashMap<>();
//		HashSet<Integer> ch = new HashSet<>();
//		for(char x : s.toCharArray()){
//			sH.put(x, sH.getOrDefault(x, 0) + 1);
//		}
//		for(char key : sH.keySet()){
//			while(ch.contains(sH.get(key))){
//				answer++;
//				sH.put(key, sH.get(key) - 1);
//			}
//			if(sH.get(key) == 0) continue;
//			ch.add(sH.get(key));
//		}
//		return answer;
//	}
//
//	public static void main(String[] args){
//		A08character T = new A08character();
//		System.out.println(T.solution("aaabbbcc"));	
//		System.out.println(T.solution("aaabbc"));	
//		System.out.println(T.solution("aebbbbc"));	
//		System.out.println(T.solution("aaabbbcccde"));	
//		System.out.println(T.solution("aaabbbcccdddeeeeeff"));	
//	}
//}