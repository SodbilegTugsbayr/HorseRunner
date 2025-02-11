package Assignment1;

import java.util.ArrayList;

public class DB implements IDB{
  FileManager file = new FileManager();

  private ArrayList<Deck> decks = new ArrayList<>();

  public void initializeDB(){
    ArrayList<ArrayList<String>> lines = file.scanLines();

    for(int i = 0; i < lines.size(); i++){
      Deck d = new Deck(lines.get(i).get(0));
      for(int j = 1; j < lines.get(i).size(); j++){
        String line = lines.get(i).get(j);
        String[] words = line.split(" ");
        Card c = new Card(words[0], words[1]);
        d.addCard(c);
      }
      decks.add(d);
    }
  }

  public Card selectCard(int indexDeck, int cardDeck) {
    return decks.get(indexDeck).getCard(cardDeck);
  }

  public void deleteCard(int indexDeck, int cardDeck) {
    file.clearFile(indexDeck);
    decks.get(indexDeck).removeCard(cardDeck);

    for(int i = 0; i < decks.get(indexDeck).getSize(); i++){
      String line;
      Card card = decks.get(indexDeck).getCard(i);
      line = card.getQuestion() + " " + card.getAnswer();
      file.writeText(indexDeck, line);
    }
  }

  public void updateCard(int indexDeck, int cardDeck, String question, String answer) {
    Card card = new Card(question, answer);
    decks.get(indexDeck).setCard(cardDeck, card);

    file.clearFile(indexDeck);

    for(int i = 0; i < decks.get(indexDeck).getSize(); i++){
      String line;
      card = decks.get(indexDeck).getCard(i);
      line = card.getQuestion() + " " + card.getAnswer();
      file.writeText(indexDeck, line);
    }
  }

  public void addCard(int indexDeck, Card card){
    decks.get(indexDeck).addCard(card);
    String line = card.getQuestion() + " " + card.getAnswer();
    file.writeText(indexDeck, line);
  }

  public void addDeck(String name){
    file.writeText(getDeckNum(), name);
    Deck d = new Deck(name);
    decks.add(d);
  }

  public void deleteDeck(int i){
    for(int j = i; j < getDeckNum(); j++){
      file.renameFile(j, j-1);
    }
    decks.remove(i-1);
    file.deleteFile(getDeckNum());
  }

  public void showDecks() {
    int num = getDeckNum();

    for(int i = 0; i < num; i++){
      System.out.println(i+1 + ". " + getName(i));
    }
  }

  public void showCards(int i){
    decks.get(i).printAll();
  }

  public String getName(int i){
    return decks.get(i).getName();
  }

  public int getDeckNum(){
    return decks.size();
  }

  public int getDeckSize(int i){
    return decks.get(i).getSize();
  }
}
