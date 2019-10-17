package Chess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class StartPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel title, sTitle, sTimer, sLength, sIndicator, author, scoreTrack;
	private JButton play, settings, sUp, sDown;
	private JPanel buttons, sPanel, sButtons, sUD, sLR, header;
	private JTextField sTime;
	private JFrame topFrame;
	private Font titleFont, buttonFont, sFont;
	private Color randColL, randColB, randColT, randColX;
	private JCheckBox timer, indicator, tracking;
	private boolean clock, show, score;
	private double clockTime;
	private DecimalFormat time;
	private int min, sec;

	public StartPanel() {
		clockTime = 600;
		time = new DecimalFormat("00");
		setLayout(new BorderLayout());
		do {
			randColL = new Color((int) (Math.random() * 128), (int) (Math.random() * 128), (int) (Math.random() * 128));
		} while (Math.abs(Color.GRAY.getRed() - randColL.getRed()) < 100
				|| Math.abs(Color.GRAY.getBlue() - randColL.getBlue()) < 100
				|| Math.abs(Color.GRAY.getGreen() - randColL.getGreen()) < 100);
		do {
			randColB = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
		} while (Math.abs(randColL.getRed() - randColB.getRed()) < 100
				|| Math.abs(randColL.getBlue() - randColB.getBlue()) < 100
				|| Math.abs(randColL.getGreen() - randColB.getGreen()) < 100);
		do {
			randColT = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
		} while (Math.abs(randColL.getRed() - randColT.getRed()) < 100
				|| Math.abs(randColL.getBlue() - randColT.getBlue()) < 100
				|| Math.abs(randColL.getGreen() - randColT.getGreen()) < 100);
		do {
			randColX = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
		} while (Math.abs(randColL.getRed() - randColX.getRed()) < 100
				|| Math.abs(randColL.getBlue() - randColX.getBlue()) < 100
				|| Math.abs(randColL.getGreen() - randColX.getGreen()) < 100
				|| Math.abs(Color.GRAY.getRed() - randColL.getRed()) < 100
				|| Math.abs(Color.GRAY.getBlue() - randColL.getBlue()) < 100
				|| Math.abs(Color.GRAY.getGreen() - randColL.getGreen()) < 100);
		setBackground(randColL);
		titleFont = new Font("Comic Sans", Font.BOLD, 72);
		buttonFont = new Font("Comic Sans", Font.PLAIN, 48);
		sFont = new Font("Comic Sans", Font.PLAIN, 24);
		header = new JPanel();
		header.setLayout(new GridLayout(2, 1, -100, -250));
		header.setBackground(randColL);
		title = new JLabel("CHESS");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(titleFont);
		title.setForeground(randColT);
		header.add(title);
		author = new JLabel("<html><center>Made by: Jack Liu<br>Summer 2016</center></html>");
		author.setHorizontalAlignment(SwingConstants.CENTER);
		author.setFont(new Font("Comic Sans", Font.BOLD, 32));
		author.setForeground(randColT);
		header.add(author);
		add(header);
		buttons = new JPanel();
		play = new JButton("Play");
		play.setFont(buttonFont);
		play.setBorderPainted(false);
		play.setFocusPainted(false);
		play.addActionListener(new Play());
		play.setForeground(randColB);
		play.setBackground(randColL);
		settings = new JButton("Settings");
		settings.setFont(buttonFont);
		settings.setBorderPainted(false);
		settings.setFocusPainted(false);
		settings.addActionListener(new Settings());
		settings.setForeground(randColB);
		settings.setBackground(randColL);
		buttons.add(play);
		buttons.add(settings);
		buttons.setBackground(randColL);
		add(buttons, BorderLayout.SOUTH);
		sPanel = new JPanel();
		sPanel.setLayout(new BorderLayout());
		sPanel.setBackground(randColL);
		sTitle = new JLabel("Settings");
		sTitle.setForeground(randColT);
		sTitle.setFont(titleFont);
		sTitle.setHorizontalAlignment(SwingConstants.CENTER);
		sPanel.add(sTitle, BorderLayout.NORTH);
		sButtons = new JPanel();
		sButtons.setLayout(new GridLayout(4, 2, 0, 0));
		sButtons.setBackground(randColL);
		sTimer = makeLabel(sTimer, "  Clock (Off)");
		sButtons.add(sTimer);
		sButtons.add(timer = new JCheckBox());
		timer.setBackground(randColL);
		timer.addItemListener(new Timer());
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		sLength = makeLabel(sLength, "  Time");
		sLength.setForeground(Color.GRAY);
		sButtons.add(sLength);
		sLR = new JPanel();
		sLR.setLayout(new GridLayout(1, 2));
		sLR.setBackground(randColL);
		sTime = makeTextBox(sTime, "---");
		sTime.setHorizontalAlignment(SwingConstants.RIGHT);
		sTime.setForeground(Color.GRAY);
		sLR.add(sTime);
		sUD = new JPanel();
		sUD.setBackground(randColL);
		sUD.setLayout(new GridLayout(2, 1));
		sUp = makeButton(sUp, "↑");
		sUp.addActionListener(new Up());
		sDown = makeButton(sDown, "↓");
		sDown.addActionListener(new Down());
		sUD.add(sUp);
		sUD.add(sDown);
		sLR.add(sUD);
		sButtons.add(sLR);
		sIndicator = makeLabel(sIndicator, "  Movement Indicator");
		sButtons.add(sIndicator);
		sButtons.add(indicator = new JCheckBox());
		indicator.setBackground(randColL);
		indicator.addItemListener(new Indicator());
		indicator.setHorizontalAlignment(SwingConstants.CENTER);
		scoreTrack = makeLabel(scoreTrack, "  Score Tracking");
		sButtons.add(scoreTrack);
		sButtons.add(tracking = new JCheckBox());
		tracking.setBackground(randColL);
		tracking.addItemListener(new Tracking());
		tracking.setHorizontalAlignment(SwingConstants.CENTER);
		sPanel.add(sButtons, BorderLayout.CENTER);
	}

	public JLabel makeLabel(JLabel label, String s) {
		label = new JLabel(s);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setOpaque(true);
		label.setBackground(randColL);
		label.setForeground(randColX);
		label.setFont(sFont);
		return label;
	}

	public JTextField makeTextBox(JTextField text, String s) {
		text = new JTextField(s);
		text.setHorizontalAlignment(SwingConstants.LEFT);
		text.setOpaque(true);
		text.setBackground(randColL);
		text.setForeground(randColX);
		text.setFont(sFont);
		text.setEditable(false);
		text.setBorder(null);
		return text;
	}

	public JButton makeButton(JButton button, String s) {
		button = new JButton(s);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setOpaque(true);
		button.setBackground(randColL);
		button.setForeground(randColX);
		button.setFont(sFont);
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setEnabled(false);
		return button;
	}

	public void close() {
		topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		topFrame.dispose();
	}

	public class Play implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String s = sTime.getText();
				if (s.contains(":")) {
					min = Integer.parseInt(s.substring(0, s.indexOf(":")));
					sec = Integer.parseInt(s.substring(s.indexOf(":") + 1));
					clockTime = min * 60 + sec;
				} else if (s.contains(".")) {
					if (s.indexOf(".") != 0) {
						min = Integer.parseInt(s.substring(0, s.indexOf(".")));
					}
					else{
						min = 0;
					}
					sec = Integer.parseInt(s.substring(s.indexOf(".") + 1));
					if (s.charAt(s.indexOf(".") + 1) == '0') {
						clockTime = min * 60 + sec * .6;
					} else {
						clockTime = min * 60 + sec * 6;
					}
				} else {
					min = Integer.parseInt(s);
					clockTime = min * 60;
				}
			} catch (Exception x) {
				clockTime = 600;
			}
			JFrame frame = new JFrame("C H E S S");
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setSize(dim.height, dim.height);
			frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(new Chessboard(clock, clockTime, show, score));
			frame.setVisible(true);
			close();
			frame.setResizable(false);
		}

	}

	public class Settings implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(header);
			add(sPanel, BorderLayout.CENTER);
			settings.setText("Back");
			ActionListener[] temp = (settings.getActionListeners());
			for (int x = 0; x < temp.length; x++) {
				settings.removeActionListener(temp[x]);
			}
			settings.addActionListener(new Back());
			repaint();
		}

	}

	public class Back implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			remove(sPanel);
			add(header);
			settings.setText("Settings");
			ActionListener[] temp = (settings.getActionListeners());
			for (int x = 0; x < temp.length; x++) {
				settings.removeActionListener(temp[x]);
			}
			settings.addActionListener(new Settings());
			repaint();
		}

	}

	public class Up implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String s = sTime.getText();
				if (s.contains(":")) {
					min = Integer.parseInt(s.substring(0, s.indexOf(":")));
					sec = Integer.parseInt(s.substring(s.indexOf(":") + 1));
					clockTime = min * 60 + sec;
				} else if (s.contains(".")) {
					if (s.indexOf(".") != 0) {
						min = Integer.parseInt(s.substring(0, s.indexOf(".")));
					}
					else{
						min = 0;
					}
					sec = Integer.parseInt(s.substring(s.indexOf(".") + 1));
					if (s.charAt(s.indexOf(".") + 1) == '0') {
						clockTime = min * 60 + sec * .6;
					} else {
						clockTime = min * 60 + sec * 6;
					}
				} else {
					min = Integer.parseInt(s);
					clockTime = min * 60;
				}
			} catch (Exception x) {
				clockTime = 0;
			}
			clockTime += 30;
			int m = (int) (clockTime / 60);
			int s = (int) (clockTime % 60);
			sTime.setText(time.format(m) + ":" + time.format(s));
		}

	}

	public class Down implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String s = sTime.getText();
				if (s.contains(":")) {
					min = Integer.parseInt(s.substring(0, s.indexOf(":")));
					sec = Integer.parseInt(s.substring(s.indexOf(":") + 1));
					clockTime = min * 60 + sec - 30;
				} else if (s.contains(".")) {
					if (s.indexOf(".") != 0) {
						min = Integer.parseInt(s.substring(0, s.indexOf(".")));
					}
					else{
						min = 0;
					}
					sec = Integer.parseInt(s.substring(s.indexOf(".") + 1));
					if (s.charAt(s.indexOf(".") + 1) == '0') {
						clockTime = min * 60 + sec * .6;
					} else {
						clockTime = min * 60 + sec * 6;
					}
				} else {
					min = Integer.parseInt(s);
					clockTime = min * 60 - 30;
				}
				if (clockTime < 0) {
					clockTime = 0;
				}
			} catch (Exception x) {
				clockTime = 0;
			}
			int m = (int) (clockTime / 60);
			int s = (int) (clockTime % 60);
			sTime.setText(time.format(m) + ":" + time.format(s));
		}

	}

	private class Timer implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				clock = true;
				sTime.setForeground(randColX);
				sLength.setForeground(randColX);
				sUp.setEnabled(true);
				sDown.setEnabled(true);
				sTime.setEditable(true);
				int m = (int) (clockTime / 60);
				int s = (int) (clockTime % 60);
				sTime.setText(time.format(m) + ":" + time.format(s));
				sTimer.setText("  Clock (On)");
			} else {
				clock = false;
				sTime.setForeground(Color.GRAY);
				sLength.setForeground(Color.GRAY);
				sUp.setEnabled(false);
				sDown.setEnabled(false);
				try {
					String s = sTime.getText();
					if (s.contains(":")) {
						min = Integer.parseInt(s.substring(0, s.indexOf(":")));
						sec = Integer.parseInt(s.substring(s.indexOf(":") + 1));
						clockTime = min * 60 + sec;
					} else if (s.contains(".")) {
						if (s.indexOf(".") != 0) {
							min = Integer.parseInt(s.substring(0, s.indexOf(".")));
						}
						else{
							min = 0;
						}
						sec = Integer.parseInt(s.substring(s.indexOf(".") + 1));
						System.out.println(min+"   "+sec);
						if (s.charAt(s.indexOf(".") + 1) == '0') {
							clockTime = min * 60 + sec * 6/10;
							System.out.println("test");
						} else {
							clockTime = min * 60 + sec * 6;
						}
					} else {
						min = Integer.parseInt(s);
						clockTime = min * 60;
					}
				} catch (Exception x) {
					clockTime = 0;
				}
				sTime.setText("---");
				sTime.setEditable(false);
				sTimer.setText("  Clock (Off)");
			}
		}
	}

	private class Indicator implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				show = true;
			} else {
				show = false;
			}
		}
	}

	private class Tracking implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				score = true;
			} else {
				score = false;
			}
		}
	}
}
