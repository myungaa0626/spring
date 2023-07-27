package ex01.annot.java;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCats {

	private String name;
	private int age;
	private ArrayList<String> hobbys;
	private double weight;
	private String color;

	public MyCats(String name, int age, ArrayList<String> hobbys) {
		super();
		this.name = name;
		this.age = age;
		this.hobbys = hobbys;
	}

}
