package Member;

import java.util.*;

public class BookstoreMain {
	Scanner scan = new Scanner(System.in);
	BookstoreService service = BookstoreService.getInstance();
	Login save1 = new Login();

	public BookstoreMain() {
	}

	public void start() {

		while (true) {
			// 아이디와 비밀번호를 입력받아 로그인 구현하기
			System.out.println("┌=============================================================================┐");
			System.out.println("\t\t\t\t일보서점 로그인 페이지");
			System.out.println("└=============================================================================┘");
//		String menu1 = service.conInput
			System.out.println("메뉴[ 1.유저로그인  2.관리자로그인 0.프로그램종료] ");
			System.out.print("메뉴선택>> ");
			int menu1 = scan.nextInt();

//		if (menu1 == 1) {
//			service.memberInsert();
			if (menu1 == 2) {
				Login.id = service.conInput("관리자 아이디>>");
				Login.pwd = service.conInput("관리자 비밀번호>>");
				Login.num = service.intInput("관리자가 맞습니까? 맞으면 1번");
			}else if (menu1 == 0) {
				break;
			}

			// 미리 데이터셋을 가져온다.
			BookstoreDataset.setBookstoreList();
			MemberDataSet.setMemberList();
			boolean loginok = false;
			while (true) {
				if (menu1 == 1 && loginok == false) { // 일반
					System.out.println("로그인 이나 회원가입 후 사용할 수 있습니다");
					System.out.println("1.로그인 2. 회원가입 ");
					System.out.print("메뉴선택>> ");
					int menu2 = scan.nextInt();
					if (menu2 == 1 && service.memberCheck()) {
						while (true) {
							loginok = true;
							System.out
									.println("=============================일보서점 회원프로그램==============================");
							String menu = service.conInput("메뉴[1.책목록, 2.책검색, 3.잔액확인, 4.책사기, 5.충전, 6.로그아웃]");
							System.out.println(
									"=============================================================================");
							if (menu.equals("1")) {// 책전체목록
								service.bookstoreOutput();
							} else if (menu.equals("4")) {// 책사기
								try {
									service.bookstoreBuy();
								} catch (NullPointerException null32) {
									System.out.println("이름이나 책이름이 잘못되었습니다.");
								}
							} else if (menu.equals("2")) {// 책검색
								service.bookstoreSearch();
							} else if (menu.equals("5")) {// 충전하기
								service.charging();
							} else if (menu.equals("3")) {// 잔액확인하기
								service.charge();
							} else if (menu.equals("6")) {// 로그아웃
								start();
							}
							System.out.println("");
						}

					} else if (menu2 == 2) {
						service.memberInsert();
					}
				} else if (Login.login2() && Login.id.equals("master")) { // 관리자

					System.out.println(
							"==========================================일보서점 관리자프로그램==============================================");
					String menu = service
							.conInput("메뉴[1.책보기, 2.책등록 , 3.책수정, 4.책삭제, 5.회원목록  6.회원수정 7. 회원삭제 8.로그아웃");
					System.out.println(
							"========================================================================================================");
					if (menu.equals("E")) {// 프로그램종료
						break;
					} else if (menu.equals("1")) {// 책전체목록
						service.bookstoreOutput();
					} else if (menu.equals("2")) {// 책등록
						service.bookstoreInsert();
					} else if (menu.equals("3")) {// 책수정
						service.bookstoreEdit();
					} else if (menu.equals("4")) {// 책삭제
						service.bookstoreDel();
					} else if (menu.equals("5")) {// 회원목록
						service.memberOutput();
					} else if (menu.equals("6")) {// 회원수정
						service.memberEdit();
					} else if (menu.equals("7")) {// 회원삭제
						service.memberDel();
					} else if (menu.equals("8")) {// 로그아웃
						start();
						break;
					}
					System.out.println("");
				} 
			}
		}
	}
}
