package othello.players;

import java.util.ArrayList;

import othello.Board;
import othello.Player;
import othello.Point;
import othello.util.Coin;

public class SequentialPlayer implements Player {

	Coin playerType;

	public SequentialPlayer(Coin playerType) {
		this.playerType = playerType;
	}

	@Override
	public Point nextMove(Board board) {
		ArrayList<Point> legalMoves =  board.getLegalMoves(playerType);
		if(legalMoves.isEmpty()) return null;
		else return legalMoves.get(0);
	}

	@Override
	public String getName() {
		return "Sequential Player";
	}

}
