package recursionBacktrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * */
public class SubsetsII 
{
    public List<List<Integer>> subsetsWithDup(int[] nums ) 
    {
    	List<List<Integer>> allSubsets = new LinkedList<>();
    	List<Integer> oneSubset = new LinkedList<>();
    	Arrays.sort( nums );
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
    		if ( i > startPos 
    				&& nums[i] == nums[i-1] )
    		{
    			continue;
    		}
    		
    		oneSubset.add( nums[i] );
    		generateSubsets( allSubsets, oneSubset, nums, i + 1 );
    		oneSubset.remove( oneSubset.size( ) - 1 );
    	}
    }
}