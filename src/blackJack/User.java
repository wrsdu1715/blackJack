package blackJack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User extends Player{

	List<Card> hasHandList = new ArrayList<Card>();
	private boolean isBurst = false;

	public User(String name) {
		super(name);
	}

	public void initialSet(Deck deck) {
		// ���ʂ�2��֐����s�������ق����������x�����H
		for (int i = 0; i < 2; i++) {
			Card card = deck.draw();
			addHasHandList(card);
			System.out.println(getName() + "���������J�[�h��" + card.getSuit() + "��" + card.NoString() + "�ł�");
		}
	}

	public void cardCalculation() {
		calcTotalPoint();

		if (getIsBurst()) {
			System.out.println(getName() + "�̌��݂̓��_��" + getTotalPoint() + "�ł��B");
			System.out.println("21�_�𒴂��ăo�[�X�g���܂����B" + getName() + "�̕����ł�");
		} else {
			System.out.println(getName() + "�̌��݂̓��_��" + getTotalPoint() + "�ł��B");
		}
	}

	public void drawCardOrAsk(Deck deck) {
		if (!this.isBurst) {
			Scanner sc = new Scanner(System.in);
			try {
				Object input = new Object();
				while (!this.isBurst && !input.equals("N")) {
					System.out.println("�J�[�h�������܂����H�����ꍇ��Y���A�����Ȃ��ꍇ��N�������Ă�������");
					input = sc.nextLine();
					if (input.equals("Y")) {
						Card card = deck.draw();
						addHasHandList(card);
						System.out.print(getName() + "�������J�[�h��" + card.getSuit() + "��" + card.NoString() + "�ł�\n");
						this.cardCalculation();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Y��N�ȊO�����͂���܂����B");
			}

		}
	}
}
