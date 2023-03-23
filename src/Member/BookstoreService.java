package Member;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;



public class BookstoreService {
	static BookstoreService service = new BookstoreService();
	private static Login save1 = new Login();
	private String loginId = null;
	private String loginPassword = null;
	public static BookstoreService getInstance() {
		return service;
	}
	Scanner scan = new Scanner(System.in);
	int totaal = 0;
	//----------------------------------------------회원기능영역-----------------------------------------
	public void save() {
	MemberDTO memberDTO = new MemberDTO();
	while(true) {
		System.out.print("이름>");
		memberDTO.setMemberName(scan.next());
		System.out.print("id> ");
		memberDTO.setMemberId(scan.next());
		System.out.print("password> ");
		memberDTO.setMemberPw(scan.next());
		System.out.print("핸드폰 번호");
		memberDTO.setMemberPN(scan.next());
		if(save1.save(memberDTO)) {
			System.out.println("회원가입 성공");
			break;
		}else {
			System.out.println("ID 중복 입니다");
		}
	}
}
	public boolean loginCheck() {
		System.out.print("id> ");
		String id = scan.next();
		System.out.print("password> ");
		String password = scan.next();
		if (save1.loginCheck(id, password)) {
			loginId = id;
			loginPassword = password;
			System.out.println("로그인성공");
			return true;
		} else {
			System.out.println("로그인실패");
			return false;
		}	
	}
	
	public void bookstoreBuy() { // 책사기
		String memberName = conInput("회원이름");
		String bookstoreName = conInput("살 책이름");
		MemberDTO vo = MemberDataSet.MemberList.get(memberName);
		BookstoreDTO vo1 = BookstoreDataset.BookstoreList.get(bookstoreName);
		String name = vo.getMemberName(); // vo.getMemberName에서 가져온 이름
		int youcharge = vo.getCharge(); // 현재금액
		int total = vo.getCharge() - vo1.getBooktotal(); // 현재금액-책값
		if (total < 0) {
			System.out.println("잔액이 부족합니다 충전후에 이용하세요.");
		} else if (total > 0) {
			System.out.println("구매하신 회원님의 이름은 " + name + "이며 사기전 금액은 " + youcharge + "원 이였고, " + "책 가격은 "
					+ vo1.getBooktotal() + "원 입니다.");
			System.out.println("사고난 후 금액은 " + total + "원 입니다.");
			vo.setCharge(total);
			totaal = total;
		} else if (vo == null || vo1 == null) {
			System.out.println("이름이나 책 이름이 잘못되었습니다.");
		}
		/*
		 * Set<String> keyList = BookstoreDataSet.BookstoreList.keySet();
		 * Iterator<String> ii = keyList.iterator(); while(ii.hasNext()) { BookstoreVO
		 * vo = BookstoreDataSet.BookstoreList.get(ii.next());
		 * System.out.printf("%d\t%s\t%s\t%s\t%s\t\n", vo.getBookstoreNo(),
		 * vo.getBookstoreName(), vo.getBookstoreWriter(), vo.getBookstorePublish(),
		 * vo.getBooktotal()); }
		 */
	}

	public void bookstoreSearch() { // 책검색
		String bookstoreName = Lineput("찾고싶은 책 이름를 검색하세요");
		BookstoreDTO vo = BookstoreDataset.BookstoreList.get(bookstoreName);
		switch (bookstoreName) {
		case "코딩테스트다":
			System.out.println("확인 결과 " + vo.getBookstoreName() + "는 저희서점에 있습니다.");
			break;
		case "혼자하는 자바":
			System.out.println("확인 결과 " + vo.getBookstoreName() + "는 저희서점에 있습니다.");
			break;
		case "생활코딩 책":
			System.out.println("확인 결과 " + vo.getBookstoreName() + "는 저희서점에 있습니다.");
			break;
		case "do it!자바!":
			System.out.println("확인 결과 " + vo.getBookstoreName() + "는 저희서점에 있습니다.");
			break;
		case "자바의정석기초":
			System.out.println("확인 결과 " + vo.getBookstoreName() + "는 저희서점에 있습니다.");
			break;
		default:
			System.out.println("해당 이름의 책은 없습니다.");
			break;
		}
	}

	public void charging() { // 잔액충전
		String memberName = conInput("충전할 회원이름");
		MemberDTO vo = MemberDataSet.MemberList.get(memberName);
		if (vo == null) {
			System.out.println("존재하지 않는 이름입니다.");
		} else {// 해당 회원의 정보가 있을때
			int charge1 = totaal;
			System.out.println("현재 " + charge1 + "원 있습니다.");
			int charge2 = intInput("얼마를 충전하시겠습니까? ");
			vo.setCharge(charge1 + charge2);
			System.out.println("현재 금액은 = " + vo.getCharge() + "원 입니다. ");
		}
	}

	public void charge() { // 잔액확인
		String memberName = conInput("잔액을 확인할 회원이름");
		MemberDTO vo = MemberDataSet.MemberList.get(memberName);
		if (vo == null) {
			System.out.println("존재하지 않는 이름입니다.");
		} else {
			System.out.println("현재 " + vo.getCharge() + "원 있습니다.");
		}
	}

//----------------------------------관리자영역----------------------------------------------------------
//---------------------------------관리자 책 + 일반회원 책 출력만-----------------------------------------
	// 책 전체목록 출력
	public void bookstoreOutput() {
		Set<String> keyList = BookstoreDataset.BookstoreList.keySet();
		Iterator<String> ii = keyList.iterator();
		while (ii.hasNext()) {
			BookstoreDTO vo = BookstoreDataset.BookstoreList.get(ii.next());
			System.out.printf("%d\t%s\t%s\t%s\t%s\t\n", vo.getBookstoreNo(), vo.getBookstoreName(),
					vo.getBookstoreWriter(), vo.getBookstorePublish(), vo.getBooktotal());
		}
	}

	// 책등록
	public void bookstoreInsert() {
		try {
			int bookstoreNo = Integer.parseInt(conInput("책번호"));
			String bookstoreName = Lineput("책이름");
			String bookstoreWriter = conInput("책저자");
			String bookstorePublish = conInput("출판사");
			int booktotal = intInput("책가격");

			BookstoreDataset.BookstoreList.put(bookstoreName,
					new BookstoreDTO(bookstoreNo, bookstoreName, bookstoreWriter, bookstorePublish, booktotal));
		} catch (NumberFormatException ne) {
			System.out.println("잘못입력하셨습니다. 다시 시도해주세요");
		}
	}

	// 책 수정
	public void bookstoreEdit() {
		// 책 명
		String bookstoreName = Lineput("책이름");

		// 해당 책의 정보가 없을때
		BookstoreDTO vo = BookstoreDataset.BookstoreList.get(bookstoreName);
		if (vo == null) {
			System.out.println("존재하지 않는 책입니다.");
		} else {// 해당 책의 정보가 있을때
				// 책 이름, 저자, 판매수, 출판사
			String subMenu = conInput("수정할 필드 선택[1.책저자, 2.출판사]");
			if (subMenu.equals("1")) {
				String writer = conInput("수정할 책저자");
				vo.setBookstoreWriter(writer);
			} else if (subMenu.equals("2")) {
				String publish = conInput("수정할 출판사");
				vo.setBookstorePublish(publish);
			}
		}
	}

	// 책삭제
	public void bookstoreDel() {
		String bookstoreName = conInput("삭제할 책이름");
		BookstoreDTO vo = BookstoreDataset.BookstoreList.get(bookstoreName);
		if (vo == null) {
			System.out.println("책이름을 잘못 입력하셨습니다.");
		} else {
			BookstoreDataset.BookstoreList.remove(bookstoreName);
			System.out.println("삭제되었습니다.");
		}
		System.out.println(
				"========================================================================================");
		bookstoreOutput();
	}

	// -------------------------------------관리자
	// 책끝-------------------------------------------
	// ---------------------------------관리자
	// 회원시작------------------------------------------
	// 회원 전체목록 출력
	public void memberOutput() {
		Set<String> keyList = MemberDataSet.MemberList.keySet();
		Iterator<String> ii = keyList.iterator();
		while (ii.hasNext()) {
			MemberDTO vo = MemberDataSet.MemberList.get(ii.next());
			System.out.printf("%s\t %s\t %s\t %s\t %s\t \n", vo.getMemberNo(), vo.getMemberName(), vo.getMemberPN(),
					vo.getMemberId(), vo.getCharge());
		}
	}

	// 등록
	public void memberInsert() {
		try {
			MemberDTO memberDTO = new MemberDTO();
			String no = memberDTO.getMemberNo();
			String name = conInput("회원이름>> ");
//			String name = scan.next();
			String sell = conInput("회원아이디>> ");
//			String sell = scan.next();
			String writer = conInput("회원핸드폰번호>> ");
//			String writer = scan.next();
			int charge = 0;
			MemberDataSet.MemberList.put(name, new MemberDTO(no,name, writer, sell, charge));
		} catch (NumberFormatException ne) {
			System.out.println("잘못입력하셨습니다. 다시 시도해주세요");
		}
	}

	// 회원 수정
	public void memberEdit() {
		// 회원명
		String memberName = conInput("회원명");
		MemberDTO vo = MemberDataSet.MemberList.get(memberName);
		if (vo == null) {// 해당 회원의 정보가 없을때
			System.out.println("존재하지않는 회원입니다.");
		} else {// 해당 회원의 정보가 있을때
				// 회원 번호, 이름, 전화번호, 아이디
			String subMenu = conInput("수정할 필드 선택[1.회원전화번호, 2.회원아이디, 3.충전금액]");
			if (subMenu.equals("1")) {
				String Pn = conInput("수정할 회원전화번호");
				vo.setMemberPN(Pn);
			} else if (subMenu.equals("2")) {
				String Id = conInput("수정할 회원아이디");
				vo.setMemberId(Id);
			} else if (subMenu.equals("3")) {
				int charge = intInput("수정할 충전금액");
				vo.setCharge(charge);
			}
		}
	}
	public boolean memberCheck() {
		MemberDTO memberDTO = new MemberDTO();
		String memberName = conInput("회원이름>>");
		MemberDTO vo = MemberDataSet.MemberList.get(memberName);
		String memberId = conInput("회원아이디>>");
		MemberDTO voId = MemberDataSet.MemberList.get(memberId);
		
		if (vo == null && voId == null) {// 해당 회원의 정보가 없을때
			System.out.println("존재하지않는 회원입니다.");
			return false;
		} else {
			System.out.println("로그인 성공");
			return true;
		}
	}

	// 회원삭제
	public void memberDel() {
		String memberNameName = conInput("삭제할 회원이름");
		MemberDataSet.MemberList.remove(memberNameName);
		memberOutput();
	}
	// ----------------------------관리자 회원끝--------------------------------------

	// 콘솔에서 문자입력받아 리턴하는 메소드
	public String conInput(String msg) {
		System.out.print(msg + "=");
		return scan.next();
	}
	public String Lineput(String msg) {
		System.out.print(msg + "=");
		return scan.nextLine();
	}

	// 콘솔에서 인트형 입력받아 리턴하는 메소드
	public int intInput(String msg) {
		System.out.print(msg + "=");
		return scan.nextInt();
	}

	// 시작하는메소드
	public static void main(String[] args) {
		new BookstoreMain().start();
		System.out.println("시스템이 종료되었습니다.");
	}
}