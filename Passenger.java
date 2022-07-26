package circularQueueSolution;


/** This class hold all the instance variable, getter and setter methods for each cabin object*/
public class Passenger {

        private String firstName;
        private String lastName;
        private double expense;

        //this is the constructor method
        public Passenger(String firstName, String lastName, double expense){
            this.firstName = firstName;
            this.lastName = lastName;
            this.expense = expense;
        }

        public Passenger() {
            this.firstName = "empty";
            this.lastName = "empty";
            this.expense = 0;
        }

        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {this.firstName = firstName;}

        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public double getExpense() {
            return expense;
        }
        public void setExpense(double expense) {
            this.expense = expense;
        }

        @Override
        public String toString(){
            String info = "\nFirst name: "+ firstName+ "" +"\nLast name: " + lastName +"" + "\nExpense: "+ expense + "\n";
            return info;
        }

    }


