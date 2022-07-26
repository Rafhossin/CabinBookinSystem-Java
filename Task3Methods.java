package circularQueueSolution;
import java.io.*;
import java.util.InputMismatchException;
import static circularQueueSolution.Task3DriverClass.*;

/** This class hold all the methods of the menu system*/
public class Task3Methods {

    //By invoking this method from the main will add a Guest name into the waitingList CircularQueue if cabinObjects array is full
    public static void addCustomerToCabinObjects(circularQueueSolution.Cabin[] cabinObjects, CircularQueue waitingList) {

        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            System.out.println("\nCabin number: " + (Task3DriverClass.cabinNumber + 1));
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                System.out.println("\nGuest: " + (guestNumber + 1) + cabinObjects[cabinNumber].passenger[guestNumber]);
            }
            System.out.println("---------------------------------------");
        }

        boolean addCustomer = false;
        int  totalGuest = 0;
        int count = 0;
        while (!addCustomer) {
            try {
                for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
                    for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                        if (!cabinObjects[cabinNumber].passenger[guestNumber].getFirstName().equals("empty") &&
                                !cabinObjects[cabinNumber].passenger[guestNumber].getLastName().equals("empty") &&
                                cabinObjects[cabinNumber].passenger[guestNumber].getExpense() != 0) {   //guest expense = 0

                            totalGuest++;
                        }
                    }
                }

                if (totalGuest == 1) { // There are 12 cabins and each cabin hold 3 guests (3*12 = 36)
                    System.out.print("Please enter a guest's first name for the circular queue list: ");
                    scanner.nextLine();
                    String firstName = Task3DriverClass.scanner.next().toUpperCase();

                    System.out.print("Please enter a guest's last name for the circular queue list : ");
                    scanner.nextLine();
                    String lastName = Task3DriverClass.scanner.next().toUpperCase();

                    System.out.print("Please enter a guest's expenses: ");
                    scanner.nextLine();
                    double expenses = Task3DriverClass.scanner.nextDouble();

                    //Instantiating the guest for circular queue list.
                    Passenger guest = new Passenger(firstName, lastName, expenses);

                    //Setting the guest object by calling the enqueue method
                    waitingList.enqueue(guest);

                    System.out.print("\n"+ waitingList);
                } else {
                    System.out.print("Please enter a cabin number from (1-12)[Each cabin can hold up to 3 guests]: ");
                    Task3DriverClass.cabinNumber = Task3DriverClass.scanner.nextInt() - 1;

                    if (Task3DriverClass.cabinNumber >= 0 && Task3DriverClass.cabinNumber < cabinObjects.length) {
                        for (guestNumber = 0; guestNumber < 3; guestNumber++) {

                            if (cabinObjects[cabinNumber].passenger[guestNumber].getFirstName().equals("empty") &&
                                    cabinObjects[cabinNumber].passenger[guestNumber].getLastName().equals("empty") &&
                                    cabinObjects[cabinNumber].passenger[guestNumber].getExpense() == 0) {

                                System.out.print("Please enter a guest's first name for " + "cabin number " + (Task3DriverClass.cabinNumber + 1) + ": ");
                                cabinObjects[cabinNumber].passenger[guestNumber].setFirstName(Task3DriverClass.scanner.next().toUpperCase());

                                System.out.print("Please enter a guest's last name for cabin number " + (Task3DriverClass.cabinNumber + 1) + ": ");
                                cabinObjects[cabinNumber].passenger[guestNumber].setLastName(Task3DriverClass.scanner.next().toUpperCase());


                                System.out.print("Please enter a guest's expenses for cabin number " + (Task3DriverClass.cabinNumber + 1) + ": ");
                                cabinObjects[cabinNumber].passenger[guestNumber].setExpense(Task3DriverClass.scanner.nextDouble());
                                break;

                            } else {
                                count++;
                            }

                            if (count >= 3) {
                                System.out.println("Cabin no " + (Task3DriverClass.cabinNumber + 1) + " has Been booked already");
                            }
                        }
                        count = 0;
                    } else {
                        System.out.println("Cabin number " + (Task3DriverClass.cabinNumber + 1) + " do not exist");
                    }
                }
            } catch (InputMismatchException e) {

                System.out.println("This is not a valid number");

                Task3DriverClass.scanner.next();   // this statement will clear scanner buffer of wrong input otherwise it will
                // loop continuously.
                continue;
            }

            System.out.print("\nWould you like to add another guest?\nPlease enter yes or no: ");
            String option = Task3DriverClass.scanner.next();
            option = option.toLowerCase();

            switch (option) {
                case "yes":
                    totalGuest = 0;
                    continue;
                case "no":
                    addCustomer = true;
                    break;
                default:
                    System.out.println("It's not a valid option\n");
            }

        }
    }

    //  By invoking this method from the main will show all the cabins number and the guests name.
    public static void viewAllCabinsObjects(circularQueueSolution.Cabin[] cabinObjects,CircularQueue waitingList) {

        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            System.out.println("\nCabin number: " + (Task3DriverClass.cabinNumber + 1));
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                System.out.println("\nGuest: " + (guestNumber + 1) + cabinObjects[cabinNumber].passenger[guestNumber]);
            }
            System.out.println("---------------------------------------");
        }

        System.out.print("\n"+ waitingList);
    }

    //  By invoking this method from the main will show the user empty cabins only.
    public static void displayEmptyCabinObjects(circularQueueSolution.Cabin[] cabinObjects) {

        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            System.out.println("\nCabin number: " + (Task3DriverClass.cabinNumber + 1));
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                if (cabinObjects[cabinNumber].passenger[guestNumber].getFirstName().equals("empty")) {

                    System.out.println("\nGuest: " + (guestNumber + 1) + cabinObjects[cabinNumber].passenger[guestNumber]);
                }
            }
            System.out.println("---------------------------------------");
        }
    }

    // By invoking this method from the main will delete a guest name from the cabins Array.If the cabin array is full and
    // the user delete a guest, this method also dequeue the waitingList element and add it to the empty index just has been
    // vacant

    public static void deleteCustomerFromCabinObjects(circularQueueSolution.Cabin[] cabinObjects,CircularQueue waitingList) {

        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            System.out.println("\nCabin number: " + (Task3DriverClass.cabinNumber + 1));
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                System.out.println("\nGuest: " + (guestNumber + 1) + cabinObjects[cabinNumber].passenger[guestNumber]);
            }
            System.out.println("---------------------------------------");
        }

        System.out.print("Please enter a guest first name to be deleted: ");
        guestFName = Task3DriverClass.scanner.next();
        guestFName = guestFName.toUpperCase();

        System.out.print("Please enter a guest last name to be deleted: ");
        guestLName = Task3DriverClass.scanner.next();
        guestLName = guestLName.toUpperCase();
        boolean testCase = false;

        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                if (cabinObjects[cabinNumber].passenger[guestNumber].getFirstName().equals(guestFName) &&
                        cabinObjects[cabinNumber].passenger[guestNumber].getLastName().equals(guestLName)) {

                    cabinObjects[cabinNumber].passenger[guestNumber].setFirstName("empty");
                    cabinObjects[cabinNumber].passenger[guestNumber].setLastName("empty");
                    cabinObjects[cabinNumber].passenger[guestNumber].setExpense(0);
                    System.out.println("Guest named " + guestFName + " " + guestLName + " has been deleted from cabin number " + (Task3DriverClass.cabinNumber + 1));
                    testCase = true;

                    if(!waitingList.isEmpty()){
                        cabinObjects[cabinNumber].passenger[guestNumber] = waitingList.dequeue();

                    }


                }
            }
        }
        if (!testCase) {
            System.out.println("Guest named " + guestFName + " " + guestLName + " does not exist in the system");
        }
    }

    //  By invoking this method from the main will find a cabin number by inputting guest name.
    public static void findCabinNumberFromCustomerName(circularQueueSolution.Cabin[] cabinObjects) {

        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            System.out.println("\nCabin number: " + (Task3DriverClass.cabinNumber + 1));
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                System.out.println("\nGuest: " + (guestNumber + 1) + cabinObjects[cabinNumber].passenger[guestNumber]);
            }
            System.out.println("---------------------------------------");
        }

        System.out.print("Please enter a guest first name: ");
        guestFName = Task3DriverClass.scanner.next();
        guestFName = guestFName.toUpperCase();

        System.out.print("Please enter a guest last name: ");
        guestLName = Task3DriverClass.scanner.next();
        guestLName = guestLName.toUpperCase();
        boolean testCase = false;

        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                if (cabinObjects[cabinNumber].passenger[guestNumber].getFirstName().equals(guestFName) &&
                        cabinObjects[cabinNumber].passenger[guestNumber].getLastName().equals(guestLName)) {

                    System.out.println("Guest named " + guestFName + " " + guestLName + " booked cabin number " + (Task3DriverClass.cabinNumber + 1));
                    testCase = true;
                }
            }
        }
        if (!testCase) {
            System.out.println("Guest named " + guestFName + " " + guestLName + " does not exist in the system");
        }
    }

    // By invoking this method from the main will store all the data from the array to a file named "ObjectDataIntoFile.txt"
    public static void storeCabinObjectsDataIntoFile(String fileName, circularQueueSolution.Cabin[] cabinObjects) {

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
                printWriter.println((Task3DriverClass.cabinNumber + 1));
                for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                    printWriter.println("\nGuest: " + (guestNumber + 1) + cabinObjects[cabinNumber].passenger[guestNumber]);

                }
                printWriter.println("---------------------------------------");
            }
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Error- Cannot write to file " + fileName);
        }
        System.out.println("Guest information has been written into the file");
    }

    //By invoking this method from the main will load all the data from the file named "ObjectDataIntoFile.txt"
    // and output to the console.
    public static void loadCabinObjectsDataFromFile(String fileName, circularQueueSolution.Cabin[] cabinObjects) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);

            }
            bufferReader.close();
        } catch (IOException e) {
            System.out.println("Error- Cannot read from file " + fileName);
        }
    }

    //The function below,sort an Array of string (temsCabinObjects[temporaryArraySize] ) using bubble sort.In this case two successive strings
    // cabins[i] and cabins[i+1] are swapped around whenever cabins[i] > cabins[i+1].The larger values sink to
    // the bottom and smaller values bubble their way to the top.After all iteration,the cabinArray's elements are
    // sorted alphabetically.
    public static void viewGuestsNameAlphabetically(circularQueueSolution.Cabin[] cabinObjects) {
        int temporaryArraySize = 36;
        int temsvariable = temporaryArraySize - 1;

        String[] temsCabinObjects = new String[temporaryArraySize];
        int i;
        for (i = 0; i < temsCabinObjects.length; i++) {
            temsCabinObjects[i] = "empty";
        }

        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {
                if (cabinObjects[cabinNumber].passenger[guestNumber].getExpense() != 0) {

                    temsCabinObjects[temsvariable] = cabinObjects[cabinNumber].passenger[guestNumber].getFirstName() + " "
                            + cabinObjects[cabinNumber].passenger[guestNumber].getLastName();
                    temsvariable--;
                }
            }

        }

        String temporaryVariable;
        System.out.println("\nGuest name in alphabetical order:");

        //algorithm for sorting**/
        for (i = 0; i < temsCabinObjects.length; i++) {            //holds each elements
            for (int j = i + 1; j < temsCabinObjects.length; j++) {  //check for remaining elements
                // used the compareTo() method to compare and swap the array elements.
                if (temsCabinObjects[j].compareTo(temsCabinObjects[i]) < 0) {
                    temporaryVariable = temsCabinObjects[i];
                    temsCabinObjects[i] = temsCabinObjects[j];
                    temsCabinObjects[j] = temporaryVariable;

                }
            }
            System.out.print(temsCabinObjects[i] + ", ");
        }
        System.out.println();
    }

    //By invoking this method from the main will show individual expenses of the guest and calculate the total expenses of all guests
    public static void viewTotalExpenses(Cabin[] cabinObjects) {

        int totalExpenses = 0;
        for (cabinNumber = 0; cabinNumber < cabinObjects.length; cabinNumber++) {
            for (guestNumber = 0; guestNumber < 3; guestNumber++) {

                if (cabinObjects[cabinNumber].passenger[guestNumber].getExpense() != 0) {
                    System.out.println("\nFull name: " + cabinObjects[cabinNumber].passenger[guestNumber].getFirstName() + " " +
                            cabinObjects[cabinNumber].passenger[guestNumber].getLastName() + "\nExpenses:£" +
                            cabinObjects[cabinNumber].passenger[guestNumber].getExpense());
                    totalExpenses += cabinObjects[cabinNumber].passenger[guestNumber].getExpense();
                }
            }
        }
        System.out.println("\nTotal expenses of all guests:£" + totalExpenses);

    }
}
