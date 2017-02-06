package ProducaoAcademica;

import java.util.ArrayList;

public class professor extends Developers {
	
	protected ArrayList <Developers> orientations;
	
		public professor(){
			orientations = new ArrayList<Developers>();
		}

		public ArrayList<Developers> getOrientations() {
			return orientations;
		}

		public void setOrientations(Developers stu) {
			orientations.add(stu);
		}
}
