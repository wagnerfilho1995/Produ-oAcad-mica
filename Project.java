package ProducaoAcademica;

import java.util.ArrayList;

public class Project {
	
	public int status; // ESTADO DE DESENVOLVIMENTO DO PROJETO
	
	public String headline; // TITULO DO PROJETO
	
	public int starDate; // ANO DE INICIO
	
	public int endDate; // ANO DE TERMINO
	
	public String funder; // FINANCIADOR
	
	public double financedValue; // VALOR DE FINANCIAMENTO
	
	public String goal; // OBJETIVOS DO PROJETO
	 
	public String description; // DESCRIÇÃO DO PROJETO
	
	protected ArrayList <Developers> developers; // ARRAYLIST DE PESSOAS ENVOLVIDAS NO PROJETO

	protected ArrayList <Publications> publications; // ARRAYLIST DE PUBLICAÇÕES RELACIONADAS AO PROJETO

	public Project(){
		developers = new ArrayList <Developers>();
		publications = new ArrayList <Publications>();
	}
	
	public ArrayList<Developers> getDevelopers() {
		return developers;
	}

	public void setDevelopers(Developers dev) {
		developers.add(dev);
	}
	
	public ArrayList<Publications> getPubs() {
		return publications;
	}

	public void setPublication(Publications p) {
		publications.add(p);
	}

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
	
	public String toString(){
		return this.headline;
	}

}
