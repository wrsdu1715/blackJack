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
	
	public void calcTotalPoint() {
		this.totalPoint = 0;
		for (Card card : hasHandList) {
			this.totalPoint += card.point();
		}
		this.checkTotalPointBurst();
	}
	
	public void addHasHandList(Card card) {
		hasHandList.add(card);
	}
	
	public void checkTotalPointBurst() {
		if (this.totalPoint >= this.BURST_POINT) { this.isBurst = true; }
	}
	
}
