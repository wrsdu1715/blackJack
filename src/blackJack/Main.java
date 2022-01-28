package blackJack;

public class Main {

	public static void main(String[] args) {

		User user = new User("あなた");
		Dealer dealer = new Dealer("ディーラー");

		Deck deck = new Deck();

		// 最初に二枚取得する
		user.initialSet(deck);
		dealer.initialSet(deck);

		user.cardCalculation();
		user.drawCardOrAsk(deck);

		dealer.showSecondCard();
		dealer.cardCalculation();
		dealer.drawCard(deck);

		dealer.gameResult(dealer, user);
	}
}
