package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	int[] ranks = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	String[] suits = { "�n�[�g", "�_�C��", "�X�y�[�h", "�N���[�o�[" };
	List<Card> decks = new ArrayList<Card>();

	public Deck() {
		// Joker�𔲂����J�[�h������
		for (String suit : suits) {
			for (int rank : ranks) {
				decks.add(new Card(suit, rank));
			}
		}
		Collections.shuffle(decks);
	}

	public Card draw() {
		Card card = decks.get(0);
		decks.remove(0);

		return card;
	}
}
