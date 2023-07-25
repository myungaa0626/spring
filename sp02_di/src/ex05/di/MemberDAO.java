package ex05.di;


public class MemberDAO {
	
	private MemberDTO dto;
	
	public MemberDAO(){}
	
	public MemberDAO(MemberDTO dto) { // DI - <constructor-arg>
		this.dto=dto;
		
	}

	public void setDto(MemberDTO dto) {
		this.dto = dto;
	}
	

	public void insert() {
		
		System.out.println(dto.getName()+" < "+dto.getAge()+" < "+dto.getMessage());
//		System.out.println(dto.getMessage()+" < "+ dto.getAge()+" < "+dto.getName());
//		System.out.println(dto.getMessage()+", "+dto.getAge()+", "+dto.getName());
		
	}
	
	

}
