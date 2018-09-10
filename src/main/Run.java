package main;

public class Run {
	public static void main(String args[]){
		Deck deck = new Deck();
		deck.shuffle();

		battle(deck);
	}

	public static void outputCard(Card card) {
		System.out.println(card.getMarkAndNumber() + "です。");
	}

	public static void battle(Deck deck) {
		System.out.println("カードを2枚引いて2枚目と勝負します。");
		Card card1 = deck.draw();
		Card card2 = deck.draw();
		outputCard(card1);
		outputCard(card2);

		int compare = card1.compare(card2);
		if(compare < 0) {
			System.out.println("勝ちです。");
		}else if(compare > 0) {
			System.out.println("負けです。");
		}else {
			System.out.println("引き分けです。");
		}
	}
}
