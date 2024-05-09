package thread;

import static java.lang.Thread.currentThread;
import static utils.IOUtils.*;

import java.io.IOException;
import java.util.Map;

import com.app.core.Student;

public class SortOnGpaFromSubject implements Runnable {
	private Map<String, Student> studMap;
	private String subject;
	private String fName;

	public SortOnGpaFromSubject(Map<String, Student> studMap, String subject, String fName) {
		super();
		this.studMap = studMap;
		this.subject = subject;
		this.fName = fName;
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName() + "Thread Start");
		
		try {
			sortByGPA(studMap,fName,subject);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(currentThread().getName() + "Thread Over");
	}

}
