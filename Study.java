package Assignment1;

public class Study implements App{
  public void start(){
    int num = Main.db.getDeckNum();

    for(int i = 0; i < num; i++){
      System.out.println( "------" + Main.db.getName(i) + "------");
      Main.db.showCards(i);
      System.out.println("\n\n");
    }
    System.out.println("Буцах бол enter дарна уу.");
    MyScanner.scanLine();
  }
  public String getCaption(){return "Study";}
}