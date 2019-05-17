package exercise.cards;

import java.util.ArrayList;
import java.util.List;

/**
 * this class represents a set of playing cards containing 52 cards
 * 
 * @author saman
 *
 */
public class CardGenerator {

	public CardGenerator() {

	}

	public static Card[] generateCardArray() {
		List<Card> cardList = new ArrayList<>(52);
		addAllSuits(cardList);
		return cardList.toArray(new Card[0]);
	}
	
	public static List<Card> generateCardList() {
		List<Card> cardList = new ArrayList<>(52);
		addAllSuits(cardList);
		return cardList;
	}

	private static void addAllSuits(List<Card> cardList) {
		for (CardSuit oneCardSuit : CardSuit.values()) {
			addAllRanks(cardList, oneCardSuit);
		}
	}

	private static void addAllRanks(List<Card> cardList, CardSuit cardSuit) {
		for (CardRank oneCardRank : CardRank.values()) {
			cardList.add(new CardImpl(cardSuit, oneCardRank));
		}
	}


}
