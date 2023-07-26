package ex03.di;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeePersonImpl implements Person {

	private String name, gender;
	private int age;
	private ArrayList<Integer> hobbys;

	@Override
	public boolean personShow(String name, int age, String gender) {
		System.out.println(name + " / " + age + " / " + gender);
		return true;
	}

	@Override
	public boolean personShow(Person person) {
		System.out.println(person);
		return true;
	}

	public boolean personShow(ArrayList<String> hobbys) {
		for (int i = 0; i < hobbys.size(); i++) {
			System.out.println(hobbys);
		}
		return true;

	}

}
