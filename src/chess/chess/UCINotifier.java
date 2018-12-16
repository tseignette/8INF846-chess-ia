package chess;

public class UCINotifier {

  int nbNodeLooked = 0;
  int depth = 0;
  Move move;
  int currentMoveNumber = 0;

  public UCINotifier actualMove(Move move, int currMove) {
    this.move = move;
    this.currentMoveNumber = currMove;

    System.out.println("info currmovenumber " + currentMoveNumber + " currmove " + Move.moveToUCI(move));

    return this;
  }

  public UCINotifier nodeLooked() {
    nbNodeLooked++;

    if (nbNodeLooked % 50000 == 0)
      this.sendNotification();

    return this;
  }

  public UCINotifier depthReached(int depth) {
      this.depth = depth;

      return this;
  }

  public void clear() {
    nbNodeLooked = 0;
    depth = 0;
  }

  public void sendNotification() {
    System.out.println("info nodes " + nbNodeLooked + " depth " + depth);
  }

}