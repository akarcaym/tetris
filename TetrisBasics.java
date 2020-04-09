
import java.awt.Color; // import Color class
import java.awt.Point; // import Point class
import edu.princeton.cs.introcs.StdDraw;

// A program demonstrating the following tetris basics: 
// 1. drawing the game environment as a grid 
// 2. modeling the L shaped tetromino using 2d arrays 
// 3. tetromino entering the game environment from a random horizontal position
// 4. tetromino going down by one grid automatically in each iteration
// 5. using keyboard keys (a and d) for moving the tetromino left/right by one in each iteration
//    (checking for collisions with side boundaries and occupied squares in the grid)
// 6. detecting when the active tetromino stops due to reaching the bottom of the game environment 
//    or colliding with occupied squares in the grid
// 7. updating the game grid with each placed (stopped) tetromino
public class TetrisBasics {
	
	public static void main(String[] args) {
		
		// set the size of the drawing canvas
		StdDraw.setCanvasSize(500, 750);
		// set the scale of the coordinate system
		StdDraw.setXscale(-0.5, 7.5);
		StdDraw.setYscale(-0.5, 11.5);
		// double buffering is used for speeding up drawing needed to enable computer animations 
		// check https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html for details
		StdDraw.enableDoubleBuffering();
		
		// create a grid as the tetris game environment
		Grid gameGrid = new Grid(12, 8);
		// create the first tetromino to enter the game grid
		TetrominoL t = new TetrominoL(12, 8);
		boolean createANewTetrominoL = false;
		int RotCounter = 0;
		// main animation loop
		while (true)  { 
			
			// keyboard interaction for moving the active tetromino left or right
			boolean success = false;
			if (StdDraw.hasNextKeyTyped()) {
			
                char ch = StdDraw.nextKeyTyped();            
                if (ch == 'a') // move the active tetromino left by one
                    success = t.goLeft(gameGrid);
                if (ch == 'd') // move the active tetromino right by one
                	success = t.goRight(gameGrid);
                if (ch == 'r')
                {
                	RotCounter ++;
                	System.out.printf("%d",RotCounter);
                	success = t.rotate(RotCounter);
                	}
			}
			// move the active tetromino down by one if a successful move left/right is not performed
			if (!success)
				success = t.goDown(gameGrid);
			// place (stop) the active tetromino on the game grid if it cannot go down anymore
			createANewTetrominoL = !success;
			if (createANewTetrominoL) {
				RotCounter = 0;
				// update the game grid by adding the placed tetromino
				Point[] occupiedSquares = t.getOccupiedSquares();
				Color color = t.getColor();
				gameGrid.updateGrid(occupiedSquares, color);
				
				// create the next tetromino to enter the game grid 
				t = new TetrominoL(12, 8);
			}
			
			// clear the background (double buffering)
			StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
			// draw the game grid
			//gameGrid.removeLine();
			gameGrid.display();
			// draw the active tetromino
			t.display();
			// copy offscreen buffer to onscreen (double buffering)
			StdDraw.show();
			// pause for 200 ms (double buffering) 
			StdDraw.pause(200);
		}
	}
}