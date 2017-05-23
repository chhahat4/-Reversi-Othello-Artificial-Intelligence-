package othello.players;

import othello.Board;
import othello.Player;
import othello.Point;
import othello.util.Algorithm;
import othello.util.Coin;
import othello.util.Difficulty;
import othello.util.TreeWalk;

public class IdealPlayer implements Player {

	Coin playerType;
	int difficultyLevel;
	Algorithm algorithm;

	public IdealPlayer(Coin playerType) {
		this.playerType = playerType;
		this.difficultyLevel = Difficulty.medium;
		this.algorithm = Algorithm.alphaBeta;
	}

	public IdealPlayer(Coin playerType, int difficultyLevel, Algorithm algorithm) {
		this.playerType = playerType;
		this.difficultyLevel = difficultyLevel;
		this.algorithm = algorithm;
	}

	@Override
	public Point nextMove(Board board) {
		boolean shouldMaximize = false;
		
		if(playerType == Coin.white) shouldMaximize = true;
		
		if (algorithm == Algorithm.minimax)
			return TreeWalk.askMinimax(board, playerType, difficultyLevel,
					shouldMaximize);

		else
			return TreeWalk.askAlphaBeta(board, playerType, difficultyLevel,
					shouldMaximize);
	}
	
	@Override
	public String getName() {
		String name = "Ideal Player";
		if(algorithm == Algorithm.alphaBeta) name += " (alpha-beta)";
		else if(algorithm == Algorithm.minimax) name += " (minimax)";
		else name += " (progressive deepening)";
		
		return name;
	}
}
