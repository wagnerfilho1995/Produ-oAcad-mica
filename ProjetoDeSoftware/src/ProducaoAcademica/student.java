package ProducaoAcademica;

public class student extends Developers{
	
	public int type;
	/*
	 * 1 - Graduate
	 * 2 - Master Degree
	 * 3 - Doctor Degree
	 */
	public int numbersOfProjects;
	
	public String College;
	
	public String getCollege() {
		return College;
	}
	public void setCollege(String college) {
		College = college;
	}
	public int getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
	public int getNumbersOfProjects() {
		return numbersOfProjects;
	}
	public void setNumbersOfProjects(int numbersOfProjects) {
		this.numbersOfProjects = numbersOfProjects;
	}
	
}
