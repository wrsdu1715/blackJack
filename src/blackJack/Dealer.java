package blackJack;

import java.util.List;

public class Dealer extends Player {

	public Dealer(String name) {
		super(name);
	}

	public void initialSet(Deck deck) {
		for (int i = 0; i < 2; i++) {
			if (i == 1) {
				draw(deck, true);
			} else {
				draw(deck, false);
			}
		}
	}

	public void showSecondCard() {
		List<Card> list = getHasHandList();
		Card card = list.get(1);
		System.out.println(getName() + "の2枚目は" + card.getSuit() + "の" + card.NoString() + "でした。");
		statusNotice(false);
	}

	public void drawCard(Deck deck) {
		while (getTotalPoint() < 17 && !getIsBurst()) {
			draw(deck, false);
			statusNotice(false);
		}
	}

	public void gameResult(Dealer dealer, User user) {
		System.out.println(user.getName() + "の得点は" + user.getTotalPoint() + "です");
		if (dealer.getTotalPoint() == user.getTotalPoint()) {
			System.out.println("引き分けです");
		} else {
			if (!dealer.getIsBurst() && (dealer.getTotalPoint() > user.getTotalPoint())) {
				System.out.println(getName() + "の勝ちです");
			} else {
				System.out.println(user.getName() + "の勝ちです");
			}
		}

	}
}
