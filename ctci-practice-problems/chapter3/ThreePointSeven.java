package chapter3;

import java.util.LinkedList;

public class ThreePointSeven {

	LinkedList<Data> qDog;
	LinkedList<Data> qCat;
	int time;

	public ThreePointSeven() {
		// TODO Auto-generated constructor stub
		qDog = new LinkedList<Data>();
		qCat = new LinkedList<Data>();
		time = 0;
	}

	public void enQueue(String type) throws Exception {
		Data temp = new Data();
		temp.setType(type);
		temp.setTimeStamp(++time);
		if (type == "dog") {
			qDog.add(temp);
		} else if (type == "cat") {
			qCat.add(temp);
		} else
			throw new Exception("Data passed is not dog or cat");
	}

	public String deQueueDog() throws Exception {
		if (qDog.isEmpty())
			throw new Exception("There are no dogs");
		return qDog.remove().getType();
	}

	public String deQueueCat() throws Exception {
		if (qCat.isEmpty())
			throw new Exception("There are no cats");
		return qCat.remove().getType();
	}

	public String deQueueAny() throws Exception {
		if (qDog.isEmpty() || qCat.isEmpty())
			throw new Exception("There are no dogs or cats");
		if (qDog.peek().getTimeStamp() < qCat.peek().getTimeStamp())
			return deQueueDog();
		else
			return deQueueCat();
	}
}
