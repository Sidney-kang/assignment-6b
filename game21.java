package assignments;

import java.util.Scanner;

public class assignment6b
{
	static Player user = new Player();
	static Player computer = new Player();

	public static void main(String[] args) {
		DeckOfCards newDeck = new DeckOfCards();

		Card newCardToDeal1 = newDeck.GetACard();
		Card newCardToDeal2 = newDeck.GetACard();
		Card[] cardsToDealToUser = new Card[] { newCardToDeal1, newCardToDeal2 };

		user.DealNewCards(cardsToDealToUser);

		newCardToDeal1 = newDeck.GetACard();
		newCardToDeal2 = newDeck.GetACard();
		Card newCardToDeal3 = newDeck.GetACard();
		Card[] cardsToDealToComputer = new Card[] { newCardToDeal1, newCardToDeal2, newCardToDeal3 };
		computer.DealNewCards(cardsToDealToComputer);

		System.out.println("User Cards:\n" + user + "\n");

		System.out.println("Do you want another card?");

		String userInput;
		Scanner inputScanner = new Scanner(System.in);
		userInput = inputScanner.next();

		Card thridCardForUser;
		if (userInput.equalsIgnoreCase("Yes")) {
			thridCardForUser = newDeck.GetACard();
			user.DealThirdCard(thridCardForUser);
		}
		int cardSumForUser = user.GetSumOfAllDealtCards();
		int cardSumForComputer = computer.GetSumOfAllDealtCards();

		if (
		    cardSumForComputer == cardSumForUser
		            || 0 < cardSumForComputer && cardSumForComputer > 21 && cardSumForUser > 21 || cardSumForUser > 21
		)
		{
			System.out.println("Computer Cards:\n" + computer + "\n");
			System.out.println("Card sum for user = " + cardSumForUser);
			System.out.println("Card sum for computer = " + cardSumForComputer);
			System.out.println(" You lost");
		} else if (0 < cardSumForComputer && cardSumForComputer < 21 && cardSumForComputer > cardSumForUser) {
			System.out.println("Computer Cards:\n" + computer + "\n");
			System.out.println("Card sum for user = " + cardSumForUser);
			System.out.println("Card sum for computer = " + cardSumForComputer);
			System.out.println(" You lost");
		} else if (
		    0 < cardSumForComputer && cardSumForComputer < 21 && cardSumForUser < 21
		            && cardSumForComputer < cardSumForUser
		)
		{
			System.out.println("Computer Cards:\n" + computer + "\n");
			System.out.println("Card sum for user=" + cardSumForUser);
			System.out.println("Card sum for computer=" + cardSumForComputer);
			System.out.println(" You won");
		}
	}
}

package assignments;

public class Card
{
	public Card(String n, int v)
	{
		name = n;
		value = v;
		isAvailableToDeal = true;
	}

	public Boolean IsCardAvailableToDeal() {
		return isAvailableToDeal;
	}

	public void SetCardHasBeenDealt() {
		isAvailableToDeal = false;
	}

	public void SetCardIsAvailableToDeal() {
		isAvailableToDeal = true;
	}

	public String toString() {
		return "Card: " + name;
	}

	public int value;
	public String name;
	public Boolean isAvailableToDeal;
}

package assignments;

import java.util.Random;

public class DeckOfCards
{
	String[] suit = { "Hearts", "Diamonds", "Spades", "Clubs" };

	String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	int[] validCardValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10 };

	public DeckOfCards()
	{
		for (int i = 0; i < deckOfCards.length; i++) {

			deckOfCards[i] = new Card(rank[i % 13] + " " + suit[i / 13], validCardValues[i % 13]);
			// System.out.print(deckOfCards[i] + "\n");
		}
	}

	public Card GetACard() {
		Random r = new Random();
		int nextRandomCardIdx;
		Card randomlySelectedCard;
		do {
			nextRandomCardIdx = r.nextInt(52);
			randomlySelectedCard = deckOfCards[nextRandomCardIdx];
		} while (!randomlySelectedCard.IsCardAvailableToDeal());

		/*
		 * System.out.println("Next randomly selected card idx=" + nextRandomCardIdx +
		 * "\n" + randomlySelectedCard + "\n");
		 */
		randomlySelectedCard.SetCardHasBeenDealt();
		return randomlySelectedCard;
	}

	public Card[] deckOfCards = new Card[52];
}

package assignments;

public class Player
{
	public void DealNewCards(Card[] cardsToDeal) {
		for (int idx = 0; idx < cardsToDeal.length; idx++) {
			dealtCards[idx] = cardsToDeal[idx];
		}
	}

	public void DealThirdCard(Card thirdCard) {
		dealtCards[2] = thirdCard;
	}

	public int GetSumOfAllDealtCards() {
		int sumOfDealtCardValues = 0;
		for (int i = 0; i < dealtCards.length; i++) {
			if (dealtCards[i] == null) {
				continue;
			}
			sumOfDealtCardValues += dealtCards[i].value;
		}

		return sumOfDealtCardValues;
	}

	public String playerType;
	public Card[] dealtCards = new Card[3];

	public String toString() {
		String dealtCardsSummary = "";
		for (int i = 0; i < dealtCards.length; i++) {
			if (dealtCards[i] == null) {
				continue;
			}
			dealtCardsSummary += "Card #" + (i + 1) + "\n" + dealtCards[i] + "\n";
		}

		return dealtCardsSummary;
	}
}
