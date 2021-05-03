package application;

public class Reflector {
	private int[][] connections;
	private int reflectorName;
	
	public Reflector (int rName) {
		reflectorName = rName;
		
		switch (reflectorName) {
		// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
	    // A B C D E F G H I J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z
		case 0:
			//Reflektor B
			connections = new int[][] {{0,24},{1,17},{2,20},{3,7},{4,16},{5,18},{6,11},{7,3},{8,15},{9,23},{10,13},{11,6},{12,14},{13,10},{14,12},{15,8},{16,4},{17,1},{18,5},{19,25},{20,2},{21,22},{22,21},{23,9},{24,0},{25,19}};
			break;
		case 1:
			//Reflektor C
			connections = new int[][] {{0,5},{1,21},{2,15},{3,9},{4,8},{5,0},{6,14},{7,24},{8,4},{9,3},{10,17},{11,25},{12,23},{13,22},{14,6},{15,2},{16,19},{17,10},{18,20},{19,16},{20,18},{21,1},{22,13},{23,12},{24,7},{25,11}};
			break;
		}
	}
	
	int getName () {
		return reflectorName;
	}
	
	int returnValue (int in) {
		return connections[in][1];
	}

}
