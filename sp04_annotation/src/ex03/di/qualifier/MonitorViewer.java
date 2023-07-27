package ex03.di.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MonitorViewer {

	private Recorder recorder; // has-a

//	@Inject
//	@Autowired(required = false) /*default:required=true*/
//	public MonitorViewer(Recorder recorder) { // constructor method, DI 
//		super();
//		this.recorder = recorder;
//		System.out.println("@Autowired 자동 주입");
//	}

	@Autowired
	@Qualifier("q") // id = "recorder1"
	public void setRecorder(Recorder recorder) {
		this.recorder = recorder;

	}

	public void show() {
		recorder.show();
		System.out.println("MonitorViewer class show method call~~~");
		System.out.println("setter method MonitorViewer class show method call~~~");

	}

}
