//run class for Enigma

import java.util.*;

public class Enigma {

	//passes value through all rotors and back
	public static int passAll(Rotor1 r1, Rotor2 r2, Rotor3 r3, Reflector ref, int val) {
		int output = val; 

		//going forward
		output = r1.passFor(output); 				//goes through rotor1
		output = r2.passFor(output); 				//goes through rotor2
		output = r3.passFor(output); 				//goes through rotor3
		
		output = ref.passRef(output); 				//goes through reflector

		//going backward
		output = r3.passBack(output);				//goes through rotor3
		output = r2.passBack(output);				//goes through rotor2
    	output = r1.passBack(output);				//goes through rotor1

    	//updates settings (shiftings)
    	r1.shift();									//r1 specific because it shifts everytime
    	r2.check(r1, r1.getRev());					//checks if r1 has fully revolved, if so, r2 shift
    	r3.check(r2, r2.getRev());					//checks if r2 has fully revolved, if so, r3 shift

		return output;
	}

	//finds index within alpha
	public static int findIndex(String input, String[] alpha) {
		for(int i=0;i<alpha.length;i++) {
			if(alpha[i].equals(input)) {
				return(i);
			}
		}
		return -1;									//for error
	}

	//MAIN
	public static void main(String args[]) {
    	
    	//instantiating objects
    	Rotor1 r1 = new Rotor1(0);
		Rotor2 r2 = new Rotor2(0);
		Rotor3 r3 = new Rotor3(0);
		Reflector ref = new Reflector();
		Scanner scan = new Scanner(System.in);

		//initializing variables
		String inMsg = scan.nextLine().toUpperCase();				//what the user enters
		String outMsg = "";							                //what Enigma returns
		String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            	//index:   0    1    2    3    4    5    6    7    8    9    10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25

		//going through each letter of message
		for(int i=0;i<inMsg.length();i++) {
			if(inMsg.substring(i, i+1).equals(" ")) {
				outMsg += " ";										//spaces don't go through machine
			}
			else{
				int val = findIndex(inMsg.substring(i, i+1), alpha);
				int output = passAll(r1, r2, r3, ref, val);
				outMsg += alpha[output];
			}
		}

		//output to user
		System.out.println(outMsg);
		

	}

	//TEST
	public static void test(String[] alpha) {
		
	}
}