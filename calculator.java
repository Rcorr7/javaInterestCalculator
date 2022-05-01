public class calculator {
	
	String price;
	
	String tax;
	
	String downPayment;
	
	String numOfMonths;
	
	String InterestRate;
	
	String totalInterestPaid;
	
	String monthlyPayments;
	
	String totalOwned;
	
	double totalInterestPaidCal;

    protected String SalesTax;

	public double totalInterest(double principal, double interestRate, double time) {
		double totalInt=0;
		
		interestRate = interestRate/100;
		
		totalInt = principal*(1+(interestRate*time));
		
		
		
		
		
		return totalInt;
	}

}