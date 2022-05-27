# Husker-Du-Game Crap Edition Doc

University of Prishtina 2022;

Java project 

Rregullat dhe Loja

Loja:
    - Rrota e figures
    - Paneli(Kartoni) i lojes
    - 36 Pjes te figurave

Rregullat:
    - Lojtari me i ri hap i pari the hek 2 nga pjeset nese pjeset e zbuluara jan identike athere ai vazhdon te luaj deri sa te gaboj nese ato nuk jan identike athere ai vendos prap pjeset ne vendet e tyre dhe rrota e figurave sillet nje her loja vazhdon derisa te gjitha figurat te jen zbuluar.

Shqarimi i kodit:

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
				//System.out.println(rotate[row][col] + "");			
			}	
			//System.out.println();
		}
		return rotate;
	}

Ky funksion ben rrotullimin e rrotes se figurave merr si 2d array panelin e lojes dhe i zhvendos elementet nga nje djathtas kurse elementi i fundit behet i pari.

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

Ky funksion ben fshirjen e figurave nga paneli i lojes dmth figurat e hapura qe te mos hapen ma.


