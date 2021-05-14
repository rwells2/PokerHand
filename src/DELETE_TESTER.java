
public class DELETE_TESTER 
{

	public static void main(String[] args) 
	{
		PokerHand hand = new PokerHand();
		System.out.println(hand.getBestHand());
		System.out.println(hand.toString());

		Card card1 = new Card('H',"J",11);
		Card card2 = new Card('D',"A",14);
		Card card3 = new Card('C',"8",8);
		Card card4 = new Card('D',"10",10);
		Card card5 = new Card('S',"5",5);
		Card[] cardArr = {card1, card2, card3, card4, card5};
		PokerHand hand2 = new PokerHand(cardArr);
		System.out.println("\n" + hand2.getBestHand());
		System.out.println(hand2.toString());
		
		Card cardTest1 = new Card('S',"A",14);
		Card cardTest2 = new Card('D',"4",4);
		Card[] switching = {cardTest1, cardTest2};
		int[] arr = {3,4};
		hand2.discard(arr, switching);
		System.out.println("\n" + hand2.toString());
		
		Deck deck = new Deck();
		deck.shuffle();
		for (int i=0; i<53; i++)
		{
			System.out.println(deck.deal());
		}
	}
}
