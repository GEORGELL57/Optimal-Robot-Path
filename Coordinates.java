/*
 * The class Coordinates represents coordinates of grid that robot moves
 * 
 * @since 09/01/2024
 * @author George Ellinides
 *
 */
public class Coordinates {
	private int x;
	private int y;
	
	/*
	 * Constructor that initializes with x and y
	 */
	public Coordinates(int x,int y) {
		this.x=x;
		this.y=y;
	}
	/*
	 * Constructor that initializes with Coordinates
	 */
	public Coordinates(Coordinates c) {
		this.x=c.getX();
		this.y=c.getY();
	}
	/*
	 * Getter of x
	 */
	public int getX() {
		return x;
	}
	/*
	 * Setter of x
	 */
	public void setX(int x) {
		this.x = x;
	}
	/*
	 * Getter of y
	 */
	public int getY() {
		return y;
	}
	/*
	 * Setter of y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	
}
