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
				{   	true ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).isMember(5),
					new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).set.length ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).sizeOfSet(),
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18,40 }).isSubset(new IntSet(new int[] { 8, 15, 40 })),true,
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 }).getCompliment().set,
					new int[] { 1, 3, 5, 8, 12, 15, 18, 40, 2, 4, 7 } , IntSet.union(new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 }), new IntSet(new int[] { 3, 2, 5, 4, 7, 8 })).set },
				
				{	true ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }).isMember(18),
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
	public void testForEmptySet() {
		IntSet intSet = new IntSet(new int[] {});
	}
	
	@Test  //test wether value is a member of set or not
	public void testForMembership() {
		assertEquals(expectedValue, intSet);
	}

	@Test  //test for Size of Set 
	public void testForSizeOfSet() {
		assertEquals(expectedLength, sizeOfSet);
	}

	@Test   //test for Subset
	public void testForSubset() {
		assertEquals(value, subSet);
	}

	@Test  //test for compliment
	public void testForCompliment() {
		/*
		*here the intSet is taken before hand 
		*/
		IntSet intSet = new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 });
		int[] expectedArray = new int[1000 - intSet.set.length];
		int count_j = 0;
		for (int count_i= 0;count_i < 1000; count_i++) {
			if (!(intSet.isMember(count_i + 1))) {
				expectedArray[count_j] = count_i + 1;
				count_j++;
			}
		}
		assertArrayEquals(expectedArray, Array);
	}
	
	@Test  //union TestCase
	public void testForSetUnion() {
		assertArrayEquals(intSet_Expected,intSet_1);
	}

}
