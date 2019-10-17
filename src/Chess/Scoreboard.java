package Chess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Scoreboard extends JPanel {
	private static final long serialVersionUID = 1L;
	private boolean count, clock;
	private JLabel label1, label2;
	private int s1, s2, p;
	private int t1, t2, constant;
	private Timer timer1, timer2;
	private Font f;
	private DecimalFormat time;

	public Scoreboard(boolean cl, boolean co, double t, ActionListener a, ActionListener b) {
		clock = cl;
		count = co;
		setLayout(new GridLayout(1, 2));
		setBackground(Color.BLACK);
		f = new Font("Arial Black", Font.PLAIN, 20);
		if (cl) {
			time = new DecimalFormat("00");
			t1 = (int) t;
			t2 = (int) t;
			constant = (int) t;
			timer1 = new Timer(1000, new timerListener1());
			timer1.addActionListener(a);
			timer1.start();
			timer2 = new Timer(1000, new timerListener2());
			timer2.addActionListener(b);
		}
		label1 = new JLabel();
		label2 = new JLabel();
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setHorizontalAlignment(SwingConstants.CENTER);

		label1.setBackground(Color.YELLOW.brighter());
		label2.setBackground(new Color(238, 238, 238));
		label1.setOpaque(true);
		label2.setOpaque(true);

		int m = t1 / 60;
		int s = t1 % 60;
		if (cl && co) {
			label1.setText(
					"<html>WHITE: " + s1 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText(
					"<html>BLACK: " + s2 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (cl && !co) {
			label1.setText("<html>WHITE<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText("<html>BLACK<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (!cl && co) {
			label1.setText("<html>WHITE: " + s1);
			label2.setText("<html>BLACK: " + s2);
		} else {
			label1.setText("<html>WHITE");
			label2.setText("<html>BLACK");
		}
		label1.setFont(f);
		label2.setFont(f);

		add(label1);
		add(label2);
		p = 1;
	}

	public class timerListener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			t1--;
			int m = t1 / 60;
			int s = t1 % 60;
			if (clock && count) {
				label1.setText("<html>WHITE: " + s1 + "<br><center>" + time.format(m) + ":" + time.format(s)
						+ "</center></html>");
			} else if (clock && !count) {
				label1.setText("<html>WHITE<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			}
		}
	}

	public class timerListener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			t2--;
			int m = t2 / 60;
			int s = t2 % 60;
			if (clock && count) {
				label2.setText("<html>BLACK: " + s1 + "<br><center>" + time.format(m) + ":" + time.format(s)
						+ "</center></html>");
			} else if (clock && !count) {
				label2.setText("<html>BLACK<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			}
		}
	}

	public void timer1() {
		timer2.stop();
		timer1.start();
	}

	public void timer2() {
		timer1.stop();
		timer2.start();
	}

	public void pause() {
		if(clock){
		timer1.stop();
		timer2.stop();
		}
	}

	public void update1() {
		s1++;
		if (clock && count) {
			int m = t2 / 60;
			int s = t2 % 60;
			label1.setText(
					"<html>WHITE: " + s1 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText(
					"<html>BLACK: " + s2 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (clock && !count) {
			int m = t2 / 60;
			int s = t2 % 60;
			label1.setText("<html>WHITE<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText("<html>BLACK<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (!clock && count) {
			label1.setText("<html>WHITE: " + s1);
			label2.setText("<html>BLACK: " + s2);
		} else {
			label1.setText("<html>WHITE");
			label2.setText("<html>BLACK");
		}
	}

	public void update2() {
		s2++;
		if (clock && count) {
			int m = t1 / 60;
			int s = t1 % 60;
			label1.setText(
					"<html>WHITE: " + s1 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText(
					"<html>BLACK: " + s2 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (clock && !count) {
			int m = t1 / 60;
			int s = t1 % 60;
			label1.setText("<html>WHITE<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText("<html>BLACK<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (!clock && count) {
			label1.setText("<html>WHITE: " + s1);
			label2.setText("<html>BLACK: " + s2);
		} else {
			label1.setText("<html>WHITE");
			label2.setText("<html>BLACK");
		}
	}

	public void color() {
		p++;
		if (p % 2 == 1) {
			label1.setBackground(Color.YELLOW.brighter());
			label2.setBackground(new Color(238, 238, 238));
		} else {
			label1.setBackground(new Color(238, 238, 238));
			label2.setBackground(Color.YELLOW.brighter());
		}
	}

	public void reset1() {
		t1 = constant + 1;
		t2 = constant;
		label1.setBackground(Color.YELLOW.brighter());
		label2.setBackground(new Color(238, 238, 238));
		if (clock && count) {
			int m = t2 / 60;
			int s = t2 % 60;
			label1.setText(
					"<html>WHITE: " + s1 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText(
					"<html>BLACK: " + s2 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (clock && !count) {
			int m = t2 / 60;
			int s = t2 % 60;
			label1.setText("<html>WHITE<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText("<html>BLACK<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (!clock && count) {
			label1.setText("<html>WHITE: " + s1);
			label2.setText("<html>BLACK: " + s2);
		} else {
			label1.setText("<html>WHITE");
			label2.setText("<html>BLACK");
		}
		p = 1;
	}

	public void reset2() {
		t1 = constant;
		t2 = constant + 1;
		label1.setBackground(Color.YELLOW.brighter());
		label2.setBackground(new Color(238, 238, 238));
		if (clock && count) {
			int m = t1 / 60;
			int s = t1 % 60;
			label1.setText(
					"<html>WHITE: " + s1 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText(
					"<html>BLACK: " + s2 + "<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (clock && !count) {
			int m = t1 / 60;
			int s = t1 % 60;
			label1.setText("<html>WHITE<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
			label2.setText("<html>BLACK<br><center>" + time.format(m) + ":" + time.format(s) + "</center></html>");
		} else if (!clock && count) {
			label1.setText("<html>WHITE: " + s1);
			label2.setText("<html>BLACK: " + s2);
		} else {
			label1.setText("<html>WHITE");
			label2.setText("<html>BLACK");
		}
		p = 1;
	}
}