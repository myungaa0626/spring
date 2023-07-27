package ex04.di.resource;

import javax.annotation.Resource;

public class MonitorViewer {

	private Recorder recorder; // has-a

//	@Resource(name = "x")
//	@Resource(name = "y")

	@Resource(name = "z")
//	@Qualifier("y")

	public void setRecorder(Recorder recorder) { // DI
		this.recorder = recorder;

//		boolean record = Resource.class.getTypeName().contains("record1");
		boolean record = Resource.class.getTypeName().contains("record1");
		System.out.println(record);

		System.out.println(!Resource.class.getTypeName().equals("record1"));
		System.out.println(Resource.class.getCanonicalName().equals("record1"));

		System.out.println(Resource.AuthenticationType.class);

		recorder.show();
		System.out.println(recorder);
		System.out.println("@Resource 주입");

	}

}
