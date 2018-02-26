/**
 * 
 */
package ch.bbcag.tictactoe.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.bbcag.tictactoe.controller.ComputerGameLogicController;
import ch.bbcag.tictactoe.controller.GameController;

/**
 * @author zmaurn
 *
 */
public class LogikTester {

	private static ComputerGameLogicController logik = null;
	private static final String COMPUTER = "computer";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logik = new ComputerGameLogicController(GameController.getGameController());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logik = null;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		// init spielfeld

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

		// reset spielfeld
		logik.clear();
	}

	/**
	 * Test method for
	 * {@link ch.bbcag.tictactoe.controller.ComputerGameLogicController#checkForWin(java.lang.String)}.
	 */
	@Test
	public void testCheckForWin() {
		// init spielfeld
		logik.getSpielfeld()[0][0] = COMPUTER;
		logik.getSpielfeld()[0][1] = COMPUTER;
		logik.getSpielfeld()[0][2] = COMPUTER;
		// end of init

		final String EXPECTED_RESULT = "gewonnen";
		String result = logik.checkForWin(COMPUTER);
		Assert.assertEquals(EXPECTED_RESULT, result);
	}
}
