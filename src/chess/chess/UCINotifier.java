package chess;

public class UCINotifier {

  int nbNodeLooked = 0;
  int depth = 0;

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
    System.out.println("info string nodes " + nbNodeLooked + " depth " + depth);
  }

}