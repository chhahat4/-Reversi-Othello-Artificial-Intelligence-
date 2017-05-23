package othello.ai;

import java.io.Serializable;

import othello.Board;
import othello.Point;

public class DataBlob implements Serializable {
	private static final long serialVersionUID = 1L;

	private Board board;
	private double evalScore;
	private Point nextMove;

	public DataBlob(Board board, double evalScore, Point nextMove) {
		this.board = board;
		this.evalScore = evalScore;
		this.nextMove = nextMove;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public double getEvalScore() {
		return evalScore;
	}

	public void setEvalScore(double evalScore) {
		this.evalScore = evalScore;
	}

	public Point getNextMove() {
		return nextMove;
	}

	public void setNextMove(Point nextMove) {
		this.nextMove = nextMove;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(board.toString() + "\n");
		if(nextMove != null)
				sb.append(nextMove.toString() + "\n");
		else
			sb.append("[]\n");
		sb.append(evalScore);
		
		return sb.toString();
	}
}
