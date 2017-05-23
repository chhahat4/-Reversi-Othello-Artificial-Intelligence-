package othello.players;

import java.util.ArrayList;

import othello.Board;
import othello.Player;
import othello.Point;
import othello.util.Coin;

public class RandomPlayer implements Player {
	
	Coin playerType;
	
	public RandomPlayer(Coin playerType) {
		this.playerType = playerType;
	}

	@Override
	public Point nextMove(Board board) {
		ArrayList<Point> legalMoves = board.getLegalMoves(playerType);
		if(legalMoves.isEmpty()) return null;
		
		short index = (short) (Math.random() * legalMoves.size());
		return legalMoves.get(index);
	}

	@Override
	public String getName() {
		return "Random Player";
	}

}
