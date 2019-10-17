package Chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Chessboard extends JPanel {
	private static final long serialVersionUID = 1L;
	private boolean indicator, timer;
	public JPanel board;
	private Scoreboard score;
	public JPanel[][] Squares;
	public JButton[][] Pieces;
	public Piece[][] Action;
	public JLabel[][] Spaces;
	public int turn, move, tempT, tempR, tempC;
	public double time, t1, t2;
	Font f = new Font("Sans Serif", Font.PLAIN, 0);
	public static String tempP, w;
	ImageIcon BR, BN, BB, BK, BQ, BP;
	ImageIcon WR, WN, WB, WK, WQ, WP;
	ImageIcon BRT, BNT, BBT, BKT, BQT, BPT;
	ImageIcon WRT, WNT, WBT, WKT, WQT, WPT;
	ImageIcon n;
	Color board1, board2;

	public Chessboard(boolean clock, double t, boolean show, boolean count) // Panel
																			// Constructor
	{
		time = t;
		t1 = time;
		t2 = time;
		indicator = show;
		if(t==0){
			timer=false;
		}
		else{
		timer = clock;
		}
		turn = 1;
		move = 0;
		setLayout(new BorderLayout());
		if (t == 0) {
			score = new Scoreboard(false, count, time, new timer1(), new timer2());
		} else {
			score = new Scoreboard(clock, count, time, new timer1(), new timer2());
		}
		add(score, BorderLayout.NORTH);
		board = new JPanel();
		board.setLayout(new GridLayout(8, 8));
		board.setBackground(Color.BLACK);
		Squares = new JPanel[8][8];
		Pieces = new JButton[8][8];
		Action = new Piece[8][8];
		Spaces = new JLabel[8][8];
		BR = new ImageIcon("rec/icons/BR.png");
		BN = new ImageIcon("rec/icons/BN.png");
		BB = new ImageIcon("rec/icons/BB.png");
		BK = new ImageIcon("rec/icons/BK.png");
		BQ = new ImageIcon("rec/icons/BQ.png");
		BP = new ImageIcon("rec/icons/BP.png");

		WR = new ImageIcon("rec/icons/WR.png");
		WN = new ImageIcon("rec/icons/WN.png");
		WB = new ImageIcon("rec/icons/WB.png");
		WK = new ImageIcon("rec/icons/WK.png");
		WQ = new ImageIcon("rec/icons/WQ.png");
		WP = new ImageIcon("rec/icons/WP.png");

		BRT = new ImageIcon("rec/icons/BRT.png");
		BNT = new ImageIcon("rec/icons/BNT.png");
		BBT = new ImageIcon("rec/icons/BBT.png");
		BKT = new ImageIcon("rec/icons/BKT.png");
		BQT = new ImageIcon("rec/icons/BQT.png");
		BPT = new ImageIcon("rec/icons/BPT.png");

		WRT = new ImageIcon("rec/icons/WRT.png");
		WNT = new ImageIcon("rec/icons/WNT.png");
		WBT = new ImageIcon("rec/icons/WBT.png");
		WKT = new ImageIcon("rec/icons/WKT.png");
		WQT = new ImageIcon("rec/icons/WQT.png");
		WPT = new ImageIcon("rec/icons/WPT.png");

		n = new ImageIcon("rec/icons/null.png");

		board1 = new Color(240, 212, 170);
		board2 = new Color(190, 101, 45);
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Squares[row][col] = new JPanel();
				Pieces[row][col] = new JButton();
				Action[row][col] = new Piece(row, col);
				Spaces[row][col] = new JLabel();

				Squares[row][col].setOpaque(true);

				if ((row + col) % 2 == 0)
					Squares[row][col].setBackground(board1);
				else
					Squares[row][col].setBackground(board2);

				Squares[row][col].setLayout(new GridLayout(3, 3, -80, -80));

				Pieces[row][col].addActionListener(Action[row][col]);

				if ((row + col) % 2 == 0)
					Pieces[row][col].setBackground(board1);
				else
					Pieces[row][col].setBackground(board2);

				Pieces[row][col].setBorderPainted(false);
				Pieces[row][col].setFocusPainted(false);
				if (Action[row][col].myT == 1)
					Pieces[row][col].setForeground(Color.WHITE.brighter());

				else if (Action[row][col].myT == 2)
					Pieces[row][col].setForeground(Color.BLACK);
				else
					Pieces[row][col].setForeground(Color.GREEN);
				add(Squares[row][col]);
				Squares[row][col].add(new JLabel(""));
				Squares[row][col].add(new JLabel(""));
				Squares[row][col].add(new JLabel(""));
				Squares[row][col].add(new JLabel(""));
				Squares[row][col].add(Pieces[row][col]);
				Squares[row][col].add(new JLabel(""));
				Squares[row][col].add(new JLabel(""));
				Squares[row][col].add(Spaces[row][col]);
				Squares[row][col].add(new JLabel(""));
				board.add(Squares[row][col]);
			}
		}
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Spaces[row][col].setFont(f);
			}
		}
		Pieces[0][0].setIcon(BR);
		Spaces[0][0].setText("BR");
		Pieces[0][1].setIcon(BN);
		Spaces[0][1].setText("BN");
		Pieces[0][2].setIcon(BB);
		Spaces[0][2].setText("BB");
		Pieces[0][3].setIcon(BQ);
		Spaces[0][3].setText("BQ");
		Pieces[0][4].setIcon(BK);
		Spaces[0][4].setText("BK");
		Pieces[0][5].setIcon(BB);
		Spaces[0][5].setText("BB");
		Pieces[0][6].setIcon(BN);
		Spaces[0][6].setText("BN");
		Pieces[0][7].setIcon(BR);
		Spaces[0][7].setText("BR");
		for (int col = 0; col < 8; col++) {
			Pieces[1][col].setIcon(BP);
			Spaces[1][col].setText("BP");
		}
		for (int col = 0; col < 8; col++) {
			Pieces[6][col].setIcon(WP);
			Spaces[6][col].setText("WP");
		}
		Pieces[7][0].setIcon(WR);
		Spaces[7][0].setText("WR");
		Pieces[7][1].setIcon(WN);
		Spaces[7][1].setText("WN");
		Pieces[7][2].setIcon(WB);
		Spaces[7][2].setText("WB");
		Pieces[7][3].setIcon(WQ);
		Spaces[7][3].setText("WQ");
		Pieces[7][4].setIcon(WK);
		Spaces[7][4].setText("WK");
		Pieces[7][5].setIcon(WB);
		Spaces[7][5].setText("WB");
		Pieces[7][6].setIcon(WN);
		Spaces[7][6].setText("WN");
		Pieces[7][7].setIcon(WR);
		Spaces[7][7].setText("WR");
		add(board, BorderLayout.CENTER);
	}

	private class Piece implements ActionListener // Listener for Each Piece
	{
		private int myR, myC, myT;

		private boolean shown;

		public Piece(int r, int c) {
			myR = r;
			myC = c;
			if (myR < 2)
				myT = 2;
			else if (myR > 5)
				myT = 1;
			else
				myT = 0;
		}

		public void setT(int t) {
			myT = t;
		}

		public int getT() {
			return myT;
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("" + myT);
			if (move == 0) {
				if (myT == turn && turn == 1) {
					tempT = myT;
					myT = 0;
					tempR = myR;
					tempC = myC;
					tempP = Spaces[myR][myC].getText();
					Spaces[myR][myC].setText("");
					if (tempP.equals("WR")) {
						Pieces[myR][myC].setIcon(WRT);
						showR(myR, myC, tempT);
					}
					if (tempP.equals("WN")) {
						Pieces[myR][myC].setIcon(WNT);
						showN(myR, myC, tempT);
					}
					if (tempP.equals("WB")) {
						Pieces[myR][myC].setIcon(WBT);
						showB(myR, myC, tempT);
					}
					if (tempP.equals("WK")) {
						Pieces[myR][myC].setIcon(WKT);
						showK(myR, myC, tempT);
					}
					if (tempP.equals("WQ")) {
						Pieces[myR][myC].setIcon(WQT);
						showQ(myR, myC, tempT);
					}
					if (tempP.equals("WP")) {
						Pieces[myR][myC].setIcon(WPT);
						showP(myR, myC, tempT);
					}
					move = 1;
				} else if (myT == turn && turn == 2) {
					tempT = myT;
					myT = 0;
					tempR = myR;
					tempC = myC;
					tempP = Spaces[myR][myC].getText();
					Spaces[myR][myC].setText("");
					if (tempP.equals("BR")) {
						Pieces[myR][myC].setIcon(BRT);
						showR(myR, myC, tempT);
					}
					if (tempP.equals("BN")) {
						Pieces[myR][myC].setIcon(BNT);
						showN(myR, myC, tempT);
					}
					if (tempP.equals("BB")) {
						Pieces[myR][myC].setIcon(BBT);
						showB(myR, myC, tempT);
					}
					if (tempP.equals("BK")) {
						Pieces[myR][myC].setIcon(BKT);
						showK(myR, myC, tempT);
					}
					if (tempP.equals("BQ")) {
						Pieces[myR][myC].setIcon(BQT);
						showQ(myR, myC, tempT);
					}
					if (tempP.equals("BP")) {
						Pieces[myR][myC].setIcon(BPT);
						showP(myR, myC, tempT);
					}
					move = 1;
				}
			} else if (move == 1 && shown) {
				if (tempT == 1) {
					w = Spaces[myR][myC].getText();
					myT = tempT;
					hide();
					Spaces[myR][myC].setText(tempP);
					if (tempP.equals("WR")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(WR);
					}
					if (tempP.equals("WN")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(WN);
					}
					if (tempP.equals("WB")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(WB);
					}
					if (tempP.equals("WK")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(WK);
					}
					if (tempP.equals("WQ")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(WQ);
					}
					if (tempP.equals("WP") && !w.equals("BK")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(WP);
						if (myR == 0) {
							score.pause();
							String s = JOptionPane
									.showInputDialog("What Piece?\nQ---Queen\nR---Rook\nN---Knight\nB---Bishop");
							if (s.equalsIgnoreCase("Q")) {
								Pieces[myR][myC].setIcon(WQ);
								Spaces[myR][myC].setText("WQ");
							}
							if (s.equalsIgnoreCase("R")) {
								Pieces[myR][myC].setIcon(WR);
								Spaces[myR][myC].setText("WR");
							}
							if (s.equalsIgnoreCase("N")) {
								Pieces[myR][myC].setIcon(WN);
								Spaces[myR][myC].setText("WN");
							}
							if (s.equalsIgnoreCase("B")) {
								Pieces[myR][myC].setIcon(WB);
								Spaces[myR][myC].setText("WB");
							}
						}
					}
					if (myR == tempR && myC == tempC) {
						move = 0;
						turn = 1;
					} else {
						move = 0;
						turn = 2;
						score.color();
						if (timer) {
							score.timer2();
						}
						if (w.equals("BK")) {
							score.update1();
							reset();
						}
					}
				}

				else if (tempT == 2) {
					w = Spaces[myR][myC].getText();
					myT = tempT;
					hide();
					Spaces[myR][myC].setText(tempP);
					if (tempP.equals("BR")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(BR);
					}
					if (tempP.equals("BN")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(BN);
					}
					if (tempP.equals("BB")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(BB);
					}
					if (tempP.equals("BK")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(BK);
					}
					if (tempP.equals("BQ")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(BQ);
					}
					if (tempP.equals("BP")) {
						Pieces[tempR][tempC].setIcon(n);
						Pieces[myR][myC].setIcon(BP);
						if (myR == 7 && !w.equals("WK")) {
							score.pause();
							String s = JOptionPane
									.showInputDialog("Bhat Piece?\nQ---Queen\nR---Rook\nN---Knight\nB---Bishop");
							if (s.equalsIgnoreCase("Q")) {
								Pieces[myR][myC].setIcon(BQ);
								Spaces[myR][myC].setText("BQ");
							}
							if (s.equalsIgnoreCase("R")) {
								Pieces[myR][myC].setIcon(BR);
								Spaces[myR][myC].setText("BR");
							}
							if (s.equalsIgnoreCase("N")) {
								Pieces[myR][myC].setIcon(BN);
								Spaces[myR][myC].setText("BN");
							}
							if (s.equalsIgnoreCase("B")) {
								Pieces[myR][myC].setIcon(BB);
								Spaces[myR][myC].setText("BB");
							}
						}
					}
					if (myR == tempR && myC == tempC) {
						move = 0;
						turn = 2;
					} else {
						move = 0;
						turn = 1;
						score.color();
						if (timer) {
							score.timer1();
						}
						if (w.equals("WK")) {
							score.update2();
							reset();
						}
					}
				}
			}
		}

		public void setShown(boolean b) {
			shown = b;
		}
	}

	private class timer1 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (t1 == 0) {
				score.pause();
				int reply = JOptionPane.showConfirmDialog(null, "Play Again?", "Black Wins!",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					score.update2();
					reset();
					score.reset1();
				} else {
					System.exit(0);
				}
			}
			t1--;
		}

	}

	private class timer2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (t2 == 0) {
				score.pause();
				int reply = JOptionPane.showConfirmDialog(null, "Play Again?", "White Wins!",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					score.update1();
					reset();
					score.reset2();
				} else {
					System.exit(0);
				}
			}
			t2--;
		}

	}

	public void reset() {
		turn = 1;
		move = 0;
		t1 = time + 1;
		t2 = time;
		score.reset1();
		score.reset2();
		if (timer) {
			score.timer1();
		}
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Spaces[row][col].setText("");
			}
		}
		Pieces[0][0].setIcon(BR);
		Spaces[0][0].setText("BR");
		Pieces[0][1].setIcon(BN);
		Spaces[0][1].setText("BN");
		Pieces[0][2].setIcon(BB);
		Spaces[0][2].setText("BB");
		Pieces[0][3].setIcon(BQ);
		Spaces[0][3].setText("BQ");
		Pieces[0][4].setIcon(BK);
		Spaces[0][4].setText("BK");
		Pieces[0][5].setIcon(BB);
		Spaces[0][5].setText("BB");
		Pieces[0][6].setIcon(BN);
		Spaces[0][6].setText("BN");
		Pieces[0][7].setIcon(BR);
		Spaces[0][7].setText("BR");
		for (int col = 0; col < 8; col++) {
			Pieces[1][col].setIcon(BP);
			Spaces[1][col].setText("BP");
		}
		for (int col = 0; col < 8; col++) {
			Pieces[6][col].setIcon(WP);
			Spaces[6][col].setText("WP");
		}
		Pieces[7][0].setIcon(WR);
		Spaces[7][0].setText("WR");
		Pieces[7][1].setIcon(WN);
		Spaces[7][1].setText("WN");
		Pieces[7][2].setIcon(WB);
		Spaces[7][2].setText("WB");
		Pieces[7][3].setIcon(WQ);
		Spaces[7][3].setText("WQ");
		Pieces[7][4].setIcon(WK);
		Spaces[7][4].setText("WK");
		Pieces[7][5].setIcon(WB);
		Spaces[7][5].setText("WB");
		Pieces[7][6].setIcon(WN);
		Spaces[7][6].setText("WN");
		Pieces[7][7].setIcon(WR);
		Spaces[7][7].setText("WR");

		for (int row = 2; row < 6; row++) {
			for (int col = 0; col < 8; col++) {
				Spaces[row][col].setText("");
				Pieces[row][col].setIcon(n);
				Action[row][col].setT(0);
			}
		}
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < 8; col++) {
				Action[row][col].setT(2);
			}
		}
		for (int row = 6; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				Action[row][col].setT(1);
			}
		}
	}

	public void show(int r, int c) {
		if (indicator) {
			Pieces[r][c].setOpaque(true);
			Pieces[r][c].setBackground(new Color(0, 224, 0));
			Action[r][c].setShown(true);
		} else {
			Action[r][c].setShown(true);
		}
	}

	public void hide() {
		for (int r = 0; r < 8; r++) {
			for (int c = 0; c < 8; c++) {
				if (Action[r][c].shown == true) {
					Action[r][c].setShown(false);
					if ((r + c) % 2 == 0) {
						Squares[r][c].setBackground(board1);
						Pieces[r][c].setBackground(board1);
					} else {
						Squares[r][c].setBackground(board2);
						Pieces[r][c].setBackground(board2);
					}
				}
			}
		}
	}

	public void showR(int r, int c, int t) {
		for (int row = r; row < 8; row++) {
			if (Action[row][c].getT() == 0) {
				show(row, c);
			} else if (Action[row][c].getT() != t) {
				show(row, c);
				break;
			} else if (Action[row][c].getT() == t) {
				break;
			}
		}
		for (int row = r; row >= 0; row--) {
			if (Action[row][c].getT() == 0) {
				show(row, c);
			} else if (Action[row][c].getT() != t) {
				show(row, c);
				break;
			} else if (Action[row][c].getT() == t) {
				break;
			}
		}
		for (int col = c; col < 8; col++) {
			if (Action[r][col].getT() == 0) {
				show(r, col);
			} else if (Action[r][col].getT() != t) {
				show(r, col);
				break;
			} else if (Action[r][col].getT() == t) {
				break;
			}
		}
		for (int col = c; col >= 0; col--) {
			if (Action[r][col].getT() == 0) {
				show(r, col);
			} else if (Action[r][col].getT() != t) {
				show(r, col);
				break;
			} else if (Action[r][col].getT() == t) {
				break;
			}
		}
	}

	public void showN(int r, int c, int t) {
		Action[r][c].setShown(true);
		try {
			if (Action[r + 1][c + 2].getT() != t)
				show(r + 1, c + 2);
		} catch (Exception e) {
		}
		try {
			if (Action[r + 2][c + 1].getT() != t)
				show(r + 2, c + 1);
		} catch (Exception e) {
		}
		try {
			if (Action[r + 2][c - 1].getT() != t)
				show(r + 2, c - 1);
		} catch (Exception e) {
		}
		try {
			if (Action[r + 1][c - 2].getT() != t)
				show(r + 1, c - 2);
		} catch (Exception e) {
		}
		try {
			if (Action[r - 1][c - 2].getT() != t)
				show(r - 1, c - 2);
		} catch (Exception e) {
		}
		try {
			if (Action[r - 2][c - 1].getT() != t)
				show(r - 2, c - 1);
		} catch (Exception e) {
		}
		try {
			if (Action[r - 2][c + 1].getT() != t)
				show(r - 2, c + 1);
		} catch (Exception e) {
		}
		try {
			if (Action[r - 1][c + 2].getT() != t)
				show(r - 1, c + 2);
		} catch (Exception e) {
		}
	}

	public void showB(int r, int c, int t) {
		int col = c;
		for (int row = r; row < 8; row++) {
			if (Action[row][col].getT() == 0) {
				show(row, col);
			} else if (Action[row][col].getT() != t) {
				show(row, col);
				break;
			} else if (Action[row][col].getT() == t) {
				break;
			}
			col++;
			if (col > 7) {
				break;
			}
		}
		col = c;
		for (int row = r; row < 8; row++) {
			if (Action[row][col].getT() == 0) {
				show(row, col);
			} else if (Action[row][col].getT() != t) {
				show(row, col);
				break;
			} else if (Action[row][col].getT() == t) {
				break;
			}
			col--;
			if (col < 0) {
				break;
			}
		}
		col = c;
		for (int row = r; row >= 0; row--) {
			if (Action[row][col].getT() == 0) {
				show(row, col);
			} else if (Action[row][col].getT() != t) {
				show(row, col);
				break;
			} else if (Action[row][col].getT() == t) {
				break;
			}
			col--;
			if (col < 0) {
				break;
			}
		}
		col = c;
		for (int row = r; row >= 0; row--) {
			if (Action[row][col].getT() == 0) {
				show(row, col);
			} else if (Action[row][col].getT() != t) {
				show(row, col);
				break;
			} else if (Action[row][col].getT() == t) {
				break;
			}
			col++;
			if (col > 7) {
				break;
			}
		}
	}

	public void showK(int r, int c, int t) {
		Action[r][c].setShown(true);
		try {
			if (Action[r - 1][c].getT() != t) {
				show(r - 1, c);
			}
		} catch (Exception e) {
		}
		try {
			if (Action[r - 1][c + 1].getT() != t) {
				show(r - 1, c + 1);
			}
		} catch (Exception e) {
		}
		try {
			if (Action[r][c + 1].getT() != t) {
				show(r, c + 1);
			}
		} catch (Exception e) {
		}
		try {
			if (Action[r + 1][c + 1].getT() != t) {
				show(r + 1, c + 1);
			}
		} catch (Exception e) {
		}
		try {
			if (Action[r + 1][c].getT() != t) {
				show(r + 1, c);
			}
		} catch (Exception e) {
		}
		try {
			if (Action[r + 1][c - 1].getT() != t) {
				show(r + 1, c - 1);
			}
		} catch (Exception e) {
		}
		try {
			if (Action[r][c - 1].getT() != t) {
				show(r, c - 1);
			}
		} catch (Exception e) {

		}
		try {

			if (Action[r - 1][c - 1].getT() != t) {
				show(r - 1, c - 1);
			}
		} catch (Exception e) {
		}
	}

	public void showQ(int r, int c, int t) {
		showR(r, c, t);
		showB(r, c, t);
	}

	public void showP(int r, int c, int t) {
		Action[r][c].setShown(true);
		if (t == 1) {
			if (Action[r - 1][c].getT() == 0) {
				show(r - 1, c);
				if (r == 6 && Action[r - 2][c].getT() == 0) {
					show(r - 2, c);
				}
			}
		}
		if (t == 2) {
			if (Action[r + 1][c].getT() == 0) {
				show(r + 1, c);
				if (r == 1 && Action[r + 2][c].getT() == 0) {
					show(r + 2, c);
				}
			}
		}
		try {
			if (t == 1 && Action[r - 1][c - 1].getT() == 2) {
				show(r - 1, c - 1);
			}
		} catch (Exception e) {
		}
		try {
			if (t == 1 && Action[r - 1][c + 1].getT() == 2) {
				show(r - 1, c + 1);
			}
		} catch (Exception e) {
		}
		try {
			if (t == 2 && Action[r + 1][c - 1].getT() == 1) {
				show(r + 1, c - 1);
			}
		} catch (Exception e) {
		}
		try {
			if (t == 2 && Action[r + 1][c + 1].getT() == 1) {
				show(r + 1, c + 1);
			}
		} catch (Exception e) {
		}
	}

}
