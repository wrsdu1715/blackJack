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
				System.out.println(this.name + "�̈������J�[�h�͕�����܂���");
			} else {
				System.out.println(this.name + "�̈������J�[�h��" + card.getSuit() + "��" + card.NoString() + "�ł�");
			}
		}
	}

	public int getTotalPoint() {
		return this.totalPoint;
	}

	public void showSecondCard() {
		Card card = hasHandList.get(1);
		System.out.println(this.name + "��2���ڂ�" + card.getSuit() + "��" + card.getPoint() + "�ł����B");
	}

	public void cardCalculation() {
		this.totalPoint = 0;
		for (Card list : hasHandList) {
			this.totalPoint += list.point();
		}
		System.out.println(this.name + "�̌��݂̓��_��" + this.totalPoint + "�ł��B");
	}

	public void drawCard(Deck deck) {
		while (this.totalPoint < 17) {
			Card card = deck.draw();
			hasHandList.add(card);
			System.out.println(this.name + "���������J�[�h��" + card.getSuit() + "��" + card.getPoint() + "�ł�");
			this.totalPoint += card.getPoint();
		}
	}

	public void gameResult(Dealer dealer, User user) {
		if (dealer.getTotalPoint() == user.getTotalPoint()) {
			System.out.println("���������ł�");
		} else {
			if (dealer.getTotalPoint() > user.getTotalPoint()) {
				System.out.println(dealer.name + "�̏����ł�");
			} else {
				System.out.println(user.getName() + "�̏����ł�");
			}
		}

	}
}
