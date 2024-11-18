import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ParkingLot {
    private int[] motorcycleSpaces;
    private int[] regularSpaces;
    private int[] largeSpaces;

    ParkingLot(int numberOfMotorcycleSpaces, int numberOfRegularSpaces, int numberOfLargeSpaces ){
        motorcycleSpaces = new int[numberOfMotorcycleSpaces];
        Arrays.fill(motorcycleSpaces,0);
        regularSpaces = new int[numberOfRegularSpaces];
        Arrays.fill(regularSpaces,0);
        largeSpaces = new int[numberOfLargeSpaces];
        Arrays.fill(largeSpaces,0);
    }

    public void remainingSpots() {
        int remaining = 0;
        for(int i=0;i<motorcycleSpaces.length;i++){
            if(motorcycleSpaces[i] == 0){
                remaining++;
            }
        }
        for(int j=0;j<regularSpaces.length;j++){
            if(regularSpaces[j] == 0){
                remaining++;
            }
        }
        for(int k=0;k<regularSpaces.length;k++){
            if(regularSpaces[k] == 0){
                remaining++;
            }
        }
        System.out.println("There are "+ remaining + " spots remaining.");
    }

    public void totalSpots(){
        int totalSpots = motorcycleSpaces.length + regularSpaces.length + largeSpaces.length;
        System.out.println("There are " + totalSpots + " total spots.");
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
        for(int i=0;i<regularSpaces.length;i++){
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
}
