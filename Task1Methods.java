package arraySolution;
import java.io.*;
import java.util.InputMismatchException;

/** This class hold all the methods of the menu system*/
public class Task1Methods {

//By invoking this method from the main will add a Guest name into the cabin(index)
    public static void  addCustomerToCabin(String[] cabins) {//cabins reference to cabinArray

        for (int i = 0; i < cabins.length; i++) {
            if (cabins[i].equals("empty")) {
                System.out.println("Cabin " + (i + 1) + " = " + cabins[i]);
            }
        }
        boolean addCustomer = false;
        while (!addCustomer) {
            try {
                System.out.print("Please enter a cabin number from (1-12): ");
                Task1DriverClass.cabinNumber = Task1DriverClass.scanner.nextInt() - 1;

                if (Task1DriverClass.cabinNumber >= 0 && Task1DriverClass.cabinNumber < cabins.length) {
                    if (cabins[Task1DriverClass.cabinNumber].equals("empty")) {
                        System.out.print("Please enter a guest name for cabin number " + (Task1DriverClass.cabinNumber + 1) + ": ");
                        Task1DriverClass.customerName = Task1DriverClass.scanner.next();
                        cabins[Task1DriverClass.cabinNumber] = Task1DriverClass.customerName.toUpperCase();
                    } else {
                        System.out.println("Cabin no " + (Task1DriverClass.cabinNumber + 1) + " has been booked already");
                    }
                } else {
                    System.out.println("Cabin number " + (Task1DriverClass.cabinNumber + 1) + " do not exist");
                }
            } catch (InputMismatchException e) {
                System.out.println("This is not a valid number");

                Task1DriverClass.scanner.next(); // this statement will clear scanner buffer of wrong input otherwise it will
                // loop continuously.
                continue;
            }
            String option = "no";
            while (!option.equals("yes")) {
                System.out.print("\nWould you like to add another guest ? \nPlease enter yes or no: ");
                option = Task1DriverClass.scanner.next();
                option = option.toLowerCase();

                switch (option) {
                    case "yes":
                        continue;
                    case "no":
                        addCustomer = true;
                        break;
                    default:
                        System.out.println("It's not a valid option\n");
                        continue;
                }break;
            }
        }
    }

//  By invoking this method from the main will show all the cabins number and the guests name.
    public static void viewAllCabins(String[] cabins){

        for (   int i = 0; i < cabins.length; i++) {
            System.out.println("Cabin number " + (i + 1) + " booked by " + "guest "+ cabins[i]);
        }

    }

//  By invoking this method from the main will show the user empty cabins only.
    public static void  displayEmptyCabin(String[] cabins){

        for (int i = 0; i < cabins.length; i++) {
            if (cabins[i].equals("empty")) {
                System.out.println("Cabin " + (i + 1) + " = " + cabins[i]);
            }
        }

    }

//   By invoking this method from the main will delete a guest name from the cabins Array.
    public static void  deleteCustomerFromCabin(String[] cabins) {

        for (int i = 0; i < cabins.length; i++) {
            System.out.println("Cabin " + (i + 1) + " = " + (cabins[i]));
        }

        System.out.print("Please enter a guest name to be deleted: ");
        Task1DriverClass.customerName = Task1DriverClass.scanner.next();
        Task1DriverClass.customerName = Task1DriverClass.customerName.toUpperCase();
        boolean testCase = false;

        for (int i = 0; i < cabins.length; i++) {
            if ((cabins[i]).equals(Task1DriverClass.customerName)) {
                cabins[i] = "empty";
                System.out.println("Guest named "+ Task1DriverClass.customerName + " has been deleted from cabin number " + (i + 1));
                testCase = true;
            }
        }
        if (!testCase){
            System.out.println("Guest named " + Task1DriverClass.customerName + " does not exist in the system");
        }
    }

//  By invoking this method from the main will find a cabin number by inputting guest name.
    public static void   findCabinFromCustomerName(String[] cabins){

        System.out.print("Please enter a guest name: ");
        Task1DriverClass.customerName = Task1DriverClass.scanner.next();
        Task1DriverClass.customerName = Task1DriverClass.customerName.toUpperCase();
        boolean testCase = false;

        for (int i = 0; i < cabins.length; i++) {
            if ((cabins[i]).equals(Task1DriverClass.customerName)) {
                System.out.println("Guest named "+ Task1DriverClass.customerName + " booked " + "cabin number " + (i + 1));
                testCase = true;
            }
        }
        if (!testCase){
            System.out.println("Guest named " + Task1DriverClass.customerName + " does not exist in the system");
        }
    }

//    By invoking this method from the main will store all the data from the array to a file named "dataIntoFile.txt"
    public static void   storeDataIntoFile(String fileName,String[] cabins) {

        try {
            FileWriter fileWriter = new FileWriter(fileName); //fileWriter object has been created from class FileWriter
            PrintWriter printWriter = new PrintWriter(fileWriter);//printWriter  object has been created from class PrintWriter
            for ( int i = 0; i < cabins.length; i++) {
                printWriter.println("Cabin number " + (i + 1) + " booked by " + "guest "+ cabins[i]);

            }
            printWriter.close();
        }
        catch (IOException e){
            System.out.println("Error- Cannot write to file "+ fileName);
        }
        System.out.println("Guest information has been written into the file");
    }


//    By invoking this method from the main will load all the data from the file named "dataIntoFile.txt" and output to the console.
    public static void loadDataFromFile (String fileName,String[]cabins) {



        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferReader.readLine()) != null) {

                System.out.println(line);

            }
            bufferReader.close();
        }
        catch (IOException e) {
            System.out.println("Error- Cannot read from file "+ fileName);
        }
    }


    // The function below,sort an Array of string (cabins[12]) using bubble sort.In this case two successive strings
// cabins[i] and cabins[i+1] are swapped around whenever cabins[i] > cabins[i+1].The larger values sink to
// the bottom and smaller values bubble their way to the top.After all iteration,the cabinArray's elements are
// sorted alphabetically

    public static void viewPassengersNameAlphabetically (String[]cabins){
        String[] temporaryArray = cabins.clone();
        String temporaryVariable;
        System.out.println("\nGuest name in alphabetical order:");
//        algorithm for sorting
        for ( int i = 0; i < temporaryArray.length; i++) {         //holds each elements
            for( int j = i+1;j<temporaryArray.length;j++ ){        //check for remaining elements
//              used the compareTo() method to compare and swap the array elements.
                if (temporaryArray[j].compareTo(temporaryArray[i]) < 0){
                    temporaryVariable = temporaryArray[i];
                    temporaryArray[i] = temporaryArray[j];
                    temporaryArray[j] = temporaryVariable;

                }
            }
            System.out.print(temporaryArray[i] + ", ");
        }
        System.out.println();
        }

    }


