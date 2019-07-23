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
	private boolean value, expectedValue ;
	IntSet intSet,sizeOfSet,expectedLength,subSet,subSetValue;
	private int []intSet_Expected,intSet_1,intSet_2,Array;

	public IntSetTest(boolean expectedValue ,IntSet intSet ,int member, 
						IntSet expectedLength ,IntSet sizeOfSet, 
						IntSet subSet ,boolean value ,IntSet subSetValue,
						int Array[],
						int intSet_Expected[] ,int[] intSet_1 ,int[] intSet_2) {
		
		//is member test
		this.member = member;
		this.intSet = intSet;
		this.expectedValue =expectedValue;
		// sizeOfSet
		this.expectedLength =expectedLength  ;
		this.sizeOfSet = sizeOfSet;
		//is Subset Test
		this.value = value ;
		this.subSet = subSet ;
		this.subSetValue = subSetValue;
		//compliment 
		this.Array =Array ;
		//is union Test
		this.intSet_Expected =intSet_Expected ;
		this.intSet_1 = intSet_1 ;
		this.intSet_2 = intSet_2 ;
	}

	@Parameterized.Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{   true ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }),5 ,
					new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }) ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }),
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18,40 }),true,new IntSet(new int[] { 8, 15, 40 }),
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 }).getCompliment().set,
					new int[] { 1, 3, 5, 8, 12, 15, 18, 40, 2, 4, 7 } ,new int[] { 1, 3, 5, 8, 12, 15, 18, 40 }, new int[] { 3, 2, 5, 4, 7, 8 } },
				{	true ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }), 18,
					new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }) ,new IntSet(new int[]{1, 3, 5, 8, 12, 15, 18, 40 }),
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18,40 }),true, new IntSet(new int[] { 8, 15,18, 40 }),
					new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 }).getCompliment().set,
					new int[] { 1, 3, 5, 8,  40, 2, 4, 7 } , new int[] { 1, 3, 5, 8, 40 }, new int[] { 3, 2, 5, 4, 7, 8 } },		
		});
	}
	
	//Test case when input set is empty
	@Test(expected = AssertionError.class)
	public void testForEmptySet() {
		IntSet intSet = new IntSet(new int[] {});
	}
	
	@Test  //membership test
	public void testForMember() {
		assertEquals(expectedValue, intSet.isMember(member));
	}

	@Test  //Size test of Set
	public void testForSetSize() {
		assertEquals(expectedLength.set.length, sizeOfSet.sizeOfSet());
	}

	@Test  //test for Subset
	public void testForSubset() {
		assertEquals(value, subSet.isSubset(subSetValue));
	}

	@Test //test for compliment
	public void testForCompliment() {
		IntSet intSet = new IntSet(new int[] { 1, 3, 5, 8, 12, 15, 18, 40 });
		int[] expectedArray = new int[1000 - intSet.set.length];
		int count_j = 0;
		for (int count_i = 0; count_i < 1000; count_i++) {
			if (!(intSet.isMember(count_i + 1))) {
				expectedArray[count_j] = count_i + 1;
				count_j++;
			}
		}
		assertArrayEquals(expectedArray, Array);
	}
	
	@Test  //test for union
	public void testForSetUnion() {
		IntSet intSet3 = new IntSet(intSet_1);
		IntSet intSet4 = new IntSet(intSet_2);
		assertArrayEquals(intSet_Expected, intSet3.union(intSet3, intSet4));
	}
}
