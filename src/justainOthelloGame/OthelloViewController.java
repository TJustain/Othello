	package justainOthelloGame;
	
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.GridLayout;
	import java.awt.Image;
	import java.awt.Insets;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyEvent;
	import java.awt.image.BufferedImage;
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JCheckBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JRadioButtonMenuItem;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import javax.swing.JToolBar;
	import javax.swing.SwingConstants;
	import javax.swing.WindowConstants;
	import javax.swing.border.CompoundBorder;
	import javax.swing.border.EmptyBorder;
	import javax.swing.border.LineBorder;
	
	/**
	 * @author Justian Tremblay
	 * @version 2.0
	 * 
	 * Responsible for the GUI and all buttons.
	 */
	public class OthelloViewController extends JFrame {
		
		/**
		 * Deceleration
		 */
		private static final long serialVersionUID = 1L;
		private  int whitePieces = 0;
		private int blackPieces = 0;
		private int currentPlayer = 1;
		private int currentRow = 3;
		private int currentCol = 3;
		OthelloModel model = new OthelloModel();
		
	    /**
	     * Colors used 
	     */
	    private Color blue = new Color(175, 175, 255);
	    private Color grey = new Color(220, 220, 220);
	    
	    /**
	     * Images
	     */

	    
	    private ImageIcon whiteIcon = new ImageIcon(getClass().getClassLoader().getResource("white.png"));
	    private ImageIcon checkIcon = new ImageIcon(getClass().getClassLoader().getResource("checkmark.png"));
	    private ImageIcon upIcon= new ImageIcon(getClass().getClassLoader().getResource("uparrow.png"));
	    private ImageIcon leftIcon= new ImageIcon(getClass().getClassLoader().getResource("leftarrow.png"));
	    private ImageIcon rightIcon= new ImageIcon(getClass().getClassLoader().getResource("rightarrow.png"));
	    private ImageIcon downIcon= new ImageIcon(getClass().getClassLoader().getResource("downarrow.png"));
	    private ImageIcon blackIcon = new ImageIcon(getClass().getClassLoader().getResource("black.png"));
	    
	   JPanel container = new JPanel();
	    JPanel panelOne = new JPanel(new BorderLayout(3,3));
	    JPanel panelTwo = new JPanel(new BorderLayout());
	    JLabel[][] boardSquares = new JLabel[8][8];
	    JTextArea textBox = new  JTextArea("");
	    JToolBar toolBar = new JToolBar();
	    JTextField submitText = new JTextField();
	    JButton submit = new JButton("Submit");
	    //control pieces panel
		JPanel cp = new JPanel(new FlowLayout(FlowLayout.LEADING,5, 5));
		JPanel controls = new JPanel(new GridLayout(3,3, 5, 5));
		JCheckBox check = new JCheckBox("Show Valid Moves");
		
		JFrame frame = new JFrame("Justain's Othello Client"); 
		//Movment buttons
		JButton move = new JButton("move");
		JButton down = new JButton(downIcon);
		JButton right = new JButton(rightIcon);       			
		JButton up = new JButton(upIcon);
	  	JButton left = new JButton(leftIcon);
	  	
    	JPanel text = new JPanel(new GridLayout(2, 1, 0, 40));
    	
    	JPanel pieces = new JPanel(new GridLayout(2,1, 5,20));
    		
    	JLabel whitePiece = new JLabel(""+whitePieces);
    	JLabel blackPiece = new JLabel(""+blackPieces);
	    
	    final String list = "ABCDEFGHI";
	    JMenuBar menuBar = new JMenuBar();
	    JMenu menuFile = new JMenu("File");
	    
	    
	    JMenu menuGame = new JMenu("Game");
	    JMenuItem defaultColour = new JMenuItem("Default");
	    JMenuItem canadaDay = new JMenuItem("Canada Day!");
	    JMenu menuHelp = new JMenu("Help");
	    JMenuItem about = new JMenuItem("About");
	    JMenuItem newGame = new JMenuItem("New Game");
	    
	    //radio buttons
	    JRadioButtonMenuItem defaultLayout = new JRadioButtonMenuItem("Normal Game");
	    JRadioButtonMenuItem corner = new JRadioButtonMenuItem("Corner Test");
	    JRadioButtonMenuItem side = new JRadioButtonMenuItem("Side Test");
	    JRadioButtonMenuItem capture1 = new JRadioButtonMenuItem("1x Capture Test");
	    JRadioButtonMenuItem capture2 = new JRadioButtonMenuItem("2x Capture Test");
	    JRadioButtonMenuItem empty = new JRadioButtonMenuItem("Empty Board");
	    JRadioButtonMenuItem inner = new JRadioButtonMenuItem("Inner Square Test");
	    JRadioButtonMenuItem arrow = new JRadioButtonMenuItem("Up Arrow Orientation");
	    	    
	    //default Font
	    final Font FONT = new JLabel().getFont();
	    
	    Controller control = new Controller();
	    public OthelloViewController(String help){
	    	
	    }
		
	    /**
	     * Constructor where the gui is built
	     */
		public OthelloViewController(){
			
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			
	        this.setLayout(new BorderLayout());
	        	        
	        panelOne = new JPanel(new GridLayout(0, 10)); 
	
	      	panelOne.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,-5),new LineBorder(Color.GRAY, 5)));
	        panelOne.setBackground(grey);
	        
	        /*
	         * Menu bar code
	         */
	        
	        /**
	         * File
	         */
	        	menuFile.setMnemonic(KeyEvent.VK_A);
	        	newGame.addActionListener(control);
	        	menuFile.add(newGame);
	        	JMenuItem menuItem = new JMenuItem("Load");
	        	menuItem.setEnabled(false);
	        	menuFile.add(menuItem);
	        	menuItem = new JMenuItem("Save");
	        	menuItem.setEnabled(false);
	        	menuFile.add(menuItem);
	        	menuBar.add(menuFile);
	        	
	        	
	        	
	        	
	        /**
	         * Game
	         */
	        	JMenu subMenu = new JMenu("Board Colours");
	        	subMenu.setMnemonic(KeyEvent.VK_A);
	        	defaultColour.addActionListener(control);
	        	subMenu.add(defaultColour);
	        	
	        	canadaDay.addActionListener(control);
	        	subMenu.add(canadaDay);
	        	menuGame.add(subMenu);
	        	subMenu = new JMenu("Debug Scenarios");
	        	
	        	subMenu.add(defaultLayout);
	        		canadaDay.addActionListener(control);
	        	
	        	subMenu.add(corner);
	        		canadaDay.addActionListener(control);
	        	
	        	subMenu.add(side);
	        		canadaDay.addActionListener(control);
	        	
	        	subMenu.add(capture1);
	        		canadaDay.addActionListener(control);
	        	
	        	subMenu.add(capture2);
	        		canadaDay.addActionListener(control);
	        	
	        	subMenu.add(empty);
	        		canadaDay.addActionListener(control);
	        	
	        	subMenu.add(inner);
	        		canadaDay.addActionListener(control);
	        		
	        	arrow.addActionListener(control);
	        	subMenu.add(arrow);
	        		
	        	menuGame.add(subMenu);
	        	menuBar.add(menuGame);

	        /**
	         * Help  
	         */
	        	menuHelp.setMnemonic(KeyEvent.VK_A);
	        	about.addActionListener(control);
	        	menuHelp.add(about);
	        	
	        	menuBar.add(menuHelp);
	        
	        /**
	         * Loops to fill the 2d array with all necessary colors
	         */
	        for (int i = 0; i < boardSquares.length; i++) {
	            for (int j = 0; j < boardSquares[i].length; j++) {
	                JLabel temp = new JLabel();
	                //sets piece to center
                   	temp.setHorizontalAlignment(JLabel.CENTER);
	                //Temporary Image
	                ImageIcon iconIcon = new ImageIcon(new BufferedImage(60, 60,BufferedImage.TYPE_INT_ARGB));
	                temp.setPreferredSize(new Dimension(60,60));
	                temp.setIcon(iconIcon);
	                temp.setOpaque(true);
	                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
	                	temp.setBackground(Color.WHITE);
	                } else {
	                	temp.setBackground(Color.BLACK);
	                }
	                boardSquares[j][i] = temp;
	            }
	        }
	       
	        /*
	         * Adds the labels surrounding the the board as well as builds the board 
	         * Simple explanation of the following code: 
	         * Since the board is made up of 10 Columns you basically gradually build the grid column by column
	         * Start with an empty for the top left corner, then fill the column with letters from a string and end with an empty bottom left corner.
	         * Enter a loop that loops the amount of collumns necec
	         * 
	         */
	        Font labelFont = new Font(FONT.getName(), FONT.getStyle(), 20);
	        
	        //Start with an empty for the top left corner
	        panelOne.add(new JLabel(""));
	           
	           //Fill the column with letters from a string
	           for (int i = 0; i < 8; i++) {
	           	JLabel label = new JLabel("",SwingConstants.CENTER);
	           	label.setText("" + (i + 1));
	           	label.setFont(labelFont);
	           	panelOne.add(label);           	
	           }
	           //End with an empty bottom left corner
	           panelOne.add(new JLabel(""));
	           
	           for (int i = 0; i < 8; i++) {
	               for (int j = 0; j <= 8 ; j++) {  
	                if(j == 0) {
	                  	JLabel label = new JLabel("");
	                  	label.setHorizontalAlignment(JLabel.CENTER);
	               	label.setText(list.substring(i, i+1));
	               	label.setFont(labelFont);
	               	panelOne.add(label);
	        
	                panelOne.add(boardSquares[j][i]);
	                }else if(j <8){
	               	 panelOne.add(boardSquares[j][i]);
	                }else if(j == 8) {
	                   	JLabel label = new JLabel("");
	                   	label.setHorizontalAlignment(JLabel.CENTER);
	                   	label.setText(list.substring(i, i+1));
	                   	label.setFont(labelFont);
	                   	panelOne.add(label);
	                }
	                          
	                   }
	               }
	           
	           panelOne.add(new JLabel(""));
	           for (int i = 0; i < 8; i++) {
                  	JLabel label = new JLabel("");
                  	label.setHorizontalAlignment(JLabel.CENTER);
	           	label.setText("" + (i + 1));
	           	label.setFont(labelFont);
	           	panelOne.add(label);
	           }
	           panelOne.add(new JLabel(""));
	          
	         /*
	          * Submit and text field code
	          */
	     	panelTwo.setBorder(new CompoundBorder(new EmptyBorder(0,0,0,0),new LineBorder(Color.GRAY, 5)));
	
	        submit.setBackground(Color.BLACK);
	        submit.setForeground(Color.RED);
	        submit.addActionListener(control);
	        toolBar.add(submitText);
	        toolBar.add(submit);
	        toolBar.setFloatable(false);
	     	toolBar.setBorder(new CompoundBorder(new EmptyBorder(-5,0,0,0),new LineBorder(Color.GRAY, 5)));
	
	        Dimension panelOneSize = panelOne.getPreferredSize();
	     	panelTwo.setPreferredSize(new Dimension(450, panelOneSize.height));
	        
	     	/*
	     	 * Check Box code
	     	 */
	        check.setBackground(grey);
	        check.addActionListener(control);
	        panelTwo.add(check, BorderLayout.NORTH);
	        
	        /**
	         * Adding move Buttons and amount of pieces
	         * Small explanation to help understand my thought process:
	         * Step 1: Split the 5 move buttons and the amount of pieces into two separate Panels
	         * Step 2: Add the 5 buttons and the amount of pieces into one Panel side by side
	         * Step 3: Add those to the other two(check box and text box)
	         */
	        	Dimension controlSize = new Dimension(120,120);
	        	controls.setSize(controlSize);
	        	controls.setPreferredSize(controlSize);
	        	controls.setMinimumSize(controlSize);
	        	controls.setMaximumSize(controlSize);
	
	        			up.setBackground(Color.WHITE);
	        			up.addActionListener(control);
	
	        			left.setBackground(Color.WHITE);
	        			left.addActionListener(control);
	        		
	        			right.setBackground(Color.WHITE);
	        			right.addActionListener(control);
	        			
	        			down.setBackground(Color.WHITE);
	        			down.addActionListener(control);
	        		
	        			move.setBackground(Color.WHITE);
	        			move.setMargin(new Insets(0,0,0,0));
	        			move.setFont(new Font("Arial", Font.PLAIN, 10));
	        			move.addActionListener(control);
	
	        			controls.setBackground(grey);
	            		controls.add(new JLabel(""));
	        			controls.add(up);
	        			controls.add(new JLabel(""));
	        			controls.add(left);
	        			controls.add(move);
	        			controls.add(right);
	        			controls.add(new JLabel(""));
	        			controls.add(down);
	        			controls.add(new JLabel(""));
	        			
	        		//Extra spaces to set the gaps between components note: not the ideal solution but the best I came up with
	        		text.add(new JLabel("                   Player 1 Pieces:                  "));
	        		text.add(new JLabel("                   Player 2 Pieces:                  "));
	        		text.setBackground(grey);
	        		pieces.add(new JLabel(blackIcon));
	        		pieces.add(blackPiece);
	        		
	        		pieces.add(new JLabel(whiteIcon));
	        		pieces.add(whitePiece);
	        	
	        		pieces.setBackground(grey);
	        		
	        	cp.add(controls);
	        	cp.add(text);
	        	cp.add(pieces);
	        	
	        	cp.setBackground(grey);
	        	cp.setPreferredSize(new Dimension(450, 200));
	        	cp.setBorder(new CompoundBorder(new EmptyBorder(0,-5,-5,-5),new LineBorder(Color.GRAY, 5)));
	        	panelTwo.add(cp);
	        	
	        /**
	         * Adding blue text fields
	         */
	        textBox.setBackground(blue);
	        textBox.setOpaque(true);
	        textBox.setBorder(new CompoundBorder(new EmptyBorder(0,-5,-5,-5),new LineBorder(Color.GRAY, 5)));
	        textBox.setPreferredSize(new Dimension(450,460));
	      
	        panelTwo.add(textBox, BorderLayout.SOUTH);
	        
	        container.setLayout(new BorderLayout());
	        container.add(panelOne);
	      
	        container.add(panelTwo, BorderLayout.EAST);
	
	        container.add(toolBar,BorderLayout.PAGE_END);
	        
	        frame.getContentPane().add(container);
	        
	        
	        Dimension panelTwoSize = panelTwo.getPreferredSize();

	        Dimension frameSize = new Dimension((panelOneSize.width + panelTwoSize.width),725);
	        
	        frame.setMinimumSize(frameSize);
	        frame.setJMenuBar(menuBar);
	        frame.setVisible(true);
	        frame.setResizable(false);
	        frame.setLocationRelativeTo(null); 
	    }
		
		/**
		 * Method that sets the background colour of the board
		 * 
		 * @param first the first colour to set the background
		 * @param second the second colour to set the background
		 */
		 public void changeColours(Color first, Color second) {
			for(int i = 0; i < 8 ; i++) {
				for(int j = 0; j < 8; j++) {
					
					if(i %2 == 0) {
						if(j % 2 == 0) {
							boardSquares[i][j].setBackground(first);
						}else {
							boardSquares[i][j].setBackground(second);
						}
					}else {
						if(j % 2 == 0) {
							boardSquares[i][j].setBackground(second);
						}else {
							boardSquares[i][j].setBackground(first);
						}
					}
				
				}//second for loop
			}//first for loop
		}//Method
		public void launchGame(int mode) {
			move.setEnabled(true);
			int board[][] = model.prepareBoard(mode);
			
			for(int i = 0; i < 8 ; i++) {
				for(int j = 0; j < 8; j++) {
					if( board[i][j] == 1) {
						boardSquares[j][i].setIcon(blackIcon);
					}else if(board[i][j] == 2) {
						boardSquares[j][i].setIcon(whiteIcon);
					}else {
						boardSquares[j][i].setIcon(null);
					}					
				}
			}
			blackPieces = model.chipCount(1);
			whitePieces = model.chipCount(2);
			blackPiece.setText(""+blackPieces);	
			whitePiece.setText(""+whitePieces);	
			boardSquares[currentCol][currentRow].setBorder(null);
			boardSquares[currentRow][currentCol].setBorder((new CompoundBorder(new EmptyBorder(0,0,0,0),new LineBorder(Color.GREEN, 2))));
			textBox.setText("Player 1 initilaized with "+blackPieces+" pieces\nPlayer 2 initialized with "+whitePieces+" pieces");
			winCondition();
			
		}
		
	    /**
	     * Method to update the entire board pieces 
		 *
	     */
	    public void updateBoard() {
			int board[][] = model.getBoard();
			int player1Count = model.chipCount(1);
			int player2Count = model.chipCount(2);
			for(int i = 0; i < 8 ; i++) {
				for(int j = 0; j < 8; j++) {
					if( board[i][j] == 1) {
						boardSquares[j][i].setIcon(blackIcon);
					}else if(board[i][j] == 2) {
						boardSquares[j][i].setIcon(whiteIcon);
					}else {
						boardSquares[j][i].setIcon(null);
					}					
				}
			}

				blackPiece.setText(""+player1Count);	
				whitePiece.setText(""+player2Count);			
	    }
	    /**
	     * Generates the win conditions
	     */
	    public void winCondition() {
	    	if(!model.moveTest(1) && !model.moveTest(2)){
	    			textBox.append("\nGame Over");
	    			if(whitePieces > blackPieces) {
	    				textBox.append("\nPlayer 2 Wins");
	    			}else if(blackPieces > whitePieces) {
	    				textBox.append("\nPlayer 1 Wins");
	    			}else {
	    				textBox.append("\nDraw");
	    			}
	    		move.setEnabled(false);
	    	}
	    }
	   
		/**
		 * @author Justain Tremblay
		 * @version 1.0
		 * 
		 * Inner class responsible for the action listeners
		 *
		 */
		private class Controller implements ActionListener{
			
			/*
			 *  When a action event occur's call the appropriate method
			 * 
			 * 	@param ActionEvent: an action event
			 */
			public void actionPerformed(ActionEvent e) {
					
				if(e.getSource() == move ) {
					moveAction(e);
				}else if(e.getSource() == up ) {
					upAction(e);
				}else if(e.getSource() == down) {
					downAction(e);
				}else if(e.getSource() == left) {
					leftAction(e);
				}else if(e.getSource() == right) {
					rightAction(e);
				}else if(e.getSource() == submit) {
					submitAction(e);
				}else if(e.getSource() == check) {
					checkAction(e);
				}else if(e.getSource() == defaultColour) {
					defaultColourAction(e);
				}else if(e.getSource() == canadaDay){
					canadaDayAction(e);
				}else if(e.getSource() == about) {
					aboutAction(e);
				}else if(e.getSource() == newGame){
					newGameAction(e);
				}
				
				
			}
			
			
			
			
			/**
			 * Method gets called when the new game menu option is selected
			 * 
			 * @param e action event
			 */
			private void newGameAction(ActionEvent e) {
				
				if(arrow.isSelected()) {
					launchGame(OthelloModel.ARROW);
				}else if(defaultLayout.isSelected()){
					launchGame(OthelloModel.NORMAL);
				}else if(corner.isSelected()){
					launchGame(OthelloModel.CORNER_TEST);
				}else if(side.isSelected()){
					launchGame(OthelloModel.OUTER_TEST);
				}else if(capture1.isSelected()){
					launchGame(OthelloModel.TEST_CAPTURE);
				}else if(capture2.isSelected()){
					launchGame(OthelloModel.TEST_CAPTURE2);
				}else if(empty.isSelected()){
					launchGame(OthelloModel.UNWINNABLE);
				}else if(inner.isSelected()){
					launchGame(OthelloModel.INNER_TEST);
				}	
			}
			/**
			 * Method gets called when the about menu option is selected
			 * 
			 * @param e action event
			 */
			private void aboutAction(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Othello Game\nby Justain Tremblay", "About", JOptionPane.INFORMATION_MESSAGE);
				
			}
			/**
			 * Method gets called when the Canada day menu option is selected
			 * 
			 * @param e action event
			 */
			private void canadaDayAction(ActionEvent e) {
				changeColours(Color.WHITE, Color.RED);
				
			}
			/**
			 * Method gets called when the default colour menu option is selected
			 * 
			 * @param e action event
			 */
			private void defaultColourAction(ActionEvent e) {
				changeColours(Color.WHITE, Color.BLACK);
			}
			/**
			 * Method gets called when the move button gets pressed
			 * 
			 * @param e action event
			 */
			private void moveAction(ActionEvent e) {
				int capturedPieces = model.tryMove(currentRow, currentCol, currentPlayer);
				updateBoard();
				if(move.getText() == "skip") {
					//switch players
					if(currentPlayer == 1) {
						currentPlayer = 2;
					}else {
						currentPlayer = 1;
					}		
					move.setText("move");
				}else if(capturedPieces > 0) {
					textBox.append("\nPlayer "+currentPlayer+" captured "+capturedPieces+" piece(s).");
					//switch players
					if(currentPlayer == 1) {
						currentPlayer = 2;
					}else {
						currentPlayer = 1;
					}		
					
					if(model.moveTest(currentPlayer)) {
						move.setText("move");
					}else {
						move.setText("skip");
						textBox.append("\nPlayer "+currentPlayer+" cant move press skip.");
					}
					checkAction(e);
				}
				winCondition();
			}			
			/** 
			 * Method gets called when the up button gets pressed
			 * 
			 * @param e action event
			 */
			private void upAction(ActionEvent e) {
				if(!(currentRow <= 0)) {
				boardSquares[currentCol][currentRow].setBorder(null);
				currentRow--;
				}
				boardSquares[currentCol][currentRow].setBorder((new CompoundBorder(new EmptyBorder(0,0,0,0),new LineBorder(Color.GREEN, 2))));

			}
			/**
			 * Method gets called when the down button gets pressed
			 * 
			 * @param e action event
			 */
			private void downAction(ActionEvent e) {
				if(!(currentRow >= 7)) {
				boardSquares[currentCol][currentRow].setBorder(null);
				currentRow++;
				}
				boardSquares[currentCol][currentRow].setBorder((new CompoundBorder(new EmptyBorder(0,0,0,0),new LineBorder(Color.GREEN, 2))));
			}
			/**
			 * Method gets called when the left button gets pressed
			 * 
			 * @param e action event
			 */
			private void leftAction(ActionEvent e) {
				if(!(currentCol <= 0)) {
				boardSquares[currentCol][currentRow].setBorder(null);
				currentCol--;
				}
				boardSquares[currentCol][currentRow].setBorder((new CompoundBorder(new EmptyBorder(0,0,0,0),new LineBorder(Color.GREEN, 2))));
			}
			/**
			 * Method gets called when the right button gets pressed
			 * 
			 * @param e action event
			 */
			private void rightAction(ActionEvent e) {
				if(!(currentCol >= 7)) {
				boardSquares[currentCol][currentRow].setBorder(null);
				currentCol++;
				}
				boardSquares[currentCol][currentRow].setBorder((new CompoundBorder(new EmptyBorder(0,0,0,0),new LineBorder(Color.GREEN, 2))));
			}
			/**
			 * Method gets called when the submit button gets pressed
			 * 
			 * @param e action event
			 */
			private void submitAction(ActionEvent e) {
				System.out.println(submitText.getText());
			}
			/**
			 * Method gets called when the check has an event occur
			 * 
			 * @param e action event
			 */
			private void checkAction(ActionEvent e) {
				
				if(check.isSelected()) {
					for(int i = 0; i < 8; i++) {
						for(int j = 0; j < 8; j++) {
							if(model.getSquare(i, j) == 0) {
							if(model.canMove(i, j, currentPlayer)) {
								
								boardSquares[j][i].setIcon(checkIcon);
							}
							}
						}	
					}
				}else {
					for(int i = 0; i < 8; i++) {
						for(int j = 0; j < 8; j++) {
							if(model.getSquare(i, j) == 0) {
							if(model.canMove(i, j, currentPlayer)) {
								boardSquares[j][i].setIcon(null);
							
							}
							}
						}
						}
					}
				}

			}
			
		}
	
	
