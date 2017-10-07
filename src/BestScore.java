
public class BestScore{
	private int _data;
	private String _name;
	
	public BestScore(int data,String name){
		this._data = data;
		this._name = name;
	}
	
	public int getData(){
		return _data;
	}
	
	public String getName(){
		return _name;
	}
	
	public String toString() {
		return (_name + ":" + _data);
	}

}
