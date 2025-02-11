package Assignment1;

import java.util.ArrayList;
import java.util.Collections;

public class Play implements App{
  public void start(){
    int num = Main.db.getDeckNum();

    for(int i = 0; i < num; i++){
      System.out.println(i+1 + ". " + Main.db.getName(i));
    }

    System.out.println("Тоглох цуглуулгийн дугаар:");

    int indexDeck = MyScanner.scanInt();
    indexDeck--;

    int size = Main.db.getDeckSize(indexDeck);

    ArrayList<Integer> indices = new ArrayList<>();
    for(int i = 0; i < size; i++){
      indices.add(i);
    }
    Collections.shuffle(indices);

    boolean cont = true;
    int count = 0;
    int cardDeck;
    String pAnswer;
    int point = 0;

    while(cont == true && count < size){
      cardDeck = indices.get(count);
      Card card = Main.db.selectCard(indexDeck, cardDeck);
      System.out.println("Асуулт : " + card.getQuestion());
      System.out.print("Хариулт : ");
      pAnswer = MyScanner.scanLine();

      if(card.checkAnswer(pAnswer)){
        System.out.println("*** Зөв хариуллаа ***\n");
        point++;
      } else {
        System.out.println("*** Буруу хариуллаа ***");
        System.out.println("*** Зөв хариулт : " + card.getAnswer() + " ***\n");
      }

      count++;
      if(count == size){
        System.out.println("Цуглуулгийн бүх картаар тоглож дууслаа.");
        System.out.println("*** Оноо: " + point + " ***\n");
        break;
      }

      System.out.println("1. Үргэлжлүүлэх.");
      System.out.println("2. Буцах.");

      int ch = MyScanner.scanInt();

      if(ch == 2){
        cont = false;
        System.out.println("*** Оноо: " + point + " ***\n");
      }
    }
  }

  public String getCaption(){
    return "Play";
  }
}

