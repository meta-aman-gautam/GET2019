
public class Recursion {
	
	private int value =1;
	private int remainder =-1;
	
	public int lcm(int a,int b) {
		int min =Math.min(a, b);
		int max =Math.max(a, b);
		for(int count=min;count>=1;count--) {
			if(min%count==0 && max%count==0 && count!=1) {
				value =count;
				a= a/count;
				b= b/count;
				return value *lcm(a,b);	
			}
			else if(count == 1) {
				value=a*b;
			}
		}
		return value;	
	}
	
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
