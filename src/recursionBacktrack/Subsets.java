package recursionBacktrack;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
] 
 * */
public class Subsets 
{
    public List<List<Integer>> subsets( int[] nums ) 
    {
    	List<List<Integer>> allSubsets = new LinkedList<>();
    	List<Integer> oneSubset = new LinkedList<>();
    	generateSubsets( allSubsets, oneSubset, nums, 0 );
    	return allSubsets;
    }
    
    private void generateSubsets( List<List<Integer>> allSubsets, List<Integer> oneSubset, int[] nums, int startPos )
    {
    	// recursion base
    	if ( startPos > nums.length )
    	{
    		return;
    	}
    	
    	allSubsets.add( new LinkedList<>( oneSubset ) );
    	
    	// recursion body
    	for ( int i = startPos; i < nums.length; i++ )
    	{
    		oneSubset.add( nums[i] );
    		generateSubsets( allSubsets, oneSubset, nums, i + 1 );
    		oneSubset.remove( oneSubset.size( ) - 1 );
    	}
    }

    @Test
    public void test()
    {
    	System.out.println( subsets( new int[]{ 1, 2, 3 } ) );
    }
}
