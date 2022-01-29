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
		calcTotalPoint();
	}

	public void showSecondCard() {
		List<Card> list = getHasHandList();
		Card card = list.get(1);
		System.out.println(getName() + "��2���ڂ�" + card.getSuit() + "��" + card.NoString() + "�ł����B");
	}

	public void drawCard(Deck deck) {
		while (getTotalPoint() < 17 && !getIsBurst()) {
			draw(deck, false);
			calcTotalPoint();
			statusNotice(false);
		}
	}

	public void gameResult(Dealer dealer, User user) {
		System.out.println(user.getName() + "�̓��_��" + user.getTotalPoint() + "�ł�");
		if (dealer.getTotalPoint() == user.getTotalPoint()) {
			System.out.println("���������ł�");
		} else {
			if (!dealer.getIsBurst() && (dealer.getTotalPoint() > user.getTotalPoint())) {
				System.out.println(getName() + "�̏����ł�");
			} else {
				System.out.println(user.getName() + "�̏����ł�");
			}
		}

	}
}
