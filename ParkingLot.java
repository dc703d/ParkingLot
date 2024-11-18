import java.util.Arrays;

public class ParkingLot {
    private final int[] motorcycleSpaces;
    private final int[] regularSpaces;
    private final int[] largeSpaces;
    private int motorbikeNumber = 0;
    private int carNumber = 0;
    private int vansNumber = 0;
    ParkingLot(int numberOfMotorcycleSpaces, int numberOfRegularSpaces, int numberOfLargeSpaces ){
        motorcycleSpaces = new int[numberOfMotorcycleSpaces];
        Arrays.fill(motorcycleSpaces,0);
        regularSpaces = new int[numberOfRegularSpaces];
        Arrays.fill(regularSpaces,0);
        largeSpaces = new int[numberOfLargeSpaces];
        Arrays.fill(largeSpaces,0);
    }


    public void totalSpots(){
        int totalSpots = motorcycleSpaces.length + regularSpaces.length + largeSpaces.length;
        System.out.println("There are " + totalSpots + " total spots in the parking lot.");
    }

    public int checkMotorcycleSpots(){
        int availabeSpots = motorcycleSpaces.length;
        for(int i=0; i<motorcycleSpaces.length;i++) {
            if (motorcycleSpaces[i] == 1) {
                availabeSpots--;
            }
        }
        return availabeSpots;
    }

    public int checkRegularSpots(){
        int availabeSpots = regularSpaces.length;
        for(int i=0; i<regularSpaces.length;i++) {
            if (regularSpaces[i] == 1) {
                availabeSpots--;
            }
        }
        return availabeSpots;
    }

    public int checkLargeSpots(){
        int availabeSpots = largeSpaces.length;
        for(int i=0; i<largeSpaces.length;i++) {
            if (largeSpaces[i] == 1) {
                availabeSpots--;
            }
        }
        return availabeSpots;
    }

    public void currentStatus(){
        System.out.println("There are currently " + checkMotorcycleSpots() + " motorcycle spaces, " + checkRegularSpots() + " regular spaces, and " + checkLargeSpots() + " large spaces available.");
    }

    public int checkRegularForVan(){
        for(int i=0;i<regularSpaces.length-2;i++){
            if(regularSpaces[i] == 0 && regularSpaces[i+1] == 0 && regularSpaces[i+2] == 0) {
                return i;
            }
        }
        return -1;
    }

    public void leaveMotorcycle(int number){
        motorcycleSpaces[number-1] = 0;
    }
    public void leaveRegular(int number){
        regularSpaces[number-1] = 0;
    }
    public void leaveLarge(int number){
        largeSpaces[number-1] = 0;
    }

    public void leaveRegularforVan(int number){
        regularSpaces[number-1] = 0;
        regularSpaces[number] = 0;
        regularSpaces[number+1] = 0;
    }

    public int parkMotorcycle(){
        for(int i=0;i<motorcycleSpaces.length;i++){
            if(motorcycleSpaces[i] == 0){
                motorcycleSpaces[i] = 1;
                return i;
            }
        }
        return -1;
    }
    public int parkRegular(){
        for(int i=0;i<regularSpaces.length;i++){
            if(regularSpaces[i] == 0){
                regularSpaces[i] = 1;
                return i;
            }
        }
        return -1;
    }
    public int parkLarge(){
        for(int i=0;i<largeSpaces.length;i++){
            if(largeSpaces[i] == 0){
                largeSpaces[i] = 1;
                return i;
            }
        }
        return -1;
    }

    public int parkRegularforVan(){
        for(int i=0;i<regularSpaces.length;i++){
            if(regularSpaces[i] == 0 && regularSpaces[i+1] == 0 && regularSpaces[i+2] == 0) {
                regularSpaces[i] = 1;
                regularSpaces[i+1] = 1;
                regularSpaces[i+2] = 1;
                return i;
            }
        }
        return -1;
    }

    public void increaseMotorbikeNumber(){
        motorbikeNumber++;
    }
    public void increaseCarNumber(){
       carNumber++;
    }
    public void increaseVansNumber(){
        vansNumber++;
    }

    public void decreaseMotorbikeNumber(){
        motorbikeNumber--;
    }
    public void decreaseCarNumber(){
        carNumber--;
    }
    public void decreaseVansNumber(){
        vansNumber--;
    }

    public int getMotorbikeNumber(){
        return motorbikeNumber;
    }
    public int getCarNumber(){
        return carNumber;
    }
    public int getVansNumber(){
        return vansNumber;
    }


}
