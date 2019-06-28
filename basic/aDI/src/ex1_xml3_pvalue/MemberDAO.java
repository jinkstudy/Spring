package ex1_xml3_pvalue;

public class MemberDAO {

		private MemberBean member;
		public MemberDAO() {
			
		}
		public MemberDAO(MemberBean member) {
			this.member = member;
		}
		
		public void setMember(MemberBean member) {
			this.member=member;
		}
		public void insert() {
			System.out.println(member.getName()+"님 정보가 입력됩니다.");
		}
}
