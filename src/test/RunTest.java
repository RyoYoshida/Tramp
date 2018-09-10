package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Card;
import main.Deck;
import main.Run;

class RunTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {}

	@AfterAll
	static void tearDownAfterClass() throws Exception {}

	@BeforeEach
	void setUp() throws Exception {}

	@AfterEach
	void tearDown() throws Exception {}

	@Test
	void test1() {
		Card card = new Card(Card.Mark.HEART, 10);
		Run.outputCard(card);
	}

	@Test
	void test2() {
		Card card;
		Deck deck = new Deck();

		card = deck.draw();
		Run.outputCard(card);
		card = deck.draw();
		Run.outputCard(card);
		card = deck.draw();
		Run.outputCard(card);

		deck.shuffle();

		card = deck.draw();
		Run.outputCard(card);
		card = deck.draw();
		Run.outputCard(card);
		card = deck.draw();
		Run.outputCard(card);
	}

	@Test
	void test3() {
		Deck deck = new Deck();
	    deck.put(new Card(Card.Mark.DIA, 11));
	    deck.put(new Card(Card.Mark.HEART, 10));
		Run.battle(deck);

	    deck.put(new Card(Card.Mark.DIA, 9));
	    deck.put(new Card(Card.Mark.HEART, 10));
		Run.battle(deck);

	    deck.put(new Card(Card.Mark.DIA, 1));
	    deck.put(new Card(Card.Mark.HEART, 10));
		Run.battle(deck);

	    deck.put(new Card(Card.Mark.DIA, 10));
	    deck.put(new Card(Card.Mark.HEART, 10));
		Run.battle(deck);

	    deck.put(new Card(Card.Mark.HEART, 10));
	    deck.put(new Card(Card.Mark.HEART, 10));
		Run.battle(deck);

	    deck.put(new Card(Card.Mark.HEART, 10));
	    deck.put(Card.createJoker());
		Run.battle(deck);
	}
}
