package set_Operations;

import static org.junit.Assert.*;

import java.lang.Character.Subset;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IntSetTest {
	

	private int member  ;
	private boolean value ;
	private boolean expectedValue ;
	private boolean intSet;
	private int expectedLength;
	private int sizeOfSet ;
	private boolean subSet;
	private int Array[];
	private int []intSet_Expected;
	private int intSet_1[];
	
	
	
	public IntSetTest(boolean expectedValue ,boolean intSet , 
			int expectedLength ,int sizeOfSet,
			 boolean subSet ,boolean value ,
			 int Array[],
			 int intSet_Expected[] ,int intSet_1[]) {
		
		//is memeber test
		this.intSet = intSet;
		this.expectedValue =expectedValue;
		
		// sizeOfSet
		this.expectedLength =expectedLength  ;
		this.sizeOfSet = sizeOfSet;
		
		//is Subset Test
		this.value = value ;
		this.subSet = subSet ;
		//compliment 
		this.Array =Array ;
		
		//is union Test
		this.intSet_Expected =intSet_Expected ;
		this.intSet_1 = intSet_1 ;
	}
	
	
	
	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{   true ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).isMember(5),
					new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).set.length ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).sizeOfSet(),
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18,40 }).isSubset(new IntSet(new int[] { 8, 15, 40 })),true,
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 }).getCompliment().set,
					new int[] { 1, 3, 5, 8, 12, 15, 18, 40, 2, 4, 7 } , IntSet.union(new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 }), new IntSet(new int[] { 3, 2, 5, 4, 7, 8 })).set },
				
				{	new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).isMember(18),true ,
					new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).set.length ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).sizeOfSet(),
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18,40 }).isSubset(new IntSet(new int[] { 8, 15, 40 })),true,
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 }).getCompliment().set,
					new int[] { 1, 3, 5, 8,  40, 2, 4, 7 } , IntSet.union(new IntSet(new int[] { 1, 3, 5, 8, 40 }), new IntSet(new int[] { 3, 2, 5, 4, 7, 8 })).set },
					
		
		});
	}
	
	/**
	 * Test case when input set is empty
	 */
	@Test(expected = AssertionError.class)
	public void setIsEmptyTest() {
		IntSet intSet = new IntSet(new int[] {});
	}
	
	@Test
	public void isMemberTest() {
		assertEquals(expectedValue, intSet);
	}

	@Test
	public void sizeTest() {
		//IntSet intSet = new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 });
		assertEquals(expectedLength, sizeOfSet);
	}

	@Test
	public void isSubSetTest() {
		assertEquals(value, subSet);
	}

	@Test
	public void complimentTest() {
		IntSet intSet = new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 });
		int[] expectedArray = new int[1000 - intSet.set.length];
		int j = 0;
		for (int i = 0; i < 1000; i++) {
			if (!(intSet.isMember(i + 1))) {
				expectedArray[j] = i + 1;
				j++;
			}
		}
		assertArrayEquals(expectedArray, Array);
	}
	
	@Test
	public void unionTest() {
		assertArrayEquals(intSet_Expected,intSet_1);
	}
	

}
