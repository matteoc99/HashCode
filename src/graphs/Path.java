package graphs;

import java.util.ArrayList;

/**
 * @author Matteo Cosi
 * @since 15.12.2017
 */
public class Path {

    /**
     * contains the ids of all the nodes contained in this path
     */
    ArrayList<Node> nodes;


    /**
     * progress index on the street intersection
     */
    private int progress;


    /**
     * sets the defaults
     */
    public Path() {
        progress = 0;
        nodes= new ArrayList<>();
    }


    /**
     * returns the next Node id on this Path that we want to reach
     *
     * @return the next nOde
     */
    public Node getGoal() {
        if (progress >= nodes.size())
            return null;
        return nodes.get(progress);
    }


    /**
     * returns the next Node id on this Path that we want to reach
     * also increments the progress on this path
     *
     * @return the next node
     */
    public Node getGoalAndIncrement() {
        if (progress >= nodes.size()) {
            return null;
        }
        Node ret = nodes.get(progress);
        progress++;
        return ret;
    }

    public Node getFrom() {
        return nodes.get(0);
    }

    public Node getTo() {
        return nodes.get(nodes.size() - 1);
    }

    /**
     * Adds a Street intersection
     *
     * @return true if it was successfully added, otherwise false
     */
    public void addNodeIdAtIndex(Node node, int index) {
        if (!contains(node)) {
            nodes.add(index, node);
        } else {
            throw new RuntimeException("Path 45");
        }
    }


    public void addNodeId(Node node) {
        if (!contains(node)) {
            nodes.add(node);
        } else {
            throw new RuntimeException("Path 45");
        }
    }

    /**
     * Removes a Street intersection
     *
     * @return true if it was successfully removed, otherwise false
     */
    public void removeNode(Node node) {
        if (contains(node)) {
            nodes.remove(node);
        } else {
            throw new RuntimeException("Path");
        }
    }

    /**
     * Checks if this city contains a certain Street Intersection
     *
     * @return true if it contains the intersection, otherwise false
     */
    public boolean contains(Node node) {
        for (Node node1: nodes) {
            if (node.equals(node1))
                return true;
        }
        return false;
    }

    public boolean isValid() {
        if (nodes.size() >= 3) {
            return true;
        }
        return false;
    }

    public int getProgress() {
        return progress;
    }


    /**
     * resets the progress to zero
     */
    public void resetProgress() {
        progress = 0;
    }

    /**
     * checks if this path equals to another path
     *
     * @param path the path to check
     * @return true if the paths equal each other, otherwise false
     */
    public boolean equals(Path path) {
        if (path.nodes.size() != this.nodes.size())
            return false;
        for (int i = 0; i < nodes.size(); i++) {
            if (path.nodes.get(i).getIndex()!=this.nodes.get(i).getIndex())
                return false;
        }
        return true;
    }
}
