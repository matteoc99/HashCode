package graphs;

import java.util.ArrayList;

/**
 * Nodes are connected with {@link Arc} to each other and form so a Network of
 * Nodes. They can be interpreted as cities, locations or anything else.
 * 
 * @author Matteo Cosi
 * @since 21.04.2016
 */
public class Node {

	/**
	 * {@link Arc} {@link ArrayList} with connection to other {@link Node}
	 */
	ArrayList<Arc> connections = new ArrayList<>();
	/**
	 * global index for auto increment every time a node is created
	 */
	private static int gIndex = 0;

	/**
	 * for identification purposes
	 */
	public int index;


	/**
	 * helpful for drawing
	 */
	public int x,y;

	/**
	 * Tells if the node is a wall
	 */
	public boolean isWall;
	/**
	 * Tells if the node is a GrowPoint
	 */
	public boolean isGrow;


	/**
	 * wether to lock this node or not
	 */
	public boolean toLock=true;
	/**
	 * reference in the table
	 */
	public int i,j;

	/**
	 * constructor for a {@link Node} with a auto incrementing index
	 */
	public Node() {
		this.index = gIndex;
		gIndex++;
	}

	/**
	 * constructor for a {@link Node} with a auto incrementing index with adds
	 * automatically an {@link Arc}
	 * 
	 * @param arc the {@link Arc} to add
	 */
	public Node(Arc arc) {
		this.index = gIndex;
		gIndex++;
		connections.add(arc);
	}

	/**
	 * get the {@link ArrayList} with all the {@link Arc} to the other Nodes
	 * 
	 * @return all the {@link Arc} to the other Nodes
	 */
	public ArrayList<Arc> getConnections() {
		return connections;
	}

	/**
	 * Add a new {@link Arc} to the current connections
	 * 
	 * @param arc
	 *            the {@link Arc} to add
	 */
	public void addConnection(Arc arc) {
		this.connections.add(arc);
	}

	/**
	 * get the index of the current {@link Node}
	 * 
	 * @return the index of the current {@link Node}
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * set the index for the current {@link Node}
	 * 
	 * @param index
	 *            the index of the current {@link Node} that needs to be set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Get The Arc from all the connections, that leads to a Node with the index index
	 * @param index index for the node where the Arc ends
	 * @return the Arc that leads to that node<br>
	 * 			null if the Arc does not exist
	 */

	public Arc getArcTo(int index){
		Arc ret=null;
		for (int i = 0; i < connections.size(); i++) {
			if(connections.get(i).to.index==index)
				ret= connections.get(i);
		}
		return ret;
	}
}
