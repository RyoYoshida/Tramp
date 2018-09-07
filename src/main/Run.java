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
	}

	public static void outputCard(Card card) {
		System.out.println(card.getMarkAndNumber() + "‚Å‚·B");
	}
}
