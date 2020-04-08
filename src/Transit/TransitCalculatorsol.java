import java.util.Arrays;

public class TransitCalculator {

    String[] fareOptions = {"Pay-per-ride", "7-day Unlimited", "30-day Unlimited"};
    double[] fares = {2.75, 33.0, 127.0};

    int rides;
    int days;

    public TransitCalculator(int numRides, int numDays) {

        rides = numRides;
        days = numDays;

    }

    public double unlimited7Price() {

        double sevenDayPurchases = Math.ceil(days / 7.0);
        double total7DayCost = sevenDayPurchases * fares[1];

        return total7DayCost / rides;

    }

    public double[] getRidePrices() {

        double pprPrice = fares[0];
        double unlimited7Price = unlimited7Price();
        double unlimited30Price = fares[2] / rides;
      
        double prices[] = {pprPrice, unlimited7Price, unlimited30Price};
        return prices;
      
    }
    
    public String getBestFare() {

        double[] ridePrices = getRidePrices();
        int winningIndex = 0;

        for (int i = 0; i < ridePrices.length; i++) {
            
            if (ridePrices[i] < ridePrices[winningIndex]){

                winningIndex = i;

            }

        }

        return "You should get the " + fareOptions[winningIndex] + " option at $" + Math.round(ridePrices[winningIndex] * 100.0) / 100.0 + " per ride.";
    }

    public static void main(String[] args) {

        int myRides = 12;
        int myDays = 5;

        TransitCalculator transitCalc = new TransitCalculator(myRides, myDays);
        
        System.out.println(transitCalc.getBestFare());

    }

}