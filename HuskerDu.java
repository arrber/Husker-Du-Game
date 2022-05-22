import java.util.*;

public class HuskerDu {
	
	public static void main(String[] args)
	{
		GameBoard();
	}
	
	public static void GameBoard() 
	{
		char[][]  pieces = {
				{'A', '2', '!', 'B', '1', '@', 'C', '6', '$', 'D', '3', '#'},
				{'2', 'A', 'C', 'D', '1', '#', '!', '6', '$', 'B', '3', '@'},
				{'E', '4', 'F', '5', '%', '&', '4', 'F', '%', 'E', '&', '5'}
		};		
		
//		System.out.println(pieces[0][0]);
				
		RotateBoard(pieces);		
		
//		System.out.println(pieces[0][0]);
				
		int[] check = CheckResult(pieces);
		
		System.out.println(check[1]);
		
		DeleteElement(pieces, check[0], check[1], check[2]);
		
		System.out.println(pieces[2].length);
		
		for(int row = 0; row < pieces.length; row++)
		{
			if(pieces[row].length == 0) {
				System.out.println("Game has ended all pices have been unveiled");
				OpenPieces(true);
			}
			else
				CheckResult(pieces);
		}
		
	}
	
	public static char[][] DeleteElement(char[][] element, int affectedRow, int index1, int index2)
	{
		int row = element.length;
		int col = element[row].length;
		
		char[][] new_arr = new char[row][col - 2];
		
	    for(int i = 0, k = 0; i < element[row].length ; i++)
	    {
	    	if(element[affectedRow][i] != index1 && element[affectedRow][i] != index2)
	        {
	    		new_arr[affectedRow][k] = element[affectedRow][i];
	            k++;
	        }
	    }
	    
	    System.out.println(new_arr[0][0]);
		
		return new_arr;
	}
	
	public static char[][] RotateBoard(char[][] rotate)
	{
		for(int row = 0; row < rotate.length; row++)
		{
			int getLastIndex = rotate[row].length - 1;
			int getFirstIndex = rotate[row].length - rotate[row].length;
			char saveFirstElement = rotate[row][getFirstIndex];
						
			for(int col = 0; col < rotate[row].length; col++)
			{			
				if(col == getLastIndex)
				{
					rotate[row][col] = saveFirstElement;	
				} else {					
					rotate[row][col] = rotate[row][col + 1];	
				}
//				System.out.println(rotate[row][col] + "");			
			}	
//			System.out.println();
		}
		return rotate;
	}
	
	private static int[] OpenPieces(boolean ended)
	{
		Scanner input = new Scanner(System.in);
		
		int n = 3;
		
		int[] data = new int[n];
	
		if(!ended)
		{
			
			for(int i = 0; i < n; i++)
			{
				if(i == 0){
					System.out.println("Chose which row you want to open the unveil the piece(From 0 - 2)");
					data[i] = input.nextInt();
				}
				else if(i == 1){
					System.out.println("unveil the first piece!(From 0 - 11)");
					data[i] = input.nextInt();
				}	
				else{
					System.out.println("unveil the second piece!(From 0 - 11)");
					if(data[1] == input.nextInt())
						System.out.println("Pick another number!");
					data[i] = input.nextInt();
//				input.close();
				}
			
			}
		}
		else
			input.close();
		return data;
	}
	
	private static int[] CheckResult(char[][] result)
	{
		int[] data = OpenPieces(false);
		int[] remove = new int[3];

		for(int row = 0; row < result.length; row++)
		{
			if (row == data[0])
			{
				if(result[row][data[1]] == result[row][data[2]]){
					System.out.println("You guessed the right pieces you have one more turn!");
					OpenPieces(false);
					remove[0] = row; // Row
					remove[1] = result[row][data[1]]; // Col
					remove[2] = result[row][data[2]]; // Col
					return remove;
				}
				else{
					System.out.println("You didnt guess the right pieces.(Next Player) The board has been rotated!");
					RotateBoard(result);
					OpenPieces(false);
				}
				row = 0;
			}
			else	
				System.out.println("Invalid Data!");
		}
		return null;
	}
}
