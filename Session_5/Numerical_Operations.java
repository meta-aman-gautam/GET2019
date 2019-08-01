/**
 * This is Recursion class which is used to calculate the LCM and HCF using Recursion
 * 
 * @author Aman Gautam
 * Dated 21/07/2019
 */
public class Numerical_Operations {
	
	private int value =1 ,remainder =-1;
	
	//Calculating LCM
	public int lcm(int a,int b) {
		int min =Math.min(a, b);
		int max =Math.max(a, b);
		for(int count=min;count>=1;count--) {
			if(min%count==0 && max%count==0 && count!=1) {
				value =count;
				a= a/count;
				b= b/count;
				//calling Recursion
				return value *lcm(a,b);	
			}
			else if(count == 1) {
				value=a*b;
			}
		}
		return value;	
	}
	
	// Calculating using Euclid method
	public int hcf(int divisor, int dividend){
		remainder = dividend%divisor ;
		if(remainder==0)
			value= divisor ;
		else {
			dividend = divisor;
			divisor =remainder ;
			hcf(divisor ,dividend);
		}			
		return value;		
	}
}
