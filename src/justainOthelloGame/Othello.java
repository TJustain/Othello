package justainOthelloGame;

/**
 * @author Justian Tremblay
 * @version 2.0
 * 
 * Main program of an othello board game
 */
public class Othello {
	public static void main(String args[]) {
		
		//displays the gui
		OthelloViewController control = new OthelloViewController();
		control.launchGame(OthelloModel.NORMAL);
				
	}
}
