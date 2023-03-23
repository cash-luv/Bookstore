package Member;

public class MemberDTO {
	private static int firstNumber = 10;
	private String memberNo;  //회원번호
	private String memberName; //회원이름
	private String memberPN; //회원전화번호
	private String memberId; //회원아이디
	private String memberPw; //회원비밀번호
	private int charge; //회원충전금액
	
	
	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPN() {
		return memberPN;
	}

	public void setMemberPN(String memberPN) {
		this.memberPN = memberPN;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public MemberDTO() {
		
	}
	
	public MemberDTO(String memberNo, String memberName, String memberPN, String memberId, int charge){
		this.memberNo = "일보"+firstNumber++;
		this.memberName = memberName;
		this.memberPN = memberPN;
		this.memberId = memberId;
		this.charge = charge;
	}

	@Override
	public String toString() {
		return "MemberDTO [memberNo=" + memberNo + ", memberName=" + memberName + ", memberPN=" + memberPN
				+ ", memberId=" + memberId + ", memberPw=" + memberPw + ", charge=" + charge + "]";
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

}