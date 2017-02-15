package AcademicProduction;

import java.util.ArrayList;

public class Project {
	
	public int status; // ESTADO DE DESENVOLVIMENTO DO PROJETO
	
	public String headline; // TITULO DO PROJETO
	
	public int startDateDay, startDateMonth, startDateYear; // DATA DE INICIO
	
	public int endDateDay, endDateMonth, endDateYear; // DATA DE TERMINO
	
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

	public String getHeadline() {
		return headline;
	}	

	public void setHeadline(String headline) {
		this.headline = headline;
	}
	
	public int getStatus() {
			return status;
		}
	
	public void setStatus(int status) {
			this.status = status;
		}
	
	public int getStartDate(){
			return (this.startDateDay + (this.startDateMonth*30) + (this.startDateYear*365));
		}
		
	public void setStartDate(int startDateDay, int startDateMonth, int startDateYear){
			this.startDateDay = startDateDay;
			this.startDateMonth = startDateMonth;
			this.startDateYear = startDateYear;
		}
		
	public int getEndDate(){
			return (this.endDateDay + (this.endDateMonth*30) + (this.endDateYear*365));
		}
		
	public void setEndDate(int endDateDay, int endDateMonth, int endDateYear){
			this.endDateDay = endDateDay;
			this.endDateMonth = endDateMonth;
			this.endDateYear = endDateYear;
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
	
