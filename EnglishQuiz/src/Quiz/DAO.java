package Quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class DAO {

	Random random = new Random();

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	// 유틸

	// 0.01초 딜레이 메소드
	public void delaym1sc() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // delaym1sc

	// 0.05초 딜레이 메소드
	public void delaym5sc() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // delaym5sc

	// 0.25초 딜레이 메소드
	public void delayhhsc() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // delayhhsc

	// 0.5초 딜레이 메소드
	public void delayhalfsc() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 1초 딜레이 메소드
	public void delay1sc() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // delay1sc

	// 1.5초 딜레이 메소드
	public void delay1halfsc() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // delay1halfsc

	// 2초 딜레이 메소드
	public void delay2sc() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // delay2sc

	// 3초 딜레이 메소드
	public void delay3sc() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // delay3sc

	// 연결
	public void connect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@121.147.52.204:1521:xe";
			String user = "C##WORDTEST";
			String password = "12345";

			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

			e.printStackTrace();
		}

	} // connect

	// 회원가입
	// 아이디 중복체크 메소드
	public int selectID(String ID) {
		connect();

		String sql = "select userID from user_info where userID = ? ";

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, ID);
			ResultSet rs = pst.executeQuery(); // 커서, 화살표 > 결과가 테이블 형태로 생성됨
			// 테이블에 행마다 데이터가 있으면 true, 없으면 false(boolean:String)--> 데이터가 없을 떄까지 반복 while문

			while (rs.next()) {

				String ID2 = rs.getString(1);
				pst.close();
				conn.close();

				if (ID.equals(ID2)) {
					return 1; // 아이디 중복
				} else {
					return 0;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	} // selectID

	// 닉네임 중복체크 메소드
	public int selectNick(String Nick) {
		connect();

		String sql = "select NickName from user_info where NickName = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, Nick);// (sql문장에 들어갈 물음표의 위치, java에서 입력할 변수명)
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String Nick2 = rs.getString(1);
				pst.close();
				conn.close();

				if (Nick.equals(Nick2)) {
					return 1;
				} else {
					return 0;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	} // selectNick

	// User_info 테이블에 정보 등록 메소드
	public int SignUp(String ID, String PW, String Nick) {
		connect();

		PreparedStatement pst = null;
		String sql = "INSERT INTO user_info VALUES(?, ?, ?, 0)";
		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, ID);
			pst.setString(2, PW);
			pst.setString(3, Nick);

			int cnt = pst.executeUpdate();

			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	// 로그인
	// 아이디와 비밀번호 DB에서 대조 메소드
	// 로그인
	// 회원 정보에서 ID와 PW를 select 해서 로그인 성공 여부를 판단하는 메소드
	public int login(String userID, String userPassword) { // 어떤 계정에 대한 실제로 로그인을 시도하는 함수, 인자값으로 ID와 Password를 받아 login을
															// 판단함.

		String SQL = "SELECT pw FROM USER_Info WHERE userID = ?"; // 실제로 DB에 입력될 명령어를 SQL 문장으로 만듬.

		try {
			connect();
			pst = conn.prepareStatement(SQL);

			pst.setString(1, userID);

			rs = pst.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1; // 아이디가 없음
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				pst.close();
				conn.close();

			} catch (Exception e2) {

			}
		}
		return -2; // DB 오류
	} // log in 메소드

	//
	// 로그인 시 로그인한 아이디의 닉네임 정보를 임시로 저장해주는 메소드
	public String saveNic(String ID) {

		connect();

		String sql = "select nickname from user_info where userid = ? ";

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, ID);

			ResultSet rs = pst.executeQuery();

			String nic = null;

			while (rs.next()) {
				nic = rs.getString(1);
			}

			return nic;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	// 게임 진행
	// 난이도별 5개 랜덤으로 뽑고, 중복인지 확인하는 메소드
	public int[] rd(int index) {
		int[] array = new int[5];
		for (int i = 0; i < 5; i++) {
			array[i] = random.nextInt(index) + 1;
			// 각 테이블에 마지막 번호

			for (int j = 0; j < i; j++) {
				if (array[i] == array[j])
					i--;
			} // 문제 중복 체크

		} // 난이도별 문제 랜덤으로 선택, 중복xx

		return array;
	}

	// 난이도 테이블별 마지막 인덱스
	public int MaxIndex(String tableName) {
		connect();

		String spl = "select no from " + tableName + " order by no desc";
		pst = null;

		try {
			pst = conn.prepareStatement(spl);

			rs = pst.executeQuery();

			while (rs.next()) {
				int mi = rs.getInt(1);
				pst.close();
				conn.close();
				return mi;

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return 0;
	} // MaxIndex

	// 문제번호 입력 받으면 그 번호에 맞는 문제 출력하는 메소드
	public String Quiz(int no, String lv) {
		// select 해야함, lv 테이블에 있는 no번 문제 출력
		connect();
		String quiz;

		try {
			String spl = "select quiz from " + lv + " where no = ?";
			pst = null;
			pst = conn.prepareStatement(spl);
			pst.setInt(1, no);
			rs = null;
			rs = pst.executeQuery();

			while (rs.next()) {
				quiz = rs.getString(1);

				pst.close();
				conn.close();

				return quiz;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	} // Quiz

	// 문제번호 입력 후 그 번호에 맞는 정답 리턴
	public String ReAnswer(int num, String tableName) {
		connect();

		try {
			String spl = "select Answer from " + tableName + " where no = ?";
			pst = null;
			pst = conn.prepareStatement(spl);
			pst.setInt(1, num);

			rs = null;
			rs = pst.executeQuery();

			if (rs.next()) {
				String answer = rs.getString(1);
				pst.close();
				conn.close();

				return answer;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	} // ReAnswer
	
	// 오답 중복 확인 메소드
	public boolean ch(String logID,String lvl,int qNum) { 
	      ArrayList<Review_Note_VO> array = new ArrayList<Review_Note_VO>();

	      array = Review_Note_select(logID);
	      boolean bl = false;
	      for (int i = 0; i < array.size(); i++) {
	         if (array.get(i).getUserid().equals(logID) && array.get(i).getLvl().equals(lvl)
	                 && array.get(i).getQ_number() == qNum) {
	            bl = false;
	            break;
	         } else
	            bl = true;
	      }
	      return bl;
	   } // ch 오답 중복확인 메소드


	// 회원 id, 난이도, 문제번호 입력 받아 오답노트 테이블에 입력
	public void ReNote(String id, String LEVEL, int i) {
	      if (ch(id,LEVEL,i)) {
	    	  connect();
	         try {
	        	System.out.println(id);
	        	System.out.println(LEVEL);
	        	System.out.println(i);
	            String sql = "insert into Review_Note values (?,?,?)";
	            pst = conn.prepareStatement(sql);
	            pst.setString(1, id);
	            pst.setString(2, LEVEL);
	            pst.setInt(3, i);
	            int cc = pst.executeUpdate();


	            pst.close();
	            conn.close();
	         } catch (Exception e) {

	            e.printStackTrace();
	         } 
	        	 
	         }
	      

	} // ReNote

	// 회원 id, 최종점수 입력 받아 회원정보 테이블에 입력
	public void FinalScore(String id, int score) {
		connect();

		try {
			String spl = "update user_info set Score = " + score + " where userid= ?  ";
			pst = null;
			pst = conn.prepareStatement(spl);
			pst.setString(1, id);
			pst.executeUpdate();

			pst.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // FinalScore

	// 랭킹 조회
	// 최상위 3인 점수 및 순위 메소드
	// 랭킹 조회
	// 최상위 3명 select 메소드
	public ArrayList<Ranking_VO> select() {
		connect();
		ArrayList<Ranking_VO> allScore = new ArrayList<>();

		String sql = "select nickname, score from(select * from user_info order by score desc) where rownum <=3";
		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String NickName = rs.getString(1);
				int score = rs.getInt(2);

				Ranking_VO ran = new Ranking_VO(NickName, score);
				allScore.add(ran);

			}
			return allScore;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

	// 로그인한 사용자의 순위 메소드
	public ArrayList<MyRanking_VO> selectMy(String id) {
		connect();
		ArrayList<MyRanking_VO> myscore = new ArrayList<>();

		String sql = "select rn, nickname, score from(select rownum as rn, a.* from(select * from user_info order by score desc) a) where userid= ?";
		// 뒤에 있는 id는 로그인 되어 있는 id
		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();

			rs.next();
			int rn = rs.getInt(1);
			String NickName = rs.getString(2);
			int score = rs.getInt(3);

			MyRanking_VO myran = new MyRanking_VO(rn, NickName, score);
			myscore.add(myran);

			return myscore;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	// 오답노트
	// 오답노트 조회 메소드
	public ArrayList<Review_Note_VO> Review_Note_select(String logID) {
		connect();

		ArrayList<Review_Note_VO> array = new ArrayList<Review_Note_VO>();
		pst = null;
		String sql = "select userid, lvl, q_number from Review_Note where userid = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, logID);
			ResultSet rs = pst.executeQuery();
			Review_Note_VO rn;
			while (rs.next()) {

				String userid = rs.getString(1);
				String lvl = rs.getString(2);
				int q_number = rs.getInt(3);

				rn = new Review_Note_VO(userid, lvl, q_number);

				String sql2 = "select Quiz, Answer from " + rn.getLvl() + " where no = ?";
				pst = conn.prepareStatement(sql2);
				pst.setInt(1, rn.getQ_number());
				ResultSet rs2 = pst.executeQuery();

				while (rs2.next()) {
					String Quiz = rs2.getString(1);
					String Answer = rs2.getString(2);
					rn.setQuiz(Quiz);
					rn.setAnswer(Answer);
					array.add(rn);

				}
			}
			return array;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rs != null) {
					pst.close();
				}
				if (rs != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return null;
	} // Review_Note_select

	// 오답노트 삭제 메소드
	public void Review_Note_Delete(String logID) {

		connect();

		try {
			String sql = "delete from Review_Note where userid = ? ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, logID);
			int cnt = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	} // Review_Note_Delete

	// 닉네임 변경
	// 닉네임 변경 메소드
	public int change_Nick_Name(String id, String ch_Nick_Name) {
		connect();

		String sql = "update user_info set " + ch_Nick_Name + " where id = ?";

		pst = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;

	} // change_Nick_Name

	// 비밀번호 변경
	// 비밀번호 변경 메소드
	public int change_PASSWORD(String logID, String pASSWORD) {
		connect();

		String sql = "update user_info set " + pASSWORD + " where id = ?";

		pst = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, logID);

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;

	} // change_PASSWORD

	// 점수 초기화
	// 로그인한 사용자의 점수 삭제 메소드
	public int delete(String id) {
		connect();

		String sql = "update user_info set score = 0 where userid = ?";

		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;

	}

	// 회원탈퇴
	// 로그인 한 id의 회원정보를 삭제하는 메소드

	public int unregist(String ID) {

		connect();

		String sql = "delete from User_Info where UserID = ?";

		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, ID);
			int cnt = pst.executeUpdate();
			return cnt;

		} catch (Exception e) {
			e.printStackTrace();

		}
		return 0;
	}

}
