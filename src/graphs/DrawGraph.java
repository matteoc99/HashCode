package graphs;


import javax.swing.*;
import java.awt.*;

/**
 * Display a Graph
 * @author Matteo Cosi
 * @since 20.04.2017
 */
public class DrawGraph extends JFrame {

	
	/**
	 * Make a new JFrame which displays a {@link Graph}
	 * @param graph Graph to display
	 */
	DrawPanel p;

	public DrawGraph(Graph graph) {
		setTitle("Graph:");
		setBounds(810, 10, 400, 400);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(true);
		getContentPane().setBackground(Color.white);
		Container c = getContentPane();
		c.setLayout(null);
		p = new DrawPanel(graph);
		p.setBounds(0, 0, getWidth(), getHeight());
		c.add(p);
		setVisible(true);
		p.repaint();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		p.setSize(this.getSize());
		super.paint(g);
		repaint();
	}
}
