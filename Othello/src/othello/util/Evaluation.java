
package othello.util;

import othello.Board;


public class Evaluation {
	public static int score(Board board) {
	
		// Returns the number of white coins on the board
		return board.getPieceCount(Coin.white);
	}
}
