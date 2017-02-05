package ProducaoAcademica;

import java.util.ArrayList;

public class professor extends Developers {
	
	protected ArrayList <student> orientations;
	
		public professor(){
			orientations = new ArrayList<student>();
		}

		public ArrayList<student> getOrientations() {
			return orientations;
		}

		public void setOrientations(student stu) {
			orientations.add(stu);
		}
}
