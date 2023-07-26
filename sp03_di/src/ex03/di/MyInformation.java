package ex03.di;

import lombok.Data;

@Data // @Setter 있음
public class MyInformation {

	private Person person; // has-a

	// setter method DI
	
	public boolean processMessage(StudentPersonImpl student) {
		return this.person.personShow(student.getName(), student.getAge(), student.getGender());

	}

	public boolean processMessage(EmployeePersonImpl emp) {
		return this.person.personShow(emp);

	}

	public boolean processMessage(String name, int age, String gender) {

		return this.person.personShow(name, age, gender);
	}

}
