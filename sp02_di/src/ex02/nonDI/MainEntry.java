package ex02.nonDI;

public class MainEntry {

//	is-a	, 	has-a		
//	상속		,	포함관계
//	
//	has-a 관계를 통해서 객체 다루기

	public static void main(String[] args) {

		NewRecordView view = new NewRecordView();
		NewRecord record = new NewRecord(10, 20, 30, 40);

		view.setRecord(record);
		view.print();

	}

}
