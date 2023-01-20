package 블랙잭;


public class Deck {
	String[] deck = new String[52];
	private static Deck instance = new Deck();
    public static Deck getInstance() {
    	return instance;
    }
	private Deck() {
		
	}
}
