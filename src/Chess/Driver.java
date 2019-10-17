package Chess;

import java.awt.*;

import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		/*
		 * JFrame frame = new JFrame("C H E S S"); Dimension dim =
		 * Toolkit.getDefaultToolkit().getScreenSize();
		 * frame.setSize(dim.height,dim.height);
		 * frame.setLocation(dim.width/2-frame.getSize().width/2,
		 * dim.height/2-frame.getSize().height/2);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 */
		JFrame frame = new JFrame("C H E S S");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//frame.setResizable(false);
		frame.setSize(500,600);
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new StartPanel());
		frame.setVisible(true);
	}
}