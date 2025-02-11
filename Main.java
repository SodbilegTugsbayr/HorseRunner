package Assignment1;

public class Main {
  public static DB db = new DB();

  public static void main(String[] args){
    db.initializeDB();

    App[] apps = new App[3];
    apps[0] = new Manage();
    apps[1] = new Play();
    apps[2] = new Study();

    int ch;

    boolean cont = true;

    while(cont == true){
      System.out.println("1. " + apps[0].getCaption());
      System.out.println("2. " + apps[1].getCaption());
      System.out.println("3. " + apps[2].getCaption());
      System.out.println("4. Гарах.");
      
      ch = MyScanner.scanInt();

      if(ch == apps.length+1)
        cont = false;
      else if(ch >= 1 && ch <= apps.length)
        apps[ch-1].start();
      else System.out.println("1 - " + (apps.length + 1) + " хоорондох тоо оруулна уу");
    }
  }
}

