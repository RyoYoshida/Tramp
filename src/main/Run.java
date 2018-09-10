package main;

public class Run {
	public static void main(String args[]){
		Deck deck = new Deck();
		deck.shuffle();

		battle(deck);
	}

	public static void outputCard(Card card) {
		System.out.println(card.getMarkAndNumber() + "�ł��B");
	}

	public static void battle(Deck deck) {
		System.out.println("�J�[�h��2��������2���ڂƏ������܂��B");
		Card card1 = deck.draw();
		Card card2 = deck.draw();
		outputCard(card1);
		outputCard(card2);

		int compare = card1.compare(card2);
		if(compare < 0) {
			System.out.println("�����ł��B");
		}else if(compare > 0) {
			System.out.println("�����ł��B");
		}else {
			System.out.println("���������ł��B");
		}
	}
}
