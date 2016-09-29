package chapter3;

public class Data {
	private String type;
	private int timeStamp;
	
	Data(){
		setType(null);
		setTimeStamp(0);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(int timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
