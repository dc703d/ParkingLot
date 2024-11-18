import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final int motorCycleSpots = 3000;
        final int regularSpots = 50000;
        final int largeSpots = 1000;
        ParkingLot parkingLot = new ParkingLot(motorCycleSpots, regularSpots, largeSpots);
        boolean option1Chosen = false;
        boolean option2Chosen = false;
        while (true) {
            System.out.println("\nWelcome to the parking lot. Would you like to get some information, park a vehicle or leave the lot?");
            while (!option1Chosen) {
                System.out.println("A) Get Information\nB) Park a Vehicle\nC) Leave the Lot");
                Scanner scanner = new Scanner(System.in);
                String infoParkOrLeave = scanner.next();
                if (infoParkOrLeave.equals("A") || infoParkOrLeave.equals("a")) {
                    option1Chosen = true;
                    System.out.println("A) Total Number of Spots in Parking Lot");
                    System.out.println("B) Current Status of Parking Lot");
                    System.out.println("C) How Many Spots Are Motorbikes Occupying");
                    System.out.println("D) How Many Spots Are Cars Occupying");
                    System.out.println("E) How Many Spots Are Vans Occupying");
                    System.out.println("F) How Many Vehicles Are Parked");
                    String question = scanner.next();
                    switch (question) {
                        case "A", "a" -> parkingLot.totalSpots();
                        case "B", "b" -> parkingLot.currentStatus();
                        case "C", "c" -> System.out.println("There are currently " + parkingLot.getMotorbikeNumber() + " motorcycles in the lot. ");
                        case "D", "d" -> System.out.println("There are currently " + parkingLot.getCarNumber() + " cars in the lot. ");
                        case "E", "e" -> System.out.println("There are currently " + parkingLot.getVansNumber() + " vans in the lot. ");
                        case "F", "f" -> System.out.println("There are currently " + ((parkingLot.getMotorbikeNumber() + parkingLot.getCarNumber() + parkingLot.getVansNumber()) + " vehicles in the lot. "));

                    }
                } else if (infoParkOrLeave.equals("B") || infoParkOrLeave.equals("b")) {
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
                                    System.out.println("Please park in spot M" + (parkingLot.parkMotorcycle() + 1));
                                    parkingLot.increaseMotorbikeNumber();
                                } else if (remainingRegularSpots != 0) {
                                    System.out.println("There are currently no motorcycle spots available. Please park in spot R" + (parkingLot.parkRegular() + 1));
                                    parkingLot.increaseMotorbikeNumber();
                                } else if (remainingLargeSpots != 0) {
                                    System.out.println("There are currently no motorcycle or regular spots available. Please park in spot L" + (parkingLot.parkLarge() + 1));
                                    parkingLot.increaseMotorbikeNumber();
                                } else {
                                    System.out.println("Sorry. The parking lot is currently at full capacity.");
                                }
                            }
                            case "B", "b" -> {
                                option2Chosen = true;
                                if (remainingRegularSpots != 0) {
                                    System.out.println("Please park in spot R" + (parkingLot.parkRegular() + 1));
                                    parkingLot.increaseCarNumber();
                                } else if (remainingLargeSpots != 0) {
                                    System.out.println("There are currently no regular spots available. Please park in spot L" + (parkingLot.parkLarge() + 1));
                                    parkingLot.increaseCarNumber();
                                } else {
                                    System.out.println("Sorry. The parking lot is currently at full capacity.");
                                }
                            }
                            case "C", "c" -> {
                                option2Chosen = true;
                                if (remainingLargeSpots != 0) {
                                    System.out.println("Please park in spot L" + (parkingLot.parkLarge() + 1));
                                    parkingLot.increaseVansNumber();
                                } else if (parkingLot.checkRegularForVan() != -1) {
                                    int regularsForVan = parkingLot.checkRegularForVan();
                                    parkingLot.parkRegularforVan();
                                    System.out.println("There are currently no large spots available. Please park in spots R" + (regularsForVan + 1) + " - R" + (regularsForVan + 3));
                                    parkingLot.increaseVansNumber();
                                } else {
                                    System.out.println("Sorry. The parking lot is currently at full capacity.");
                                }
                            }
                            default -> System.out.println("Please enter a valid option");
                        }
                    }

                } else if (infoParkOrLeave.equals("C") || infoParkOrLeave.equals("c")) {
                    option1Chosen = true;
                    System.out.println("What vehicle did you park?");
                    System.out.println("A) Motorcycle\nB) Car\nC) Van");
                    String occupiedVehicleType = scanner.next();
                    System.out.println("Were you parked in a motorcycle, regular or large spot?");
                    System.out.println("A) Motorcycle\nB) Regular\nC) Large");
                    String occupiedSpotType = scanner.next();
                    System.out.println("What number spot were you in? If you parked a van in regular spots please enter the first bay you occupied.");
                    int occupiedSpotNumber = scanner.nextInt();

                    switch (occupiedSpotType) {
                        case "A", "a" -> {
                            parkingLot.leaveMotorcycle(occupiedSpotNumber);
                            parkingLot.decreaseMotorbikeNumber();
                            System.out.println("Thank you for staying with us.");
                        }
                        case "B", "b" -> {
                            if(occupiedVehicleType.equals("C") || occupiedVehicleType.equals("c")){
                                parkingLot.leaveRegularforVan(occupiedSpotNumber);
                                parkingLot.decreaseVansNumber();
                            }else {
                                parkingLot.leaveRegular(occupiedSpotNumber);
                                parkingLot.decreaseCarNumber();
                            }
                            System.out.println("Thank you for staying with us.");
                        }
                        case "C", "c" -> {
                            parkingLot.leaveLarge(occupiedSpotNumber);
                            parkingLot.decreaseVansNumber();
                            System.out.println("Thank you for staying with us.");
                        }
                    }
                } else {
                    System.out.println("Please enter a valid option");
                }

            }
            option1Chosen = false;
            option2Chosen = false;

        }

    }
}
