package blackJack;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("----  �u���b�N�W���b�N�ւ悤���� ----");
		System.out.println("�Q�[�����J�n���܂�");

		User user = new User("���Ȃ�");
		Dealer dealer = new Dealer("�f�B�[���[");

		Deck deck = new Deck();

		// �ŏ��ɓ񖇎擾����
		user.initialSet(deck);
		dealer.initialSet(deck);

		user.drawCard(deck);

		if (!user.getIsBurst()) {
			dealer.showSecondCard();
			dealer.drawCard(deck);

			dealer.gameResult(dealer, user);
		}
		
		System.out.println("---- ����� ----");
	}
}
