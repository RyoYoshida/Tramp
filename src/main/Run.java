package main;

public class Run {
	public static void main(String args[]){
		Card card = new Card(Card.Mark.HEART, 10);
		outputCard(card);

		Deck deck = new Deck();
		card = deck.draw();
		outputCard(card);
		card = deck.draw();
		outputCard(card);
		card = deck.draw();
		outputCard(card);

		deck.shuffle();
		card = deck.draw();
		outputCard(card);
		card = deck.draw();
		outputCard(card);
		card = deck.draw();
		outputCard(card);

		battle(deck);
	}

	public static void outputCard(Card card) {
		System.out.println(card.getMarkAndNumber() + "�ł��B");
	}

	public static void battle(Deck deck) {
		System.out.println("�J�[�h��2�������Ĕ��肵�܂��B");
		Card card1 = deck.draw();
		Card card2 = deck.draw();
		outputCard(card1);
		outputCard(card2);

		int compare = card1.compare(card2);
		if(compare > 0) {
			System.out.println(card1.getMarkAndNumber() + "�̏����ł��B");
		}else if(compare < 0) {
			System.out.println(card2.getMarkAndNumber() + "�̏����ł��B");
		}else {
			System.out.println("���������ł��B");
		}
	}
}
