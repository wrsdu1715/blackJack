package blackJack;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
	private final String NAME;
	private final int BURST_POINT = 21;
	private int totalPoint = 0;
	private boolean isBurst = false;
	private	List<Card> hasHandList = new ArrayList<Card>();
	
	public Player(String name) {
		this.NAME = name;
	}
	
	public String getName() {
		return this.NAME;
	}
	
	public int getTotalPoint() {
		return this.totalPoint;
	}
	
	public boolean getIsBurst() {
		return this.isBurst;
	}
	
	public List<Card> getHasHandList() {
		return this.hasHandList;
	}
	
	public void calcTotalPoint() {
		this.totalPoint = 0;
		for (Card card : hasHandList) {
			this.totalPoint += card.point();
		}
		checkTotalPointBurst();
	}
	
	public void addHasHandList(Card card) {
		hasHandList.add(card);
	}
	
	public void checkTotalPointBurst() {
		if (this.totalPoint > this.BURST_POINT) { this.isBurst = true; }
	}
	
	public void draw(Deck deck, boolean isMask) {
		Card card = deck.draw();
		addHasHandList(card);
		
		if (isMask) {
			System.out.println(this.NAME + "の引いたカードは分かりません");
		} else {
			System.out.println(this.NAME + "の引いたカードは" + card.getSuit() + "の" + card.NoString() + "です");
		}
		
		calcTotalPoint();
	}
	
	public void statusNotice(boolean isPlayer) {
		System.out.println(getName() + "の現在の得点は" + getTotalPoint() + "です。");
		if (isPlayer && this.isBurst) {
			System.out.println("21点を超えてバーストしました。" + getName() + "の負けです");
		}
	}
	
	public abstract void drawCard(Deck deck);
	
	public abstract void initialSet(Deck deck);
}
