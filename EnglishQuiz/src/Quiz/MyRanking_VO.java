package Quiz;

public class MyRanking_VO {

	// 필드
	private int rn;
	private String NickName;
	private int score;

	// 생성자
	public MyRanking_VO(int rn, String nickName, int score) {
		super();
		this.rn = rn;
		NickName = nickName;
		this.score = score;
	}

	// getter & setter
	public int getRn() {
		return rn;
	}

	public void setRn(int rn) {
		this.rn = rn;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String nickName) {
		NickName = nickName;
	}

	public int getScore() {
		return score;
	}

	public void setSocre(int score) {
		this.score = score;
	}

}
