package Utility;
/**
 * Basic Card Class
 * @author ashishbillava
 *
 */
public class Card
{
	private int _face;
	private int _suit;
	private int _cardNumber;
	private String _cardFace; //card face
	private String _cardSuit; //card suits (ends with .png)
	private String _card; //holds both number and suit (name to point to image)
	
	public Card()
	{
		
	}
	
	public void setCardSuit(int suit, String cardSuit)
	{
		_suit = suit;
		_cardSuit = cardSuit;
	}
	
	public void setCardFace(int face, String cardFace)
	{
		_face = face;
		_cardFace = cardFace;
	}
	
	public void setCard(int suit, int face, int cardNumber, String cardSuit, String cardFace)
	{
		_suit = suit;
		_face = face;
		_cardSuit = cardSuit;
		_cardFace = cardFace;
		_cardNumber = cardNumber;
		_card = cardFace + cardSuit;
	}
	
	public int getSuitNumber()
	{
		return _suit;
	}
	
	public String getCardSuit()
	{
		return _cardSuit;
	}
	
	public int getFace()
	{
		return _face + 1;
	}
	
	public String getCardFace()
	{
		return _cardFace;
	}
	
	public int getCardNumber()
	{
		return _cardNumber;
	}
	
	public String getCard()
	{
		return _card;
	}
}
