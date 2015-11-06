import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameTest {
	private Game game;

	@Test
	public void testAllZero() {
		game = new Game();
		rollMany(game, 20, 0);
		assertEquals(0, game.score());
	}

	@Test
	public void testAllOne() {
		game = new Game();
		rollMany(game, 20, 1);
		assertEquals(20, game.score());
	}

	@Test
	public void testOneStrike() {
		game = new Game();
		rollStrike(game);
		game.roll(5);
		game.roll(2);
		rollMany(game, 17, 0);
		assertEquals(24, game.score());
	}

	@Test
	public void testOneSpare() {
		game = new Game();
		rollSpare(game);
		game.roll(5);
		game.roll(2);
		rollMany(game, 16, 0);
		assertEquals(22, game.score());
	}

	@Test
	public void testLastFrameStrike() {
		game = new Game();
		rollMany(game, 18, 0);
		rollStrike(game);
		game.roll(5);
		game.roll(2);
		assertEquals(17, game.score());
	}

	@Test
	public void testLastFrameSpare() {
		game = new Game();
		rollMany(game, 18, 0);
		rollSpare(game);
		game.roll(5);
		assertEquals(15, game.score());
	}

	@Test
	public void testPerfectGame() {
		game = new Game();
		rollMany(game, 12, 10);
		assertEquals(300, game.score());
	}
	
	@Test
	public void testAllSpare() {
		game = new Game();
		rollMany(game, 21, 5);
		assertEquals(150, game.score());
	}

	/**
	 * A strike is when the player hits all 10 pins in the first roll of a frame
	 * 
	 * @param game
	 */
	private void rollStrike(Game game) {
		game.roll(10);
	}

	/**
	 * A spare is when the player hits all 10 pins with both rolls of the frame
	 * 
	 * @param game
	 */
	private void rollSpare(Game game) {
		game.roll(5);
		game.roll(5);
	}

	/**
	 * Does several rolls of the same pin value
	 * 
	 * @param game
	 * @param numRolls
	 *            How many rolls to execute
	 * @param numPins
	 *            Number of pins
	 */
	private void rollMany(Game game, int numRolls, int numPins) {
		for (int i = 0; i < numRolls; i++) {
			game.roll(numPins);
		}
	}

}
