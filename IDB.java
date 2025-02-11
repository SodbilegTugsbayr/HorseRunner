package Assignment1;

public interface IDB {
  public void initializeDB();
  public Card selectCard(int indexDeck, int cardDeck);
  public void deleteCard(int indexDeck, int cardDeck);
  public void updateCard(int indexDeck, int cardDeck, String question, String answer);
  public void addCard(int indexDeck, Card card);
  public void addDeck(String name);
  public void deleteDeck(int i);
  public void showCards(int i);
  public String getName(int i);
  public int getDeckNum();
  public int getDeckSize(int i);
}
