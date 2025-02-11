package Assignment1;

import java.util.ArrayList;

public class Deck implements IDeck{
  private String name;
  ArrayList<Card> cards = new ArrayList<>();

  public Deck(String theName){
    name = theName;
  }

  public String getName(){
    return name;
  }

  public void addCard(Card card) {
    cards.add(card);
  }

  public void removeCard(int i) {
    cards.remove(i);
  }

  public int getSize(){
    return cards.size();
  }

  public Card getCard(int i){
    return cards.get(i);
  }

  public void setCard(int i, Card card){
    cards.set(i, card);
  }
  
  public void printAll() {
    for(int i = 0; i < cards.size(); i++){
      System.out.print(i+1 + ". " + cards.get(i).getQuestion() + " - " + cards.get(i).getAnswer());
      System.out.println();
    }
  }
}
