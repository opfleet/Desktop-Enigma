//class for rotor inheritance

public class Rotor {
	public int[] val;					//rotor-specific order of values in the rotor
	private int pos; 					//default should be zero for all three rotors
	private boolean rev;				//if rotor has revolved

	//shifts the rotor (once to the right)
	public void shift() {
		int newFirst = val[25];

		for(int i=25;i>0;i--) {
			val[i] = val[i-1]; 			//from last to first
		}

		val[0] = newFirst;				//first term change

		//for handling the position
		if(pos < 25) {
			pos++;
		}
		else {
			rev = true;
			pos = 0;
		}
	}

	//passes the given value forwards
	public int passFor(int input) {
		int output = -1;

		//goes through array to find index of previous value
		for(int i=0;i<val.length;i++) {
			output = val[i];
			if(i == input) {
				break;
			}
		}

		//returns index
		return output;
	}

	//passes the give value backwards
	public int passBack(int input) {
		int output = -1;

		//goes through array to find value's index
		for(int i=0;i<val.length;i++) {
			if(input == val[i]) {
				return i;
			}
		}

		//returns value
		return output;
	}


	//method to check if previous rotor has fully revolved
	public void check(Rotor r, boolean hasRev) {
		if(hasRev) {
			shift();
			r.setRev(false);
		}
	}

	//returns rev value
	public boolean getRev() {
		return rev;
	}

	//sets rev value
	public void setRev(boolean rev) {
		this.rev = rev;
	}

	//sets the position of the rotor
	public void setPos(int pos) {
		if(pos > 25) {
			System.exit(0);				//for error
		}
		else {
			this.pos = pos;				//changes field
			for(int i=0;i<pos;i++) {
				shift();				//changes the setting		//THIS NEEDS TESTING
			}
		}

	}

	//returns the position of the rotor
	public int getPos() {
		return this.pos;
	}

	//sets val[] array
	public void setVal(int val[]) {
		this.val = val;
	}
}