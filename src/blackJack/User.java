package blackJack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class User extends Player{

	public User(String name) {
		super(name);
	}

	public void initialSet(Deck deck) {
		// ���ʂ�2��֐����s�������ق����������x�����H
		for (int i = 0; i < 2; i++) {
			draw(deck, false);
		}
		calcTotalPoint();
		statusNotice(true);
	}

	public void drawCardOrAsk(Deck deck) {
		if (!getIsBurst()) {
			Scanner sc = new Scanner(System.in);
			try {
				Object input = new Object();
				while (!getIsBurst() && !input.equals("N")) {
					System.out.println("�J�[�h�������܂����H�����ꍇ��Y���A�����Ȃ��ꍇ��N�������Ă�������");
					input = sc.nextLine();
					if (input.equals("Y")) {
						draw(deck, false);
						calcTotalPoint();
						statusNotice(true);
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Y��N�ȊO�����͂���܂����B");
			}

		}
	}
}
