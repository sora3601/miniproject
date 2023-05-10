package Quiz;

public class Review_Note_VO {
	
	 private String userid ;
	   private String lvl ;   
	   private int q_number ;
	   private String Quiz ;
	   private String Answer ;
	   
	   public Review_Note_VO(String userid, String lvl, int q_number) {
	      super();
	      this.userid = userid;
	      this.lvl = lvl;
	      this.q_number = q_number;
	   }

	   public String getUserid() {
	      return userid;
	   }

	   public void setUserid(String userid) {
	      this.userid = userid;
	   }

	   public String getLvl() {
	      return lvl;
	   }

	   public void setLvl(String lvl) {
	      this.lvl = lvl;
	   }

	   public int getQ_number() {
	      return q_number;
	   }

	   public void setQ_number(int q_number) {
	      this.q_number = q_number;
	   }

	   public String getQuiz() {
	      return Quiz;
	   }

	   public void setQuiz(String quiz) {
	      Quiz = quiz;
	   }

	   public String getAnswer() {
	      return Answer;
	   }

	   public void setAnswer(String answer) {
	      Answer = answer;
	   }

	
}
