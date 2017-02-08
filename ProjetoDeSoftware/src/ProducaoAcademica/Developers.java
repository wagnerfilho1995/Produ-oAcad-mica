package ProducaoAcademica;

import java.util.ArrayList;

public class Developers {
	
	public String name;
	
	public String email;
	
	protected ArrayList <Publications> publications;
	
	protected ArrayList <Project> projects;
	
		public Developers(){
			publications = new ArrayList <Publications>();
			projects = new ArrayList <Project>();
		}
		
	
		public ArrayList<Project> getProjects() {
			return projects;
		}


		public void setProjects(Project proj) {
			projects.add(proj);
		}

		public ArrayList<Publications> getPublications() {
			return publications;
		}

		public void setPublications(Publications pub) {
			publications.add(pub);
		}

		public String getName() {
			System.out.println(name);
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	
	public String toString(){
		return this.name;
	}
	
}
