
import java.util.Random;  // import Random class

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color; // import Color class
import java.awt.Point; // import Point class

// A class representing the tetromino L
public class TetrominoL {
	boolean [][] shapeL = {{false, false, false,false},{false, false, false,false}, {true, true, true,false}, {true, false, false,false}};
	boolean [][] shapeJ = {{false, false, false,false}, {false, false, false,false},{true, true, true,false}, {false,  false,true,false}};
	boolean [][] shapeS = {{false, false, false,false}, {false, false, false,false},{false, true, true,false}, {true,true,  false,false}};
	boolean [][] shapeZ = {{false, false, false,false}, {false, false, false,false},{ true, true,false,false}, {false, true, true,false}};
	boolean [][] shapeO = {{false, false, false,false}, {false, false, false,false},{false, true, true,false}, {false, true, true,false}};
	boolean [][] shapeT = {{false, false, false,false}, {false, false, false,false},{true, true, true,false}, {false, true, false,false}};
	boolean [][] shapeI = {{false, false, false,false}, {false, false, false,false},{true, true, true,true}, {false, false, false,false}};
	boolean [][] shapeL1 = {{false, false, false,false},{true, true, false,false}, {false, true, false ,false}, {false, true, false,false}};
	boolean [][] shapeL2 = {{false, false, false,false},{false, false, true,false},  { true, true,true,false},{false, false, false,false}};
	boolean [][] shapeL3 = {{false, false, false,false},{false, true, false,false}, {false, true,false, false}, { false, true,true,false}};
	boolean [][] shapeJ1 = {{false, false, false,false}, {false, true, false,false},{false, true, false,false},{true, true, false,false}};
	boolean [][] shapeJ2 = {{false, false, false,false}, {true,false,  false,false},{true, true, true,false},{false,false, false,false}};
	boolean [][] shapeJ3 = {{false, false, false,false}, {false,true,true,  false},{false, true, false,false},{false,true, false,false}};
	boolean [][] shapeS1 = {{false, false, false,false}, {true, false, false,false},{ true, true,false,false}, {false,true,  false,false}};
	boolean [][] shapeS2 = {{false, false, false,false}, {false,true, true,false},{ true, true,false,false}, {false,false,  false,false}};
	boolean [][] shapeS3 = {{false, false, false,false}, {false,true, false,false},{false, true, true,false}, {false,false, true,false}};
	boolean [][] shapeZ1 = {{false, false, false,false}, {false, true, false,false},{ true, true,false,false}, { true,false, false,false}};
	boolean [][] shapeZ2 = {{false, false, false,false}, {true, true, false,false},{false, true, true,false}, { false,false, false,false}};
	boolean [][] shapeZ3 = {{false, false, false,false}, {false,false, true, false},{false, true, true,false}, { false,true, false,false}};
	boolean [][] shapeO1 = {{false, false, false,false}, {false, false, false,false},{true, true,false, false}, {true, true,false, false}};
	boolean [][] shapeO2 = {{false, false, false,false},{true, true,false, false}, {true, true,false, false}, {false, false, false,false}};
	boolean [][] shapeO3 = {{false, false, false,false},{false,true, true, false}, {false,true, true, false}, {false, false, false,false}};
	boolean [][] shapeT1 = {{false, false, false,false}, {false, true, false,false},{true, true, false,false}, {false, true, false,false}};
	boolean [][] shapeT2 = {{false, false, false,false}, {false, true, false,false},{true, true, true,false}, {false, false, false,false}};
	boolean [][] shapeT3 = {{false, false, false,false}, {false, true, false,false},{false, true, true,false}, {false, true, false,false}};
	boolean [][] shapeI1 = {{false, true, false,false}, {false, true, false,false},{false, true, false,false}, {false, true, false,false}};
	
	
	
	private Color color; // color of the tetromino L
	private boolean[][] shapeMatrix; // shape of the tetromino L
	private Point[][] coordinateMatrix;// coordinates of the tetromino L w.r.t the game grid
	private int gridWidth, gridHeight; // dimensions of the tetris game grid
	private int[][] numberCounter;
	// Constructor
	TetrominoL (int gridHeight, int gridWidth) {
		this.gridHeight = gridHeight;
		this.gridWidth = gridWidth;
		// color of the tetromino L is determined randomly
		Random random = new Random();
	
		// shape of the tetromino L in its initial orientation
		shapeMatrix = getRandom();
		// initial coordinates just before the tetromino L enters the game grid from the upper side
		// at a random horizontal position
		int n_rows = 4, n_cols = 4;
		coordinateMatrix = new Point[n_rows][n_cols];
		int lowerLeftCornerX = random.nextInt(gridWidth - (n_cols - 1)), lowerLeftCornerY = gridHeight;
		coordinateMatrix[n_rows - 1][0] = new Point(lowerLeftCornerX, lowerLeftCornerY);
		for (int row = n_rows - 1; row >= 0; row--)
			for (int col = 0; col < n_cols; col++) {
				if (row == n_rows - 1 && col == 0)
					continue;
				else if (col == 0) { 
					int currentX = coordinateMatrix[row + 1][col].x;
					int currentY = coordinateMatrix[row + 1][col].y + 1;
					coordinateMatrix[row][col] = new Point(currentX, currentY);
					continue;
				}
				int currentX = coordinateMatrix[row][col - 1].x + 1;
				int currentY = coordinateMatrix[row][col - 1].y; 
				coordinateMatrix[row][col] = new Point(currentX, currentY);
			}
	}

	// Getter method for getting the color of tetromino L
	public boolean[][] getRandom() {
		
		Random random = new Random();
		boolean[][] data = null;
	    int i = random.nextInt(3) % 4;
	    switch (i) {
	        case 0:
	            data = shapeL;
	            color = new Color(100, 100, 100);
	            break;
	        case 1:
	            data = shapeJ;
	            color = new Color(0, 100, 100);
	            break;
	        case 2:
	        	data = shapeS;
	        	color = new Color(100, 0, 100);
	        	break;
	        case 3:
	        	data = shapeZ;
	        	color = new Color(100, 100, 0);
	        	break;
	        case 4:
	        	data = shapeO;
	        	color = new Color(100, 50, 50);
	        	break;
	        case 5:
	        	data = shapeT;
	        	color = new Color(50, 50, 100);
	        	break;
	        case 6:
	        	data = shapeI;
	        	color = new Color(50, 100, 50);
	        	break;
	        }
	        return data;
	    }
	
	
	
	
	public Color getColor() {
						
		return color;
	}
	
	
	
	

	
	// Method for moving tetromino L down by 1 in the game grid
	public boolean goDown(Grid gameGrid) {
		// Check whether tetromino L can go down or not
		boolean canGoDown = true;
		// determine the coordinates of the bottommost block for each column of tetromino L
		Point dummyPoint = new Point(-1, -1);
		Point[] bottommostBlock = {dummyPoint, dummyPoint, dummyPoint, dummyPoint};
		for (int col = 0; col < shapeMatrix[0].length; col++) {
			for (int row = shapeMatrix.length - 1; row >= 0; row--) {
				if (shapeMatrix[row][col]) {
					
					bottommostBlock[col] = coordinateMatrix[row][col];
					if (bottommostBlock[col].y == 0 ) // tetromino L cannot go down if it is already at y = 0
						canGoDown = false;
					break; // break the inner for loop
				}
			}
			if (!canGoDown)
				break; // break the outer for loop
		}
		// check if the grid square below the bottommost block is occupied for each column of tetromino L
		if (canGoDown) {
			for (int i = 0; i < bottommostBlock.length; i++) {
				// skip each column of tetromino L that does not contain any blocks
				if (bottommostBlock[i].equals(dummyPoint))
					continue;
				// skip each column of tetromino L whose bottommost block is out of the game grid 
				// (newly entered tetromino L objects to the game grid) 
				if (bottommostBlock[i].y > gridHeight)
					continue;
				if (gameGrid.isOccupied(bottommostBlock[i].y - 1, bottommostBlock[i].x)) {
					canGoDown = false;
					
					break; // break the for loop
					
				}
			}
		}
		// move tetromino L down by 1 in the game grid if it can go down
		if (canGoDown) {
			for (int row = 0; row < coordinateMatrix.length; row++)
				for (int col = 0; col < coordinateMatrix[0].length; col++)
					coordinateMatrix[row][col].y--;
		}
		// return the result
		return canGoDown;
	}
	// Method for returning the occupied squares w.r.t. the game grid by a placed (stopped) tetromino L 
	public Point[] getOccupiedSquares() {
		Point[] occupiedSquares = new Point[4];
		int count = 0;
		for (int row = 0; row < coordinateMatrix.length; row++)
			for (int col = 0; col < coordinateMatrix[0].length; col++)
				if (shapeMatrix[row][col])
					occupiedSquares[count++] = coordinateMatrix[row][col];
		return occupiedSquares;
	}
	// Method for moving tetromino L left by 1 in the game grid
	public boolean goLeft(Grid gameGrid) {
		// Check whether tetromino L can go left or not
		boolean canGoLeft = true;
		// determine the coordinates of the leftmost block for each row of tetromino L
		Point dummyPoint = new Point(-1, -1);
		Point[] leftmostBlock = {dummyPoint, dummyPoint, dummyPoint, dummyPoint};
		for (int row = 0; row < shapeMatrix.length; row++) {
			for (int col = 0; col < shapeMatrix[0].length; col++) {
				if (shapeMatrix[row][col]) {
					leftmostBlock[row] = coordinateMatrix[row][col];
					if (leftmostBlock[row].x == 0) // tetromino L cannot go left if it is already at x = 0
						canGoLeft = false;
					break; // break the inner for loop
				}
			}
			if (!canGoLeft)
				break; // break the outer for loop
		}
		// check if the grid square on the left of the leftmost block is occupied for each row of tetromino L
		if (canGoLeft) {
			for (int i = 0; i < leftmostBlock.length; i++) {
				// skip each row of tetromino L that does not contain any blocks
				if (leftmostBlock[i].equals(dummyPoint))
					continue;
				// skip each row of tetromino L whose leftmost block is out of the game grid 
				// (newly entered tetromino L objects to the game grid) 
				if (leftmostBlock[i].y >= gridHeight)
					continue;
				if (gameGrid.isOccupied(leftmostBlock[i].y, leftmostBlock[i].x - 1)) {
					canGoLeft = false;
					break; // break the for loop
				}
			}
		}
		// move tetromino L left by 1 in the game grid if it can go left
		if (canGoLeft) {
			for (int row = 0; row < coordinateMatrix.length; row++)
				for (int col = 0; col < coordinateMatrix[0].length; col++)
					coordinateMatrix[row][col].x--;
		}
		// return the result
		return canGoLeft;
	}
	// Method for moving tetromino L right by 1 in the game grid
	public boolean goRight(Grid gameGrid) {
		// Check whether tetromino L can go right or not
		boolean canGoRight = true;
		// determine the coordinates of the rightmost block for each row of tetromino L
		Point dummyPoint = new Point(-1, -1);
		Point[] rightmostBlock = {dummyPoint, dummyPoint, dummyPoint, dummyPoint};
		for (int row = 0; row < shapeMatrix.length; row++) {
			for (int col = shapeMatrix[0].length - 1; col >= 0; col--) {
				if (shapeMatrix[row][col]) {
					rightmostBlock[row] = coordinateMatrix[row][col];
					if (rightmostBlock[row].x == gridWidth - 1) // tetromino L cannot go right if it is already at x = gridWidth - 1
						canGoRight = false;
					break; // break the inner for loop
				}
			}
			if (!canGoRight)
				break; // break the outer for loop
		}
		// check if the grid square on the right of the rightmost block is occupied for each row of tetromino L
		if (canGoRight) {
			for (int i = 0; i < rightmostBlock.length; i++) {
				// skip each row of tetromino L that does not contain any blocks
				if (rightmostBlock[i].equals(dummyPoint))
					continue;
				// skip each row of tetromino L whose rightmost block is out of the game grid 
				// (newly entered tetromino L objects to the game grid) 
				if (rightmostBlock[i].y >= gridHeight)
					continue;
				if (gameGrid.isOccupied(rightmostBlock[i].y, rightmostBlock[i].x + 1)) {
					canGoRight = false;
					break; // break the for loop
				}
			}
		}
		// move tetromino L right by 1 in the game grid if it can go right
		if (canGoRight) {
			for (int row = 0; row < coordinateMatrix.length; row++)
				for (int col = 0; col < coordinateMatrix[0].length; col++)
					coordinateMatrix[row][col].x++;
		}
		// return the result
		return canGoRight;
	}
	
	
	
	public boolean rotate(int y) {
		// Check whether tetromino L can go right or not
	
		boolean canRotate = true;
		boolean newMatrix[][] = null;
		int x = y % 5;
		if (shapeMatrix == shapeL && x == 1){
			
			newMatrix = shapeL1;
			canRotate = false;
		}
		else if (shapeMatrix == shapeL1 && x == 2){
			
			newMatrix = shapeL2;
			canRotate = false;
		}
		
		else if (shapeMatrix == shapeL2 && x == 3){
			
			newMatrix = shapeL3;
			canRotate = false;
		}
		else if (shapeMatrix == shapeL3 && x == 4){
					
					newMatrix = shapeL;
					canRotate = false;
				}
		else if (shapeMatrix == shapeJ && x == 1){
					
					newMatrix = shapeJ1;
					canRotate = false;
				}
		else if (shapeMatrix == shapeJ1 && x == 2){
					
					newMatrix = shapeJ2;
					canRotate = false;
				}
		else if (shapeMatrix == shapeJ2 && x == 3){
					
					newMatrix = shapeJ3;
					canRotate = false;
				}
		else if (shapeMatrix == shapeJ3 && x == 4){
			
			newMatrix = shapeJ;
			canRotate = false;
		}
		else if (shapeMatrix == shapeS && x == 1){
					
					newMatrix = shapeS1;
					canRotate = false;
				}
		else if (shapeMatrix == shapeS1 && x == 2){
					
					newMatrix = shapeS2;
					canRotate = false;
				}
		else if (shapeMatrix == shapeS2 && x == 3){
					
					newMatrix = shapeS3;
					canRotate = false;
				}
		else if (shapeMatrix == shapeS3 && x == 4){
					
					newMatrix = shapeS;
					canRotate = false;
				}
		else if (shapeMatrix == shapeZ && x == 1){
			
			newMatrix = shapeZ1;
			canRotate = false;
		}
		else if (shapeMatrix == shapeZ1 && x == 2){
			
			newMatrix = shapeZ2;
			canRotate = false;
		}
		else if (shapeMatrix == shapeZ2 && x == 3 ){
			
			newMatrix = shapeZ3;
			canRotate = false;
		}
		else if (shapeMatrix == shapeZ3 && x == 4){
			
			newMatrix = shapeZ;
			canRotate = false;
		}
		else if (shapeMatrix == shapeO && x == 1){
			
			newMatrix = shapeO1;
			canRotate = false;
		}
		else if (shapeMatrix == shapeO1 && x == 2){
			
			newMatrix = shapeO2;
			canRotate = false;
		}
		else if (shapeMatrix == shapeO2 && x == 3){
			
			newMatrix = shapeO3;
			canRotate = false;
		}
		else if (shapeMatrix == shapeO3 && x == 4){
			
			newMatrix = shapeO;
			canRotate = false;
		}
		else if (shapeMatrix == shapeI && (x == 1 || x == 3)){
			
			newMatrix = shapeI1;
			canRotate = false;
		}
		else if (shapeMatrix == shapeI1 && (x == 4 || x==2)){
			
			newMatrix = shapeI;
			canRotate = false;
		}
		else if (shapeMatrix == shapeT && x == 1){
			
			newMatrix = shapeT1;
			canRotate = false;
		}
		else if (shapeMatrix == shapeT1 && x == 2){
			
			newMatrix = shapeT2;
			canRotate = false;
		}
		else if (shapeMatrix == shapeT2 && x == 3){
			
			newMatrix = shapeT3;
			canRotate = false;
		}
		else if (shapeMatrix == shapeT3 && x == 4){
			
			newMatrix = shapeT;
			canRotate = false;
		}
		shapeMatrix = newMatrix;
		return canRotate;
		
	}
	
	// Method for displaying tetromino L on the game grid
		public void display() { 
			for (int row = 0; row < coordinateMatrix.length; row++)
				for (int col = 0; col < coordinateMatrix[0].length; col++) {
					Point point = coordinateMatrix[row][col];
					// considering newly entered tetromino L objects to the game grid that may have squares with point.y >= gridHeight
					if (point.y < gridHeight && shapeMatrix[row][col]) {
						StdDraw.setPenColor(color);
						StdDraw.filledSquare(point.x, point.y, 0.5);
					}
				}
		}
		
		
	

	
	
}