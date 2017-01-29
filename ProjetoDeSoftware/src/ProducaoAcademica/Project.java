package ProducaoAcademica;

public class Project {
	
	public int status;
	
	public String headline;
	
	public int starDate; // ANO
	
	public int endDate; // ANO
	
	public String funder;
	
	public double financedValue;
	
	public String goal;
	
	public String description;
	
	public Developers[] developers;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public int getStarDate() {
		return starDate;
	}

	public void setStarDate(int starDate) {
		this.starDate = starDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public String getFunder() {
		return funder;
	}

	public void setFunder(String funder) {
		this.funder = funder;
	}

	public double getFinancedValue() {
		return financedValue;
	}

	public void setFinancedValue(double financedValue) {
		this.financedValue = financedValue;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Developers[] getDevelopers() {
		return developers;
	}

	public void setDevelopers(Developers[] developers) {
		this.developers = developers;
	}
	
}
