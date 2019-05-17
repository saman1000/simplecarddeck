package exercise.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * this class represents a set of playing cards containing 52 cards
 * 
 * @author saman
 *
 */
public class CardDeckImpl implements CardDeck {
	
	private int nextcardIndex;

	private List<Card> cardList;

	public CardDeckImpl() {
		nextcardIndex = 0;
		cardList = new ArrayList<>(52);
	}

	@Override
	public void shuffle() {
		cardList.clear();
		nextcardIndex = 0;
		LinkedList<Card> oneDeck = new LinkedList<>(CardGenerator.generateCardList());
		
		
		Map<Integer, List<Card>> cardMap = new HashMap<>();
		Random randomIntegers = new Random();
		randomIntegers.ints(52, 1, 1000).boxed().forEach(e -> addOneCard(cardMap, e, oneDeck.remove()));
		generateCardList(cardMap);
	}
	
	private void generateCardList(Map<Integer, List<Card>> cardMap) {
		for (Collection<Card> cardList : cardMap.values()) {
			this.cardList.addAll(cardList);
		}
	}
	
	private void addOneCard(Map<Integer, List<Card>> cardMap, Integer bucket, Card card) {
		List<Card> cardList;
		if (cardMap.containsKey(bucket)) {
			cardList = cardMap.get(bucket);
		} else {
			cardList = new ArrayList<Card>();
			cardMap.put(bucket, cardList);
		}
		
		cardList.add(card);
	}

	@Override
	public Card dealOneCard() {
		Card result = null;
		
		if (nextcardIndex < cardList.size()) {
			result = cardList.get(nextcardIndex++);			
		}
		
		return result;
	}

}
