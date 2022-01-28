package blackJack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

	private String name;
	List<Card> hasHandList = new ArrayList<Card>();
	private int totalPoint = 0;

	public Dealer(String name) {
		this.name = name;
	}

	public void initialSet(Deck deck) {
		for (int i = 0; i < 2; i++) {
			Card card = deck.draw();
			hasHandList.add(card);
			if (i == 1) {
				System.out.println(this.name + "の引いたカードは分かりません");
			} else {
				System.out.println(this.name + "の引いたカードは" + card.getSuit() + "の" + card.NoString() + "です");
			}
		}
	}

	public int getTotalPoint() {
		return this.totalPoint;
	}

	public void showSecondCard() {
		Card card = hasHandList.get(1);
		System.out.println(this.name + "の2枚目は" + card.getSuit() + "の" + card.getPoint() + "でした。");
	}

	public void cardCalculation() {
		this.totalPoint = 0;
		for (Card list : hasHandList) {
			this.totalPoint += list.point();
		}
		System.out.println(this.name + "の現在の得点は" + this.totalPoint + "です。");
	}

	public void drawCard(Deck deck) {
		while (this.totalPoint < 17) {
			Card card = deck.draw();
			hasHandList.add(card);
			System.out.println(this.name + "が引いたカードは" + card.getSuit() + "の" + card.getPoint() + "です");
			this.totalPoint += card.getPoint();
		}
	}

	public void gameResult(Dealer dealer, User user) {
		if (dealer.getTotalPoint() == user.getTotalPoint()) {
			System.out.println("引き分けです");
		} else {
			if (dealer.getTotalPoint() > user.getTotalPoint()) {
				System.out.println(dealer.name + "の勝ちです");
			} else {
				System.out.println(user.getName() + "の勝ちです");
			}
		}

	}
}
