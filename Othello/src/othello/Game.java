package othello;

import othello.util.Coin;

// A framework for playing a single game
 
public class Game {
	private Board board;
	private Player whitePlayer, blackPlayer;

	
	 
	public Game(Player whitePlayer, Player blackPlayer) {
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.board = new Board();
	}

	public int play() {
		Point nextMove = null;
		Coin turn;
		if (Tournament.debug)
			System.out.println(board);

		while (!board.isGameOver()) {
			turn = board.getTurn();
			if (turn == Coin.white) {
				do {
					nextMove = whitePlayer.nextMove(board);
				} while (board.setPiece(Coin.white, nextMove) == false);
			} else if (turn == Coin.black) {
				do {
					nextMove = blackPlayer.nextMove(board);
				} while (board.setPiece(Coin.black, nextMove) == false);
			}

			if (Tournament.debug) {
				if (nextMove == null)
					System.out.println("Player skipped a move.");
				else
					System.out.println(nextMove);
				System.out.println(board);
			}
		}
		return announceResult();
	}

	private int announceResult() {
		short whiteCount = board.getPieceCount(Coin.white);
		short blackCount = (short) ((short) 64 - whiteCount);
		if (whiteCount > blackCount) {
			if (Tournament.debug)
				System.out.println("White wins by " + (whiteCount - blackCount)
						+ " coins.");
			return 1;
		} else if (whiteCount == blackCount) {
			if (Tournament.debug)
				System.out.println("It's a draw!");
			return 0;
		} else {
			if (Tournament.debug)
				System.out.println("Black wins by " + (blackCount - whiteCount)
						+ " coins.");
			return -1;
		}
	}
}
