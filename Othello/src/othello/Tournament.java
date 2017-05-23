package othello;

import othello.ai.DataCollector;
import othello.players.IdealPlayer;
import othello.players.RandomPlayer;
import othello.util.Algorithm;
import othello.util.Coin;
import othello.util.Difficulty;
import othello.util.Timer;


public class Tournament {
	private static int numOfGames = 1;
	public static boolean debug = true;
	public static boolean collectData = true;

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.startTimer();

		if (collectData)
			DataCollector.setup();

		int whiteWins = 0, blackWins = 0, draws = 0, score;
		Player whitePlayer = new RandomPlayer(Coin.white);
		Player blackPlayer = new IdealPlayer(Coin.black, Difficulty.medium,Algorithm.alphaBeta);

		for (int i = 0; i < numOfGames; i++) {
			score = new Game(whitePlayer, blackPlayer).play();
			if (score == 1)
				whiteWins++;
			else if (score == 0)
				draws++;
			else
				blackWins++;
		}
		timer.stopTimer();

		if (collectData) {
			System.out.println("Writing data to file...");
			DataCollector.save();
		}

		System.out.printf("%50s %3d%n", "Total games played", numOfGames);
		System.out.printf("%50s %3d%n", whitePlayer.getName() + " wins",
				whiteWins);
		System.out.printf("%50s %3d%n", "Games drawn", draws);
		System.out.printf("%50s %3d%n", blackPlayer.getName() + " wins",
				blackWins);
		System.out.printf("%50s %3.2f%n", "Elapsed time (seconds)",
				timer.getElapsedTime());
	}
}
