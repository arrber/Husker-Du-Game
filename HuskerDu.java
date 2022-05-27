import java.util.*;

public class HuskerDu {
	
	public static char[][]  GameBoard = {
			{'A', '2', '!', 'B', '1', '@', 'C', '6', '$', 'D', '3', '#'},
			{'2', 'A', 'C', 'D', '1', '#', '!', '6', '$', 'B', '3', '@'},
			{'E', '4', 'F', '5', '%', '&', '4', 'F', '%', 'E', '&', '5'}
	};
	
	
	public static void main(String[] args)
	{
		for(int rows = 0; rows < GameBoard.length; rows++)
		{
			if(GameBoard[rows].length == 0)
			{
				System.out.println("Game playing pieces have been unvieled. You have finished the game!");
			}
			else {
				CheckResult();	
			}
		}
	}
	
	private static int[] OpenPieces(boolean ended)
	{
		Scanner input = new Scanner(System.in);
		
		int n = 3;
		
		int[] data = new int[n];
				
		if(!ended)
		{
			
		
			System.out.println("Chose which row you want to open to unveil the piece(From 0 - 2)");
			data[0] = input.nextInt();
			if(data[0] > 2)
			{
				System.out.println("Type a number between 0 - 2!");
				data[0] = input.nextInt();
			}
			
			System.out.println("unveil the first piece!(From 0 - 11)");
			data[1] = input.nextInt();
			if(data[1] > 11)
			{
				System.out.println("Type a number between 0 - 11!");	
				data[1] = input.nextInt();
			}

	
			System.out.println("unveil the second piece!(From 0 - 11)");
			data[2] = input.nextInt();
			if(data[2] > 11)
			{
				System.out.println("Type a number between 0 - 11!");
				data[2] = input.nextInt();
				
				
			}
			else if(data[2] == data[1])
			{
				System.out.println("That figure is already opened");
				data[2] = input.nextInt();
			}

//			System.out.println(data[0]);
//			System.out.println(data[1]);
//			System.out.println(data[2]);
			
				
		}
		else {
			input.close();	
		}
			
		return data;
	}
	
	private static boolean CheckResult()
	{
		int[] data = OpenPieces(false);
//		System.out.println(data[0]);
		int[] remove = new int[3];
								
		for(int row = 0; row < GameBoard.length; row++)
		{
			if (row == data[0])
			{
				if(GameBoard[row][data[1]] == GameBoard[row][data[2]])
				{
					System.out.println("You guessed the right pieces you have one more turn!");
					remove[0] = data[0]; // Row
					remove[1] = GameBoard[row][data[1]]; // Col
					remove[2] = GameBoard[row][data[2]]; // Col
					
					GameBoard = DeleteElement(GameBoard, remove[0], remove[1], remove[2]);
					
					OpenPieces(false);
					
					return true;
				}
				else{
					System.out.println("You didnt guess the right pieces.(Next Player) The board has been rotated!");
					RotateBoard(GameBoard);
					OpenPieces(false);
					
					return false;
				}
			}
			else	
				System.out.println("Invalid Data!");
		}
		return true;
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
}
