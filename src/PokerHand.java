/**
 * 
 * @author Ryan Wells
 * Poker Hand
 *
 */

public class PokerHand 
{
	
	/*
	 * This field represents the cards in a player's hand
	 */
	private Card[] hand;
	
	
	/*
	 * TODO Create a constructor which takes no arguments and initializes
	 * the hand (our hand always has five cards) to an Ace of hearts, 
	 * King of hearts, Queen of hearts, Jack of hearts, and 10 of hearts.  
	 * This is a royal flush
	 *
	 */

	public PokerHand()
	{
		hand = new Card[5];
		for (int i=0; i<5; i++)
		{
			String rank = "10";
			if(i==1)
				rank = "J";
			else if (i==2)
				rank = "Q";
			else if (i==3)
				rank = "K";
			else if (i==4)
				rank = "A";
			
			Card card = new Card('H',rank,i+10);
			hand[i] = card;
		}
			
	}
	
	
	/* 
	 * TODO Create a constructor which takes an array of 5 Cards 
	 * as an argument and initializes the hand to the five cards 
	 * passed.
	 * 
	 */
	public PokerHand(Card[] initialHand)
	{
		hand = initialHand;
	}
	
	
	/**
	 * This method sortHandByValue will put your cards in order
	 * from smallest to largest.  It is private and can only be
	 * called in this class.  It may prove useful for you.
	 */
	private void sortHandByValue()
	{
		for(int i = 0; i < hand.length; i++)
		{
			int index = i;
			int minVal = hand[i].getValue();
			for(int j = i+1; j < hand.length; j++)
			{
				if(hand[j].getValue()< minVal)
				{
					index = j;
					minVal = hand[j].getValue();
				}
			}
			Card temp = hand[i];
			hand[i] = hand[index];
			hand[index] = temp;
		}
	}
	
	
	/*
	 * TODO write a method called getBestHand (sorting will help)
	 * this method will take no arguments and will return a String 
	 * identifying the best hand which can be made.  The possible hands 
	 * and return values are as follows. These are in order of precedence
	 * (the ones at the top are the best hands).
	 * return "Royal Flush" if all cards in the hand are the same
	 * 	  suit and the card ranks are A, K, Q, J, 10
	 * return "Straight Flush" if all cards are in the same suit
	 *    and the cards are all in consecutive order by value
	 *    ex.  7H, 8H, 9H, 10H, JH
	 * return "Four of a Kind" if there are four matching cards in hand
	 * 	  ex.  9D, 9H, 9S, 9C, 10D
	 * return "Flush" if all cards are the same suit.  Rank does
	 *    not matter.  Ex.  3S, 7S, 10S, KS, AS
	 * return "Straight" if all cards are in consecutive order
	 *    by value, but not the same suit.  Ex. 4H, 5C, 6H, 7D, 8S
	 * return "Full House" if there are a set of three matching
	 *    ranks and a separate set of two matching ranks.  
	 *    Ex. 4H, 4C, JD, JH, JS
	 * return "Three of a Kind" if there are three cards with the same
	 *    rank.  Ex 5C, 9H, QC, QH, QD
	 * return "Pair" if there are two matching ranks.  
	 *    Ex. 3D, 5D, 5H, KC, AH
	 * return "High (rank of highest card)" if none of the others apply
	 * 	  Ex.  3D, 6H, 10S, JD, QD would return "High Q"
	 */
	public String getBestHand()
	{
		sortHandByValue();
		
		//Royal Flush and Straight Flush
		if (hand[0].getSuit() == hand[1].getSuit() && hand[0].getSuit() == hand[2].getSuit() && 
				hand[0].getSuit() == hand[3].getSuit() && hand[0].getSuit() == hand[4].getSuit())
		{
			if (hand[0].getRank().equals("10") && hand[1].getRank().equals("J") && hand[2].getRank().equals("Q") &&
					hand[3].getRank().equals("K") && hand[4].getRank().equals("A"))
			{
				return "Royal Flush";
			}
			else if (hand[0].getValue()+1== hand[1].getValue() && hand[1].getValue()+1== hand[2].getValue() &&
					hand[2].getValue()+1== hand[3].getValue() && hand[3].getValue()+1== hand[4].getValue())
			{
				return "Straight Flush";
			}
		}
		
		//Four of a Kind Check
		if ((hand[0].getValue() == hand[1].getValue() && hand[1].getValue() == hand[2].getValue() && 
				hand[2].getValue() == hand[3].getValue()) || (hand[1].getValue() == hand[2].getValue() && 
				hand[2].getValue() == hand[3].getValue() && hand[3].getValue() == hand[4].getValue()))
			return "Four of a Kind";
		
		//Flush Check
		if (hand[0].getSuit() == hand[1].getSuit() && hand[0].getSuit() == hand[2].getSuit() && 
				hand[0].getSuit() == hand[3].getSuit() && hand[0].getSuit() == hand[4].getSuit())
			return "Flush";
		
		//Straight Check
		if (hand[0].getValue()+1== hand[1].getValue() && hand[1].getValue()+1== hand[2].getValue() &&
				hand[2].getValue()+1== hand[3].getValue() && hand[3].getValue()+1== hand[4].getValue())
			return "Straight";
		
		//Full House Check
		if (hand[0].getRank().equals(hand[1].getRank()) && hand[0].getRank().equals(hand[2].getRank()) &&
				hand[3].getRank().equals(hand[4].getRank()) || hand[0].getRank().equals(hand[1].getRank()) && 
				hand[2].getRank().equals(hand[3].getRank()) && hand[2].getRank().equals(hand[4].getRank()))
			return "Full House";
	
		//Three of a Kind Check
		if ((hand[0].getValue() == hand[1].getValue() && hand[1].getValue() == hand[2].getValue()) || 
				(hand[1].getValue() == hand[2].getValue() && hand[2].getValue() == hand[3].getValue()) ||
				(hand[2].getValue() == hand[3].getValue() && hand[3].getValue() == hand[4].getValue()))
			return "Three of a Kind";
		
		//Pair Check
		if ((hand[0].getValue() == hand[1].getValue()) || (hand[1].getValue() == hand[2].getValue()) || 
				(hand[2].getValue() == hand[3].getValue()) || (hand[3].getValue() == hand[4].getValue()))
			return "Pair";
		
		//Return Highest Rank
		return "High " + hand[4].getRank();
	}
	
	
	
	
	
	
	/*
	 * TODO write a toString method which returns a string containing
	 * the rank and suit of every card in the hand, separated by a comma
	 * Ex.  3D, 4D, 4D, 8S, KH
	 */
	public String toString()
	{
		sortHandByValue();
		String toString = "";
		for (int i=0; i<5; i++)
		{
			toString += hand[i].getRank() + hand[i].getSuit() + ", ";
		}
		return toString;
	}
	
	
	/*
	 * TODO Write a method called discard.  The goal of this method is 
	 * to choose cards to discard and replace with new cards.  The 
	 * method should take two arguments, 
	 * the first will be an int array which will store the indexes of 
	 * hand which are to be replaced, and the second is a Card array 
	 * which will contain the new cards to be placed into hand.
	 * Ex.  hand contains 4H,4D,4C,JS,KC  
	 * 		given int[] arr = {3,4};
	 * 		and Card[] cards = {4S,AD} //using shorthand to demonstrate
	 * 		after discard(arr,cards);
	 * 		hand would now contain 4H,4D,4C,4S,AD
	 * 
	 */
	public void discard(int[] arr, Card[] cardArr)
	{
		for (int i=0; i<arr.length; i++)
		{
			hand[arr[i]] = cardArr[i];
		}
	}
}
