package chapter3;

public class Test3dot7 {

	public static void main(String args[]) throws Exception{
		ThreePointSeven obj = new ThreePointSeven();
		obj.enQueue("dog");
		obj.enQueue("cat");
		obj.enQueue("dog");
		obj.enQueue("dog");
		System.out.println(obj.deQueueDog());
		System.out.println(obj.deQueueAny());
		System.out.println(obj.deQueueDog());
		
	}
}
