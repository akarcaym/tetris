

import java.awt.Color; // import Color class
import java.awt.Point; // import Point class
import edu.princeton.cs.introcs.StdDraw;
// A class representing the tetris game grid
public class Grid {
	// Private data fields
	private Color emptySquare; // color used for empty squares 
	private Color[][] colorMatrix; // a matrix storing colors of all squares
	private int[][] dataMatrix;
	// Constructor
	Grid (int n_rows, int n_cols) {
		// assigning color used for empty squares
		emptySquare = StdDraw.BOOK_LIGHT_BLUE;
		// creating colorMatrix with given dimensions
		colorMatrix = new Color[n_rows][n_cols];
		// initializing colorMatrix with color emptySquare for all its elements 
		// using initMatrix method defined below
		dataMatrix = new int[n_rows][n_cols];
		initMatrix();	
		declareMatrix();
	}
	

	public void removeLine(){
		int fullLines = -1;
		int neededLine = -1;
		for (int i = 12; i>0 ;i--){
			int counterLine=0;
			for(int j=8; j>0; j--){
				if (colorMatrix[i][j] != emptySquare){
					counterLine++;
				}
				if (counterLine >7){
					neededLine = i;
				}
			}
		}
		
		if(neededLine != -1){
			for(int x=0; x<8; x++){
				colorMatrix[neededLine][x] = emptySquare;
			}
		}
	}
	
	public boolean isRowFull(int row){
		for(int x = 0; x <8;x++){
			if(colorMatrix[x][row] == emptySquare){
				return false;
			}
		}
		return true;
	}
	
	public void removeFullRow(){
		int full = 0;
		for(int y = 0; y < 12; y++){
			if(isRowFull(y)){
				full ++ ;
			}
		}
	}
	
	// Method used for initializing colorMatrix 
	public void initMatrix() {
		for (int row = 0; row < colorMatrix.length; row++)
			for (int col = 0; col < colorMatrix[0].length; col++)
				colorMatrix[row][col] = emptySquare;
	}
	
	public void declareMatrix(){
		for (int row = 0; row < dataMatrix.length; row++)
			for (int col = 0; col < dataMatrix[0].length; col++)
				dataMatrix[row][col] = '0';
	}
	// Method used for checking whether the square with given indices is inside the grid or not
	public boolean isInside(int row, int col) {
		if (row < 0 || row >= colorMatrix.length)
			return false;
		if (col < 0 || col >= colorMatrix[0].length)
			return false;
		return true;
	}
	// Getter method for getting color of the square with given indices
	public Color getColor(int row, int col) {
		if (isInside(row, col))
			return colorMatrix[row][col];
		else
			return null;
	}
	// Setter method for setting color of the square with given indices
	public void setColor(Color color, int row, int col) {
		if (isInside(row, col))
			colorMatrix[row][col] = color;
	}
	// Method used for checking whether the square with given indices is occupied or empty
	public boolean isOccupied(int row, int col) {
		return colorMatrix[row][col] != emptySquare;
	}
	// Method for updating the game grid with a placed (stopped) tetromino L
	public void updateGrid(Point[] occupiedSquaresByTetrominoL, Color colorOfTetrominoL) {
		for (Point point: occupiedSquaresByTetrominoL)
			if (isInside(point.y, point.x))
				colorMatrix[point.y][point.x] = colorOfTetrominoL;
	}
	
	
	// Method used for displaying the grid
	public void display() {
		// drawing squares
		StdDraw.filledSquare(.8, .8, .15);
		for (int row = 0; row < colorMatrix.length; row++)
			for (int col = 0; col < colorMatrix[0].length; col++) {
				StdDraw.setPenColor(colorMatrix[row][col]);
				StdDraw.filledSquare(col, row, 0.5);
			}
		// drawing the grid
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		for (double x = -0.5; x < colorMatrix[0].length; x++) // vertical lines
			StdDraw.line(x, -0.5, x, colorMatrix.length - 0.5);
		for (double y = -0.5; y < colorMatrix.length; y++) // horizontal lines
			StdDraw.line(-0.5, y, colorMatrix[0].length - 0.5, y);
	}
}