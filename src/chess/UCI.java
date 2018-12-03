package chess;

import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.*;

public class UCI {

  // ===============================================================================================
  // CONSTANTS
  // ===============================================================================================
  public static final String ENGINENAME = "Chess destroyer";
  public static final String AUTHOR = "BERTUGLIA Camille, LEFEVRE Arnaud and SEIGNETTE Thomas";


  // ===============================================================================================
  // ATTRIBUTES
  // ===============================================================================================
  private Chessboard chessboard;
  private AI ai;


  // ===============================================================================================
  // PRIVATE METHODS
  // ===============================================================================================
  private void inputUCI() {
    System.out.println("id name " + ENGINENAME);
    System.out.println("id author " + AUTHOR);
    System.out.println("uciok");
  }

  private void setOptions(String input) {
    // Called when Arena sends options
  }

  private void isReady() {
    System.out.println("readyok");
  }

  private void newGame() {
    this.chessboard = new Chessboard();
    this.ai = new AI(this.chessboard);
  }

  private void newPosition(String input) {
    input = input.substring(9).concat(" ");

    if (input.contains("startpos ")) {
      input = input.substring(9);
      ai.setColor(AI.BLACK);
    }

    if (input.contains("moves")) {
      input = input.substring(input.indexOf("moves") + 6);
      Move move = Move.UCIToMove(input);
      this.chessboard.makeMove(move);
    }
  }

  private void go() {
    Move bestMove = ai.chooseBestMove();
    System.out.println("bestmove " + Move.moveToUCI(bestMove));
  }

  private void quit() {
    // Called when game is over
  }


  // ===============================================================================================
  // PUBLIC METHODS
  // ===============================================================================================
  public void listen() {
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

}
