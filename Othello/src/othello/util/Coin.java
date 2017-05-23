package othello.util;

public enum Coin {
	white, black, empty;

	public Coin change() {
		if(this == white) return black;
		else if(this == black) return white;
		else return empty;
	}
}
