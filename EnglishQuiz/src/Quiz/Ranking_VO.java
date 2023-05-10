package Quiz;

public class Ranking_VO {

	// 필드
	private String NickName;
    private int socre;
    
    // 생성자
    public Ranking_VO(String nickName, int socre) {
       super();
       this.NickName = nickName;
       this.socre = socre;
    }
    
    // getter & setter
    public String getNickName() {
       return NickName;
    }
    public void setNickName(String nickName) {
       NickName = nickName;
    }
    public int getSocre() {
       return socre;
    }
    public void setSocre(int socre) {
       this.socre = socre;
    }

	
	
	
}
