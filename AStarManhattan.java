import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * The class AStarManhattan finds the shortest path of the robot according to the manhattan distance
 * 
 * @since 04/02/2024
 * @author GiuseppeGG
 *
 */
public class AStarManhattan {
	//a static variable containing the position of an element that is in the list la
	static int pos;

	/*
	/return the node that has the minimum distance from the ending node according to the manhattan distance
	*/
	public static Node findMin(List<Node> la) {
		double min=la.get(0).getF2();
		int counter=0;
		Node m = new Node(la.get(0));
		pos=0;
		for(Node n:la) {
			//System.out.println(n.getC().getX()+" "+n.getC().getY());
			if(n.getF2()<=min) {
				min=n.getF2();
				pos=counter;
				m=n;
			}
			counter++;
		}
		//System.out.println(pos);
		return m;
	}
	/*
	/find if the coordinates are in the list ld
	*/
	public static boolean findAtList(int x,int y,List<Node> ld) {
		for(Node n:ld) {
			if(n.getC().getX()==x && n.getC().getY()==y) {
				return true;
			}
		}
		return false;
	}
	
	/*
	/finding the optimal path of robot starting from the ending node using its parent nodes
	/and printing the path from starting node to ending node
	*/
	public static void printList(Node n, char[][] arr2) {
		//System.out.println(n.getC().getX()+" "+n.getC().getY());
		ArrayList<Node> p=new ArrayList<>();
		
		while(n.getParent()!=null) {
			//System.out.println(n.getParent().getC().getX()+" "+n.getParent().getC().getY());
			p.add(0,n);
			n=n.getParent();
		}
		p.add(0,n);
		System.out.print("Path:   [ ");
		for(Node m:p) {
			System.out.print("("+m.getC().getX()+","+m.getC().getY()+") ");
			arr2[m.getC().getX()][m.getC().getY()] = 'M';
		}
		System.out.print("]\n\n");
	}

	public static String printGrid(char[][] arr2, int x, int y) {
        String s = "\n  |";
        	for (int i = 0; i < x; i++) {
            		if (i <= 9)
                		s += " " + i + " |";
            		else
               	 		s += "" + i + " |";
        	}
        	s += "\n" + "--|";
        	for (int i = 0; i < y; i++) {
            		s += "---+";
        	}
        	s += "\n";
        	for (int i = 0; i < x; i++) {
            		if (i <= 9)
                		s += i + " |";
            		else
                		s += i + "|";
            	for (int j = 0; j < y; j++) {
               		s += " " + arr2[i][j] + " |";
            	}
            	s += "\n" + "--|";
            	for (int k = 0; k < y; k++) {
                	s += "---+";
            	}
            	s += "\n";
        	}
        	return s;

    	}
	
	public static void main(String[] args) throws Exception {
		// pass the path to the file as a parameter
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		Scanner sc2 = new Scanner(file);

		//array of the grid
		int arr[][] = null;
		char arr2[][] = null;
		int counter = 0, counter2 = 0, x = 0, y = 0;
		Coordinates c = null, cs = null, ce = null;

		//count the file lines
		while (sc.hasNextLine()) {
			counter++;
			sc.nextLine();
		}

		sc.close();

		System.out.println("Start scan");
		int x1 = 0, y1 = 0;
		while (sc2.hasNextLine()) {
			//create array
			if (counter2 == 0) {
				x = sc2.nextInt();
				y = sc2.nextInt();
				x1 = x;
                		y1 = y;
				c = new Coordinates(x, y);
				arr = new int[x][y];
				arr2 = new char[x][y];
                		for (int i = 0; i < x; i++) {
                    			for (int j = 0; j < y; j++) {
                       				arr2[i][j] = ' ';
                    			}
                		}
				System.out.println("X is: " + c.getX());
				System.out.println("Y is: " + c.getY());
			} //initialize the robot's starting coordinates 
				else if (counter2 == (counter - 2)) {
				x = sc2.nextInt();
				y = sc2.nextInt();
				cs = new Coordinates(x, y);
				System.out.println("X start is: " + cs.getX());
				System.out.println("Y start is: " + cs.getY());
				arr2[x][y] = 'R';
				} //initialize the robot's ending coordinates, the final destination
				else if (counter2 == (counter - 1)) {
				x = sc2.nextInt();
				y = sc2.nextInt();
				ce = new Coordinates(x, y);
				System.out.println("X end is: " + ce.getX());
				System.out.println("Y end is: " + ce.getY());
				arr2[x][y] = 'D';
                		System.out.println(printGrid(arr2, x1, y1));
			} //determine which cells have bombs
				else if (counter2 < counter) {
				String s = sc2.next();
				for (int i = 0; i < c.getY(); i++) {
					arr[counter2 - 1][i] = s.charAt(i) - '0';
					if (s.charAt(i) == '1') {
                        		arr2[counter2 - 1][i] = 'B';
                    			}
					System.out.print(arr[counter2 - 1][i]);
				}
				System.out.println("");
			}
			//counter of file lines
			counter2++;
		}
		//all the possible nodes that Ι can go to
		ArrayList<Node> la=new ArrayList<>();
		//save the nodes that I have visited
		ArrayList<Node> ld=new ArrayList<>();
		//add to arraylist la the starting node
		la.add(new Node(cs,cs,ce,null));
		//will be true if I am at the ending node
		boolean b=false;
		//a temporary variable that saves the node the robot is currently at
		Node temp = null;
		long startTime = System.currentTimeMillis();

		//while I have choices for nodes to go to and I am not at the ending node
		while(!la.isEmpty() && !b) {
			//find minimum distance from the node that I am according to the manhattan distance
			temp=findMin(la);
			//move temporarily to temp node and remove it from the list la
			ld.add(la.remove(pos));
			//delete the empty position that I create at the list la
			la.trimToSize();
			
			//if I go to the ending node
			if(temp.getC().getX()==ce.getX() && temp.getC().getY()==ce.getY()) {
				b=true;
				printList(temp,arr2);
				System.out.println(printGrid(arr2, x1, y1));
			}
			//if there is a safe position to the left without a bomb
			if(temp.getC().getX()-1>=0 && arr[temp.getC().getX()-1][temp.getC().getY()]==0) {
				//if the node that I am currently at isn't at the list of nodes that I have already visited or the list of my choices
				if(!findAtList(temp.getC().getX()-1,temp.getC().getY(),ld) && !findAtList(temp.getC().getX()-1,temp.getC().getY(),la)) {
					Coordinates ct=new Coordinates(temp.getC().getX()-1,temp.getC().getY());
					//add this coordinate in the list of my choices
					la.add(new Node(ct,cs,ce,temp));
				}
			}
			//if there is a safe position below without a bomb
			if(temp.getC().getY()-1>=0 && arr[temp.getC().getX()][temp.getC().getY()-1]==0) {
				//if the node that I am currently at isn't at the list of nodes that I have already visited or the list of my choices
				if(!findAtList(temp.getC().getX(),temp.getC().getY()-1,ld) && !findAtList(temp.getC().getX(),temp.getC().getY()-1,la)) {
					Coordinates ct=new Coordinates(temp.getC().getX(),temp.getC().getY()-1);
					//add this coordinate in the list of my choices
					la.add(new Node(ct,cs,ce,temp));
				}
			}
			//if there is a safe position to the right without a bomb
			if(temp.getC().getX()+1<c.getX() && arr[temp.getC().getX()+1][temp.getC().getY()]==0) {
				//if the node that I am currently at isn't at the list of nodes that I have already visited or the list of my choices
				if(!findAtList(temp.getC().getX()+1,temp.getC().getY(),ld) && !findAtList(temp.getC().getX()+1,temp.getC().getY(),la)) {
					Coordinates ct=new Coordinates(temp.getC().getX()+1,temp.getC().getY());
					//add this coordinate in the list of my choices
					la.add(new Node(ct,cs,ce,temp));
				}
			}
			//if there is a safe position above without a bomb
			if(temp.getC().getY()+1<c.getY() && arr[temp.getC().getX()][temp.getC().getY()+1]==0) {
				//if the node that I am currently at isn't at the list of nodes that I have already visited or the list of my choices
				if(!findAtList(temp.getC().getX(),temp.getC().getY()+1,ld) && !findAtList(temp.getC().getX(),temp.getC().getY()+1,la)) {
					Coordinates ct=new Coordinates(temp.getC().getX(),temp.getC().getY()+1);
					//add this coordinate in the list of my choices
					la.add(new Node(ct,cs,ce,temp));
				}
			}
		}
		System.out.println("\nSteps: "+(ld.size()+la.size()));
		long endTime   = System.currentTimeMillis();
		float sec = (endTime - startTime) / 1000F; 
		System.out.println(sec + " seconds");
		sc2.close();
	}
}
