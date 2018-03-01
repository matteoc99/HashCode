package graphs;

/**
 * An Arc is the connection between two {@link Node} inside a {@link Graph}
 * 
 * @author Matteo Cosi
 * @since 20.04.2017
 */
public class Arc {
	/**
	 * {@link Node} where the {@link Arc} starts
	 */
	public Node from;
	/**
	 * {@link Node} where the {@link Arc} ends
	 */
	public Node to;
	/**
	 * weight is value or cost of the {@link Arc}
	 */
	public double weight;

	/**
	 * Constructor for an Arc which connects two {@link Node} with a weighted
	 * connection
	 * 
	 * @param from
	 *            {@link Arc#from}
	 * @param to
	 *            {@link Arc#to}
	 * @param weight
	 *            {@link Arc#weight}
	 */
	public Arc(Node from, Node to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
		if(!from.isWall&&!to.isWall)
			this.from.connections.add(this);
	}

	/**
	 * get the start {@link Node}
	 * 
	 * @return the start {@link Node}
	 */
	public Node getFrom() {
		return from;
	}

	/**
	 * sets the start {@link Node}
	 * 
	 * @param from the start {@link Node} to set
	 */
	public void setFrom(Node from) {
		this.from = from;
	}

	/**
	 * get the end {@link Node}
	 * 
	 * @return the end {@link Node}
	 */
	public Node getTo() {
		return to;
	}

	/**
	 * sets the end {@link Node}
	 * 
	 * @return to the end {@link Node} to set
	 */
	public void setTo(Node to) {
		this.to = to;
	}
	/**
	 *  get the {@link Arc#weight} of the current {@link Arc}
	 * @return the {@link Arc#weight} of the {@link Arc}
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * set the {@link Arc#weight} of the current {@link Arc}
	 * @param weight : the {@link Arc#weight} of the current {@link Arc} to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
