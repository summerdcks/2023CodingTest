package Practice230425;

import java.util.*;
public class P18zip {
	public String solution(String s){
		String answer = "";
		Stack<Character> st = new Stack<>();
		char[] ss = s.toCharArray();
		for(char x : ss) {
			st.push(x);
		}
		System.out.println(st);
		String tmp = "";
		String num = "";
			while(!st.empty()) {
				if(st.peek().equals(')')) {
					st.pop();
					answer = answer + tmp;
					tmp = "";
				} else if(st.peek().equals('(')) {		
					while(st.peek().equals('(')) {
						st.pop();
					}
					num = st.pop() + num;
					for(int i = 0; i < Integer.parseInt(num); i++) {
						answer = tmp + answer;
					}
					
					break;
				} else if((int)st.peek() >= (int)'a' && (int)st.peek() <= (int)'z') {
					tmp = st.pop() + tmp;
				} else if((int)st.peek() >= (int)'0' && (int)st.peek() <= (int)'9') {
					
				}		
			}
		System.out.println(tmp);
		System.out.println(num);
		return answer;
	}

	public static void main(String[] args){
		P18zip T = new P18zip();
		System.out.println(T.solution("3(a2(b))ef"));
		System.out.println(T.solution("2(ab)k3(bc)"));
		System.out.println(T.solution("2(ab3((cd)))"));
		System.out.println(T.solution("2(2(ab)3(2(ac)))"));
		System.out.println(T.solution("3(ab2(sg))"));
	}
}