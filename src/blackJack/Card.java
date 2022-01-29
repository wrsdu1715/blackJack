package blackJack;

public class Card {
	private int rank;
	private String suit;

	public Card(String suit, int rank) {
		this.rank = rank;
		this.suit = suit;
	}

	public int getPoint() {
		return this.rank;
	}

	public String getSuit() {
		return this.suit;
	}

	public String NoString() {
		switch (this.rank) {
		case 1:
			return "A";
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
		default:
			return String.valueOf(this.rank);
		}
	}

	public int point() {
		switch (this.rank) {
		case 11:
		case 12:
		case 13:
			return 10;
		default:
			return this.rank;
		}
	}
	
	
}
