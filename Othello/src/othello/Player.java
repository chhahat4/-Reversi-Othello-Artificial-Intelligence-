package othello;

public interface Player {
	public Point nextMove(Board board);
	public String getName();
}
