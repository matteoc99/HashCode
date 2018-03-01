package graphs;

import java.util.ArrayList;

/**
 * A Graph is a kind of Network with {@link Node} connected by {@link Arc} witch
 * can be traveled on. TODO DIJKSTRA TRAVELING SM and many other algorithms
 * 
 * @author Matteo Cosi
 * @since 20.04.2017
 */
public class Graph {
	/**
	 * {@link ArrayList} with all the nodes in the Graph
	 */
	public ArrayList<Node> nodes = new ArrayList<>();
	/**
	 * {@link ArrayList} with all the arcs in the Graph
	 */
	public ArrayList<Arc> arcs = new ArrayList<>();

	public Path doTravelinSM(int fromIndex) {
		Path ret = new Path();
		// TODO
		return ret;
	}

	public Path doDijkstra(int fromIndex, int toIndex) {
		Path ret = new Path();
		
		//cost at index 0 eltern at index 1
		double[][] cost = new double[2][nodes.size()];
		ArrayList<Node>visited= new ArrayList<>();
		for (int i = 0; i < cost[0].length; i++) {
			cost[0][i]=Integer.MAX_VALUE;
		}
		cost[0][fromIndex]=0;
		
		while (visited.size()<nodes.size()) {
			//search lowest cost
			int lowIndex=-1;
			double lowcost=Integer.MAX_VALUE;
			for (int i = 0; i < cost[0].length; i++) {
				if(cost[0][i]<=lowcost&&!contains(visited,i)){
					lowIndex=i;
					lowcost= cost[0][i];
				}
			}	
			
			Node n=nodes.get(lowIndex);
			visited.add(n);
			for (int i = 0; i < n.connections.size() ; i++) {
				Arc a= n.connections.get(i);
				Node to = n.connections.get(i).to;
				if(cost[0][to.index]>a.weight+cost[0][n.index]){
					cost[0][to.index]=a.weight+cost[0][n.index];
					cost[1][to.index]=n.index;
				}
			}
		}
		boolean done=false;
		int currIndex=toIndex;
		while (!done) {
			
			ret.nodes.add(nodes.get(currIndex));
			if(currIndex==fromIndex){
			 done=true;	
			}else{
				currIndex=(int) cost[1][currIndex];
			}
		}
		return ret;
	}

	private boolean contains(ArrayList<Node> visited, int i) {
		boolean ret = false;
		for (int j = 0; j < visited.size(); j++) {
			if (visited.get(j).index == i)
				ret = true;
		}
		return ret;
	}

	public Path doDFS(int fromIndex, int toIndex) {
		Path ret = new Path();

		return ret;
	}

	public Path doBFS(int fromIndex, int toIndex) {
		Path ret = new Path();
		// TODO
		return ret;
	}
}
