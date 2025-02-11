package Assignment1;

public interface IDeck {
  public String getName();
  public void addCard(Card card);
  public void removeCard(int i);
  public int getSize();
  public Card getCard(int i);
  public void setCard(int i, Card card);
  public void printAll();
}
