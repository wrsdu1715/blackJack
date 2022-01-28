package blackJack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User {

	private String name;
	List<Card> hasHandList = new ArrayList<Card>();
	private boolean isBurst = false;
	private int totalPoint = 0;

	public User(String name) {
		this.name = name;
	}

	public void initialSet(Deck deck) {
		// 普通に2回関数実行させたほうが処理速度早い？
		for (int i = 0; i < 2; i++) {
			Card card = deck.draw();
			hasHandList.add(card);
			System.out.println(this.name + "が引いたカードは" + card.getSuit() + "の" + card.NoString() + "です");
		}
	}

	public int getTotalPoint() {
		return this.totalPoint;
	}

	public String getName() {
		return this.name;
	}

	public void cardCalculation() {
		this.totalPoint = 0;
		for (Card list : hasHandList) {
			this.totalPoint += list.point();
		}

		if (this.totalPoint > 22) {
			System.out.println("21点を超えてバーストしました。" + this.name + "の負けです");
			this.isBurst = true;
		} else {
			System.out.println(this.name + "の現在の得点は" + this.totalPoint + "です。");
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
						hasHandList.add(card);
						System.out.print(this.name + "引いたカードは" + card.getSuit() + "の" + card.NoString() + "です\n");
						this.cardCalculation();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("YとN以外が入力されました。");
			}

		}
	}
}
