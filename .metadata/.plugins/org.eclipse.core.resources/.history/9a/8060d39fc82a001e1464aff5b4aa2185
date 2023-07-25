package ex05.di;

public class MemberDAO {
	
	private MemberDTO dto;
	
	public MemberDAO() { }

	public MemberDAO(MemberDTO dto) {   //  DI   - <constructor-arg>
		super();
		this.dto = dto;
	}

	public void setDto(MemberDTO dto) {  // DI  - <property>
		this.dto = dto;
	}
	
	public void insert() {
		System.out.println(dto.getName() +" < " + dto.getAge() + " < " + dto.getMessage());
	}

}
