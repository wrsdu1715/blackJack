package blackJack;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("----  ブラックジャックへようこそ ----");
		System.out.println("ゲームを開始します");

		User user = new User("あなた");
		Dealer dealer = new Dealer("ディーラー");

		Deck deck = new Deck();

		// 最初に二枚取得する
		user.initialSet(deck);
		dealer.initialSet(deck);

		user.drawCard(deck);

		if (!user.getIsBurst()) {
			dealer.showSecondCard();
			dealer.drawCard(deck);

			dealer.gameResult(dealer, user);
		}
		
		System.out.println("---- おわり ----");
	}
}
