import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class UCI {

  public static final String ENGINENAME = "Chess destroyer";
  public static final String AUTHOR = "BERTUGLIA Camille, LEFEVRE Arnaud and SEIGNETTE Thomas";

  public static void listen() {
    Scanner input = new Scanner(System.in);
    while (true) {
      String command = input.nextLine();

      if ("uci".equals(command))
        inputUCI();
      else if (command.startsWith("setoption"))
        setOptions(command);
      else if ("isready".equals(command))
        isReady();
      else if ("ucinewgame".equals(command))
        newGame();
      else if (command.startsWith("position"))
        newPosition(command);
      else if (command.startsWith("go"))
        go();
      else if ("quit".equals(command)) {
        quit();
        break;
      }
    }
    input.close();
  }

  private static void inputUCI() {
    System.out.println("id name " + ENGINENAME);
    System.out.println("id author " + AUTHOR);
    System.out.println("uciok");
  }

  private static void setOptions(String input) {
    // Called when Arena sends options
  }

  private static void isReady() {
    System.out.println("readyok");
  }

  private static void newGame() {
    // TODO: board init
  }

  private static void newPosition(String input) {
    // HINT: white if there is the string "startpos", black otherwise
    // TODO: update board
  }

  private static void go() {
    // TODO: choose best move
  }

  private static void quit() {
    // Called when game is over
  }

}
