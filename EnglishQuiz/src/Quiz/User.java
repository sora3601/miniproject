package Quiz;

public class User {
	
	private String id;
	private String pw;
	private String nic;
	private int score;
	private int rank;
	
	
	
	// 생성자
	public User(String id, String pw, String nic) {
		this.id = id;
		this.pw = pw;
		this.nic = nic;
		this.score = 0;
		this.rank = 0;
	} 

	
	
	// getter & setter
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
	
	
}
