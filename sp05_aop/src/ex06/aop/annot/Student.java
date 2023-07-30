package ex06.aop.annot;

public class Student {

	private String name;
	private int age, gradeNum, classNum;


	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}

	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	
	
	public void getStudentInfo() {
		System.out.println("이름: "+this.name);
		System.out.println("나이: "+this.age);
		System.out.println("학년: "+this.gradeNum);
		System.out.println("반: "+this.classNum);}
	

	
	
}
