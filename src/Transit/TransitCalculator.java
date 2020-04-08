package Transit;

import java.util.Arrays;

public class TransitCalculator {
	
	
	int days;
	int rides;
	boolean disabilities;
	boolean ageAbove65;
	double[] faresPrices = { 2.75, 33, 127 };
	static double[] reducedFaresPrices = { 1.35, 16.5 , 63.5 };
	String[] faresNames = {"Pay-per-ride (single ride)", "7-day Unlimited Rides", "30-day Unlimited Rides"};
	

	
	public TransitCalculator(int days ,int rides, boolean ageAbove65, boolean disabilities){
		this.days = days;
		this.rides = rides;
		this.ageAbove65 = ageAbove65;
		this.disabilities = disabilities;
		
	}
	
	public double unlimited7Price() {
		
		double totalPrice;
		if (ageAbove65 || disabilities){
			totalPrice = Math.ceil(days/7) * reducedFaresPrices[1];
		} else {
			totalPrice = Math.ceil(days/7) * faresPrices[1];
		}
		
		return  totalPrice / rides;
	}
	
	public double[] getRidePrices() {
		
		double payPerRide = faresPrices[0];
		double sevenDaysRide = unlimited7Price();
		double thirtyDaysRide = faresPrices[2]/ rides;
		
		if (ageAbove65 || disabilities){
			 payPerRide = reducedFaresPrices[0];
			 sevenDaysRide = unlimited7Price();
			 thirtyDaysRide = reducedFaresPrices[2]/ rides;}
		
		double[] ridePrices = { payPerRide, sevenDaysRide, thirtyDaysRide };
		return ridePrices;
			
	}
	
	public String getBestFare() {
		
		double[] allRides = getRidePrices();
		int index = 0;
		
		for (int i = 1; i < allRides.length; i++) {
			if (allRides[i] < allRides[index]) {
				allRides[index] = allRides[i];
				index = i;
			}
			allRides[index] = Math.round(allRides[index] * 100.0) / 100.0;
		}
		
		return "You should get the " + faresNames[index] + " option at $ " +  allRides[index] + " per ride.";
	}
	
	
	public static void main(String[] args) {
		int myRides = 10;
		int myDays = 32; 
		boolean disable = false;
		boolean above65 = false;
		TransitCalculator tc = new TransitCalculator(myRides, myDays, above65, disable);
		
		System.out.println(tc.getBestFare());
		
		
	}
}
