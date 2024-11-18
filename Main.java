import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(12,12,12);
        boolean option1Chosen = false;
        System.out.println("Welcome to the parking lot. Would you like to get some information or park a vehicle?");
        while(!option1Chosen) {
            System.out.println("A) Get Information\nB) Park a Vehicle");
            Scanner scanner = new Scanner(System.in);
            String infoOrPark = scanner.next();
            if (infoOrPark.equals("A") || infoOrPark.equals("a")) {
                option1Chosen = true;
            } else if (infoOrPark.equals("B") || infoOrPark.equals("b")) {
                option1Chosen = true;

            } else {
                System.out.println("Please enter a valid option");
            }
        }

        System.out.println("A) Motorcycle\nB) Car\nC) Van");
        parkingLot.remainingSpots();
        parkingLot.currentStatus();
    }
}
