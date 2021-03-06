import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	private Game game;
	
	@Before
	public void setUp(){
		game = new Game();
	}

	@Test
	public void testAllZero() {
		rollMany(game, 20, 0);
		assertEquals(0, game.score());
	}

	@Test
	public void testAllOne() {
		rollMany(game, 20, 1);
		assertEquals(20, game.score());
	}

	@Test
	public void testOneStrike() {
		rollStrike(game);
		game.roll(5);
		game.roll(2);
		rollMany(game, 17, 0);
		assertEquals(24, game.score());
	}

	@Test
	public void testOneSpare() {
		rollSpare(game);
		game.roll(5);
		game.roll(2);
		rollMany(game, 16, 0);
		assertEquals(22, game.score());
	}

	@Test
	public void testLastFrameStrike() {
		rollMany(game, 18, 0);
		rollStrike(game);
		game.roll(5);
		game.roll(2);
		assertEquals(17, game.score());
	}

	@Test
	public void testLastFrameSpare() {
		rollMany(game, 18, 0);
		rollSpare(game);
		game.roll(5);
		assertEquals(15, game.score());
	}

	@Test
	public void testPerfectGame() {
		rollMany(game, 12, 10);
		assertEquals(300, game.score());
	}

	@Test
	public void testAllSpare() {
		rollMany(game, 21, 5);
		assertEquals(150, game.score());
	}

	@Test
	public void testKataExampleGame() {
		// frame 1
		game.roll(1);
		game.roll(4);
		// frame 2
		game.roll(4);
		game.roll(5);
		// frame 3
		game.roll(6);
		game.roll(4);
		// frame 4
		game.roll(5);
		game.roll(5);
		// frame 5
		game.roll(10);
		// frame 6
		game.roll(0);
		game.roll(1);
		// frame 7
		game.roll(7);
		game.roll(3);
		// frame 8
		game.roll(6);
		game.roll(4);
		// frame 9
		game.roll(10);
		// frame 10
		game.roll(2);
		game.roll(8);
		// got spare - bonus frame
		game.roll(6);
		assertEquals(133, game.score());
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
	 *            Number of pins hit
	 */
	private void rollMany(Game game, int numRolls, int numPins) {
		for (int i = 0; i < numRolls; i++) {
			game.roll(numPins);
		}
	}

}
