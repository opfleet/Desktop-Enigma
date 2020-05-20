//class for the reflector

public class Reflector {
	private int[][] wir;

	//constructor for reflector
	Reflector() {
		this.wir = new int[][]{ {0, 1, 2, 4, 5, 6, 8, 9, 11, 13, 15, 17, 20},
							   //A  B  C  E  F  G  I  J  L   N   P   R   U  |
						    	{3, 23, 7, 18, 12, 22, 14, 10, 19, 25, 16, 21, 24} };
					 		   //D  X   H  S   M   W   O   K   T   Z   Q   V   Y |
	}

	//pass through reflector to get corresponding value
	public int passRef(int input) {
		int firstIndex = -1;				//for row, -1 for error
		int secondIndex = -1;				//for col, -1 for error

		for(int i=0;i<wir.length;i++) {
			for(int j=0;j<wir[i].length;j++) {
				if(wir[i][j] == input) {
					firstIndex = i;
					secondIndex = j;
				}
			}
		}

		if(firstIndex == 0) {
			return wir[1][secondIndex];		//if input is in 1st, output in second
		}
		else if (firstIndex == 1) {
			return wir[0][secondIndex];		//if input is in 2nd, output in first
		}
		else {
			return -1;						//for error
		}
	}

}