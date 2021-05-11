
package application;

//Autor: Katarzyna Stojek
public class Rotor {
	String wiring;
	protected int[] forwardWiring;
    protected int[] backwardWiring;
	private int position = 0;
	private int rotorNumber;
	
	public Rotor (int n) {
		rotorNumber = n;		
		switch(rotorNumber) {
	    case 0:
	    	wiring = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
	    	break;
	    case 1:
	    	wiring = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
	    	break;
	    case 2:
	    	wiring = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
	    	break;
	    case 3:
	    	wiring = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
	    	break;
	    case 4:
	    	wiring = "VZBRGITYUPSDNHLXAWMJQOFECK";
	    	break;
	    }
		
		this.forwardWiring = getForwardWiring(wiring);
        this.backwardWiring = getBackwardWiring(this.forwardWiring);
	}
	
	protected static int[] getForwardWiring(String wiring) {
        char[] letterWiring = wiring.toCharArray();
        int[] forwardWiring = new int[letterWiring.length];
        for (int i = 0; i < letterWiring.length; i++) {
        	forwardWiring[i] = letterWiring[i] - 65;
        }
        return forwardWiring;
    }
	
	protected static int[] getBackwardWiring(int[] forewardWiring) {
        int[] backward = new int[forewardWiring.length];
        for (int i = 0; i < forewardWiring.length; i++) {
            int forward = forewardWiring[i];
            backward[forward] = i;
        }
        return backward;
    }
	
	void setRotorPosition (int pos) {
		position = pos;
	}
	
	int getRotorPosition () {
		return position;
	}

    public int returnValueForward(int input) {
        return (forwardWiring[(input + position) % 26] - position + 26) % 26;
    }

    public int returnValueBackward(int input) {
        return (backwardWiring[(input + position) % 26] - position + 26) % 26;
    }
}


