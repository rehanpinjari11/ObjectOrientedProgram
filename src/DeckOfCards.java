import java.util.Random;

public class DeckOfCards {

        // Suits and Ranks of the cards
        private static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
        private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Deck of cards
        private String[] deck = new String[52];

        public DeckOfCards()
        {
            // Initialize the deck with all combinations of suits and ranks
            int index = 0;
            for (String suit : SUITS)
            {
                for (String rank : RANKS)
                {
                    deck[index++] = rank + " of " + suit;
                }
            }
        }

        // Method to shuffle the deck
        public void shuffle()
        {
            Random random = new Random();
            for (int i = 0; i < deck.length; i++)
            {
                int randomIndex = random.nextInt(52);
                String temp = deck[i];
                deck[i] = deck[randomIndex];
                deck[randomIndex] = temp;
            }
        }

        // Method to distribute cards to 4 players
        public String[][] distributeCards()
        {
            String[][] playersCards = new String[4][9];
            int cardIndex = 0;

            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    playersCards[i][j] = deck[cardIndex++];
                }
            }

            return playersCards;
        }

        // Method to print the cards received by each player
        public void printCards(String[][] playersCards)
        {
            for (int i = 0; i < 4; i++)
            {
                System.out.println("Player " + (i + 1) + "'s cards:");
                for (int j = 0; j < 9; j++)
                {
                    System.out.println(playersCards[i][j]);
                }
                System.out.println();
            }
        }

        public static void main(String[] args)
        {
            DeckOfCards deckOfCards = new DeckOfCards();
            deckOfCards.shuffle();
            String[][] playersCards = deckOfCards.distributeCards();
            deckOfCards.printCards(playersCards);
        }

}



