package practice;

public class DistanceBetnPoints {
	double perfectCity(double[] departure, double[] destination) {
		double x = departure[0];
		double y = departure[1];
		boolean isXInteger = false;
		if ((int) x == x) {
			isXInteger = true;
		}
		double distance = 0;

		if (!isXInteger) {
			distance = Math.min(Math.ceil(x) - x + manhatten(Math.ceil(x), y, destination[0], destination[1]),
					x - Math.floor(x) + manhatten(Math.floor(x), y, destination[0], destination[1]));
		} else {
			distance = Math.min(Math.ceil(y) - y + manhatten(x, Math.ceil(y), destination[0], destination[1]),
					y - Math.floor(y) + manhatten(x, Math.floor(y), destination[0], destination[1]));
		}
		return distance;
	}

	double manhatten(double x1, double y1, double x2, double y2) {
		return Math.abs(x2 - x1) + Math.abs(y2 - y1);
	}
	
	public static void main(String[] args){
		DistanceBetnPoints dp = new DistanceBetnPoints();
		double[] src = {0.4,1};
		double[] dest = {2,0};
		System.out.println(dp.perfectCity(src, dest));
	}

}
