package ProducaoAcademica;

public class Developers {
	
	public String name;
	
	public String email;
	
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
	// Historico;
	// Publicações;
	
}
