/**
 * A short program to run a game of bowling. We are assuming that the maximum
 * number of frames for the game is 10, and thus the maximum number of rolls to
 * be 21 (2 for each frame plus a possible bonus one on the last frame).
 *
 * @author Mike Zrimsek
 *
 */
public class Game {
	private int[] rollValues = new int[21];
	private int rollCounter = 0;

	/**
	 * Execute one roll
	 *
	 * @param numPins
	 *            Numbers of pins hit; must be between 0 and 10
	 */
	public void roll(int numPins) {
		rollValues[rollCounter++] = numPins;
	}

	/**
	 * Calculate total score of game based on values for each roll
	 *
	 * @return Total score for game
	 */
	public int score() {
		int score = 0;
		int rollIndex = 0;
		for (int frame = 0; frame < 10; frame++) {
			// check if rolled a strike
			// 10 + value of next 2 balls rolled
			if (rollValues[rollIndex] == 10) {
				score += 10 + rollValues[rollIndex + 1]
						+ rollValues[rollIndex + 2];
				rollIndex++;
			}
			// check if rolled a spare
			// 10 + value of next ball rolled
			else if (rollValues[rollIndex] + rollValues[rollIndex + 1] == 10) {
				score += 10 + rollValues[rollIndex + 2];
				rollIndex += 2;
			} else {
				score += rollValues[rollIndex] + rollValues[rollIndex + 1];
				rollIndex += 2;
			}
		}
		return score;
	}

	public int[] getRollValues() {
		return rollValues;
	}

	public int getRollCounter() {
		return rollCounter;
	}
}
