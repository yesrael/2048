
public class Index {
	private int _row;
	private int _column;
	
	public  Index(int row,int column) {
		this._row = row;
		this._column= column;
	}

	public int getRow(){
		return _row;
	}
	
	public int getColumn(){
		return _column;
	}
	
	public void setRow(int row){
		this._row=row;
	}
	
	public void setColumn(int column){
		this._column = column;
	}
	
}
