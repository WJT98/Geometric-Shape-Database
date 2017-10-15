/*======================================================================
Quadrilateral Database
Author:William Tang
Date: April 27,2016
Java, jre7, Eclipse
 * =====================================================================
 * Problem Definition - The purpose of this assignment is to use the object-oriented programming 
 * concepts discussed in class. This program implements a series of classes (hierarchy) that
 * deal with geometric shapes: square, rhombus, rectangle, parallelogram, trapezoid, kite.  
 * It also includes methods to determine the perimeter and surface area.  
 * It includes data fields that keep track of the number geometric shapes created, as well 
 * as the number of each type of geometric shape created. 
 * 
 * Input - The shape the user wishes to create, and dimensions of the shape if the user chooses
 * to create a custom shape. Also, a unique ID to search for an existing shape.
 * 
 * Output - Number of shapes created, and number of each type of shape created. 
 * The attributes of shapes, list of the objects stored in the database.
 * 
 * Process - Used OOP concepts to build a database with shapes the user creates. 
 * Search for shapes using the ID provided when a shape is created.
 =================================================================
<Class>
The class ShapeDatabase is the driver class used for the quadrilateral database.
Other classes include the abstract class Quadrilateral, and classes for each 
quadrilateral object that can be instantiated. This includes square, rhombus, 
rectangle, parallelogram, trapezoid, and kite.

=================================================================
 */
//Allows access to external libraries, such as BufferedReader.
import java.io.*;
import java.util.ArrayList;
public class ShapeDatabase {
	/**
	 * Main method: This procedural method is automatically called and is used
	 * to organize the calling of other methods defined in the class. 
	 * This is the driver class which prompts the user to input which function they would like to proceed to.
	 * 
	 * Local Variables:
	 * 
	 * wt - Object used to gain access to non-static methods defined in the class <type Assignment2>
	 * shapeList - ArrayList of type Object used to store the shapes created <type ArrayList>
	 * input - Stores the users input <type double>
	 * endProgram - Check to see if the user would like to exit the program <type boolean>
	 * newShape - Check to see if a new shape is created <type boolean>
	 * 
	 * @param args <type String>
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException{ //Method Header
		ShapeDatabase wt = new ShapeDatabase();
		ArrayList<Object> shapeList = new ArrayList<Object>();
		double input = 0;
		boolean endProgram =false,newShape = false;		
		System.out.println("Welcome to the Quadrilateral Database!");
		System.out.println("This amazing database allows you to create a variety of shapes:");
		System.out.println("(Square, Rhombus, Rectangle, Parallelogram, Trapezoid, and Kite)");
		System.out.println("It can also create shapes with custom or default dimensions,");
		System.out.println("Print the number of shapes, search for shapes by their unqiue ID,");
		System.out.println("And print a list of all the shapes stored within the database. \n");
		System.out.println("NOTE: Please only enter positive numbers for all dimensions.");
		System.out.println("To navigate through the program, please enter the positive integer of \n" 
				+ "the option you would like to proceed with");
		while (!endProgram) {
			input = wt.prompt();
			switch ((int)input){
			case 1:
				newShape = wt.createShape(shapeList); //Calls the method that creates a new shape
				break;
			case 2:
				wt.displayNumShapes(shapeList); //Calls the method that displays number of each object created
				break;
			case 3:
				wt.printAllShapes(shapeList);//Calls the method that displays all the objects created
				break;
			case 4:
				System.out.println("\nWhat shape would you like to search for?");																			
				wt.searchShape(shapeList);//Calls the method that searches for a shape
				break;
			case 5:
				System.out.println("\nWhat shape would you like to edit?");
				wt.editShape(shapeList); //Calls the method that edits a shape
				break;
			default:
				endProgram = true;
				break;
			}
			if (newShape == true) {
				System.out.println("\nThe following has been added to the database:\n");
				System.out.println(shapeList.get(shapeList.size() - 1));
				newShape = false;
			}
		}//End while loop
		System.out.println("Thank you for using the quadrilateral database.");
	}//End main method

	/**
	 * editShape method: 
	 * This method allows you to edit the shapes on the object created
	 * 
	 * Local Variables:
	 *  
	 * input - The input of the user <type double>	 
	 * id - Number of which the object is identified as
	 * input - Stores the users input <type double>
	 * side2 - Temporarily stores side 2 of shape <type double>
	 * side3 - Temporarily stores side 2 of shape <type double>
	 * side4 - Temporarily stores side 2 of shape <type double>
	 * height - Temporarily stores height of shape <type double>
	 * length - Temporarily stores length of shape <type double>
	 * width - Temporarily stores width of shape <type width>
	 * newShape - Check to see if the user created a new shape <type boolean>
	 * test - Stores an integer used to be passed to an object created only to be used for comparing <type short>
	 * s - Square object created for comparison uses <type Square>
	 * rh - Rhombus object created for comparison uses <type Rhombus>
	 * r - Rectangle object created for comparison uses <type Rectangle>
	 * p -  Parallelogram created for comparison uses <type Parallelogram>
	 * t - Trapezoid object created for comparison uses <type Trapezoid>
	 * k - Kite object created for comparison uses <type Kite>
	 * 
	 * @param shapeList - The arraylist that stores all the objects created by the user.
	 * @throws IOException
	 * 
	 */

	public void editShape(ArrayList <Object> shapeList) throws IOException { //Method Header
		int input = 0,id = 0; 
		double length=0,side2=0,side3=0,side4=0,height=0,width=0;
		short test =0;
		Square s = new Square(test);
		Rhombus rh = new Rhombus (test);
		Rectangle r = new Rectangle (test);	
		Parallelogram p = new Parallelogram (test);
		Trapezoid t = new Trapezoid (test);	
		Kite k = new Kite (test);
		System.out.println("1. Square");
		System.out.println("2. Rhombus");
		System.out.println("3. Rectangle");
		System.out.println("4. Parallelogram");
		System.out.println("5. Trapezoid");
		System.out.println("6. Kite");
		System.out.println("Type any other integer to return to the menu.");
		input = Integer.parseInt(userInput());
		switch ((int)input) {
		case 1:
			id = getShapeId(shapeList,s); //Calls the method that finds the id of all squares
			if (id >0) {
				s = (Square) shapeList.get(id-1); //Cast to gain access to square class methods
				System.out.println("What would you like to change the length to?");
				length = Double.parseDouble(userInput());
				s.setLength(length);
			}
			break;
		case 2:
			id = getShapeId(shapeList,rh); //Calls the method that finds the id of all rhombuses
			if (id>0){
				rh= (Rhombus) shapeList.get(id-1); //Cast to gain access to rhombus class methods
				System.out.println("What would you like to change the length to?");
				length = Double.parseDouble(userInput());
				rh.setLength(length);	
				System.out.println("What would you like to change the height to?");
				height = Double.parseDouble(userInput());
				rh.setHeight(height);
			}
			break;
		case 3:
			id = getShapeId(shapeList,r);//Calls the method that finds the id of all rectangles
			if (id>0) {
				r = (Rectangle) shapeList.get(id-1); //Cast to gain access to rectangle class methods
				System.out.println("What would you like to change the length to?");
				length = Double.parseDouble(userInput());
				r.setLength(length);
				System.out.println("What would you like to change the width to?");
				side2 = Double.parseDouble(userInput());
				r.setSide2(side2);
			}
			break;
		case 4:
			id = getShapeId(shapeList,p); //Calls the method that finds the id of all parallelograms
			if (id > 0) {
				p = (Parallelogram) shapeList.get(id-1); //Cast to gain access to parallelogram class methods
				System.out.println("What would you like to change the length to?");
				length = Double.parseDouble(userInput());
				p.setLength(length);
				System.out.println("What would you like to change the adjacent side to the length to?");
				side2 = Double.parseDouble(userInput());
				p.setSide2(side2);
				System.out.println("What would you like to change height to?");
				height = Double.parseDouble(userInput());
				p.setHeight(height);
			}
			break;
		case 5:
			id = getShapeId(shapeList,t); //Calls the method that finds the id of all trapezoids
			if (id >0) {
				t = (Trapezoid) shapeList.get(id-1); //Cast to gain access to trapezoid class methods
				System.out.println("What would you like to change the length to?");
				length = Double.parseDouble(userInput());
				t.setLength(length);
				System.out.println("What would you like to change the side opposite to the length of the trapezoid to?");
				side3 = Double.parseDouble(userInput());
				t.setSide3(side3);
				System.out.println("What would you like to change the length of the 3rd side of the trapezoid to? ");
				side2 = Double.parseDouble(userInput());
				t.setSide2(side2);
				System.out.println("What would you like to change the length of the 4th side of the trapezoid to? ");
				side4 = Double.parseDouble(userInput());
				t.setSide4(side4);
				System.out.println("What would you like to change height to?");
				height = Double.parseDouble(userInput());
				t.setHeight(height);
			}
			break;
		case 6:
			id = getShapeId(shapeList,k); //Calls the method that finds the id of all kites
			if (id > 0) {
				k = (Kite) shapeList.get(id-1); //Cast to gain access to kite class methods
				System.out.println("What would you like to change the length to?");
				length = Double.parseDouble(userInput());
				k.setLength(length);
				System.out.println("What would you like to change the adjacent side length to?");
				side2 = Double.parseDouble(userInput());
				k.setSide2(side2);
				System.out.println("What would you like to change height to?");
				height = Double.parseDouble(userInput());
				k.setHeight(height);
				System.out.println("What would you like to change width to?");
				width = Double.parseDouble(userInput());
				k.setWidth(width);
			}
			break;
		default:
			break;
		}
		if (id<1) { 
			System.out.println("To edit a shape, a shape must first be created.");
		}
		else if (id >=1) { //Prints updated shape if it has been updated
			System.out.println("The following shape has been updated to:\n");
			System.out.println(shapeList.get(id-1));	
		}
	}//end editShape method

	/**
	 * createSquare method: 
	 * This method allows the user to create a square which will be added to the shapeList array.
	 * 
	 * Local Variables:
	 * length - Temporarily stores length of square <type double>
	 * newShape - Stores whether a shape has been created <type boolean>
	 * shapeSetting - Stores dimensions of the shape <type String>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @param customShape - Boolean value that determines whether a custom shape is to be created or not.
	 * @return newShape - Boolean value that determines whether a shape has been created or not.
	 * @throws IOException
	 */
	public boolean createSquare(ArrayList <Object> shapeList,boolean customShape) throws IOException { //Method Header
		String shapeSetting;
		double length = 0;
		boolean newShape = false;
		if (customShape) {
			System.out.println("Enter the length of the square:");
			length = Double.parseDouble(userInput());
			shapeSetting = "Square: " + "Length = " + length;
		}
		else {
			shapeSetting = "Square: Length = 5.0";
		}
		if (confirmShape(shapeSetting)) {
			if (customShape) {
				shapeList.add(new Square(length)); 
			}
			else {
				shapeList.add(new Square());
			}
			newShape = true;
		}
		return newShape;
	}//end createSquare method

	/**
	 * createRhombus method: 
	 * This method allows the user to create a rhombus which will be added to the shapeList array.
	 * 
	 * Local Variables:
	 * length - Temporarily stores length of rhombus <type double>
	 * height - Temporarily stores height of rhombus <type double>
	 * newShape - Stores whether a shape has been created <type boolean>
	 * shapeSetting - Stores dimensions of the shape <type String>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @param customShape - Boolean value that determines whether a custom shape is to be created or not.
	 * @return newShape - Boolean value that determines whether a shape has been created or not.
	 * @throws IOException
	 */
	public boolean createRhombus(ArrayList <Object> shapeList,boolean customShape) throws IOException { //Method Header
		String shapeSetting;
		double length = 0, height = 0;
		boolean newShape = false;
		if (customShape) {
			System.out.println("Enter the length of the rhombus:");
			length = Double.parseDouble(userInput());
			System.out.println("Enter the height of the rhombus:");
			height = Double.parseDouble(userInput());
			shapeSetting = "Rhombus: " + "Length = " + length+ " Height = " + height;
		}
		else {
			shapeSetting = "Rhombus: Length = 5.0 Height = 4.0";
		}
		if (confirmShape(shapeSetting)) {
			if (customShape) {
				shapeList.add(new Rhombus(length,height));
			}
			else {
				shapeList.add(new Rhombus());
			}
			newShape = true;
		}
		return newShape;
	}//end createSquare method

	/**
	 * createRectangle method: 
	 * This method allows the user to create a Rectangle which will be added to the shapeList array.
	 * 
	 * Local Variables:
	 * length - Temporarily stores length of Rectangle <type double>
	 * side2 - Temporarily stores width of Rectangle <type double>
	 * newShape - Stores whether a shape has been created <type boolean>
	 * shapeSetting - Stores dimensions of the shape <type String>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @param customShape - Boolean value that determines whether a custom shape is to be created or not.
	 * @return newShape - Boolean value that determines whether a shape has been created or not.
	 * @throws IOException
	 */
	public boolean createRectangle(ArrayList <Object> shapeList,boolean customShape) throws IOException { //Method Header
		String shapeSetting;
		double length = 0, side2 = 0;
		boolean newShape = false;
		if (customShape) {
			System.out.println("Enter the length of the rectangle:");
			length = Double.parseDouble(userInput());
			System.out.println("Enter the wdith of the rectangle:");
			side2 = Double.parseDouble(userInput());
			shapeSetting = "Rectangle: " + "Length = " + length+ " Width = " + side2;
		}
		else {
			shapeSetting = "Rectangle: Length = 5.0" + " Width = 4.0";
		}
		if (confirmShape(shapeSetting)) {
			if (customShape) {
				shapeList.add(new Rectangle(length,side2));
			}
			else {
				shapeList.add(new Rectangle());
			}
			newShape = true;
		}
		return newShape;
	}

	/**
	 * createParallelogram method: 
	 * This method allows the user to create a Parallelogram which will be added to the shapeList array.
	 * 
	 * Local Variables:
	 * length - Temporarily stores length of Parallelogram <type double>
	 * height - Temporarily stores height of Parallelogram <type double>
	 * side2 - Temporarily stores short side length of Parallelogram <type double>
	 * newShape - Stores whether a shape has been created <type boolean>
	 * shapeSetting - Stores dimensions of the shape <type String>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @param customShape - Boolean value that determines whether a custom shape is to be created or not.
	 * @return newShape - Boolean value that determines whether a shape has been created or not.
	 * @throws IOException
	 */
	public boolean createParallelogram(ArrayList <Object> shapeList,boolean customShape) throws IOException { //Method Header
		String shapeSetting;
		double length = 0, side2 = 0,height = 0;
		boolean newShape = false;
		if (customShape) {
			System.out.println("Enter the length of the parallelogram");
			length = Double.parseDouble(userInput());
			System.out.println("Enter the side adjacent to the length of the parallelogram:");
			side2 = Double.parseDouble(userInput());
			System.out.println("Enter the height of the parallelogram:");
			height = Double.parseDouble(userInput());
			shapeSetting = "Parallelogram: " + "Length = " + length+ " Short Side = " + side2 + " Height = " + height;
		}
		else {
			shapeSetting = "Parallelogram: Length = 5.0 Short side = 4.0" + " Height = 3.0";
		}
		if (confirmShape(shapeSetting)) {
			if (customShape) {
				shapeList.add(new Parallelogram(length,side2,height));
			}
			else {
				shapeList.add(new Parallelogram());
			}
			newShape = true;
		}
		return newShape;
	}//end createParallelogram method

	/**
	 * createTrapezoid method: 
	 * This method allows the user to create a Trapezoid which will be added to the shapeList array.
	 * 
	 * Local Variables:
	 * length - Temporarily stores length of Trapezoid <type double>
	 * height - Temporarily stores height of Trapezoid <type double>
	 * side2 - Temporarily stores 2nd side length of Trapezoid <type double>
	 * side3 - Temporarily stores 3rd side length of Trapezoid <type double>
	 * side4 - Temporarily stores 4th side length of Trapezoid <type double>
	 * newShape - Stores whether a shape has been created <type boolean>
	 * shapeSetting - Stores dimensions of the shape <type String>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @param customShape - Boolean value that determines whether a custom shape is to be created or not.
	 * @return newShape - Boolean value that determines whether a shape has been created or not.
	 * @throws IOException
	 */
	public boolean createTrapezoid(ArrayList <Object> shapeList,boolean customShape) throws IOException { //Method Header
		String shapeSetting;
		double length = 0, side2 = 0,height = 0,side3 =0,side4=0;
		boolean newShape = false;
		if (customShape) {
			System.out.println("Enter the length of the trapezoid:");
			length = Double.parseDouble(userInput());
			System.out.println("Enter the side opposite to the length of the trapezoid:");
			side3 = Double.parseDouble(userInput());
			System.out.println("Enter the side adjacent to the length of the trapezoid:");
			side2 = Double.parseDouble(userInput());
			System.out.println("Enter the other adjacent side to the length of the trapezoid:");
			side4 = Double.parseDouble(userInput());
			System.out.println("Enter the height of the trapezoid:");
			height = Double.parseDouble(userInput());
			shapeSetting = "Trapezoid: " + "Length = " + length+ " Side opposite to length = " + side2 +" Side 3 = " + side3 +  " Side 4 = " + side4 +" Height = " + height;
		}
		else {
			shapeSetting = "Trapezoid: " + "Length = 5.0 Side opposite to length = 4.5 Sides adjacent to length = 4.0 Height = 3.0";
		}
		if (confirmShape(shapeSetting)) {
			if (customShape) {
				shapeList.add(new Trapezoid (length, side2, height, side3, side4));
			}
			else {
				shapeList.add(new Trapezoid());
			}
			newShape = true;
		}
		return newShape;
	}//end createTrapezoid method

	/**
	 * createKite method: 
	 * This method allows the user to create a Trapezoid which will be added to the shapeList array.
	 * 
	 * Local Variables:
	 * length - Temporarily stores length of Kite <type double>
	 * side2 - Temporarily stores 2nd side length of Kite <type double>
	 * width - Temporarily stores the shorter diagonal of Kite <type double>
	 * height - Temporarily stores the longer diagonal of Kite <type double>
	 * newShape - Stores whether a shape has been created <type boolean>
	 * shapeSetting - Stores dimensions of the shape <type String>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @param customShape - Boolean value that determines whether a custom shape is to be created or not.
	 * @return newShape - Boolean value that determines whether a shape has been created or not.
	 * @throws IOException
	 */
	public boolean createKite(ArrayList <Object> shapeList,boolean customShape) throws IOException { //Method Header
		String shapeSetting;
		double length = 0, side2 = 0,height = 0,width=0;
		boolean newShape = false;
		if (customShape) {
			System.out.println("Enter the longest side length of the Kite:");
			length = Double.parseDouble(userInput());
			System.out.println("Enter the shorter side length of the Kite:");
			side2 = Double.parseDouble(userInput());
			System.out.println("Enter the longer diagonal of the Kite:");
			height = Double.parseDouble(userInput());
			System.out.println("Enter the shorter diagonal of the Kite:");
			width = Double.parseDouble(userInput());
			shapeSetting = "Kite: " + "Long side = " + length+ " Short side = " + side2 +" Shorter Diagonal = " + width +  " Longer Diagonal = " + height;
		}
		else {
			shapeSetting = "Kite: Long side = 5.0 Short side = 4.0 Shorter Diagonal = 3.0 Longer Diagonal = 3.0";
		}
		if (confirmShape(shapeSetting)) {
			if (customShape) {
				shapeList.add(new Kite (length, side2, height, width));
			}
			else {
				shapeList.add(new Kite());
			}
			newShape = true;
		}
		return newShape;
	}//end of createKite method


	/**
	 * createShape method:
	 * This method prompts the user asking them what shape they would like to create. 
	 * It then calls the appropriate method that creates the shape the user is asking,
	 * 
	 * Local Variables:
	 * customShape - Stores whether a custom shape is to be created or not <type boolean>
	 * newShape - Stores whether a shape has been created <type boolean>
	 * input - Stores user input <type double>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @return newShape - Boolean value that determines whether a shape has been created or not.
	 * @throws IOException
	 */
	public boolean createShape(ArrayList <Object> shapeList) throws IOException{ //Method Header
		Boolean customShape=false,newShape = false;
		double input = 0;
		System.out.println("\nWould you like to create a custom or a default shape?");
		System.out.println("1. Custom Shape (You choose the dimensions of the shape)");
		System.out.println("2. Default Shape (Default dimensions)");
		System.out.println("Type any other integer to return to the menu.");
		input = Double.parseDouble(userInput());
		if (input == 1) {
			customShape = true;
		}
		else if (input ==2) {
			customShape = false;
		}
		else {
			return false;
		}
		System.out.println("\nWhat shape would you like to create:");
		System.out.println("1. Square");
		System.out.println("2. Rhombus");
		System.out.println("3. Rectangle");
		System.out.println("4. Parallelogram");
		System.out.println("5. Trapezoid");
		System.out.println("6. Kite");
		System.out.println("Type any other integer to return to the menu.");
		input = Double.parseDouble(userInput());
		switch ((int)input) {
		case 1:
			newShape = createSquare(shapeList,customShape);
			break;
		case 2:
			newShape = createRhombus(shapeList,customShape);
			break;
		case 3:
			newShape = createRectangle(shapeList,customShape);
			break;
		case 4:
			newShape = createParallelogram(shapeList,customShape);
			break;
		case 5:
			newShape = createTrapezoid(shapeList,customShape);
			break;
		case 6:
			newShape = createKite(shapeList,customShape);	
			break;
		default: 
			return false;
		}
		return newShape;
	}//end createShape method
	/**
	 * searchShape method: 
	 * This procedural method is used to search for an object of a specific quadrilateral/class.
	 * 
	 * Local Variables:
	 * test - Stores an integer used to be passed to an object created only to be used for comparing <type short>
	 * s - Square object created for comparison uses <type Square>
	 * rh - Rhombus object created for comparison uses <type Rhombus>
	 * r - Rectangle object created for comparison uses <type Rectangle>
	 * p -  Parallelogram created for comparison uses <type Parallelogram>
	 * t - Trapezoid object created for comparison uses <type Trapezoid>
	 * k - Kite object created for comparison uses <type Kite>
	 * id - Stores the id of the object that the user would like to see <type int>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @throws IOException
	 */
	public void searchShape(ArrayList <Object> shapeList) throws IOException{ //Method Header
		short test =0;
		int id=0;
		double input;
		Square s = new Square(test);
		Rhombus rh = new Rhombus (test);
		Rectangle r = new Rectangle (test);	
		Parallelogram p = new Parallelogram (test);
		Trapezoid t = new Trapezoid (test);	
		Kite k = new Kite (test);
		System.out.println("1. Square");
		System.out.println("2. Rhombus");
		System.out.println("3. Rectangle");
		System.out.println("4. Parallelogram");
		System.out.println("5. Trapezoid");
		System.out.println("6. Kite");
		System.out.println("Type any other integer to return to the menu.");
		input = Integer.parseInt(userInput());
		switch ((int)input) {
		case 1:
			id = getShapeId(shapeList,s);
			break;
		case 2:
			id = getShapeId(shapeList,rh);
			break;
		case 3:
			id = getShapeId(shapeList,r);
			break;
		case 4:
			id = getShapeId(shapeList,p);
			break;
		case 5:
			id = getShapeId(shapeList,t);
			break;
		case 6:
			id = getShapeId(shapeList,k);
			break;
		default:
			break;
		}
		if (id > 0) { //Only prints out the shape if a shape exists in the arraylist 
			//index of the element in the arraylist must therefore be greater than equal to 0
			System.out.println(shapeList.get(id-1));
		}
	}//end searchShape method

	/**
	 * prompt method:
	 * This method prompts users what they would like to do.
	 * 
	 * Local Variable:
	 * input - Stores which option number they would like to proceed to <type int>
	 * 
	 * @param none	 
	 * @return input - Returns the integer number of the option they would like to proceed to.
	 * @throws IOException
	 */
	public int prompt() throws IOException{ //Method Header
		int input;
		System.out.println("\nWhat would you like to do? ");
		System.out.println("1. Create a Shape");
		System.out.println("2. View the number of objects");
		System.out.println("3. View the objects in the database (Only accessible after a shape has been created)");
		System.out.println("4. Search for a certain object");
		System.out.println("5. Edit an object based on the id");
		System.out.println("Type any other integer to exit the program.");
		input = Integer.parseInt(userInput());
		return input;
	}//end prompt method

	/**
	 * displayNumShapes method:
	 * This procedural method outputs the number of each object/shape created and the total 
	 * number of objects/shapes created.
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 */
	public void displayNumShapes (ArrayList<Object> shapeList){ //Method Header
		System.out.println("Total number of Quadrilaterals: " + Quadrilateral.getNumShapes());
		System.out.println("Number of Squares Created: " + Square.getNumSquares());
		System.out.println("Number of Rhombuses Created: " + Rhombus.getNumRhombuses());
		System.out.println("Number of Rectangles Created: " + Rectangle.getNumRectangles());
		System.out.println("Number of Parallelograms Created: " + Parallelogram.getNumParallelograms());
		System.out.println("Number of Trapezoids Created: " + Trapezoid.getNumTrapezoids());
		System.out.println("Number of Kites Prisms Created: " + Kite.getNumKites());
		if (shapeList.size() == 0) {
			System.out.println("The database is empty!");
		}
	}//end displayNumShapes

	/**
	 * getShapeId method:
	 * This method displays all the possible id's of a certain shape 
	 * and prompts the user to enter the id of the shape which they would like to access.
	 * 
	 * Local Variables:
	 * shapeExists - Determines whether an object of that shape exists <type boolean>
	 * id - Id of the shape/object <type int>
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 * @param o - The object taken in used to compare with the shapes stored in the shapeList array.
	 * @return id - The integer value id of the shape.
	 * @throws IOException
	 */
	public int getShapeId(ArrayList<Object> shapeList, Object o) throws IOException {//Method header
		Boolean shapeExists = false;
		int id = 0;
		System.out.println("IDs of this particular shape: ");
		for (int index= 0; index < (shapeList.size()); index++) {
			if (shapeList.get(index).equals(o)) {
				System.out.println(index+1);
				shapeExists = true;
			}
		}
		if (shapeExists) {
			System.out.println("Enter the ID of the particular object you would like to view:");
			id= Integer.parseInt(userInput());
		}
		else {
			System.out.println("Sorry, no objects of this shape exists in the database.");
		}
		return id;
	}//end getShapeId method

	/**
	 * printAllShapes method:
	 * This procedural method outputs all the objects created by the user which is stored
	 * in shapeList array.
	 * 
	 * @param shapeList - The array list that stores all the objects created by the user.
	 */
	public void printAllShapes(ArrayList<Object> shapeList) {//Method header
		System.out.println("The following are all the shapes stored in the database:\n");
		for (int index = 0; index < shapeList.size(); index++) {
			System.out.println(shapeList.get(index) + "\n");
		}
	}//end printAllShapes method

	/**
	 * confirmShape method:
	 * This method prompts the user to confirm the dimensions of their created shape.
	 * 
	 * @param message - Takes in a string variable which holds the dimensions of the shape in question.
	 * @return This method returns a boolean value of whether they want to create the shape or not.
	 * @throws IOException
	 */
	public boolean confirmShape(String message) throws IOException{//Method header
		System.out.println("\nWould you like to create this shape with these characteristics?");
		System.out.println(message);
		System.out.println("1. Yes");
		System.out.println("2. No");
		if (Integer.parseInt(userInput()) == 1)
			return true;
		else
			return false;
	}//end confirmShape method

	/**
	 * userInput method:
	 * This method allows the user to input
	 * 
	 * @return input - String value of user input
	 * @param none
	 * @throws IOException
	 */
	public String userInput() throws IOException{//Method Header
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		input = br.readLine();
		return input;
	}
}

/**
 * BELOW ARE ALL THE ABSTRACT OBJECTS WHICH EXTENDS EACH OTHER.
 * ALL USED BY ABOVE METHODS.
 * 
 * Quadrilateral Abstract Class
 * The superclass which all shapes extend. This class includes all variables and methods 
 * which that all the shapes will incorporate. 
 * 
 * numShapes - Stores total number of shapes created <type int>
 * id - Stores id of shape <type int>
 * 
 * @author William
 *
 */
abstract class Quadrilateral { //class header
	private static int numShapes = 0;
	private int id;

	//Default constructor - increments shapes created and sets id of shape
	Quadrilateral() { //constructor header
		numShapes ++;
		id = getNumShapes();
	}//end constructor

	//Overloaded constructor used for test shapes whose purpose is to 
	//search for created objects that have the same class by using comparison
	Quadrilateral (short test){ //constructor header
	}//end constructor

	/**
	 * getId method:
	 * Getter method to get id.
	 * 
	 * @return id <type int>
	 */
	public int getId(){ //method header
		return id;
	}//end getId method

	/**
	 * getNumShapes method:
	 * Getter method to get total number of shapes
	 *
	 * @return numShapes <type int>
	 */
	public static int getNumShapes() {//method header
		return numShapes;
	}//end getNumShapes method

	//Abstract functional method to calculate and return area
	public abstract double  findArea();

	//Abstract functional method to calculate and return perimeter
	public abstract double findPerimeter();

}

/**
 * Square Class
 * The class creates a template for the square object
 * This class extends the quadrilateral class
 * 
 * Local Variables
 * type - Stores string value of type of shape <type string>
 * numSquares - Stores total number of squares created <type int>
 * length - Stores value of length of square <type double>
 * 
 * @author William
 *
 */
class Square extends Quadrilateral {//class header
	private String type; 
	private static int numSquares=0;
	private double length;

	//Default constructor for default square
	Square() { //constructor header
		length = 5;
		//Only increments number of square and sets id to square if the object is of square class
		if (this.getClass() == Square.class) { 
			numSquares++;
			setType("[Square]");
		}
	}//end constructor

	//Overloaded constructor for square with user inputed length
	Square(double length){ //constructor header
		this.length = length;
		//Only increments number of square and sets id to square if the object is of square class
		if (this.getClass() == Square.class) {
			numSquares++;
			setType("[Square]");
		}
	}//end constructor

	//Overloaded constructor used for test shapes whose purpose is to 
	//search for created objects that have the same class by using comparison
	Square (short test){
		super(test);
		if (this.getClass() == Square.class) {
			setType("[Square]");
		}
	}//end constructor
	/**
	 * getLength method:
	 * Getter method used to get length
	 * @return length <type double>
	 */
	public double getLength() {//method header
		return length;
	}//end getLength method

	/**
	 * setLength method:
	 * Setter method used to set length
	 * @param length <type double>
	 */
	public void setLength(double length) {	//method header
		this.length = length;
	}//end setLength method

	/**
	 * findArea method:
	 * Method used to find area of square
	 * @param none
	 * return length * length <type double>
	 */
	public double findArea(){ //method header
		return Math.pow(length, 2);
	}
	/**
	 * findPerimeter method:
	 * Method used to find perimeter of square
	 * @param none
	 * return length * 4 <type double>
	 */
	public double findPerimeter(){//method header
		return length * 4;
	}//end findPerimeter method

	/**
	 * getNumSquares method:
	 * Getter method to get total number of squares
	 *
	 * @return numSquares <type int>
	 */
	public static int getNumSquares(){//method header
		return numSquares;
	}//end getNumSquares method

	/**
	 * setType method:
	 * Setter method used to set type 
	 * @param type <type String>
	 */
	public void setType(String type) {//method header
		this.type = type;
	}//end setType method
	
	/**
	 * getType method:
	 * Getter method used to get type 
	 * @return type <type String>
	 */
	public String getType() {//method header
		return type;
	}//end getType method
	
	/**
	 * equals method:
	 * Method to compare whether 2 objects have the same type
	 * 
	 * Local Variables:
	 * x - Variable of square used to store casted object <type Square>
	 * @param o - Object taken in for comparison
	 * @return boolean value of whether 2 objects' type's are equal
	 */
	public boolean equals(Object o) {//method header
		if (o instanceof Square) {
			Square x = (Square) o;
			if(this.getType().equals(x.getType())){
				return true;
			}
		}
		return false;
	}//end equals method

	/**
	 * toString method:
	 * Method used to output all the characteristics of the object
	 * @return String that contains all characteristics of the object
	 */
	public String toString() {//method header
		return type + " \nUnique Key = " + getId() + "\nLength = " + length + "\nSurface Area = "
		+ Math.round(findArea() * 100.0) / 100.0
		+ "\nPerimeter = " + Math.round(findPerimeter() * 100.0) / 100.0;
	}//end toString method
}//end Square class

/**
 * Rhombus Class
 * The class creates a template for the rhombus object
 * This class extends the square class
 * 
 * Local Variables
 * numRhombuses - Stores total number of rhombuses created <type int>
 * height - Stores value of height of rhombus <type double>
 * 
 * @author William
 *
 */
class Rhombus extends Square {
	private static int numRhombuses=0;
	private double height;
	
	//Default constructor for default rhombus
	Rhombus(){
		super();
		height = 4;
		//Only increments number of rhombuses and sets id to square if the object is of square class
		if (this.getClass() == Rhombus.class) {
			numRhombuses++;
			setType("[Rhombus]");
		}
	}//end constructor
	
	//Overloaded constructor for rhombus with user inputed length and height
	Rhombus(double length,double height){
		super(length);
		this.height = height;
		//Only increments number of rhombuses and sets id to rhombus if the object is of square class
		if (this.getClass() == Rhombus.class) {
			numRhombuses++;
			setType("[Rhombus]");
		}
	}//end constructor

	//Overloaded constructor used for test shapes whose purpose is to 
	//search for created objects that have the same class by using comparison
	Rhombus (short test){
		super(test);
		setType("[Rhombus]");
	}//end constructor
	
	/**
	 * setHeight method:
	 * Setter method used to set height
	 * @param height <type double>
	 */
	public void setHeight(double height) {//method header
		this.height = height;
	}//end setHeight method
	
	/**
	 * getHeight method:
	 * Getter method used to get height
	 * @return height <type double>
	 */
	public double getHeight() {//method header
		return height;
	}//end getHeight method
	
	/**
	 * findArea method:
	 * Method used to find area of rhombus
	 * @param none
	 * return length * height <type double>
	 */
	public double findArea(){//method header
		return getLength() * height;
	}//end findArea method
	
	/**
	 * getNumRhombuses method:
	 * Getter method to get total number of  rhombuses
	 *
	 * @return numRhombuses <type int>
	 */
	public static int getNumRhombuses(){//method header
		return numRhombuses;
	}//end getNumRhombuses method
	
	/**
	 * equals method:
	 * Method to compare whether 2 objects have the same type
	 * 
	 * Local Variables:
	 * x - Variable of Rhombus used to store casted object <type Square>
	 * @param o - Object taken in for comparison
	 * @return boolean value of whether 2 objects' type's are equal
	 */
	public boolean equals(Object o) {//method header
		if (o instanceof Rhombus) {
			Rhombus x = (Rhombus) o;
			if(this.getType().equals(x.getType())){
				return true;
			}
		}
		return false;
	}//end equals method
	
	/**
	 * toString method:
	 * Method used to output all the characteristics of the object
	 * @return String that contains all characteristics of the object
	 */
	public String toString() {
		return "[Rhombus] \nUnique Key = " + getId() + "\nLength = " + getLength() +"\nHeight = " + getHeight()+ "\nSurface Area = "
				+ Math.round(findArea() * 100.0) / 100.0
				+ "\nPerimeter = " + Math.round(findPerimeter() * 100.0) / 100.0;
	}
}//end Rhombus class

/**
 * Rectangle Class
 * The class creates a template for the rectangle object.
 * This class extends the square class.
 * 
 * Local Variables
 * numRectangles - Stores total number of rectangles created <type int>
 * side2 - Stores value of width of rectangle <type double>
 * 
 * @author William
 *
 */
class Rectangle extends Square {//class header
	private static int numRectangles = 0;
	private double side2;
	
	//Default constructor for default Rectangle
	Rectangle () {//constructor header
		super();
		side2 = 4;
		//Only increments number of rectangle and sets id to rectangle if the object is of rectangle class
		if (this.getClass() == Rectangle.class) {
			numRectangles++;
			setType("[Rectangle]");
		}
	}//end constructor

	//Overloaded constructor for rectangle with user inputted length and width
	Rectangle (double length, double side2) {
		super(length);
		this.side2 = side2;
		//Only increments number of rectangle and sets id to rectangle if the object is of rectangle class
		if (this.getClass() == Rectangle.class) {
			numRectangles++;
			setType("[Rectangle]");
		}
	}//end constructor

	//Default constructor for default Rectangle
	Rectangle (short test){ //Rectangle constructor for object created for searching rectangles by comparing types
		super(test);
		//Only increments number of rectangle and sets id to rectangle if the object is of rectangle class
		if (this.getClass() == Rectangle.class) {
			setType("[Rectangle]");
		}
	}//end constructor

	/**
	 * getSide2 method:
	 * Getter method used to get side2
	 * @return side2 <type double>
	 */
	public double getSide2() {//method header
		return side2;
	}//end getSide2 method
	
	/**
	 * setSide2 method:
	 * Setter method used to set side2
	 */
	public void setSide2(double side2) {//method header
		this.side2 = side2;
	}//end setSide2 method
	
	/**
	 * findArea method:
	 * Method used to find area of parallelogram
	 * @param none
	 * return length * side2 <type double>
	 */
	public double findArea(){//method header
		return getLength() * side2;
	}//end findArea method
	
	/**
	 * findPerimeter method:
	 * Method used to find perimeter of parallelogram
	 * @param none
	 * return length *2 + side2 *2 <type double>
	 */
	public double findPerimeter(){//method header
		return getLength() * 2 + side2 * 2;
	}//end findPerimeter method
	
	/**
	 * getNumRectangles method:
	 * Getter method to get total number of rectangles
	 *
	 * @return numRectangles <type int>
	 */
	public static int getNumRectangles(){//method header
		return numRectangles;
	}//end getNumRectangles method
	
	/**
	 * equals method:
	 * Method to compare whether 2 objects have the same type
	 * 
	 * Local Variables:
	 * x - Variable of square used to store casted object <type Square>
	 * @param o - Object taken in for comparison
	 * @return boolean value of whether 2 objects' type's are equal
	 */
	public boolean equals(Object o) {//method header
		if (o instanceof Rectangle) {
			Rectangle x = (Rectangle) o;
			if(this.getType().equals(x.getType())){
				return true;
			}
		}
		return false;
	}//end equals method
	
	/**
	 * toString method:
	 * Method used to output all the characteristics of the object
	 * @return String that contains all characteristics of the object
	 */
	public String toString() {//method header
		return "[Rectangle] \nUnique Key = " + getId() + "\nLength = " + getLength() + "\nWidth = " + getSide2() +  "\nSurface Area = "
		+ Math.round(findArea() * 100.0) / 100.0
		+ "\nPerimeter = " + Math.round(findPerimeter() * 100.0) / 100.0;
	}//end toString method

}//end toString method

/**
 * Parallelogram Class
 * The class creates a template for the Parallelogram object.
 * This class extends the rectangles class.
 * 
 * Local Variables
 * numParallelogram - Stores total number of rectangles created <type int>
 * height - Stores value of height of Parallelogram <type double>
 * 
 * @author William
 *
 */
class Parallelogram extends Rectangle {//class header
	private static int numParallelograms=0;
	private double height;
	
	//Default constructor for default Parallelogram
	Parallelogram(){//constructor header
		super();
		height = 3;
		if (this.getClass() == Parallelogram.class) {
			numParallelograms++;
			setType("[Parallelogram]");
		}
	}//end constructor 
	
	//Overloaded constructor for parallelogram with user inputted length, side2, and height
	Parallelogram(double length, double side2,double height) { //constructor header
		super(length, side2);
		this.height = height;
		//Only increments number of Parallelogram and sets id to Parallelogram if the object is of Parallelogram class
		if (this.getClass() == Parallelogram.class) {
			numParallelograms++;
			setType("[Parallelogram]");
		}
	}//end constructor

	//Overloaded constructor used for test shapes whose purpose is to 
	//search for created objects that have the same class by using comparison
	Parallelogram (short test){//constructor
		super(test);
		//Only increments number of Parallelogram and sets id to Parallelogram if the object is of Parallelogram class
		if (this.getClass() == Parallelogram.class) {
			setType("[Parallelogram]");
		}
	}
	
	/**
	 * getHeight method:
	 * Getter method used to get height
	 * @return height <type double>
	 */
	public double getHeight() {//method header
		return height;
	}//end getHeight method
	
	/**
	 * setHeight method:
	 * Setter method used to set height
	 * @return height <type double>
	 */
	public void setHeight(double height) {	//method header
		this.height = height;
	}//end setHeight method
	
	/**
	 * findArea method:
	 * Method used to find area of parallelogram
	 * @param none
	 * return length * height <type double>
	 */
	public double findArea(){//method header
		return getLength() * height;
	}//end findArea method
	
	/**
	 * getNumParallelograms method:
	 * Getter method to get total number of parallelograms
	 *
	 * @return numParallelograms <type int>
	 */
	public static int getNumParallelograms(){//method header
		return numParallelograms;
	}//end getNumParalleograms method

	/**
	 * equals method:
	 * Method to compare whether 2 objects have the same type
	 * 
	 * Local Variables:
	 * x - Variable of square used to store casted object <type Square>
	 * @param o - Object taken in for comparison
	 * @return boolean value of whether 2 objects' type's are equal
	 */
	public boolean equals(Object o) {//method header
		if (o instanceof Parallelogram) {
			Parallelogram x = (Parallelogram) o;
			if(this.getType().equals(x.getType())){
				return true;
			}
		}
		return false;
	}//end equals method
	
	/**
	 * toString method:
	 * Method used to output all the characteristics of the object
	 * @return String that contains all characteristics of the object
	 */
	public String toString() {
		return "[Parallelogram] \nUnique Key = " + getId() + "\nLength = " + getLength() + "\nShort Side = " + getSide2() + "\nHeight = " + height + "\nSurface Area = "
				+ Math.round(findArea() * 100.0) / 100.0
				+ "\nPerimeter = " + Math.round(findPerimeter() * 100.0) / 100.0;
	}//end toString method
}//end Parallelogram class

/**
 * Trapezoid Class
 * The class creates a template for the Trapezoid object.
 * This class extends the parallelogram class.
 * 
 * Local Variables
 * numTrapezoid - Stores total number of rectangles created <type int>
 * side3 - Stores value of 3rd side of trapezoid <type double>
 * side4 - Stores value of 4th side of trapezoid <type double>
 * @author William
 *
 */
class Trapezoid extends Parallelogram { //class header
	private static int numTrapezoids=0;
	private double side3,side4;
	
	//Default constructor for default trapezoid
	Trapezoid () {//constructor header
		super();
		side3 = 5;
		side4 = 4;
		//Only increments number of Trapezoid and sets id to Trapezoid if the object is of Trapezoid class
		if (this.getClass() == Trapezoid.class) {
			numTrapezoids++;
			setType("[Trapezoid]");
		}
	}//end constructor
	
	//Overloaded constructor for trapezoid with user inputed length, side2, side3, and side4
	Trapezoid (double length, double side2, double height, double side3,double side4) {//constructor header
		super(length, side2, height);
		this.side3 = side3;
		this.side4 = side4;
		//Only increments number of Trapezoid and sets id to Trapezoid if the object is of Trapezoid class
		if (this.getClass() == Trapezoid.class) {
			numTrapezoids++;
			setType("[Trapezoid]");
		}
	}//end constructor
	
	//Overloaded constructor used for test shapes whose purpose is to 
	//search for created objects that have the same class by using comparison
	Trapezoid (short test){//constructor header
		super(test);
		setType("[Trapezoid]");
	}//end constructor
	
	/**
	 * findArea method:
	 * Method used to find area of trapezoid
	 * @param none
	 * return (length + side3)/2 * height <type double>
	 */
	public double findArea(){//method header
		return (getLength() + side3)/2 * getHeight();
	}//end findArea method
	
	/**
	 * findPerimeter method:
	 * Method used to find area of trapezoid
	 * @param none
	 * return length + side2 + side3 + side4 <type double>
	 */
	public double findPerimeter(){//method header
		return getLength() + getSide2() + side3 + side4;
	}//end findPerimeter method
	
	/**
	 * getNumTrapezoids method:
	 * Getter method to get total number of trapezoids
	 *
	 * @return numTrapezoids <type int>
	 */
	public static int getNumTrapezoids(){//method header
		return numTrapezoids;
	}//end getNumTrapezoids method
	
	/**
	 * equals method:
	 * Method to compare whether 2 objects have the same type
	 * 
	 * Local Variables:
	 * x - Variable of square used to store casted object <type Square>
	 * @param o - Object taken in for comparison
	 * @return boolean value of whether 2 objects' type's are equal
	 */
	public boolean equals(Object o) {//method header
		if (o instanceof Trapezoid) {
			Trapezoid x = (Trapezoid) o;
			if(this.getType().equals(x.getType())){
				return true;
			}
		}
		return false;
	}//end equals method
	
	/**
	 * getSide4 method:
	 * Getter method used to get side4
	 * @return side4 <type double>
	 */
	public double getSide4() {//method header
		return side4;
	}//end getSide4 method
	
	/**
	 * getSide3 method:
	 * Getter method used to get side3
	 * @return side3 <type double>
	 */
	public double getSide3() {//method header	
		return side3;
	}//end getSide3 method
	
	/**
	 * setSide3 method:
	 * Setter method used to set side3
	 * @param side3 <type double>
	 */
	public void setSide3(double side3) {//method header	
		this.side3 = side3;
	}//end setSide3 method
	
	/**
	 * setSide4 method:
	 * Setter method used to set side4
	 * @param side4 <type double>
	 */
	public void setSide4(double side4) {//method header
		this.side4 = side4;
	}//end setSide4 method
	public String toString() {
		return "[Trapezoid] \nUnique Key = " + getId() + "\nLength = " + getLength() + "\nSide opposite to Length = " 
				+ getSide2()  + "\nSide 3 = " + getSide3() + "\nSide 4 = " + getSide4() + "\nHeight = " + getHeight() + "\nSurface Area = "
				+ Math.round(findArea() * 100.0) / 100.0
				+ "\nPerimeter = " + Math.round(findPerimeter() * 100.0) / 100.0;
	}//end toString method
}

/**
 * Kite Class
 * The class creates a template for the Kite object.
 * This class extends the parallelogram class.
 * 
 * Local Variables
 * numKites - Stores total number of kites created <type int>
 * width - Stores value of shorter diagonal of kite <type double>
 * @author William
 *
 */
class Kite extends Parallelogram {
	private static int numKites=0;
	private double width;
	
	//Default constructor for default kite
	Kite (){
		super();
		width = 2;
		//Only increments number of Kite and sets id to Kite if the object is of Kite class
		if (this.getClass() == Kite.class) {//constructor header
			numKites++;
			setType("[Kite]");
		}
	}//end constructor
	
	//Overloaded constructor for kite with user inputted length, side2, height (longer diagonal),
	//and width (shorter diagonal)
	Kite (double length, double side2, double height, double width) {
		super(length, side2, height);
		this.width = width;
		//Only increments number of Kite and sets id to Kite if the object is of Kite class
		if (this.getClass() == Kite.class) {
			numKites++;
			setType("[Kite]");
		}
	}//end constructor
	
	//Overloaded constructor used for test shapes whose purpose is to 
	//search for created objects that have the same class by using comparison
	Kite (short test){//constructor header
		super(test);
		setType("[Kite]");
	}//end constructor

	/**
	 * findArea method:
	 * Method used to find area of kite
	 * @param none
	 * return width * height <type double>
	 */
	public double findArea(){//method header
		return width * getHeight()/2;
	}//end findArea method
	
	/**
	 * getNumKites method:
	 * Getter method to get total number of kites
	 *
	 * @return numKites <type int>
	 */
	public static int getNumKites(){//method header
		return numKites;
	}//end getNumKites method
	
	/**
	 * setType method:
	 * Setter method used to set width 
	 * @param width <type double>
	 */
	public void setWidth(double width) {//method header	
		this.width = width;
	}//end setWidth method
	
	/**
	 * getType method:
	 * Getter method used to get type 
	 * @return width <type double>
	 */
	public double getWidth() {//method header
		return width;
	}//end getWidth method
	
	/**
	 * equals method:
	 * Method to compare whether 2 objects have the same type
	 * 
	 * Local Variables:
	 * x - Variable of square used to store casted object <type Square>
	 * @param o - Object taken in for comparison
	 * @return boolean value of whether 2 objects' type's are equal
	 */
	public boolean equals(Object o) {//method header
		if (o instanceof Kite) {
			Kite x = (Kite) o;
			if(this.getType().equals(x.getType())){
				return true;
			}
		}
		return false;
	}//end equals method
	
	/**
	 * toString method:
	 * Method used to output all the characteristics of the object
	 * @return String that contains all characteristics of the object
	 */
	public String toString() {//method header
		return "[Kite] \nUnique Key = " + getId() + "\nLong Side = " + getLength() + "\nShorter Side = " 
				+ getSide2() +"\nShorter Diagonal = " + getWidth()  +"\nLonger Diagonal = " + getHeight() + "\nSurface Area = "
				+ Math.round(findArea() * 100.0) / 100.0
				+ "\nPerimeter = " + Math.round(findPerimeter() * 100.0) / 100.0;
	}//end toString method
}//end Kite class
