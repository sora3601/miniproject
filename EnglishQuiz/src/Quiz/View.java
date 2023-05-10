package Quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class View {

	public static void main(String[] args) {
		
		

		String logID = null;
		String logPW = null;
		String logNic = null;

		Scanner scan = new Scanner(System.in);

		DAO dao = new DAO();

		String eng = "English";
		String[] engA = eng.split("");
		String qu = "Quiz";
		String[] quA = qu.split("");
		String sign = "Sign";
		String[] signA = sign.split("");
		String up = "Up";
		String[] upA = up.split("");
		String log = "Log";
		String[] logA = log.split("");
		String in = "In";
		String[] inA = in.split("");
		String menus = "MENU";
		String[] menusA = menus.split("");
		String game = "Game";
		String[] gameA = game.split("");
		String starts = "Start!";
		String[] startsA = starts.split("");
		String ranks = "Ranking";
		String[] ranksA = ranks.split("");
		String top = "TOP";
		String[] topA = top.split("");
		String my = "My";
		String[] myA = my.split("");
		String rankss = "Rank";
		String[] rankssA = rankss.split("");
		String review = "Review";
		String[] reviewA = review.split("");
		String note = "Note";
		String[] noteA = note.split("");
		String page = "Page";
		String[] pageA = page.split("");
		String info = "Info";
		String[] infoA = info.split("");
		String change = "Change";
		String[] changeA = change.split("");
		String pws = "PW";
		String[] pwsA = pws.split("");
		String nics = "Nickname";
		String[] nicsA = nics.split("");
		String reset = "Reset";
		String[] resetA = reset.split("");
		String scores = "Score";
		String[] scoresA = scores.split("");
		String unreg = "Unregister";
		String[] unregA = unreg.split("");
		

		progout: while (true) { // 전체 프로그램
			for (int i = 0; i < 26; i++) {
				System.out.print("=");
				dao.delaym1sc();
			}
			System.out.println();
			dao.delaym1sc();

			for (int i = 0; i < 7; i++) {
				System.out.print("=");
				dao.delaym1sc();
			}

			for (int i = 0; i < engA.length; i++) {
				System.out.print(engA[i]);
				dao.delaym5sc();
			}
			System.out.print(" ");

			dao.delaym5sc();
			for (int i = 0; i < quA.length; i++) {
				System.out.print(quA[i]);
				dao.delaym5sc();
			}

			for (int i = 0; i < 7; i++) {
				System.out.print("=");
				dao.delaym1sc();
			}
			System.out.println();
			dao.delaym1sc();

			for (int i = 0; i < 26; i++) {
				System.out.print("=");
				dao.delaym1sc();
			}
			System.out.println();

			dao.delayhalfsc();
			System.out.println("[1] 로그인");
			dao.delayhhsc();
			System.out.println("[2] 회원가입");
			dao.delayhhsc();
			System.out.println("[3] 종료");
			dao.delayhhsc();
			System.out.print("번호를 입력해주세요 : ");
			int start = scan.nextInt();
			System.out.println();

			if (start == 3) { // 프로그램 종료
				while (true) { // 프로그램 종료 확인
					for (int i = 0; i < 26; i++) {
						System.out.print("=");
						dao.delaym1sc();
					}
					System.out.println();

					dao.delayhalfsc();
					System.out.print("종료하시겠습니까? (Y/N) ");
					String yn = scan.next();
					dao.delayhalfsc();

					for (int i = 0; i < 26; i++) {
						System.out.print("=");
						dao.delaym1sc();
					}
					System.out.println();
					dao.delayhalfsc();

					if (yn.equals("Y") || yn.equals("y") || yn.equals("ㅛ")) {
						System.out.println("프로그램을 종료합니다.");
						break progout;
					} // if

					else if (yn.equals("N") || yn.equals("n") || yn.equals("ㅜ")) {
						System.out.println("시작화면으로 돌아갑니다.");
						System.out.println();
						dao.delayhalfsc();
						break;
					} // else if

				} // while 프로그램 종료 확인

			} // if 프로그램 종료

			else if (start == 2) { // 회원가입
				for (int i = 0; i < 26; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}
				System.out.println();
				dao.delaym1sc();

				for (int i = 0; i < 9; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}

				for (int i = 0; i < signA.length; i++) {
					System.out.print(signA[i]);
					dao.delaym5sc();
				}
				System.out.print(" ");
				dao.delaym5sc();
				for (int i = 0; i < upA.length; i++) {
					System.out.print(upA[i]);
					dao.delaym5sc();
				}

				for (int i = 0; i < 10; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}

				System.out.println();
				dao.delaym1sc();

				for (int i = 0; i < 26; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}
				System.out.println();
				dao.delayhalfsc();

				String id = null;
				String pw = null;
				String nic = null;

				while (true) { // ID 중복확인

					System.out.print("사용하실 ID : ");
					id = scan.next();
					dao.delayhhsc();
					System.out.print("중복검사 하는 중");
					dao.delayhhsc();
					for (int i = 0; i < 2; i++) {
						System.out.print(". ");
						dao.delayhalfsc();
					}
					System.out.println(".");
					dao.delayhalfsc();

					if (dao.selectID(id) == 1) { // id 중복 시
						System.out.println("이미 사용 중인 ID 입니다.");
						dao.delayhhsc();
						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delaym1sc();
					} // if id 중복 시

					else {
						System.out.println("사용 가능한 ID 입니다.");
						dao.delayhhsc();
						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delayhhsc();
						break;
					} // else id 미중복 시
				} // while ID 중복확인
					// 아이디를 데이터베이스에 입력
					// 기존의 아이디와 같으면--> 반영X
					// 기존에 없는 아이디--> 반영O

				while (true) { // PW 확인

					System.out.print("사용하실 비밀번호 : ");
					pw = scan.next();
					dao.delayhhsc();

					System.out.print("비밀번호 확인 : ");
					String pw2 = scan.next();
					dao.delayhhsc();

					if (!pw.equals(pw2)) { // 비밀번호 불일치 시
						System.out.println("비밀번호가 일치하지 않습니다.");
						dao.delayhalfsc();
						System.out.println("다시 입력해 주세요.");
						dao.delayhhsc();
						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delayhhsc();
					} // if 비밀번호 불일치
					else { // 비밀번호 일치
						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delayhhsc();
						break;
					} // else 비밀번호 일치
				} // while PW 확인

				while (true) { // 닉네임 중복 검사

					System.out.print("사용하실 닉네임 : ");
					nic = scan.next();
					dao.delayhhsc();
					System.out.print("중복검사 하는 중");
					dao.delayhhsc();
					for (int i = 0; i < 2; i++) {
						System.out.print(". ");
						dao.delayhalfsc();
					}
					System.out.println(".");
					dao.delayhalfsc();

					if (dao.selectNick(nic) == 1) { // 닉네임 중복 시
						System.out.println("이미 사용 중인 닉네임 입니다.");
						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delayhhsc();
					} // if 닉네임 중복 시
					else { // 닉네임 사용가능
						System.out.println("사용 가능한 닉네임 입니다.");
						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delayhhsc();
					} // else 닉네임 사용가능
					dao.delayhalfsc();
					break;
				}

				System.out.print("가입완료 하시겠습니까? (Y/N) ");// 가입완료 버튼을 눌러 다음 페이지로 넘어간다
				String Submit = scan.next();
				for (int i = 0; i < 26; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}
				System.out.println();

				if (Submit.equals("Y") || Submit.equals("y") || Submit.equals("ㅛ")) { // 가입완료 확인
					int cnt = dao.SignUp(id, pw, nic);
					if (cnt > 0) {
						System.out.println("가입이 완료되었습니다!");
						System.out.println();
						dao.delayhalfsc();
					} // if 가입완료 확인
				} else { // 가입 취소
					System.out.println("취소");
					System.out.println();
					dao.delayhalfsc();
				} // else 가입 취소

			} // else if 회원가입

			else if (start == 1) { // 로그인
				for (int i = 0; i < 26; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}
				System.out.println();
				dao.delaym1sc();
				for (int i = 0; i < 10; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}

				for (int i = 0; i < logA.length; i++) {
					System.out.print(logA[i]);
					dao.delaym5sc();
				}

				System.out.print(" ");
				dao.delaym5sc();

				for (int i = 0; i < inA.length; i++) {
					System.out.print(inA[i]);
					dao.delaym5sc();
				}

				for (int i = 0; i < 10; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}
				System.out.println();
				dao.delaym1sc();

				for (int i = 0; i < 26; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}
				System.out.println();
				dao.delayhalfsc();

				while (true) {

					// 로그인 ID, PW 입력
					System.out.print("ID : ");
					logID = scan.next();
					dao.delayhhsc();
					System.out.print("PW : ");
					logPW = scan.next();
					dao.delayhalfsc();
					for (int i = 0; i < 26; i++) {
						System.out.print("=");
						dao.delaym1sc();
					}
					System.out.println();
					System.out.print("정보 확인하는 중");
					dao.delayhhsc();
					for (int i = 0; i < 2; i++) {
						System.out.print(". ");
						dao.delayhalfsc();
					}
					System.out.println(".");
					dao.delayhalfsc();

					int cnt = dao.login(logID, logPW);

					if (cnt == -1) { // 아이디 없음
						System.out.println("아이디가 존재하지않습니다.");
						dao.delayhhsc();
						System.out.println("다시 시도하여 주세요.");
						System.out.println();
						dao.delayhalfsc();
					} // if

					else if (cnt == 0) { // 비밀번호 불일치
						System.out.println("비밀번호가 일치 하지않습니다.");
						dao.delayhhsc();
						System.out.println("다시 시도하여 주세요.");
						System.out.println();
						dao.delayhalfsc();
					} // else if

					else if (cnt == 1) { // 로그인 성공
						System.out.println("로그인 성공! 환영합니다.");
						logNic = dao.saveNic(logID);
						System.out.println();
						dao.delayhalfsc();
						break;
					} // else if
					else if (cnt == -2) { // 오류
						System.out.println("오류");
					} // else if

				} // while

				menuout: while (true) { // 메뉴

					for (int i = 0; i < 26; i++) {
						System.out.print("=");
						dao.delaym1sc();
					}
					System.out.println();
					dao.delaym1sc();

					for (int i = 0; i < 11; i++) {
						System.out.print("=");
						dao.delaym1sc();
					}

					for (int i = 0; i < menusA.length; i++) {
						System.out.print(menusA[i]);
						dao.delaym5sc();
					}

					for (int i = 0; i < 11; i++) {
						System.out.print("=");
						dao.delaym1sc();
					}
					System.out.println();
					dao.delaym1sc();

					for (int i = 0; i < 26; i++) {
						System.out.print("=");
						dao.delaym1sc();
					}
					System.out.println();
					dao.delayhalfsc();

					System.out.println("[1] 게임 시작");
					dao.delayhhsc();
					System.out.println("[2] 랭킹");
					dao.delayhhsc();
					System.out.println("[3] 오답노트");
					dao.delayhhsc();
					System.out.println("[4] 마이 페이지");
					dao.delayhhsc();
					System.out.println("[5] 로그 아웃");
					dao.delayhalfsc();

					System.out.print("번호를 입력해주세요 : ");
					int menu = scan.nextInt();
					System.out.println();
					dao.delayhalfsc();

					if (menu == 5) { // 로그아웃

						while (true) { // 로그아웃 확인문 출력
							for (int i = 0; i < 26; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							System.out.println();
							dao.delayhalfsc();

							System.out.print("로그아웃 하시겠습니까? (Y/N) ");
							String yn = scan.next();
							dao.delayhalfsc();

							for (int i = 0; i < 26; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							System.out.println();
							dao.delay1sc();

							if (yn.equals("Y") || yn.equals("y") || yn.equals("ㅛ")) {
								System.out.println("로그아웃 성공!");
								dao.delayhalfsc();
								System.out.println("시작화면으로 돌아갑니다.");
								System.out.println();
								dao.delayhalfsc();
								break menuout;
							} // if 로그아웃 성공

							else if (yn.equals("N") || yn.equals("n") || yn.equals("ㅜ")) {
								System.out.println("로그아웃 취소.");
								System.out.println("메뉴화면으로 돌아갑니다.");
								System.out.println();
								dao.delayhalfsc();
								break;
							} // else if 로그아웃 취소

						} // while 로그아웃 확인문 출력

					} // if 로그아웃

					else if (menu == 1) { // 게임 진행

						System.out.println("3");
						dao.delay1sc();
						System.out.println("2");
						dao.delay1sc();
						System.out.println("1");
						dao.delay1sc();

						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();

						for (int i = 0; i < 8; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}

						for (int i = 0; i < gameA.length; i++) {
							System.out.print(gameA[i]);
							dao.delaym5sc();
						}
						System.out.print(" ");
						dao.delaym5sc();

						for (int i = 0; i < startsA.length; i++) {
							System.out.print(startsA[i]);
							dao.delaym5sc();
						}

						for (int i = 0; i < 7; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}

						System.out.println();
						dao.delaym1sc();

						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						dao.delay1sc();
						System.out.println();
						System.out.println();

						// 총 문항은 20문항입니다.(Easy : 2점, Normal: 4점, Hard : 6점 , Expert: 8점)

						// 각 난이도별 5개 문제 랜덤으로 선택
						int[] easy = dao.rd(dao.MaxIndex("EASY_Q"));
						int[] normal = dao.rd(dao.MaxIndex("NORMAL_Q"));
						int[] hard = dao.rd(dao.MaxIndex("HARD_Q"));
						int[] expert = dao.rd(dao.MaxIndex("EXPERT_Q"));

						// 난이도별 문제 출력 및 정답 입력, if 정답 = 점수 누적, 오답 = 오답노트 정리 -> 20번까지 반복
						int score = 0; // 점수 합계 구하기

						for (int i = 0; i < 5; i++) {
							System.out.println();
							System.out.println(i + 1 + "번 문제 " + dao.Quiz(easy[i], "easy_Q"));
							dao.delayhalfsc();
							System.out.print("정답 입력 : ");
							String input = scan.next();
							dao.delayhalfsc();
							System.out.println();

							if (input.equals(dao.ReAnswer(easy[i], "easy_Q"))) {
								System.out.println("정답입니다!");
								score += 2; // easy 점수 2
							} else {
								System.out.println("틀렸습니다..");
								dao.ReNote(logID, "easy_q", easy[i]);
							}
							dao.delayhalfsc();

						} // easy 문제 출력, 답 작성

						for (int i = 0; i < 5; i++) {
							System.out.println();
							System.out.println(i + 6 + "번 문제 " + dao.Quiz(normal[i], "normal_Q"));
							dao.delayhalfsc();
							System.out.print("정답 입력 : ");
							String input = scan.next();
							dao.delayhalfsc();
							System.out.println();

							if (input.equals(dao.ReAnswer(normal[i], "normal_Q"))) {
								System.out.println("정답입니다!");
								score += 4; // normal 점수 4
							}

							else {
								System.out.println("틀렸습니다..");
								dao.ReNote(logID, "normal_q", normal[i]);
							}
							dao.delayhalfsc();

						} // normal 문제 출력, 답 작성

						for (int i = 0; i < 5; i++) {
							System.out.println();
							System.out.println(i + 11 + "번 문제 " + dao.Quiz(hard[i], "hard_Q"));
							dao.delayhalfsc();
							System.out.print("정답 입력 : ");
							String input = scan.next();
							dao.delayhalfsc();
							System.out.println();

							if (input.equals(dao.ReAnswer(hard[i], "hard_Q"))) {
								System.out.println("정답입니다!");
								score += 6; // hard 점수 6
							} else {
								System.out.println("틀렸습니다..");
								dao.ReNote(logID, "hard_q", hard[i]);
							}
							dao.delayhalfsc();

						} // hard 문제 출력, 답 작성

						for (int i = 0; i < 5; i++) {
							System.out.println();
							System.out.println(i + 16 + "번 문제 " + dao.Quiz(expert[i], "expert_Q"));
							dao.delayhalfsc();
							System.out.print("정답 입력 : ");
							String input = scan.next();
							dao.delayhalfsc();
							System.out.println();

							if (input.equals(dao.ReAnswer(expert[i], "expert_Q"))) {
								System.out.println("정답입니다!");
								score += 8; // expert 점수 8
							} else {
								System.out.println("틀렸습니다..");
								dao.ReNote(logID, "expert_q", expert[i]);
							}
							dao.delayhalfsc();

						} // expert 문제 출력, 답 작성

						System.out.print("점수합산 중");
						dao.delayhhsc();
						for (int i = 0; i < 2; i++) {
							System.out.print(". ");
							dao.delayhalfsc();
						}
						System.out.println(".");
						dao.delayhalfsc();

						if (score == 100) {
							System.out.println(score + "점! 완벽합니다!");
						} else if (score >= 90) {
							System.out.println(score + "점! 대단해요! 100점을 노려보세요!");
						} else if (score >= 80) {
							System.out.println(score + "점 입니다. 좀 더 노력해서 고득점을 노려보세요!");
						} else if (score >= 70) {
							System.out.println(score + "점이에요. 오답노트를 참고해서 공부해보세요.");
						} else if (score >= 60) {
							System.out.println(score + "점,, 노력이 필요해요. ");
						} else if (score >= 40) {
							System.out.println(logNic + " " + score + "점. 잘하자.");
						} else {
							System.out.println(logNic + ". 엎드려.");
						}

						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delayhalfsc();

						ArrayList<MyRanking_VO> myscore = dao.selectMy(logID);
						if (myscore.get(0).getScore() < score) {

							System.out.println("최고기록 갱신! 축하합니다!");
							System.out.println();
							dao.FinalScore(logID, score);
						}

						dao.delayhhsc();
						System.out.println("메뉴로 돌아갑니다.");
						System.out.println();
						dao.delayhalfsc();

					} // else if 게임진행

					else if (menu == 2) { // 랭킹조회
						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delaym1sc();

						for (int i = 0; i < 9; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						for (int i = 0; i < ranksA.length; i++) {
							System.out.print(ranksA[i]);
							dao.delaym5sc();
						}
						for (int i = 0; i < 10; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delaym1sc();

						for (int i = 0; i < 26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						System.out.println();

						for (int i = 0; i < 10; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						for (int i = 0; i < topA.length; i++) {
							System.out.print(topA[i]);
							dao.delaym5sc();
						}
						System.out.print(" ");
						dao.delaym5sc();
						System.out.print("3");
						dao.delaym5sc();
						for (int i = 0; i < 11; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();

						ArrayList<Ranking_VO> all = dao.select();

						for (int i = 0; i < all.size(); i++) { // 3등까지 랭킹 출력

							System.out.print(i + 1 + "등 : " + all.get(i).getNickName() + "\t");
							System.out.println(all.get(i).getSocre());
							dao.delayhalfsc();

						}
						System.out.println();

						for (int i = 0; i < 10; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						for (int i = 0; i < myA.length; i++) {
							System.out.print(myA[i]);
							dao.delaym5sc();
						}
						System.out.print(" ");
						dao.delaym5sc();
						for (int i = 0; i < rankssA.length; i++) {
							System.out.print(rankssA[i]);
							dao.delaym5sc();
						}
						for (int i = 0; i < 9; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delayhhsc();

						ArrayList<MyRanking_VO> myscore = dao.selectMy(logID);

						System.out.println(myscore.get(0).getNickName() + "님의 등수는 " + myscore.get(0).getRn() + "등입니다.");
						dao.delayhalfsc();
						System.out.println();
						System.out.print("돌아가려면 아무키나 입력하세요. ");
						int ranksel = scan.nextInt();
						dao.delayhalfsc();

					} // else if 랭킹 조회

					else if (menu == 3) { // 오답노트

						ArrayList<Review_Note_VO> array = new ArrayList<Review_Note_VO>();

						while (true) {
							for (int i = 0; i < 26; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							System.out.println();
							dao.delaym1sc();

							for (int i = 0; i < 8; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}

							for (int i = 0; i < reviewA.length; i++) {
								System.out.print(reviewA[i]);
								dao.delaym5sc();
							}
							System.out.print(" ");
							dao.delaym5sc();
							for (int i = 0; i < noteA.length; i++) {
								System.out.print(noteA[i]);
								dao.delaym5sc();
							}
							for (int i = 0; i < 7; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							System.out.println();
							dao.delaym1sc();

							for (int i = 0; i < 26; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							dao.delayhalfsc();
							System.out.println();

							System.out.println("[1] 틀린 문제 확인");
							dao.delayhhsc();
							System.out.println("[2] 오답노트 비우기");
							dao.delayhhsc();
							System.out.println("[3] 돌아가기");
							dao.delayhhsc();

							System.out.print("번호를 입력해주세요 : ");
							int num = scan.nextInt();
							dao.delayhalfsc();
							if (num == 1) { // [1] Check
								array = dao.Review_Note_select(logID);

								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();

								if (array.size() == 0) {
									System.out.println("오답노트가 비었습니다!");
									dao.delayhalfsc();
									System.out.println();
								} // if
								else {
									for (int i = 0; i < array.size(); i++) {
										System.out.println(array.get(i).getQuiz());
										dao.delayhalfsc();
										System.out.println("정답 : " + array.get(i).getAnswer());
										dao.delayhhsc();
										System.out.println();
										System.out.println("[1] 다음 문제");
										dao.delayhhsc();
										System.out.println("[2] 나가기");
										dao.delayhhsc();
										System.out.print("번호를 입력해주세요 : ");
										int renoch = scan.nextInt();
										if (renoch == 2)
											break;
									} // for
								} // else

							} else if (num == 2) { // [2] delete
								System.out.println("오답노트를 비우시겠습니까? (Y/N) ");
								String yn = scan.next();
								if (yn.equals("Y") || yn.equals("y") || yn.equals("ㅛ")) {
									dao.Review_Note_Delete(logID);
									System.out.print("오답노트 비우는 중");
									dao.delayhhsc();
									for (int i = 0; i < 2; i++) {
										System.out.print(". ");
										dao.delayhalfsc();
									}
									System.out.println(".");
									dao.delayhalfsc();
									System.out.println("삭제완료!");
								} else
									break;

							} else { // [3] Back"
								break;

							}

						}

					} // else if 오답 노트

					else if (menu == 4) { // 마이 페이지

						while (true) { // 마이 페이지 메뉴 출력

							for (int i = 0; i < 26; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							System.out.println();
							dao.delaym1sc();

							for (int i = 0; i < 10; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							for (int i = 0; i < myA.length; i++) {
								System.out.print(myA[i]);
								dao.delaym5sc();
							}
							System.out.print(" ");
							dao.delaym5sc();
							for (int i = 0; i < pageA.length; i++) {
								System.out.print(pageA[i]);
								dao.delaym5sc();
							}
							for (int i = 0; i < 9; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							System.out.println();
							dao.delaym1sc();

							for (int i = 0; i < 26; i++) {
								System.out.print("=");
								dao.delaym1sc();
							}
							dao.delayhalfsc();
							System.out.println();

							System.out.println("[1] 내 정보");
							dao.delayhhsc();
							System.out.println("[2] 비밀번호 변경");
							dao.delayhhsc();
							System.out.println("[3] 닉네임 변경");
							dao.delayhhsc();
							System.out.println("[4] 점수 초기화");
							dao.delayhhsc();
							System.out.println("[5] 회원 탈퇴");
							dao.delayhhsc();
							System.out.println("[6] 돌아가기");

							dao.delayhalfsc();
							System.out.print("번호를 입력해주세요 : ");
							int myPage = scan.nextInt();
							dao.delayhhsc();
							System.out.println();

							if (myPage == 6) { // 뒤로가기
								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delayhhsc();
								System.out.println("메뉴화면으로 돌아갑니다.");
								dao.delayhalfsc();
								System.out.println();
								break;
							} // if 뒤로가기

							else if (myPage == 1) { // 내 정보 확인
								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();

								for (int i = 0; i < 10; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								for (int i = 0; i < myA.length; i++) {
									System.out.print(myA[i]);
									dao.delaym5sc();
								}
								System.out.print(" ");
								dao.delaym5sc();
								for (int i = 0; i < infoA.length; i++) {
									System.out.print(infoA[i]);
									dao.delaym5sc();
								}
								for (int i = 0; i < 9; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();

								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delayhalfsc();

								ArrayList<MyRanking_VO> myscore = dao.selectMy(logID);

								System.out.println("내 닉네임 " + logNic);
								dao.delayhhsc();
								System.out.println("최고 점수 " + myscore.get(0).getScore());
								dao.delayhhsc();
								System.out.println("나의 등수 " + myscore.get(0).getRn());
								dao.delayhhsc();

								System.out.print("돌아가려면 아무키나 입력하세요. ");
								int infosel = scan.nextInt();
								dao.delayhalfsc();

							} // else if 내정보 확인

							else if (myPage == 2) { // PW 변경
								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();

								for (int i = 0; i < 8; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								for (int i = 0; i < changeA.length; i++) {
									System.out.print(changeA[i]);
									dao.delaym5sc();
								}
								System.out.print(" ");
								dao.delaym5sc();
								for (int i = 0; i < pwsA.length; i++) {
									System.out.print(pwsA[i]);
									dao.delaym5sc();
								}
								for (int i = 0; i < 9; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();

								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delayhalfsc();
								System.out.println();

								while (true) { // 현재 비밀번호 확인

									System.out.println("현재 비밀번호 : ");
									String PASSWORD = scan.next();
									dao.delayhalfsc();

									if (!PASSWORD.equals(logPW)) {
										System.out.println("비밀번호가 일치하지 않습니다.");
										dao.delayhalfsc();
									} else
										break;
								} // while 현재 비밀번호 확인

								while (true) { // 새 비밀번호 확인

									System.out.println("새 비밀번호 : ");
									String PASSWORD = scan.next();
									dao.delayhalfsc();

									System.out.println("새 비밀번호 확인 : ");
									String PASSWORD2 = scan.next();
									dao.delayhalfsc();

									if (!PASSWORD.equals(PASSWORD2)) {
										System.out.println("비밀번호가 일치하지 않습니다.");
									} else {
										if (dao.change_PASSWORD(logID, PASSWORD) == 1) {

											System.out.print("비밀번호 변경 중");
											dao.delayhhsc();
											for (int i = 0; i < 2; i++) {
												System.out.print(". ");
												dao.delayhalfsc();
											}
											System.out.println(".");
											dao.delayhalfsc();

											System.out.println("성공적으로 변경되었습니다.");
											dao.delayhalfsc();
											break;

										} else {
											System.out.println("시스템 오류");
										}
									}
								} // while 새 비밀번호 확인

							} // else if PW변경

							else if (myPage == 3) { // 닉네임 변경
								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();

								for (int i = 0; i < 5; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								for (int i = 0; i < changeA.length; i++) {
									System.out.print(changeA[i]);
									dao.delaym5sc();
								}
								for (int i = 0; i < nicsA.length; i++) {
									System.out.print(nicsA[i]);
									dao.delaym5sc();
								}
								for (int i = 0; i < 6; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();

								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delayhalfsc();

								System.out.println("현재 닉네임은 " + logNic + " 입니다. ");
								dao.delayhhsc();
								System.out.print("변경하시겠습니까? (Y/N)");
								String yn = scan.next();
								dao.delayhalfsc();

								if (yn.equals("Y") || yn.equals("y") || yn.equals("ㅛ")) {

									while (true) { // 닉네임 변경

										System.out.println("변경할 닉네임 입력 : ");
										String Nick = scan.next();
										dao.delayhalfsc();

										if (dao.selectNick(Nick) == 1) {
											System.out.println("이미 사용 중인 닉네임 입니다");
										} else if (dao.selectNick(Nick) == 0) {
											dao.change_Nick_Name(logID, Nick);
											System.out.print("닉네임 변경 중");
											dao.delayhhsc();
											for (int i = 0; i < 2; i++) {
												System.out.print(". ");
												dao.delayhalfsc();
											}
											System.out.println(".");
											dao.delayhalfsc();

											System.out.println("변경이 완료되었습니다.");
											dao.delayhalfsc();
											break;
										} else {
											System.out.println("시스템 오류입니다. 죄송합니다.");
										}

									} // while

								} // if 변경의사 확인

							} // else if 닉네임 변경

							else if (myPage == 4) { // 점수 초기화
								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();

								for (int i = 0; i < 8; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								for (int i = 0; i < resetA.length; i++) {
									System.out.print(resetA[i]);
									dao.delaym5sc();
								}
								System.out.print(" ");
								dao.delaym5sc();
								for (int i = 0; i < scoresA.length; i++) {
									System.out.print(scoresA[i]);
									dao.delaym5sc();
								}
								for (int i = 0; i < 7; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();
								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delayhalfsc();

								ArrayList<MyRanking_VO> myscore = dao.selectMy(logID);

								System.out.print("비밀번호 : ");
								String password = scan.next();
								for (int i = 0; i < 26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delayhalfsc();

								if (logPW.equals(password)) {
									System.out.println(myscore.get(0).getNickName() + "님의 순위는 " + myscore.get(0).getRn()
											+ "위 이고,");
									dao.delayhhsc();
									System.out.println(" 점수는 " + myscore.get(0).getScore() + "점 입니다.");
									dao.delayhalfsc();
									for(int i = 0;i<26; i++) {
										System.out.print("=");
										dao.delaym1sc();
									}
									System.out.println();
									dao.delayhalfsc();
									System.out.print("초기화하시겠습니까? (Y/N) ");
									String yn = scan.next();

									if (yn.equals("Y") || yn.equals("y") || yn.equals("ㅛ")) {
										dao.delete(logID);
										System.out.print("초기화 하는 중");
										dao.delayhhsc();
										for (int i = 0; i < 2; i++) {
											System.out.print(". ");
											dao.delayhalfsc();
										}
										System.out.println(".");
										dao.delayhalfsc();
										System.out.println("초기화 되었습니다.");

										for(int i = 0;i<26; i++) {
											System.out.print("=");
											dao.delaym1sc();
										}
										System.out.println();
										
										System.out.println();
									} // if
									else {
										System.out.println("마이 페이지로 돌아갑니다.");
									} // else

								} // if

							} // else if 점수 초기화

							else if (myPage == 5) { // 회원탈퇴
								
								for(int i = 0;i<26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();
								
								for(int i = 0;i<8; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								for(int i = 0; i<unregA.length;i++) {
									System.out.print(unregA[i]);
									dao.delaym5sc();
								}
								for(int i = 0;i<8; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delaym1sc();
								
								for(int i = 0;i<26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delayhalfsc();
								
								System.out.println();
								System.out.print("탈퇴하시겠습니까? (Y/N) ");
								String yn = scan.next();
								

								if (yn.equals("Y") || yn.equals("y") || yn.equals("ㅛ")) {
									dao.unregist(logID);
									
									System.out.print("정보 삭제하는 중");
									dao.delayhhsc();
									for (int i = 0; i < 2; i++) {
										System.out.print(". ");
										dao.delayhalfsc();
									}
									System.out.println(".");
									dao.delayhalfsc();
									
									System.out.println("성공적으로 탈퇴되었습니다.");
									dao.delayhalfsc();
									break menuout;
								} else {
									dao.delayhhsc();
									System.out.println("마이 페이지로 돌아갑니다.");
								}

							} // else if 회원탈퇴

							else { // 잘못된 번호 입력 시
								for(int i = 0;i<26; i++) {
									System.out.print("=");
									dao.delaym1sc();
								}
								System.out.println();
								dao.delayhhsc();
								System.out.println("잘못된 입력입니다. ");
								dao.delayhalfsc();
								System.out.println();
							} // else 잘못된 번호 입력 시

						} // while 마이 페이지 메뉴 출력

					} // else if 마이 페이지

					else { // 잘못된 번호 입력 시
						for(int i = 0;i<26; i++) {
							System.out.print("=");
							dao.delaym1sc();
						}
						System.out.println();
						dao.delayhhsc();
						System.out.println("잘못된 입력입니다. ");
						dao.delayhalfsc();
						System.out.println();
					} // else 잘못된 번호입력시

				} // while 메뉴

			} // else if 로그인

			else { // 잘못된 번호 입력시
				for(int i = 0;i<26; i++) {
					System.out.print("=");
					dao.delaym1sc();
				}
				System.out.println();
				dao.delayhhsc();
				System.out.println("잘못된 입력입니다. ");
				dao.delayhalfsc();
				System.out.println();
			} // else 잘못된 번호 입력 시

		} // while

	} // main

} // class
