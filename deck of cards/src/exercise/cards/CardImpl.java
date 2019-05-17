package exercise.cards;

public class CardImpl implements Card {
	
	private CardSuit suit;
	
	private CardRank rank;
	
	public CardImpl(CardSuit suit, CardRank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public CardSuit getSuit() {
		return suit;
	}

	@Override
	public CardRank getRank() {
		return rank;
	}
	
	public boolean equals(Card anotherCard) {
		return this.getRank().equals(anotherCard.getRank()) 
				&& this.getSuit().equals(anotherCard.getSuit());
	}

	@Override
	public int hashCode() {
		return (this.getSuit().ordinal() * 13) + this.getRank().ordinal();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		Class<CardImpl> type = CardImpl.class;
		if (type.isInstance(obj)) {
			result = equals(type.cast(obj));
		}
		
		return result;
	}

	@Override
	public String toString() {
		return this.getSuit().name() + ":" + this.getRank().name();
	}

}
