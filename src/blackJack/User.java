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
		statusNotice(true);
	}

	public void drawCard(Deck deck) {
		Scanner sc = new Scanner(System.in);
		Object input = new Object();
		while (!getIsBurst() && !input.equals("N")) {
			System.out.println("�J�[�h�������܂����H�����ꍇ��Y���A�����Ȃ��ꍇ��N�������Ă�������");
			input = sc.nextLine().toUpperCase();
			if (input.equals("Y")) {
				draw(deck, false);
				statusNotice(true);
			} else if (!input.equals("N")) {
				System.out.println("Y/N�ȊO�����͂���܂���");
			}
		}
	}
}
