package blackJack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class User {

	private String name;
	List<Card> hasHandList = new ArrayList<Card>();
	private boolean isBurst = false;
	private int totalPoint = 0;

	public User(String name) {
		this.name = name;
	}

	public void initialSet(Deck deck) {
		// ���ʂ�2��֐����s�������ق����������x�����H
		for (int i = 0; i < 2; i++) {
			Card card = deck.draw();
			hasHandList.add(card);
			System.out.println(this.name + "���������J�[�h��" + card.getSuit() + "��" + card.NoString() + "�ł�");
		}
	}

	public int getTotalPoint() {
		return this.totalPoint;
	}

	public String getName() {
		return this.name;
	}

	public void cardCalculation() {
		this.totalPoint = 0;
		for (Card list : hasHandList) {
			this.totalPoint += list.point();
		}

		if (this.totalPoint > 22) {
			System.out.println("21�_�𒴂��ăo�[�X�g���܂����B" + this.name + "�̕����ł�");
			this.isBurst = true;
		} else {
			System.out.println(this.name + "�̌��݂̓��_��" + this.totalPoint + "�ł��B");
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
						hasHandList.add(card);
						System.out.print(this.name + "�������J�[�h��" + card.getSuit() + "��" + card.NoString() + "�ł�\n");
						this.cardCalculation();
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Y��N�ȊO�����͂���܂����B");
			}

		}
	}
}
