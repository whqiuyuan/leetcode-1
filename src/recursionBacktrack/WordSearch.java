package recursionBacktrack;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class WordSearch 
{
    public boolean exist( char[][] board, String word )
    {
    	if ( word == null
    			|| board.length == 0 
    			|| board[0].length == 0 )
    	{
    		throw new IllegalArgumentException("");
    	}
    	
    	for ( int i = 0; i < board.length; i++ )
    	{
    		for ( int j = 0; j < board[0].length; j++ )
    		{
    			if ( dfs( board, i, j, word, 0, new HashSet<>() ) )
    			{
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    private boolean dfs( char[][] board, int startX, int startY, String word, int strPos, Set<Integer> visited )
    {
    	if ( startX >= board.length 
    			|| startY >= board[0].length
    			|| startX < 0
    			|| startY < 0
    			|| visited.contains( getCoorHash( startX, startY, board ) )
    			|| strPos >= word.length() 
    			|| word.charAt( strPos ) != board[startX][startY] )
    	{
    		return false;
    	}    	    	

    	if ( strPos == word.length() - 1 )
    	{
    		return true;
    	}
    	
    	visited.add( getCoorHash( startX, startY, board ) );
    	
    	
    	// recursion body
    	if ( dfs( board, startX + 1, startY, word, strPos + 1, visited ) 
    			|| dfs( board, startX, startY + 1, word, strPos + 1, visited ) 
    			|| dfs( board, startX - 1, startY, word, strPos + 1, visited ) 
    			|| dfs( board, startX, startY - 1, word, strPos + 1, visited ) )
    	{
    		return true;
    	}
    	
    	visited.remove( getCoorHash( startX, startY, board ) );
    	return false;
    }
    
    private int getCoorHash( int xCoor, int yCoor, char[][] board )
    {
    	return xCoor * board[0].length + yCoor;
    }
    
    @Test
    public void test()
    {
    	char[][] board = new char[][]{ {'A', 'B', 'C', 'E'},
    								   {'S', 'F', 'C', 'S'},
    								   {'A', 'D', 'E', 'E'} };
    	assertTrue( exist( board, "ABCCED" ) );
    	
    	char[][] board2 = new char[][]{ {'a'} };
    	assertTrue( exist( board2, "a" ) );
    }
}