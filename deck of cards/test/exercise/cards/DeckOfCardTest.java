package exercise.cards;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import exercise.cards.Card;
import exercise.cards.CardDeck;
import exercise.cards.CardDeckImpl;
import exercise.cards.CardGenerator;
import exercise.cards.CardSuit;

public class DeckOfCardTest {

	@Test
	public void testcardGenerator() {
		Card[] generatedDeck = CardGenerator.generateCardArray();

		Assert.assertTrue(generatedDeck.length == 52);
		
		Assert.assertTrue(Stream.of(generatedDeck).filter(card -> card.getSuit() == CardSuit.Club).count() == 13);
		Assert.assertTrue(Stream.of(generatedDeck).filter(card -> card.getSuit() == CardSuit.Diamond).count() == 13);
		Assert.assertTrue(Stream.of(generatedDeck).filter(card -> card.getSuit() == CardSuit.Heart).count() == 13);
		Assert.assertTrue(Stream.of(generatedDeck).filter(card -> card.getSuit() == CardSuit.Spade).count() == 13);
	}

	@Test
	public void testCardDeck() {
		CardDeck oneDeck = new CardDeckImpl();
		
		oneDeck.shuffle();
		
		TreeSet<Card> cardSet = new TreeSet<Card>(new Comparator<Card>() {

			@Override
			public int compare(Card c1, Card c2) {
				int result = -1;
				
				if (c1 != null && c2 != null) {
					result = c1.getSuit().compareTo(c2.getSuit());
					if (result == 0) {
						result = c1.getRank().compareTo(c2.getRank());
					}
				}
				
				return result;
			}
		});
		
		Card oneCard = null;;
		do {
			oneCard = oneDeck.dealOneCard();
			if (oneCard != null) {
				cardSet.add(oneCard);
				System.out.println(oneCard);
			}
		} while (oneCard != null);
		
		System.out.println(cardSet);
		Assert.assertTrue(cardSet.size() + " cards", cardSet.size() == 52);
	}

}
