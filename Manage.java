package Assignment1;

public class Manage implements App{
  public void start(){
    boolean cont = true;
    int ch;
    while(cont == true){
      printMenu();
      ch = MyScanner.scanInt();

      switch (ch) {
        case 1:
          manageDeck();
          break;
        case 2:
          System.out.println("Шинэ цуглуулгийн нэр:");
          String name = MyScanner.scanLine();
          Main.db.addDeck(name);
          break;
        case 3:
          Main.db.showDecks();
      
          System.out.println("Устгах цуглуулгийн дугаар:");
      
          int indexDeck = MyScanner.scanInt();

          Main.db.deleteDeck(indexDeck);
          break;
        case 4:
          cont = false;
          break;
        default:
          System.out.println("1-4 хоорондох тоо оруулна уу.");
          break;
      }
    }
  }

  public String getCaption(){return "Manager";}

  private void manageDeck(){
    boolean cont = true;
    int ch;

    Main.db.showDecks();

    System.out.println("Өөрчлөх цуглуулгийн дугаар:");

    int indexDeck = MyScanner.scanInt();
    indexDeck--;

    while(cont == true){
      printSubMenu();
      ch = MyScanner.scanInt();
      switch (ch) {
        case 1:
          System.out.println("Асуулт:");
          String question = MyScanner.scanLine();
          System.out.println("Хариулт:");
          String answer = MyScanner.scanLine();
          Card card = new Card(question, answer);
          Main.db.addCard(indexDeck, card);
          break;
        case 2:
          Main.db.showCards(indexDeck);
          break;
        case 3:
          Main.db.showCards(indexDeck);
          System.out.println("Хасах картны дугаар оруулна уу:");
          int cardDeck = MyScanner.scanInt();
          cardDeck--;
          Main.db.deleteCard(indexDeck, cardDeck);
          System.out.println("Амжилттай хаслаа.");
          break;
        case 4:
          Main.db.showCards(indexDeck);
          System.out.println("Шинэчлэх картны дугаар оруулна уу:");
          cardDeck = MyScanner.scanInt();
          cardDeck--;
          System.out.println("Асуулт:");
          question = MyScanner.scanLine();
          System.out.println("Хариулт:");
          answer = MyScanner.scanLine();
          Main.db.updateCard(indexDeck, cardDeck, question, answer);
          break;
        case 5:
          cont = false;
          break;
        default:
          System.out.println("1-3 хоорондох тоо оруулна уу.");
          break;
      }
    }
  }

  private void printMenu(){
    System.out.println("\n1. Цуглуулга өөрчлөх.");
    System.out.println("2. Цуглуулга нэмэх.");
    System.out.println("3. Цуглуулга хасах.");
    System.out.println("4. Буцах.\n");
  }

  private void printSubMenu(){
    System.out.println("\n1. Карт нэмэх.");
    System.out.println("2. Картууд харах.");
    System.out.println("3. Карт хасах.");
    System.out.println("4. Карт шинэчлэх");
    System.out.println("5. Буцах.\n");
  }
}
