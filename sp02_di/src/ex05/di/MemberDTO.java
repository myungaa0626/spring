package ex05.di;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
//@Data
@Setter
@Getter
public class MemberDTO { // model

	private String name;
	private int age;
	private String message;
	
	

//	public MemberDTO() {
//		System.out.println("MemberDTO default constructor");
//	}



//	public String getName() {
//		return name;
//	}
//
//
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//
//
//	public String getAge() {
//		return age;
//	}
//
//
//
//	public void setAge(String age) {
//		this.age = age;
//	}
//
//
//
//	public String getMessage() {
//		return message;
//	}
//
//
//
//	public void setMessage(String message) {
//		this.message = message;
//	}


}