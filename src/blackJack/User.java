package blackJack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User extends Player{

	public User(String name) {
		super(name);
	}

	public void initialSet(Deck deck) {
		// 普通に2回関数実行させたほうが処理速度早い？
		for (int i = 0; i < 2; i++) {
			draw(deck, false);
		}
		calcTotalPoint();
		statusNotice(true);
	}

	public void drawCardOrAsk(Deck deck) {
		if (!getIsBurst()) {
			Scanner sc = new Scanner(System.in);
			try {
				Object input = new Object();
				while (!getIsBurst() && !input.equals("N")) {
					System.out.println("カードを引きますか？引く場合はYを、引かない場合はNを押してください");
					input = sc.nextLine();
					if (input.equals("Y")) {
						draw(deck, false);
						calcTotalPoint();
						statusNotice(true);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("YとN以外が入力されました。");
			}

		}
	}
}
