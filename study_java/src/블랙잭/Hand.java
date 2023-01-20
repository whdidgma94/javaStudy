package 블랙잭;

public class Hand {
	private String hand = "";
	private int score;
	
	public void addHand(String card) {
		this.hand += card;
	}
	public void addScore(int score) {
		this.score += score;
	}
	public String getHand() {
		return hand;
	}
	public int getScore() {
		return score;
	}
}
