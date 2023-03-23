package Member;

import java.util.HashMap;
import java.util.TreeMap;

public class MemberDataSet {


	public static TreeMap<String, MemberDTO> MemberList = new TreeMap<>();
	
	
	public MemberDataSet() {
		
	}
	
	// 회원번호, 회원이름, 회원전화번호, 회원아디
	public static void setMemberList() {
		MemberDTO memberDTO = new MemberDTO();
		String no = memberDTO.getMemberNo();
		MemberList.put("김일보", new MemberDTO(no,"김일보", "010-6231-9238", "123", 10000));
		MemberList.put("박일보", new MemberDTO(no,"박일보", "010-2001-2010", "345", 30000));
		MemberList.put("이일보", new MemberDTO(no,"이일보", "010-5678-2335", "234", 20000));
		MemberList.put("최일보", new MemberDTO(no,"최일보", "010-3565-1254", "456", 10000));
		MemberList.put("홍길동", new MemberDTO(no,"홍길동", "010-8546-4321", "567", 50000));
	}

}