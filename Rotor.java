
package application;

//Autor: Katarzyna Stojek
public class Rotor {
	String encoding;
	protected int[] forwardWiring;
    protected int[] backwardWiring;
	private int position = 0;
	private int rotorNumber;
	
	public Rotor (int n) {
		rotorNumber = n;		
		switch(rotorNumber) {
	    case 0:
	    	encoding = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
	    	break;
	    case 1:
	    	encoding = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
	    	break;
	    case 2:
	    	encoding = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
	    	break;
	    case 3:
	    	encoding = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
	    	break;
	    case 4:
	    	encoding = "VZBRGITYUPSDNHLXAWMJQOFECK";
	    	break;
	    }
		
		this.forwardWiring = getWiring(encoding);
        this.backwardWiring = backwardWiring(this.forwardWiring);
	}
	
	protected static int[] getWiring(String encoding) {
        char[] letterWiring = encoding.toCharArray();
        int[] wiring = new int[letterWiring.length];
        for (int i = 0; i < letterWiring.length; i++) {
            wiring[i] = letterWiring[i] - 65;
        }
        return wiring;
    	}
	
	protected static int[] getBackwardWiring(int[] wiring) {
        int[] backward = new int[wiring.length];
        for (int i = 0; i < wiring.length; i++) {
            int forward = wiring[i];
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
	
	protected static int code(int k, int pos, int[] wiring) {
        return (wiring[(k + pos) % 26] - pos + 26) % 26;
    }

    public int returnValueForward(int input) {
        return code(input, this.position, this.forwardWiring);
    }

    public int returnValueBackward(int input) {
        return code(input, this.position, this.backwardWiring);
    }
}

