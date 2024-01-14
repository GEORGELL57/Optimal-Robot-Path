import java.io.File;
import java.util.Scanner;

/*
 * The class AStarEuclidian finds the shortest path of the robot according to the euclidian distance
 * 
 * @since 14/01/2024
 * @author Giorgio Gregoriou
 *
 */
public class AStarEuclidian {
	public static void main(String[] args) throws Exception {
		// pass the path to the file as a parameter
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		Scanner sc2 = new Scanner(file);

		//array of the grid
		int arr[][] = null;
		int counter = 0, counter2 = 0, x = 0, y = 0;
		Coordinates c = null, cs = null, ce = null;

		//count the file lines
		while (sc.hasNextLine()) {
			counter++;
			sc.nextLine();
		}

		sc.close();

		System.out.println("Start scan");

		while (sc2.hasNextLine()) {
			//create array
			if (counter2 == 0) {
				x = sc2.nextInt();
				y = sc2.nextInt();
				c = new Coordinates(x, y);
				arr = new int[x][y];
				System.out.println("X is: " + c.getX());
				System.out.println("Y is: " + c.getY());
			} //initialize the robot's starting coordinates 
				else if (counter2 == (counter - 2)) {
				x = sc2.nextInt();
				y = sc2.nextInt();
				cs = new Coordinates(x, y);
				System.out.println("X start is: " + cs.getX());
				System.out.println("Y start is: " + cs.getY());
			} //initialize the robot's ending coordinates, the final destination
			else if (counter2 == (counter - 1)) {
				x = sc2.nextInt();
				y = sc2.nextInt();
				ce = new Coordinates(x, y);
				System.out.println("X end is: " + ce.getX());
				System.out.println("Y end is: " + ce.getY());
			} //determine which cells have bombs
			else if (counter2 < counter) {
				String s = sc2.next();
				for (int i = 0; i < c.getY(); i++) {
					arr[counter2 - 1][i] = s.charAt(i) - '0';
					System.out.print(arr[counter2 - 1][i]);
				}
				System.out.println("");
			}
			//counter of file lines
			counter2++;
		}

	}

}
