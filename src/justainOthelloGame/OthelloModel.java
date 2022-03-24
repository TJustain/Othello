package justainOthelloGame;

/**
 * @author Justain Tremblay
 * @version 1.0
 * 
 * Othello Model: Class responsible for game logic
 *
 */
public class OthelloModel
{
	private int[][] board;
	

    //Some class constants for your use:
    public static final int NORMAL=0;
    public static final int CORNER_TEST=1;
    public static final int OUTER_TEST=2;
    public static final int TEST_CAPTURE=3;
    public static final int TEST_CAPTURE2=4;
    public static final int UNWINNABLE=5;
    public static final int INNER_TEST=6;
    public static final int ARROW=7;

    public static final int EMPTY=0;
    public static final int BLACK=1;
    public static final int WHITE=2;
    
   
    

    /**
     * Prepares the game board for a new game in a selected layout
     * 
     * @param mode what mode you wish to have the board layout in
     * @return board the selected layout will be returned
     */
	 int[][] prepareBoard(int mode)
	{
		switch (mode)
		{
		case CORNER_TEST: 
			board=new int[][]{
				{2, 0, 0, 0, 0, 0, 0, 1},
				{0, 1, 0, 0, 0, 0, 2, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 0, 0, 0, 0, 1, 0},
                {2, 0, 0, 0, 0, 0, 0, 2}};
                
            break;
                
		case OUTER_TEST:
			board = new int[][] {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 2, 2, 2, 2, 2, 2, 0},
				{0, 2, 1, 1, 1, 1, 2, 0},
				{0, 2, 1, 0, 0, 1, 2, 0},
				{0, 2, 1, 0, 0, 1, 2, 0},
				{0, 2, 1, 1, 1, 1, 2, 0},
				{0, 2, 2, 2, 2, 2, 2, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}};
			break;
                
		case INNER_TEST:
			board = new int[][] {
				{2, 2, 2, 2, 2, 2, 2, 2},
				{2, 0, 0, 0, 0, 0, 0, 2},
				{2, 0, 2, 2, 2, 2, 0, 2},
				{2, 0, 2, 1, 1, 2, 0, 2},
				{2, 0, 2, 1, 1, 2, 0, 2},
				{2, 0, 2, 2, 2, 2, 0, 2},
				{2, 0, 0, 0, 0, 0, 0, 2},
				{2, 2, 2, 2, 2, 2, 2, 2}};
				
			break;
                
		case UNWINNABLE:
			board = new int[][] {
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}};
				
			break;
                
		case TEST_CAPTURE:
			board=new int[][]{
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 1, 1, 1, 1, 1, 1, 0},
				{0, 1, 1, 1, 1, 1, 1, 0},
				{0, 1, 2, 2, 2, 1, 1, 0},
				{0, 1, 2, 0, 2, 1, 1, 0},
				{0, 1, 2, 2, 2, 1, 1, 0},
				{0, 1, 1, 1, 1, 1, 1, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}};
				
				break;
				
		case TEST_CAPTURE2:
			board=new int[][]{
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1},
				{1, 2, 2, 2, 1, 2, 1, 1},
				{1, 2, 2, 2, 2, 2, 1, 1},
				{1, 2, 2, 0, 2, 2, 1, 1},
				{1, 2, 2, 2, 2, 1, 1, 1},
				{1, 2, 1, 2, 2, 2, 1, 1},
				{1, 1, 1, 1, 1, 1, 1, 1}};
				break;
                
            case ARROW:
                board=new int[][]{
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 1, 1, 0, 1, 0},
                {1, 0, 0, 1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0}};
               
                break;
                
		default:
			board = new int[][]{
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 2, 1, 0, 0, 0},
				{0, 0, 0, 1, 2, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0}};
				
		}
		return board;	
			
	}
    
   
	/**
	 * This method will return the value of a given square.
	 * 
	 * @param row row of the desired square
	 * @param col column of the desired square
	 * @return value the value of the square (0 for empty, 1 for black, 2 for white)
	 */
	public int getSquare(int row, int col)
	{
		int value = board[row][col];
		return value;

	}
	

    /**
     * Checks for a valid move at a specified board location
     * Logic for the method:
     * Step 1: Check to make sure the square selected is empty
     * Step 2: Check for an edge case if its an edge case find out what edge its is then move to step 4 otherwise continue
     * Step 3: Check if there are any opposing players surrounding the piece
     * Step 4: Check all surrounding points for a valid move if there is return true
     * 
     * @param row the row currently selected
     * @param col the column currently selected
     * @param player the player currently selected
     * @return true if a move is possible false otherwise
     */
	public boolean canMove(int row, int col, int player)
	{
		int total[] = checkSurroundings(row,col);

		int otherPlayer = getOtherPlayer(player);
		if(board[row][col] == player) {
			return false;
			
		}else if(board[row][col] == otherPlayer ) {
			return false;
		}else if(isEdgeCase(row, col)) {
			//top left corner
			if(row == 0 && col == 0) {
				if(board[row+1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,3)) {
						return true;
					}
				}
				if(board[row+1][col+1] == otherPlayer) {
					if(validMove(row,col,player,4)) {
						return true;
					}
				}
				if(board[row][col+1] == otherPlayer) {
					if(validMove(row,col,player,5)) {
						return true;
					}
				}
			//bottom left corner
			}else if(row == 7 && col == 0) {
				
					if(board[row-1][col] == otherPlayer) {
						if(validMove(row,col,player,7)) {
							return true;
						}
					}
					if(board[row-1][col+1] == otherPlayer) {
						if(validMove(row,col,player,6)) {
							return true;
						}
					}
					if(board[row][col+1] == otherPlayer) {
						if(validMove(row,col,player,5)) {
							return true;
						}
					}
			//top right corner
			}else if(row == 0 && col == 7) {
				if(board[row+1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,3)) {
						return true;
					}
				}
				if(board[row+1][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,2)) {
						return true;
					}
				}
				if(board[row][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,1)) {
						return true;
					}
				}
			//bottom right corner
			}else if(row == 7 && col == 7) {
				if(board[row-1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,7)) {
						return true;
					}
				}
				if(board[row-1][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,8)) {
						return true;
					}
				}
				if(board[row][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,1)) {
						return true;
					}
				}
			//top
			}else if(row == 0) {
				if(board[row][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,1)) {
						return true;
					}
				}
				if(board[row+1][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,2)) {
						return true;
					}
				}
				if(board[row+1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,3)) {
						return true;
					}
					
				}
				if(board[row+1][col+1] == otherPlayer) 
				{
					if(validMove(row,col,player,4)) {
						return true;
					}
				}
				if(board[row][col+1] == otherPlayer) 
				{
					if(validMove(row,col,player,5)) {
						return true;
					}
				}
			//left
			}else if(col == 0) {
				if(board[row-1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,7)) {
						return true;
					}
				}
				if(board[row-1][col+1] == otherPlayer) 
				{
					if(validMove(row,col,player,6)) {
						return true;
					}
				}
				if(board[row][col+1] == otherPlayer) 
				{
					if(validMove(row,col,player,5)) {
						return true;
					}
				}
				if(board[row+1][col+1] == otherPlayer) 
				{
					if(validMove(row,col,player,4)) {
						return true;
					}
				}
				if(board[row+1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,3)) {
						return true;
					}
				}
			//bottom
			}else if(row == 7) {
				if(board[row][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,1)) {
						return true;
					}
				}
				if(board[row-1][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,8)) {
						return true;
					}
				}
				if(board[row-1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,7)) {
						return true;
					}
				}
				if(board[row-1][col+1] == otherPlayer) 
				{
					if(validMove(row,col,player,6)) {
						return true;
					}
				}
				if(board[row][col+1] == otherPlayer) 
				{
					if(validMove(row,col,player,5)) {
						return true;
					}
				}
			//right
			}else if(col == 7) {
				if(board[row-1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,7)) {
						return true;
					}
				}
				if(board[row-1][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,8)) {
						return true;
					}
				}
				if(board[row][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,1)) {
						return true;
					}
				}
				if(board[row+1][col-1] == otherPlayer) 
				{
					if(validMove(row,col,player,2)) {
						return true;
					}
				}
				if(board[row+1][col] == otherPlayer) 
				{
					if(validMove(row,col,player,3)) {
						return true;
					}
				}
			}
		}else {
			/**
			 * Loop to check for simple false cases
			 */
			//if surroundings are empty return false
			if( total[0] == 8) {
				return false;
			}else if(player == 2) {
				//if there are no opposite player in the surrounding return false
				if(total[1] == 0) {
					return false;
				}		
			}else if(player == 1) {
				//if there are no opposite player in the surrounding return false
				if(total[2] == 0) {
					return false;
				}
			}//end of simple if else 
			
			//at this point we know there is at least one of the opposite player's pieces within the surroundings
			//check every point surrounding
			if(isOtherPlayer(row, col-1, player)) 
			{
				if(validMove(row,col,player,1)) {
					return true;
				}
				
			}
			
			if(isOtherPlayer(row+1, col-1, player)) 
			{

				if(validMove(row,col,player,2)) {
					return true;
				}
			}
			
			if(isOtherPlayer(row+1, col, player)) 
			{
				if(validMove(row,col,player,3)) {
					return true;
				}
				
			}
			
			if(isOtherPlayer(row+1, col+1, player)) 
			{
				if(validMove(row,col,player,4)) {
					return true;
				}
			}
			
			if(isOtherPlayer(row, col+1, player)) 
			{

				if(validMove(row,col,player,5)) {
					return true;
				}
			}
			
			if(isOtherPlayer(row-1, col+1, player)) 
			{
				if(validMove(row,col,player,6)) {
					return true;
				}
				
			}
			
			if(isOtherPlayer(row-1, col, player)) 
			{
				if(validMove(row,col,player,7)) {
					return true;
				}
				
			}
			
			if(isOtherPlayer(row-1, col-1, player)) 
			{
				if(validMove(row,col,player,8)) {
					return true;
				}
				
				
			}
			
		}
	
        return false;
    
    }
	
    /**
     * Attempts a move at the location specified in the parameters
     * Logic for the method:
     * Step 1: Check to make sure the square selected is empty
     * Step 2: Check for an edge case if its an edge case find out what edge its is then move to step 4 otherwise continue
     * Step 3: Check if there are any opposing players surrounding the piece
     * Step 4: Check all surrounding points for a valid move if there is make it and add the pieces captured to the total
     * Step 5: Return the total
     * 
     * @param row the row currently selected
     * @param col the column currently selected
     * @param player the player currently selected
     * @return count the number of chips captured
     */
	public int tryMove(int row, int col, int player)
	{
		int count = 0;
		int total[] = checkSurroundings(row,col);

		int otherPlayer = getOtherPlayer(player);
		if(board[row][col] != 0) {
			return 0;
		}else if(isEdgeCase(row, col)) {
			//top left corner
			if(row == 0 && col == 0) {
				if(board[row+1][col] == otherPlayer) 
				{
					count += makeMove(row, col, player, 3);
				}
				if(board[row+1][col+1] == otherPlayer) {
					count += makeMove(row, col, player, 4);
				}
				if(board[row][col+1] == otherPlayer) {
					count += makeMove(row, col, player, 5);
				}
			//bottom left corner
			}else if(row == 7 && col == 0) {
				
					if(board[row-1][col] == otherPlayer) {
						count += makeMove(row, col, player, 7);
					}
					if(board[row-1][col+1] == otherPlayer) {
						count += makeMove(row, col, player, 6);
					}
					if(board[row][col+1] == otherPlayer) {
						count += makeMove(row, col, player, 5);
					}
			//top right corner
			}else if(row == 0 && col == 7) {
				if(board[row+1][col] == otherPlayer) 
				{
					count += makeMove(row, col, player, 3);
				}
				if(board[row+1][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 2);
				}
				if(board[row][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 1);
				}
			//bottom right corner
			}else if(row == 7 && col == 7) {
				
				if(board[row-1][col] == otherPlayer) 
				{	
					count += makeMove(row, col, player, 7);
				}
				if(board[row-1][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 8);
				}
				if(board[row][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 1);
				}
			//top
			}else if(row == 0) {
				if(board[row][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 1);
				}
				if(board[row+1][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 2);
				}
				if(board[row+1][col] == otherPlayer) 
				{
					count += makeMove(row, col, player, 3);
					
				}
				if(board[row+1][col+1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 4);
				}
				if(board[row][col+1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 5);
				}
			//left
			}else if(col == 0) {
				if(board[row-1][col] == otherPlayer) 
				{
					count += makeMove(row, col, player, 7);
				}
				if(board[row-1][col+1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 6);
				}
				if(board[row][col+1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 5);
				}
				if(board[row+1][col+1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 4);
				}
				if(board[row+1][col] == otherPlayer) 
				{
					count += makeMove(row, col, player, 3);
				}
			//bottom
			}else if(row == 7) {
				if(board[row][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 1);
				}
				if(board[row-1][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 8);
				}
				if(board[row-1][col] == otherPlayer) 
				{
					count += makeMove(row, col, player, 7);
				}
				if(board[row-1][col+1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 6);
				}
				if(board[row][col+1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 5);
				}
			//right
			}else if(col == 7) {
				if(board[row-1][col] == otherPlayer) 
				{
					count += makeMove(row, col, player, 7);
				}
				if(board[row-1][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 8);
				}
				if(board[row][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 1);
				}
				if(board[row+1][col-1] == otherPlayer) 
				{
					count += makeMove(row, col, player, 2);
				}
				if(board[row+1][col] == otherPlayer) 
				{
					count += makeMove(row, col, player, 3);
				}
			}
		}else {
			/**
			 * Loop to check for simple false cases
			 */
			//if surroundings are empty return false
			if( total[0] == 8) {
				return 0;
			}else {
				//if there are no opposite player in the surrounding return false
				if(total[otherPlayer] == 0) {
					return 0;
				}		
	
			}//end of simple if else 
			
			//at this point we know there is at least one of the opposite player's pieces within the surroundings
			//check every point surrounding
			if(isOtherPlayer(row, col-1, player)) 
			{
				count += makeMove(row,col,player,1);
				
			}
			
			if(isOtherPlayer(row+1, col-1, player)) 
			{

				count += makeMove(row,col,player,2);
			}
			
			if(isOtherPlayer(row+1, col, player)) 
			{
				count += makeMove(row,col,player,3);
				
			}
			
			if(isOtherPlayer(row+1, col+1, player)) 
			{
				count+= makeMove(row, col,player,4);
			}
			
			if(isOtherPlayer(row, col+1, player)) 
			{
				count += makeMove(row,col,player,5);
			}
			
			if(isOtherPlayer(row-1, col+1, player)) 
			{
				count += makeMove(row,col,player,6);
				
			}
			
			if(isOtherPlayer(row-1, col, player)) 
			{
				count+= makeMove(row,col,player,7);
				
			}
			
			if(isOtherPlayer(row-1, col-1, player)) 
			{
				count+= makeMove(row,col,player,8);
				
			}
			
		}
	
        return count;
    }
        
	/**
	 * Test if the player has a valid move 
	 * 
	 * @param player the player to check for a possible move
	 * @return true if a move exists, false otherwise
	 */
    public boolean moveTest(int player)
    {
    		for(int i = 0; i < 8; i++) {
    			for(int j = 0; j < 8; j++) {
    				if(canMove(i,j,player)) {
    					return true;
    				}
    			}
    		}
    		return false;

    }

    
    /**
     * How many chips does the specified player have in play?
     * 
     * @param player 1 for black 2 for white
     * @return count the amount of chips for the selected player
     */
    public int chipCount(int player)
    {

    	int count = 0;
		for(int i = 0; i < 8 ; i++) {
			for(int j = 0; j < 8; j++) {
				if(board[i][j] == player) {
					count++;
				}
			}
		
		}
		return count;

    }
    
    /**
     * Method that returns the edge case see below table for the value of each edge case.
     * 
     * @param row the row of the specified point
     * @param col the column of the specified point
     * @return true if edge case, false if not an edge case
     */
    public boolean isEdgeCase(int row, int col) {
    	if(row == 0) {
    		return true;
    	}else if(col == 0) {
    		return true;
    	}else if(row == 7) {
    		return true;
    	}else if(col == 7) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    /**
     * Checks the surrounding of the desired square and returns the instances of each occurrence(player 1, player 2, empty)
     * 
     * Note: I did not do this with edge cases it is not all that useful for them since there is only a total of 3-5 surrounding pieces to check vs the 8 of a non-edge piece. 
     * In general this method is not necessary for the program. 
     * It was a good idea on paper when planning but in practice its not all that useful. 
     * However, possibly save the program from running 8 if statements in the case no opposing players are surrounding.
     * 
     * @param row the row to be checked
     * @param col the column to be checked
     * @return surroundings an array with the instances of empty, player 1 and player 2 in the 8 surrounding squares
     */
    public int[] checkSurroundings(int row, int col) {
    	int total[] = new int [3];
    	int surroundings[] = new int[8];
    	
    	//defensive programming(if an edge case calls this method it will cause an array out of bounds) 
		if(isEdgeCase(row, col)) {
		}else {
			surroundings[0] = board[row][col-1];
				
			surroundings[1] = board[row+1][col-1];
				
			surroundings[2] = board[row+1][col];
				
			surroundings[3] = board[row+1][col+1];
				
			surroundings[4] = board[row][col+1];
			
			surroundings[5] = board[row-1][col+1];
		
			surroundings[6] = board[row-1][col];

			surroundings[7] = board[row-1][col-1];
				
		for(int i = 0; i < 8; i++) {
			if(surroundings[i] == 0) {
				total[0]++;
			}else if(surroundings[i] == 1) {
				total[1]++;
			}else if(surroundings[i] == 2) {
				total[2]++;
			}
		}
			
		}
		return total;
		
    }
    
    /**
     * gets the other player
     * 
     * @param player the current player
     * @return otherPlayer
     */
    public int getOtherPlayer(int player) {
    	int otherPlayer = 0;
    	
    	if(player == 1) {
    		otherPlayer = 2;
    	}else {
    		otherPlayer = 1;
    	}
    	return otherPlayer;
    }

    /**
     * Checks is the value at the specified position is an other player
     * 
     * @param row the row of the specified point
     * @param col the column of the specified point
     * @param player selected player
     * @return true if the value is another player false if its an edge case or not another player
     */
    private boolean isOtherPlayer(int row, int col, int player) {
    	int otherPlayer = getOtherPlayer(player);

    	//if the value is the other player return true
    	if(board[row][col] == otherPlayer){
    		return true;
    	}else {
    		return false;
    	}
	
	
		}
    
    /**
     * Checks to see if the opposing players pieces can be taken, 
	 * if so converts them into the current players pieces.
     * 
     * @param row the row to be checked
     * @param col the column to be checked
     * @param player the player to be checked
     * @param direction what direction should be checked for valid pieces
     * @return the amount of pieces taken from the other player(0 if none)
     */
    private int makeMove(int row, int col, int player, int direction) {
    	int count = 0;
    	int tempRow = 0;
    	int tempCol = 0;
    	switch(direction) {	
    	
    	//middle left
    	case 1:
    		for(int i = col-1; 0 <= i ; i--) {
    			if(isOtherPlayer(row,i,player)) {
    				count++;

    			}else if(board[row][i] == player) {
    				for(int j = col-1; j> i;j--) {
    					board[row][j] = player;
    				}
    				
    				board[row][col] = player;
    				return count;
    			}else {

    				return 0;
    			}
    		}

        	break;
        //bottom left
    	case 2:
			tempRow = row+1;
			tempCol = col-1;
			while(tempRow <= 8 || tempCol >= 0) {
				if(tempRow == 8) {
					return 0;
				}
				if(tempCol == -1) {
					return 0;
				}
				
				if(isOtherPlayer(tempRow,tempCol,player)) {
					count++;
					
				}else if(board[tempRow][tempCol] == player) {
					while(tempRow != row || tempCol != col) {
						
						board[tempRow][tempCol] = player;
						tempRow--;
						tempCol++;
					}
					board[row][col] = player;
					return count;
				}else {
					break;
				}
				tempRow++;
				tempCol--;
			}
        	break;
    	//bottom center
    	case 3:
		for(int i = row+1; i < 8 ; i++) {
			if(isOtherPlayer(i,col,player)) {
				count++;
				
			}else if(board[i][col] == player) {
				for(int j = row+1; j< i;j++) {
					board[j][col] = player;
				}
				
				board[row][col] = player;
				return count;
			}else {
				return 0;
			}
		}
    	
    	break;
    	//bottom right
    	case 4:
			tempRow = row+1;
			tempCol = col+1;
			while(tempRow != 8 || tempCol != 8) {
				if(tempRow == 8) {
					return 0;
				}
				if(tempCol == 8) {
					return 0;
				}
				
				if(isOtherPlayer(tempRow,tempCol,player)) {
					count++;
					
				}else if(board[tempRow][tempCol] == player) {
					while(tempRow != row || tempCol != col) {
						
						board[tempRow][tempCol] = player;
						tempRow--;
						tempCol--;
					}
					board[row][col] = player;
					return count;
				}else {
					break;
				}
				tempRow++;
				tempCol++;
			}
    	break;
    	//middle right
    	case 5:
    		for(int i = col+1; i < 8 ; i++) {
    			if(isOtherPlayer(row,i,player)) {
    				count++;
    				
    			}else if(board[row][i] == player) {
    				for(int j = col+1; j< i;j++) {
    					board[row][j] = player;
    				}
    				
    				board[row][col] = player;
    				return count;
    			}else {
    				return 0;
    			}
    		}
        break;
        //top right
    	case 6:
			tempRow = row-1;
			tempCol = col+1;
			while(tempRow != 0 || tempCol != 8) {
				if(tempRow == -1) {
					return 0;
				}
				if(tempCol == 8) {
					return 0;
				}
				
				if(isOtherPlayer(tempRow,tempCol,player)) {
					count++;
					
				}else if(board[tempRow][tempCol] == player) {
					while(tempRow != row || tempCol != col) {
						
						board[tempRow][tempCol] = player;
						tempRow++;
						tempCol--;
					}
					board[row][col] = player;
					return count;
				}else {
					break;
				}
				tempRow--;
				tempCol++;
			}
        break;
        //top middle
    	case 7:
    		for(int i = row-1; 0 <= i ; i--) {
    			if(isOtherPlayer(i,col,player)) {
    				count++;
    				
    			}else if(board[i][col] == player) {
    				for(int j = row-1; j> i;j--) {
    					board[j][col] = player;
    				}
    				
    				board[row][col] = player;
    				return count;
    			}else {
    				return 0;
    			}
    		}
        break;
        //top left
    	case 8:
			tempRow = row-1;
			tempCol = col-1;

			while(tempRow != -1 || tempCol != -1) {
				if(tempRow == -1) {
					return 0;
				}
				if(tempCol == -1) {
					return 0;
				}
				
				if(isOtherPlayer(tempRow,tempCol,player)) {
					count++;
					
				}else if(board[tempRow][tempCol] == player) {
					while(tempRow != row || tempCol != col) {
						
						board[tempRow][tempCol] = player;
						tempRow++;
						tempCol++;
					}
					board[row][col] = player;
					return count;
				}else {
					break;
				}
				tempRow--;
				tempCol--;
			}
        break;
    
        	
    		
    	
    	}
		return 0;
    }
    
    /**
     * Checks to see if the opposing players pieces can be taken, 
	 * if so returns true false otherwise.
     * 
     * @param row the row to be checked
     * @param col the column to be checked
     * @param player the player to be checked
     * @param direction what direction should be checked for valid pieces
     * @return true if the move is valid false otherwise
     */
    private boolean validMove(int row, int col, int player, int direction) {
    	int tempRow = 0;
    	int tempCol = 0;
    	switch(direction) {	
    	
    	//middle left
    	case 1:
    		
    		for(int i = col-2; 0 <= i ; i--) {
    			if(isOtherPlayer(row,i,player)) {
    			

    			}else if(board[row][i] == player) {

    				return true;
    			}else {

    				return false;
    			}
    		}

        	break;
        //bottom left
    	case 2:
			tempRow = row+1;
			tempCol = col-1;

			while(tempRow != 8 || tempCol != 0) {
				if(tempRow == 8) {
					return false;
				}
				if(tempCol == -1) {
					return false;
				}
				
				if(isOtherPlayer(tempRow,tempCol,player)) {
					
				}else if(board[tempRow][tempCol] == player) {
					return true;
				}else {
					return false;
				}
				tempRow++;
				tempCol--;
			}
        	break;
    	//bottom center
    	case 3:
    	
		for(int i = row+2; i < 8 ; i++) {
			if(isOtherPlayer(i,col,player)) {
				
				
			}else if(board[i][col] == player) {
				return true;
			}else {
				return false;
			}
		}
    	
    	break;
    	//bottom right
    	case 4:
			tempRow = row+1;
			tempCol = col+1;

			while(tempRow != 8 || tempCol != 8) {
				if(tempRow == 8) {
					return false;
				}
				if(tempCol == 8) {
					return false;
				}
				
				if(isOtherPlayer(tempRow,tempCol,player)) {
				
					
				}else if(board[tempRow][tempCol] == player) {
					return true;
				}else if(board[tempRow][tempCol] == player) {
					return true;
				}else if(tempRow == 7 && tempCol == 7) {
					return false;
				}
				else {
					return false;
				}
				tempRow++;
				tempCol++;
			}
    	break;
    	//middle right
    	case 5:
    		for(int i = col+2; i < 8 ; i++) {
    			if(isOtherPlayer(row,i,player)) {
    				
    			}else if(board[row][i] == player) {
    				return true;
    			}else {
    				return false;
    			}
    		}
        break;
        //top right
    	case 6:
			tempRow = row-1;
			tempCol = col+1;
			while(tempRow >= 0|| tempCol != 8) {
				if(tempRow == -1) {
					return false;
				}
				if(tempCol == 8) {
					return false;
				}
				
				if(isOtherPlayer(tempRow,tempCol,player)) {
					
				}else if(board[tempRow][tempCol] == player) {
					return true;	
				}else if(board[tempRow][tempCol] == player) {
					return true;
				}else if(tempRow == 0 && tempCol == 7) {
					
					return false;
				}
				else {
					return false;
				}
				tempRow--;
				tempCol++;
			}
        break;
        //top middle
    	case 7:
    		for(int i = row-2; 0 <= i ; i--) {
				if(row == 8) {
					row = 7;
				}
    			
    			if(isOtherPlayer(i,col,player)) {
    				
    				
    			}else if(board[i][col] == player) {
    				return true;
    			}else {
    				return false;
    			}
    		}
        break;
        //top left
    	case 8:
			tempRow = row-1;
			tempCol = col-1;
			while(tempRow != -1 || tempCol != -1) {
				if(tempRow == -1) {
					return false;
				}
				if(tempCol == -1) {
					return false;
				}
				
				if(isOtherPlayer(tempRow,tempCol,player)) {
				
					
				}else if(board[tempRow][tempCol] == player) {
					return true;
				}else if(tempRow == 0 && tempCol == 0) {
					return false;
				}
				else {
					return false;
				}
				tempRow--;
				tempCol--;
			}
        break;
    	
    	}
		return false;
    }
     
    /**
     * Getter for board used to update the board in the gui
     * 
     * @return board
     */
    public int[][]  getBoard() {
    	
    	return board;
    }
    
}
	