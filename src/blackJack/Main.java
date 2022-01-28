package blackJack;

public class Main {

	public static void main(String[] args) {

		User user = new User("���Ȃ�");
		Dealer dealer = new Dealer("�f�B�[���[");

		Deck deck = new Deck();

		// �ŏ��ɓ񖇎擾����
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
