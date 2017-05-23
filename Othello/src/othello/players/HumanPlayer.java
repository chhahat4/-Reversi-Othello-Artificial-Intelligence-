package othello.players;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import othello.Board;
import othello.Player;
import othello.Point;
import othello.util.Coin;

 //Allows gameplay on the CLIck. Takes in 2 numbers <x, y> as inputs which are the
 //co-ordinates of a square on the board and places a coin on that sqaure

public class HumanPlayer implements Player {

	Coin playerType;

	public HumanPlayer(Coin playerType) {
		this.playerType = playerType;
	}

	@Override
	public Point nextMove(Board board) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Point squareToPlay = null;
		boolean validInput = false;
		short x = -1, y = -1;

		while (!validInput) {
			System.out.print("Enter move: ");
			try {
				String[] strInputs = br.readLine().split(" ");
				x = Short.parseShort(strInputs[0]);
				y = Short.parseShort(strInputs[1]);
				
				// Player decides to skip a turn
				if(x == -1 && y == -1)
					return null;

				squareToPlay = new Point(x, y);
				if (x >= 0 && x < 8 && y >= 0 && y < 8
						&& board.isMoveLegal(playerType, squareToPlay)) {
					validInput = true;
				} else {
					System.err.println("This move is not legal. Try again.");
				}

			} catch (Exception e) {
				System.err.println("Invalid format.");
				System.err.println("Acceptable format: <row> <col>");
			}
		}
		return squareToPlay;
	}

	@Override
	public String getName() {
		return "Human Player";
	}

}
