package objectSolution;
import java.util.Objects;
import java.util.Scanner;
import static objectSolution.Task2Methods.*;

/** Author : w1785478
 * Task2 program has been designed to create 12 cabins for a Cruise Ship by creating array of cabin objects from Cabin class.In the main method
 * each cabin object (index value) has been initialized and each index has been initialized with 3 passenger by calling Passenger methods from the Passenger class.
 * A menu system has been created for the user,so every time
 * if a user enter a menu, it will invoke the appropriate method created in the Task2Methods class.*/

public class Task2DriverClass {

    static int arraySize = 12;
    private static String newOption = "no";
    public static Scanner scanner = new Scanner(System.in);
    public static Cabin[] cabinObjects = new Cabin[arraySize];

    static int cabinNumber;
    static int guestNumber;
    static String guestFName;
    static String  guestLName;


    public static void main(String[] args) {


        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            cabinObjects[cabinNumber] = new Cabin();
        }

        for (int i = 0; i < cabinObjects.length; i++) {
            for(int j = 0; j<3;j++) {
                cabinObjects[i].passenger[j]= new Passenger();

            }
        }



        while (true) {

            boolean menuSystem = false;
            while (!menuSystem) {
                System.out.println("\nCruise Ship Menu System");
                System.out.println("\nA:  Add a guest to a cabin");
                System.out.println("V:  View all cabins");
                System.out.println("E:  Display Empty cabins");
                System.out.println("D:  Delete guest from cabin");
                System.out.println("F:  Find cabin from guest name");
                System.out.println("S:  Store program data into file");
                System.out.println("L:  Load program data from file");
                System.out.println("O:  View guest Ordered alphabetically by name");
                System.out.println("T:  Total expenses per guest and total expenses of all guest");

                System.out.print("Pls enter an option : ");
                char option = scanner.next().charAt(0);
                option = Character.toUpperCase(option);

                switch (option) {
                    case 'A':
                        addCustomerToCabinObjects(cabinObjects);
                        menuSystem = true;
                        break;
                    case 'V':
                        viewAllCabinsObjects(cabinObjects);
                        menuSystem = true;
                        break;
                    case 'E':
                        displayEmptyCabinObjects(cabinObjects);
                        menuSystem = true;
                        break;
                    case 'D':
                        deleteCustomerFromCabinObjects(cabinObjects);
                        menuSystem = true;
                        break;
                    case 'F':
                        findCabinNumberFromCustomerName(cabinObjects);
                        menuSystem = true;
                        break;
                    case 'S':
                        storeCabinObjectsDataIntoFile("objectDataIntoFile.txt",cabinObjects);
                        menuSystem = true;
                        break;
                    case 'L':
                        loadCabinObjectsDataFromFile("objectDataIntoFile.txt",cabinObjects);
                        menuSystem = true;
                        break;
                    case 'O':
                        viewGuestsNameAlphabetically(cabinObjects);
                        menuSystem = true;
                        break;
                    case 'T':
                        viewTotalExpenses(cabinObjects);
                        menuSystem = true;
                        break;
                    default:
                        System.out.println("It's not a valid option\n");
                }
            }

            boolean submenu = false;

            while (!submenu) {

                System.out.print("\nWould you like to choose another option from the boarding menu system? \nPlease enter yes or no: ");
                newOption = scanner.next();
                newOption =  newOption.toLowerCase();
                switch (newOption) {
                    case "yes":

                    case "no":
                        submenu = true;
                        break;

                    default:
                        System.out.println("It's not a valid option");
                }
            }
            if (Objects.equals(newOption, "no")){
                System.out.println("Thank you");
                break;
            }

        }
    }
}
