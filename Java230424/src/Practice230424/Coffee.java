package Practice230424;

import java.util.Scanner;

public class Coffee {

	public static void main(String[] args) {
		System.out.println("안녕하세요. 고래커피입니다. 아메리카노 몇 잔 주문하시겠습니까?");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int free = num /10;
		int sales = 2000 * (num-free);		
		int time = 3 * num;
		int	expence = 500 * num;
		int netProfit = (int)(0.4 * sales) - expence;
		
		System.out.printf("%d원 입니다. 소요 시간은 %d 분 입니다.\n", sales, time);
		System.out.printf("알바 지급 비용 : %d 원\n", expence);
		System.out.printf("순수익 : %d 원\n", netProfit);
	}

}
