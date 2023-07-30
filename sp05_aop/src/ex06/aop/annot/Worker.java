package ex06.aop.annot;

public class Worker {

	private String name;
	private int age;
	private String job;
	
	public void setName(String name) { // DI
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
	public void getWorkerInfo() {
		
		System.out.println("이름: "+ this.name);
		System.out.println("나이: "+ this.age);
		System.out.println("직업: "+ this.job);
		
	}
	
}
