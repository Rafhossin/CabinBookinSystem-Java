package arraySolution;
import java.util.Objects;
import java.util.Scanner;
import static arraySolution.Task1Methods.*;

/** Author : w1785478
 * Task 1 program has been designed to create 12 cabins for a Cruise Ship by creating Static Array( CabinArray).In the main method
 * each cabin(index value) has been initialized with "empty" string. A menu system has been created for the user,so every time
 * if a user enter a menu, it will invoke the appropriate method created in the Task1Methods class.*/


public class Task1DriverClass {

    private static String newOption = "no";
    static String customerName;
    static  int cabinNumber ;
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args){

        int arraySize = 12;
        String[] cabinArray = new String[arraySize];

        for (cabinNumber = 0; cabinNumber < cabinArray.length; cabinNumber++) {
            cabinArray[cabinNumber] = "empty";
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

                System.out.print("Pls enter an option : ");
                char option = scanner.next().charAt(0);
                option = Character.toUpperCase(option);

                switch (option) {
                    case 'A':
                        addCustomerToCabin(cabinArray);
                        menuSystem = true;
                        break;
                    case 'V':
                        viewAllCabins(cabinArray);
                        menuSystem = true;
                        break;
                    case 'E':
                        displayEmptyCabin(cabinArray);
                        menuSystem = true;
                        break;
                    case 'D':
                        deleteCustomerFromCabin(cabinArray);
                        menuSystem = true;
                        break;
                    case 'F':
                        findCabinFromCustomerName(cabinArray);
                        menuSystem = true;
                        break;
                    case 'S':
                        storeDataIntoFile("dataIntoFile.txt",cabinArray);
                        menuSystem = true;
                        break;
                    case 'L':
                        loadDataFromFile("dataIntoFile.txt",cabinArray);
                        menuSystem = true;
                        break;
                    case 'O':
                        viewPassengersNameAlphabetically(cabinArray);
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

