//class for Rotor3

public class Rotor3 extends Rotor{

	//Constructor for Rotor3
	Rotor3(int pos) {
		setPos(pos);
		setRev(false);
		this.val = new int[]{1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14};
						   //B  D  F  G  J  L   C  P   R   T   X   V   Z   N   Y   E  I  W   G  A  K   M   U   S   Q   O
	}
}