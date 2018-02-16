package ch.bbcag.tictactoe;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.view.StartScreen;

public class TicTacToeView extends JFrame {

	private static final long serialVersionUID = 7784372619859095392L;
	private final GameController GAME_CONTROLLER = new GameController(this);

	public TicTacToeView(String titel) {
		setTitle(titel);
	}
	
	public void switchJPanel(JPanel panel) {
		add(panel);
		pack();
        panel.setVisible(true);
        panel.setSize(500,500);
/*		removeAll();
		add(panel);
		revalidate();*/
	}

	public static void main(String[] args) {

		// Spielfeld
		TicTacToeView frame = new TicTacToeView("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		JPanel centerPanel = new JPanel(new GridLayout(3, 3));

		/*JButton OO = new JButton();
		JButton OI = new JButton();
		JButton OZ = new JButton();
		JButton IO = new JButton();
		JButton II = new JButton();
		JButton IZ = new JButton();
		JButton ZO = new JButton();
		JButton ZI = new JButton();
		JButton ZZ = new JButton();
		JButton time = new JButton();*/

		/*northPanel.add(time);
		time.setPreferredSize(new Dimension(100, 20));
		northPanel.setBackground(Color.BLACK);
		centerPanel.setBackground(Color.BLACK);

		centerPanel.add(OO);
		centerPanel.add(OI);
		centerPanel.add(OZ);
		centerPanel.add(IO);
		centerPanel.add(II);
		centerPanel.add(IZ);
		centerPanel.add(ZO);
		centerPanel.add(ZI);
		centerPanel.add(ZZ);

		northPanel.setPreferredSize(new Dimension(100, 60));

		frame.add("North", northPanel);
		frame.add("Center", centerPanel);

		frame.setSize(370, 400);
		frame.setVisible(true);
*/
		// Start
		//TicTacToeView frame = new TicTacToeView("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		StartScreen startScreen = new StartScreen(frame);
		frame.add(startScreen);
		frame.pack();
		frame.setVisible(true);
/*
		// X und O
		JFrame xo = new JFrame("TicTacToe");
		xo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel x = new JPanel(new BorderLayout());
		JPanel o = new JPanel(new BorderLayout());
		JPanel xocenter = new JPanel(new GridLayout(2,k 3));

		JButton x1 = new JButton("x");
		JButton x2 = new JButton("x");
		JButton x3 = new JButton("x");

		JButton o1 = new JButton();
		JButton o2 = new JButton();
		JButton o3 = new JButton();

		x.add("North", new JButton("x"));
		xocenter.add(x1);
		xocenter.add(x2);
		xocenter.add(x3);

		o.add("North", new JButton("o"));
		xocenter.add(o1);
		xocenter.add(o2);
		xocenter.add(o3);

		xo.add("North", x);
		xo.add("South", o);
		xo.add("Center", xocenter);

		xo.setSize(400, 400);
		xo.setVisible(true);

		// Highscore
		JFrame hScore = new JFrame("TicTacToe");
		hScore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel hSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel hNorth = new JPanel(new BorderLayout());
		JPanel hCenter = new JPanel(new BorderLayout());

		JButton restart = new JButton("Restart");
		// restart.addActionListener(new Restart());
		JTextArea hhCenter = new JTextArea();

		hNorth.setBackground(Color.BLACK);
		hSouth.setBackground(Color.BLACK);

		JLabel winLose = new JLabel(loadIcon("images.jpg"));

		hSouth.add(restart);
		hCenter.add("Center", hhCenter);
		hNorth.add("Center", winLose);

		hScore.add("South", hSouth);
		hScore.add("Center", hCenter);
		hScore.add("North", hNorth);

		hScore.setSize(400, 400);
		hScore.setVisible(true);
		hScore.getContentPane().setBackground(Color.BLACK);*/
	}

}
