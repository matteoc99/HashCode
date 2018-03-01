package graphs;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class DrawPanel extends JPanel {

	public Graph graph;
	Container c;

	public DrawPanel(Graph graph) {
		this.graph = graph;

		repaint();
	}

	@Override
	protected void paintComponent(Graphics gp) {
		super.paintComponent(gp);
		Graphics2D g = (Graphics2D) gp;
		int gridSize = (int) Math.ceil(Math.sqrt(graph.nodes.size()));
		int width = (getWidth() / gridSize) / 2;
		int height = ((getHeight() - 35) / gridSize) / 2;
		if (width > height)
			width = height;
		else
			height = width;
		int breiteAbst = getWidth() / gridSize - width;
		int hoeheAbst = (getHeight() - 35) / gridSize - height;

		for (int i = 0; i < graph.nodes.size(); i++) {
			if(graph.nodes.get(i).isGrow)
				g.setColor(Color.yellow);
			else if(graph.nodes.get(i).isWall)
				g.setColor(Color.black);
			else {
				if(graph.nodes.get(i).toLock)
					g.setColor(Color.blue);
				else
					g.setColor(Color.green);
			}
			g.fillOval((width + breiteAbst) * (i % gridSize) + breiteAbst / 2,
					(height + hoeheAbst) * (i / gridSize) + hoeheAbst / 2, width, height);
			g.drawString("" + graph.nodes.get(i).index, (width + breiteAbst) * (i % gridSize) + breiteAbst / 2 + 10,
					(height + hoeheAbst) * (i / gridSize) + hoeheAbst / 2);
			graph.nodes.get(i).x = (width + breiteAbst) * (i % gridSize) + breiteAbst / 2 + width / 2;
			graph.nodes.get(i).y = (height + hoeheAbst) * (i / gridSize) + hoeheAbst / 2 + height / 2;

		}
		g.setColor(Color.black);
		for (int i = 0; i < graph.arcs.size(); i++) {
			Arc a = graph.arcs.get(i);
			int x1 = a.from.x, x2 = a.to.x, y1 = a.from.y, y2 = a.to.y;
			g.drawLine(x1, y1, x2, y2);
			drawArrowHead(x1, x2, y1, y2, g);
		}
		repaint();
	}
	private void drawArrowHead(int x1,int x2,int y1,int y2,Graphics2D g2d) {  
		Polygon arrowHead = new Polygon();  
		int size= (int) (Math.sqrt(this.getWidth()*this.getHeight())/100);
		arrowHead.addPoint( 0,1*size);
		arrowHead.addPoint( -1*size, -1*size);
		arrowHead.addPoint( 1*size,-1*size);
		AffineTransform tx = new AffineTransform();

		tx.setToIdentity();
	    double angle = Math.atan2(y2-y1, x2-x1);
	    tx.translate(x2, y2);
	    tx.rotate((angle-Math.PI/2d));  

	    Graphics2D g = (Graphics2D) g2d.create();
	    g.setTransform(tx);   
	    g.fill(arrowHead);
	    g.dispose();
	}

}
