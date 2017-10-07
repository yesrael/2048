

import java.util.ArrayList;



public class BL {
	private int[][] _gameMatrix;
	private int score;

	public BL() {
		this._gameMatrix = new int[4][4];
		this.score=0;
	}

	public int[][] getGameMatrix() {
		return _gameMatrix;
	}
	
	public int getScore()
	{
		return this.score;
	}

	public void Initialization() {
		int value1 = randomValue();
		int value2 = randomValue();
		try {
			Index emptyIndex = this.getEmptyIndex();
			this._gameMatrix[emptyIndex.getRow()][emptyIndex.getColumn()] = value1;
			Index emptyIndex2 = this.getEmptyIndex();
			this._gameMatrix[emptyIndex2.getRow()][emptyIndex2.getColumn()] = value2;
		} catch (Exception e) {
		}
	}
	
	
	public void newGame() {
		this.score=0;
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				_gameMatrix[i][j]=0;
				
		int value1 = randomValue();
		int value2 = randomValue();
		try {
			Index emptyIndex = this.getEmptyIndex();
			this._gameMatrix[emptyIndex.getRow()][emptyIndex.getColumn()] = value1;
			Index emptyIndex2 = this.getEmptyIndex();
			this._gameMatrix[emptyIndex2.getRow()][emptyIndex2.getColumn()] = value2;
		} catch (Exception e) {
		}
	}
	
	public void AddValueInEmptyIndex() {
		int value = randomValue();
		try {
			Index emptyIndex = this.getEmptyIndex();
			this._gameMatrix[emptyIndex.getRow()][emptyIndex.getColumn()] = value;
		    }
		catch (Exception e) {
		}
	}

	public int randomValue() {
		double random = Math.random();
		if (random <= 0.25)
			return 4;
		else
			return 2;
	}

	public Index getEmptyIndex() throws Exception {
		ArrayList<Index> arrOfEmptyIndexes = new ArrayList<Index>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (_gameMatrix[i][j] == 0) {
					Index emptyIndex = new Index(i, j);
					arrOfEmptyIndexes.add(emptyIndex);
				}
			}
		}
		if (arrOfEmptyIndexes.size() == 0)
			throw new Exception("There is no empty indexses !");
		else {
			double random = Math.random();
			int chosinIndex = (int) (random * arrOfEmptyIndexes.size());
			return arrOfEmptyIndexes.get(chosinIndex);
		}
	}


	public boolean play (String move)
	{
		boolean isMoved=false;
		boolean isMerge=false;
		if(move.equals("2"))
		{
			isMoved=moveDown();
			isMerge=MergeDown();
			if(isMoved==true || isMerge==true)
			{
				moveDown();
				AddValueInEmptyIndex();
			}
		}
		if(move.equals("8"))
		{
			isMoved=moveUp();
			isMerge=MergeUp();
			if(isMoved==true || isMerge==true)
			{
				moveUp();
				AddValueInEmptyIndex();
			}
		}
		if(move.equals("6"))
		{
			isMoved=moveRight();
			isMerge=MergeRight();
			if(isMoved==true || isMerge==true)
			{
				moveRight();
				AddValueInEmptyIndex();
			}
		}
		if(move.equals("4"))
		{
			isMoved=moveLeft();
			isMerge=MergeLeft();
			if(isMoved==true || isMerge==true)
			{
				moveLeft();
				AddValueInEmptyIndex();
			}
		}
		try{
			getEmptyIndex();
		}
		catch(Exception e)
		{
			if(isPossibleToMerge()==false)
			return false;
		}
		return true;
	}

	public boolean moveDown() 
	{
		boolean isMovedDown=false;
		for (int i = 0; i < 4; i++)  //columns	
			for (int j = 1; j < 4; j++)  // rows
			if(_gameMatrix[j][i]==0)
				{
				for (int k = j; k >0; k--)
					{
					 _gameMatrix[k][i]=_gameMatrix[k-1][i];
					 _gameMatrix[k-1][i]=0;
					}
				if(_gameMatrix[j][i]!=0)
				isMovedDown=true;
				}
		return isMovedDown;
	}
	
	
	public boolean MergeDown() 
	{   
		boolean isMerge=false;
		for (int i = 0; i < 4; i++)  //columns	
		for (int j = 3; j >0; j--)  // rows
			if(_gameMatrix[j][i]==_gameMatrix[j-1][i] && _gameMatrix[j][i]!=0)
			{
			   _gameMatrix[j][i]=(_gameMatrix[j][i])*2;
			   _gameMatrix[j-1][i]=0;
			   score=score+_gameMatrix[j][i];
			   isMerge=true;
			}
		return isMerge;
			
	}
					

	
	public boolean moveUp() 
	{
		boolean isMovedUp=false;
		for (int i = 0; i < 4; i++)  //columns  
		for (int j = 2; j >=0; j--)  // rows
			if(_gameMatrix[j][i]==0)
				{
				for (int k = j; k<3 ;k++)			
					{
					 _gameMatrix[k][i]=_gameMatrix[k+1][i];
					 _gameMatrix[k+1][i]=0;
					}
				if(_gameMatrix[j][i]!=0)
				isMovedUp=true;
				}
		return isMovedUp;
	}
			
	
	public boolean MergeUp() 
	{
		boolean isMerge=false;
		for (int i = 0; i < 4; i++)  //columns 
		for (int j = 0; j<3 ; j++)  // rows
			if(_gameMatrix[j][i]==_gameMatrix[j+1][i] && _gameMatrix[j][i]!=0)
			{
			   _gameMatrix[j][i]=(_gameMatrix[j][i])*2;
			   _gameMatrix[j+1][i]=0;
			   score=score+_gameMatrix[j][i];
			   isMerge=true;
			}
		return isMerge;
	}		
		

	
	public boolean moveRight() 
	{
		boolean isMovedRight=false;
		for (int i = 0; i < 4; i++)  // rows
		for (int j = 1; j < 4; j++)  // columns
			if(_gameMatrix[i][j]==0)
				{
				for (int k = j; k >0; k--)
					{
					 _gameMatrix[i][k]=_gameMatrix[i][k-1];
					 _gameMatrix[i][k-1]=0;
					}
				if(_gameMatrix[i][j]!=0)
					isMovedRight=true;
				}
		return isMovedRight;
	}
	
	public boolean MergeRight() 
	{
		boolean isMerge=false;
		for (int i = 0; i < 4; i++)  //rows 
		for (int j = 3; j>0 ; j--)  // columns
			if(_gameMatrix[i][j]==_gameMatrix[i][j-1] && _gameMatrix[i][j]!=0)
			{
			   _gameMatrix[i][j]=(_gameMatrix[i][j])*2;
			   _gameMatrix[i][j-1]=0;
			   score=score+_gameMatrix[i][j];
			   isMerge=true;
			}
		return isMerge;
	}	
					
			
	
	public boolean moveLeft() 
	{
		boolean isMovedLeft=false;
		for (int i = 0; i < 4; i++)  // rows
		for (int j = 2; j >=0; j--)  // columns
			if(_gameMatrix[i][j]==0)
				{
				for (int k = j; k <3; k++)
					{
					 _gameMatrix[i][k]=_gameMatrix[i][k+1];
					 _gameMatrix[i][k+1]=0;
					}
				if(_gameMatrix[i][j]!=0)
					isMovedLeft=true;
				}
		return isMovedLeft;
	}		
	
	public boolean MergeLeft() 
	{
		boolean isMerge=false;
		for (int i = 0; i < 4; i++)  //rows 
		for (int j = 0; j<3 ; j++)  // columns
			if(_gameMatrix[i][j]==_gameMatrix[i][j+1] && _gameMatrix[i][j]!=0)
			{
			   _gameMatrix[i][j]=(_gameMatrix[i][j])*2;
			   _gameMatrix[i][j+1]=0;
			   score=score+_gameMatrix[i][j];
			   isMerge=true;
			}
		return isMerge;
	}	
	
	public boolean isPossibleToMerge()
	{
		boolean canMerge=false;
		///Left
		for (int i = 0; i < 4; i++)  //rows 
			for (int j = 0; j<3 ; j++)  // columns
				if(_gameMatrix[i][j]==_gameMatrix[i][j+1])
					canMerge=true;
		
		///Right
		if(!canMerge)
		for (int i = 0; i < 4; i++)  //rows 
			for (int j = 3; j>0 ; j--)  // columns
				if(_gameMatrix[i][j]==_gameMatrix[i][j-1])
					canMerge=true;
	
		///Up
		if(!canMerge)
		for (int i = 0; i < 4; i++)  //columns 
			for (int j = 0; j<3 ; j++)  // rows
				if(_gameMatrix[j][i]==_gameMatrix[j+1][i])
					canMerge=true;
		
		///Down
		if(!canMerge)
		for (int i = 0; i < 4; i++)  //columns	
			for (int j = 3; j >0; j--)  // rows
				if(_gameMatrix[j][i]==_gameMatrix[j-1][i])
					canMerge=true;
		
		return canMerge;
		
	}
					
				
			
		

}
