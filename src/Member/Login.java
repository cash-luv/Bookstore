package Member;

import java.util.HashMap;
import java.util.Map;

public class Login {
	private static Login save1 = new Login();
	private Map<String, MemberDTO> member = new HashMap<>();
	public static String id;
	public static String pwd;

	public static int num;

	public boolean save(MemberDTO memberDTO) {
		if (member.containsKey(memberDTO.getMemberId())) {
			return false;
		}
		member.put(memberDTO.getMemberId(), memberDTO);
		return true;
	}

	public boolean loginCheck(String id, String password) {
		if (member.containsKey(id)) {
			MemberDTO members = member.get(id);
			return members.getMemberPw().equals(password);
		}
		return false;
	}

	// 관리자, 일반회원 두개로 구분할것
	public static boolean login2() {
		if (id == "" || pwd == "") {
			System.out.println("아이디와 비밀번호를 입력후 로그인하세요.");
			return false;
		} else {
			if (id.equals("master") && pwd.equals("1234") && num == 1) {
				return true;
			} else {
				return false;
			}
		}
	}
}