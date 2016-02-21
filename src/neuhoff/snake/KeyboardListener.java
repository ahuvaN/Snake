package neuhoff.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {

	public void keyPressed(KeyEvent e) {
		ThreadsController tc = new ThreadsController();
		switch (e.getKeyCode()) {
		case 39: // -> Right
					// if it's not the opposite direction
			if (tc.directionSnake != 2)
				tc.directionSnake = 1;
			break;
		case 38: // -> Top
			if (tc.directionSnake != 4)
				tc.directionSnake = 3;
			break;

		case 37: // -> Left
			if (tc.directionSnake != 1)
				tc.directionSnake = 2;
			break;

		case 40: // -> Bottom
			if (tc.directionSnake != 3)
				tc.directionSnake = 4;
			break;

		default:
			break;
		}
	}

}
