package aryahmph.util;

import java.util.Scanner;

public class InputUtil {
  public static Scanner scanner = new Scanner(System.in);

  public static String input(String text) {
    System.out.print(text + " : ");
    return scanner.nextLine();
  }
}
