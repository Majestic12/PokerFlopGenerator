package Utility;

/**
 * Generates and keeps track of cards generated
 * @author ashishbillava
 */
public class Cards
{
	private static final int SUIT = 4;
	private static final int FACE = 13;
	private static final int NUMBEROFCARDS = 52;
	
	private Card[] _cards; // all cards
	
	public Cards()
	{
		//initialize values
		_cards = new Card[NUMBEROFCARDS];
		
		//counter for cards array
		int countingCards = 0;
		String suit = "";
		String face = "";
		
		//generate card image names
		for(int i = 0; i < SUIT; i++)
		{
			switch(i)
			{
				case 0:	suit =  "_of_Hearts.png";
						break;
				case 1:	suit = "_of_Diamonds.png";
						break;
				case 2: suit = "_of_Clubs.png";
						break;
				case 3: suit = "_of_Spades.png";
						break;
				default: System.out.println("ERROR IN SETTING SUITS");
						System.exit(1);
						break;
			}
			
			for(int j = 0; j < FACE; j++)
			{
				switch(j)
				{
					case 0:	face = "Ace";
							break;
					case 1:	face = "2";
							break;
					case 2: face = "3";
							break;
					case 3: face = "4";
							break;
					case 4:	face = "5";
							break;
					case 5:	face = "6";
							break;
					case 6: face = "7";
							break;
					case 7: face = "8";
							break;
					case 8:	face = "9";
							break;
					case 9: face = "10";
							break;
					case 10: face = "Jack";
							break;
					case 11: face = "Queen";
							break;
					case 12: face = "King";
							break;
					default: System.out.println("ERROR IN SETTING FACE");
							System.exit(2);
							break;
				}
				
				_cards[countingCards] = new Card();
				_cards[countingCards].setCard(i, j, countingCards, suit, face);
				countingCards++;
			}
		}
	}
	
	/**
	 * Randomly generates card numbers
	 * @param numberOfCards number of cards to randomly generate
	 * @return array of Cards dealt
	 */
	public Card[] dealAndGetCards(int numberOfCards)
	{
		int[] dealtCardNumbers = getRandomCard(numberOfCards);
		Card[] cardsDealt = new Card[dealtCardNumbers.length];
		
		for(int i = 0; i < dealtCardNumbers.length; i++)
		{
			cardsDealt[i] = getCard(dealtCardNumbers[i]);
		}
		
		return cardsDealt;
	}
	
	public Card[] getAllCards()
	{
		return _cards;
	}
	
	public Card getCard(int cardNumber)
	{
		return _cards[cardNumber];
	}
	
	/**
	 * Randomly generated number (0-51) representing cards and stored into _dealtCards
	 * @param numberOfCards Number of Cards to randomly generate
	 * @return integer array containing card numbers
	 */
	private int[] getRandomCard(int numberOfCards)
	{
		if(numberOfCards > 52)
		{
			numberOfCards = 52;
		}
		
		int[] _dealtCards = new int[numberOfCards];
		
		for(int i = 0; i < numberOfCards; i++)
		{
			int Min = 0;
			int Max = 51;
			boolean repeat = false;
			int randomCard = 0;
			
			do
			{
				repeat = false;
				randomCard = Min + (int)(Math.random() * ((Max - Min) + 1));
				
				for(int j = 0; j < i + 1; j++)
				{	
					if(_dealtCards[j] == randomCard)
					{
						repeat = true;
					}
				}
				
			} while(repeat == true);
			
			_dealtCards[i] = randomCard;
		}
		
		return _dealtCards;
	}
}