package chess;

import java.util.Scanner;

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
  private int nbOfMoves = 0;


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
    this.nbOfMoves = 0;
  }

  private void newPosition(String input) {
    input = input.substring(9).concat(" ");

    if (input.contains("moves")) {
      input = input.substring(input.indexOf("moves") + 6);
      int count = 0;
      while (input.length() > 0) {
        count++;
        if (count > this.nbOfMoves) {
          Move move = Move.UCIToMove(input);
          this.nbOfMoves++;

          try {
            this.chessboard.makeMove(move);
          }
          catch (Exception e) {
            System.out.println("info string Error while applying move "+input);
            this.chessboard.display();
            System.out.println(e);
          }
        }
        input = input.substring(input.indexOf(' ')+1);
      }
    }

    if (this.nbOfMoves == 0) {
      input = input.substring(9);
      ai.setColor(AI.WHITE);
    }
  }

  private void go() {
    Move bestMove = null;
    String UCIMove = "0000";
    
    long startTime = System.currentTimeMillis();

    try {
      bestMove = ai.chooseBestMove(startTime);
    }
    // If an exception is thrown, print the chessboard state and choose a null move
    catch (Exception e) {
      bestMove = null;
      System.out.println("info string Error while choosing best move");
      this.chessboard.display();
      System.out.println(e);
    }

    if (bestMove !=  null)
      UCIMove = Move.moveToUCI(bestMove);

    System.out.println("bestmove " + UCIMove);
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
