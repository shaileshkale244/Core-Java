package thread;
import static java.lang.Thread.currentThread;

import java.io.IOException;
import java.util.Map;
import static utils.IOUtils.*;
import com.app.core.Student;

public class SortOnDoB implements Runnable {

	private Map<String, Student> studmap;
	private String fileName;
	
	public SortOnDoB(Map<String, Student> studmap,String fileName) {
		super();
		this.studmap=studmap;
		this.fileName=fileName;
	}
	
	@Override
	public void run() {
		
		System.out.println(currentThread().getName()+"Thread Start");
		
		try {
			sortByDoB(studmap,fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(currentThread().getName()+"Thread Over");
	}

}
