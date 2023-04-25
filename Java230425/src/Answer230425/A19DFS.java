package Answer230425;

import java.util.*;
public class A19DFS {
	static int[] pm, ch, arr;
	static int n, m;
	public void DFS(int L) {
		if(L == m) {
			for(int x : pm) {
				System.out.print(x+" ");
			}
				System.out.println();
		} else {
			for(int i = 0; i < n; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;
					pm[L] = arr[i];
					DFS(L+1);
					ch[i] = 0;
				}
			}
		}
	}
		
	public static void main(String[] args){
		A19DFS T = new A19DFS();
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		arr = new int[n];
		for(int i = 0; i < n; i ++) {
			arr[i] = kb.nextInt();
			//입력받은 n개의 자연수를 arr배열에 담아줌
		}
		ch = new int[n];	//n개짜리 배열 초기화
		pm = new int[m];	//m개짜리 배열 초기화
		T.DFS(0);
	}
}