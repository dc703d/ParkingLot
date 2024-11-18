import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int motorCycleSpots = 10;
        final int regularSpots = 12;
        final int largeSpots = 10;
        ParkingLot parkingLot = new ParkingLot(motorCycleSpots,regularSpots,largeSpots);
        boolean option1Chosen = false;
        boolean option2Chosen = false;
        System.out.println("Welcome to the parking lot. Would you like to get some information, park a vehicle or leave the lot?");
        while(!option1Chosen) {
            System.out.println("A) Get Information\nB) Park a Vehicle\nC) Leave the Lot");
            Scanner scanner = new Scanner(System.in);
            String infoParkOrLeave = scanner.next();
            if (infoParkOrLeave.equals("A") || infoParkOrLeave.equals("a")) {
                option1Chosen = true;
            }
            else if (infoParkOrLeave.equals("B") || infoParkOrLeave.equals("b")) {
                option1Chosen = true;
                System.out.println("What vehicle would you like to park?");
                while (!option2Chosen) {
                    System.out.println("A) Motorcycle\nB) Car\nC) Van");
                    String vehicle = scanner.next();
                    int remainingMotorcycleSpots = parkingLot.checkMotorcycleSpots();
                    int remainingRegularSpots = parkingLot.checkRegularSpots();
                    int remainingLargeSpots = parkingLot.checkLargeSpots();

                    switch (vehicle) {
                        case "A", "a" -> {
                            option2Chosen = true;
                            if (remainingMotorcycleSpots != 0) {
                                System.out.println("Please park in spot M" + (motorCycleSpots - remainingMotorcycleSpots + 1));
                            } else if (remainingRegularSpots != 0) {
                                System.out.println("There are currently no motorcycle spots available. Please park in spot R" + (regularSpots - remainingRegularSpots + 1));
                            } else if (remainingLargeSpots != 0) {
                                System.out.println("There are currently no motorcycle or regular spots available. Please park in spot L" + (largeSpots - remainingLargeSpots + 1));
                            } else {
                                System.out.println("Sorry. The parking lot is currently at full capacity.");
                            }
                        }
                        case "B", "b" -> {
                            option2Chosen = true;
                            if (remainingRegularSpots != 0) {
                                System.out.println("Please park in spot R" + (regularSpots - remainingRegularSpots + 1));
                            } else if (remainingLargeSpots != 0) {
                                System.out.println("There are currently no regular spots available. Please park in spot L" + (largeSpots - remainingLargeSpots + 1));
                            } else {
                                System.out.println("Sorry. The parking lot is currently at full capacity.");
                            }
                        }
                        case "C", "c" -> {
                            option2Chosen = true;
                            if (remainingLargeSpots != 0) {
                                System.out.println("Please park in spot L" + (largeSpots - remainingLargeSpots + 1));
                            } else if (parkingLot.checkRegularForVan() != -1) {
                                int regularsForVan = parkingLot.checkRegularForVan();
                                System.out.println("There are currently no large spots available. Please park in spots R" + (regularsForVan + 1) + " - R" + (regularsForVan + 3));
                            } else {
                                System.out.println("Sorry. The parking lot is currently at full capacity.");
                            }
                        }
                        default -> System.out.println("Please enter a valid option");
                    }
                }

            } 
            else if (infoParkOrLeave.equals("C") || infoParkOrLeave.equals("c")) {
                System.out.println("Were you parked in a motorcycle, regular or large spot?");
                System.out.println("A) Motorcycle\nB) Regular\nC) Large");
                String occupiedSpotType = scanner.next();
                System.out.println("What number spot were you in?");
                int occupiedSpotNumber = scanner.nextInt();
            } else {
                System.out.println("Please enter a valid option");
            }

        }


        parkingLot.remainingSpots();
        parkingLot.currentStatus();
    }
}
