
package othello.gui;

import othello.util.Algorithm;
import othello.util.Coin;
import othello.util.Difficulty;


public class GUIConfig {
	private Coin humanPlayer;
	private Algorithm algorithm;
	private PlayerType playerType;
	private int difficultyLevel;

	public GUIConfig() {
		setHumanPlayer(Coin.white);
		setPlayerType(PlayerType.SequentialPlayer);
	}

	
	public Coin getHumanPlayer() {
		return humanPlayer;
	}

	
	public void setHumanPlayer(Coin humanPlayer) {
		this.humanPlayer = humanPlayer;
	}

	
	public Algorithm getAlgorithm() {
		return algorithm;
	}

	
	public void setAlgorithm(Algorithm algorithm) {
		this.algorithm = algorithm;
	}

	
	public PlayerType getPlayerType() {
		return playerType;
	}

	
	public void setPlayerType(PlayerType playerType) {
		this.playerType = playerType;
		if(playerType == PlayerType.IdealPlayer) {
			setAlgorithm(Algorithm.alphaBeta);
			setDifficultyLevel(DifficultyLevel.medium);
		}
	}


	public int getDifficultyLevel() {
		return difficultyLevel;
	}

	
	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		if (difficultyLevel == DifficultyLevel.easy)
			this.difficultyLevel = Difficulty.easy;
		else if (difficultyLevel == DifficultyLevel.medium)
			this.difficultyLevel = Difficulty.medium;
		else if (difficultyLevel == DifficultyLevel.difficult)
			this.difficultyLevel = Difficulty.difficult;
		else
			this.difficultyLevel = Difficulty.champion;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Human Player Color: " + humanPlayer + "\n");
		sb.append("Computer Player Type: " + playerType + "\n");
		if(playerType == PlayerType.IdealPlayer) {
			sb.append("Computer Algorithm: " + algorithm + "\n");
			sb.append("Computer difficulty: " + difficultyLevel + "\n");
		}
		return sb.toString();
	}
}

enum PlayerType {
	SequentialPlayer, RandomPlayer, IdealPlayer;
}

enum DifficultyLevel {
	easy, medium, difficult, champion;
}