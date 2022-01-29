package blackJack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User extends Player{

	List<Card> hasHandList = new ArrayList<Card>();
	private boolean isBurst = false;

	public User(String name) {
		super(name);
	}

	public void initialSet(Deck deck) {
		// 普通に2回関数実行させたほうが処理速度早い？
		for (int i = 0; i < 2; i++) {
			Card card = deck.draw();
			addHasHandList(card);
			System.out.println(getName() + "が引いたカードは" + card.getSuit() + "の" + card.NoString() + "です");
		}
	}

	public void cardCalculation() {
		calcTotalPoint();

		if (getIsBurst()) {
			System.out.println(getName() + "の現在の得点は" + getTotalPoint() + "です。");
			System.out.println("21点を超えてバーストしました。" + getName() + "の負けです");
		} else {
			System.out.println(getName() + "の現在の得点は" + getTotalPoint() + "です。");
		}
	}

	public void drawCardOrAsk(Deck deck) {
		if (!this.isBurst) {
			Scanner sc = new Scanner(System.in);
			try {
				Object input = new Object();
				while (!this.isBurst && !input.equals("N")) {
					System.out.println("カードを引きますか？引く場合はYを、引かない場合はNを押してください");
					input = sc.nextLine();
					if (input.equals("Y")) {
						Card card = deck.draw();
						addHasHandList(card);
						System.out.print(getName() + "引いたカードは" + card.getSuit() + "の" + card.NoString() + "です\n");
						this.cardCalculation();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("YとN以外が入力されました。");
			}

		}
	}
}
