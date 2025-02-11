package Assignment1;

import java.util.Scanner;

public class MyScanner implements IMyScanner {
  private static Scanner sc = new Scanner(System.in);

  public static int scanInt() {
      int i = sc.nextInt();
      sc.nextLine();
      return i;
  }

  public static String scanLine() {
      return sc.nextLine();
  }
}