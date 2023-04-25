package Practice230424;

import java.util.*;
public class P12election {
	public String solution(String[] votes, int k){
		String answer = " ";
		HashMap<String, String> voteHash = new HashMap<>();
		HashMap<String, Integer> candidate = new HashMap<>();
		HashMap<String, Integer> present = new HashMap<>();
		for(int i = 0; i < votes.length; i++) {
			String [] str = votes[i].split(answer);
			voteHash.put(str[i], voteHash.get(str[i]) + str[i]);
		}
		
		for(String x : voteHash.keySet()){
			candidate.put(x, candidate.getOrDefault(x, 0)+1); 
			present.put(x, present.getOrDefault(x, 0)+1); 
		}
		return answer;
	}

	public static void main(String[] args){
		P12election T = new P12election();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}