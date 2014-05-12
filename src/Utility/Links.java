package Utility;
/**
 * Figures out suits, connectedness and matches between the cards generated
 * @author ashishbillava
 *
 */
public class Links 
{
	private String[] matchCards = {"Triplet", "Paired", "Unpaired"};
	private String[] connectedCards = {"3-straight", "Connector", "1-gap", "2-gap", "Other"};
	private String[] suitCards = {"Monotone", "Two-tone", "Rainbow"};
	private int matchC;
	private int connectC;
	
	public Links()
	{
		matchC = -1;
		connectC = -1;
	}
	
	public String suit(int someCardA, int someCardB, int someCardC)
	{
		int countCards = 0;
		matchC = -1;
		
		countCards = isSameSuit(someCardA, someCardB) + isSameSuit(someCardB, someCardC) + 
				isSameSuit(someCardA, someCardC);
		
		switch(countCards)
		{
			case 0:	return suitCards[2];
			case 1:	return suitCards[1];
			case 3: matchC = 2;
					return suitCards[0];
			default:System.out.println("ERROR MATCHING SUITS");
					System.exit(3);
					return "Error";
		}
	}
	
	public String match(int someCardA, int someCardB, int someCardC)
	{
		if(matchC >= 0)
		{
			return matchCards[matchC];
		}
		
		connectC = -1;
		int countCards = 0;
		
		countCards = isSameNumber(someCardA, someCardB) + isSameNumber(someCardB, someCardC) + 
				isSameNumber(someCardA, someCardC);
		
		switch(countCards)
		{
			case 0:	return matchCards[2];
			case 1:	return matchCards[1];
			case 3: connectC = 4;
					return matchCards[0];
			default:System.out.println("ERROR MATCHING FACE NUMBERS");
					System.exit(3);
					return "Error";
		}
	}
	
	public String connectedness(int someCardA, int someCardB, int someCardC)
	{
		if(connectC >= 0)
		{
			return connectedCards[connectC];
		}
		
		int connectedAB = isConnected(someCardA, someCardB);//2
		int connectedBC = isConnected(someCardB, someCardC);//1
		int connectedAC = isConnected(someCardA, someCardC);//1
		
		if(connectedAB < 4 || connectedBC < 4 || connectedAC < 4)
		{
			if(connectedAB + connectedBC + connectedAC == 4)
			{
				return connectedCards[0];
			}
			
			if(connectedAB <= connectedBC)
			{
				if(connectedAB <= connectedAC)
				{
					return connectedCards[connectedAB];
				}
				
				return connectedCards[connectedAC];
			}
			else
			{
				if(connectedBC <= connectedAC)
				{
					return connectedCards[connectedBC];
				}
				
				return connectedCards[connectedAC];
			}
		}
		
		return connectedCards[4];
	}
	
	public int isConnected(int someCardA, int someCardB)
	{
		if(someCardA < someCardB)
		{
			if(someCardA == 1 && someCardB >= 11)
			{
				return 14 - someCardB;
			}
			
			return someCardB - someCardA;
		}
		else if(someCardB < someCardA)
		{
			if(someCardB == 1 && someCardA >= 11)
			{
				return 14 - someCardA;
			}
			
			return someCardA - someCardB;
		}
		
		return 4;
	}
	
	public int isSameNumber(int someCardA, int someCardB)
	{
		if(someCardA == someCardB)
		{
			return 1;
		}
		
		return 0;
	}
	
	public int isSameSuit(int someCardA, int someCardB)
	{
		if(someCardA == someCardB)
		{
			return 1;
		}
		
		return 0;
	}
}