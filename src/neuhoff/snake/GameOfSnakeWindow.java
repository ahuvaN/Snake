package neuhoff.snake;

import java.awt.GridLayout;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

class GameOfSnakeWindow extends JFrame {
	private static final long serialVersionUID = -2542001418764869760L;
	public static ArrayList<ArrayList<SquareColors>> grid;
	public static int width = 20;
	public static int height = 20;

	public GameOfSnakeWindow() {
		setTitle("Snake");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creates the arraylist that'll contain the threads
		grid = new ArrayList<ArrayList<SquareColors>>();
		ArrayList<SquareColors> data;

		// Creates Threads and its data and adds it to the arrayList
		for (int i = 0; i < width; i++) {
			data = new ArrayList<SquareColors>();
			for (int j = 0; j < height; j++) {
				SquareColors c = new SquareColors(2);
				data.add(c);
			}
			grid.add(data);
		}

		// Setting up the layout of the panel
		getContentPane().setLayout(new GridLayout(20, 20, 0, 0));

		// Start & pauses all threads, then adds every square of each thread to
		// the panel
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				getContentPane().add(grid.get(i).get(j).square);
			}
		}

		// initial position of the snake
		Tuple position = new Tuple(10, 10);
		// passing this value to the controller
		ThreadsController c = new ThreadsController(position);
		// Let's start the game now..
		c.start();

		// Links the window to the keyboardlistenner.
		this.addKeyListener((KeyListener) new KeyboardListener());

		// To do : handle multiplayers .. The above works, test it and see what
		// happens

		// Tuple position2 = new Tuple(13,13);
		// ControlleurThreads c2 = new ControlleurThreads(position2);
		// c2.start();

	}
}
