package ProducaoAcademica;

public class Publications {
	
	public String headline; // TÍTULO
	
	public String descriptions; // DESCRIÇÃO
	
	public int dateOfPublishing; // ANO

	public String congress; // NOME DA CONFERENCIA ONDE FOI PUBLICADA
	
	public String getCongress() {
		return congress;
	}

	public void setCongress(String congress) {
		this.congress = congress;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public int getDateOfPublishing() {
		return dateOfPublishing;
	}

	public void setDateOfPublishing(int dateOfPublishing) {
		this.dateOfPublishing = dateOfPublishing;
	}
	
	
}
