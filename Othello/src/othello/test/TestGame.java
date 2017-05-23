package othello.test;

import othello.Board;
import othello.Player;
import othello.Point;
import othello.players.IdealPlayer;
import othello.players.RandomPlayer;
import othello.util.Algorithm;
import othello.util.Coin;
import othello.util.Difficulty;


public class TestGame {
	private Board board;

	private short movesLeft, matchedMoves, idealPlayerMoves;

	private Player randomPlayer, minimaxPlayer, abPlayer;

	
	 //Initializes a game. Takes 2 objects which implement the player
	 // interface as parameters whitePlayer blackPlayer
	
	public TestGame() {
		this.randomPlayer = new RandomPlayer(Coin.white);
		this.minimaxPlayer = new IdealPlayer(Coin.black, Difficulty.medium,
				Algorithm.minimax);
		this.abPlayer = new IdealPlayer(Coin.black, Difficulty.medium,
				Algorithm.alphaBeta);
		this.board = new Board();
		this.movesLeft = 64 - 4; // 4 coins are already placed initially
	}

	//Start the game. This function exits only after the game has ended.
	
	public int play() {
		Point randomMove = null, minimaxMove = null, abMove = null;
		if (TestTournament.debug)
			System.out.println(board);

		while (movesLeft > 0) {
			if (board.getTurn() == Coin.white) {
				do {
					randomMove = randomPlayer.nextMove(board);
				} while (board.setPiece(Coin.white, randomMove) == false);
			} else if (board.getTurn() == Coin.black) {
				do {
					minimaxMove = minimaxPlayer.nextMove(board);
					abMove = abPlayer.nextMove(board);
					idealPlayerMoves++;
					if ((minimaxMove == null && abMove == null) || minimaxMove.equals(abMove)) {
						if (TestTournament.debug)
							System.out.println("Ouputs match");
						matchedMoves++;
					} else {
						if (TestTournament.debug)
							System.err.println("Ouputs do not match");
					}
				} while (board.setPiece(Coin.black, minimaxMove) == false);
			}

			if (TestTournament.debug) {
				if (minimaxMove == null)
					System.out.println(movesLeft + ". Player skipped a move.");
				else
					System.out.println(movesLeft + ". " + minimaxMove);
				System.out.println(board);
			}

			movesLeft--;
		}
		return announceResult();
	}

	private int announceResult() {
		short whiteCount = board.getPieceCount(Coin.white);
		short blackCount = (short) ((short) 64 - whiteCount);

		System.out.println(((float) (matchedMoves * 100) / idealPlayerMoves) + "% ("
				+ matchedMoves + ") "
				+ "of the moves matched between Minimax and AB");
		if (whiteCount > blackCount) {
			if (TestTournament.debug)
				System.out.println("White wins by " + (whiteCount - blackCount)
						+ " coins.");
			return 1;
		} else if (whiteCount == blackCount) {
			if (TestTournament.debug)
				System.out.println("It's a draw!");
			return 0;
		} else {
			if (TestTournament.debug)
				System.out.println("Black wins by " + (blackCount - whiteCount)
						+ " coins.");
			return -1;
		}
	}
}
