/*
 * The class Node represents coordinates of grid that robot moves
 * 
 * @since 09/01/2024
 * @author George Ellinides
 *
 */
public class Node {
	//the node before
	private Node parent;
	private Coordinates c;
	//cost of steps
	private int g;
	//heuristic of euclidian distance
	private double h1; 
	//heuristic of manhattan distance
	private double h2;
	//total cost for euclidian distance
	private double f1;
	//total cost for manhattan distance
	private double f2;
	//counter 
	private int count = 0;
	//static counter
	static int m = 0;

	/*
	 * the constructor Node calculates the attributes according to the start coordinate, the end coordinate and the robot's coordinate
	 */
	public Node(Coordinates c, Coordinates cs, Coordinates ce, Node n) {
		this.c = new Coordinates(c);
		this.h1 = euclidianDistance(c, ce);
		this.h2 = manhattan(c, ce);
		if (m != 0)
			this.g = n.getG() + 1;
		else
			this.g = 0;
		this.f1 = this.g + this.h1;
		this.f2 = this.g + this.h2;
		this.parent = n;
		count++;
		m++;
	}
	/*
	 * the constructor Node calculates the attributes according to the node n
	 */
	public Node(Node n) {
		this.c = new Coordinates(n.getC());
		this.h1 = n.getH1();
		this.h2 = n.getH2();
		this.g = n.getG();
		this.f1 = n.getF1();
		this.f2 = n.getF2();
		this.parent = n.getParent();
	}

	/*
	 * calculation of euclidian distance
	 */
	public static double euclidianDistance(Coordinates c, Coordinates c2) {
		return (Math.sqrt(
				(c2.getX() - c.getX()) * (c2.getX() - c.getX()) + (c2.getY() - c.getY()) * (c2.getY() - c.getY())));
	}

	/*
	 * calculation of manhattan distance
	 */
	public static double manhattan(Coordinates c, Coordinates c2) {
		return (Math.abs(c2.getX() - c.getX()) + Math.abs(c2.getY() - c.getY()));
	}

	/*
	 * Getter of parent
	 */
	public Node getParent() {
		return parent;
	}

	/*
	 * Setter of parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/*
	 * Getter of c
	 */
	public Coordinates getC() {
		return c;
	}
	/*
	 * Setter of c
	 */
	public void setC(Coordinates c) {
		this.c = c;
	}
	/*
	 * Getter of f1
	 */
	public double getF1() {
		return f1;
	}
	/*
	 * Setter of f1
	 */
	public void setF1(double f1) {
		this.f1 = f1;
	}
	/*
	 * Getter of f2
	 */
	public double getF2() {
		return f2;
	}
	/*
	 * Setter of f2
	 */
	public void setF2(double f2) {
		this.f2 = f2;
	}
	/*
	 * Getter of g
	 */
	public int getG() {
		return g;
	}
	/*
	 * Setter of g
	 */
	public void setG(int g) {
		this.g = g;
	}
	/*
	 * Getter of h1
	 */
	public double getH1() {
		return h1;
	}
	/*
	 * Setter of h1
	 */
	public void setH1(double h) {
		this.h1 = h;
	}
	/*
	 * Getter of h2
	 */
	public double getH2() {
		return h2;
	}
	/*
	 * Setter of h2
	 */
	public void setH2(double h2) {
		this.h2 = h2;
	}
}
